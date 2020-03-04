package com.yymt.modules.common.service.antiepidemic.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yymt.common.utils.Constant;
import com.yymt.common.utils.DateUtils;
import com.yymt.modules.common.dao.antiepidemic.DeviceDao;
import com.yymt.modules.common.dao.antiepidemic.FaceAlarmInfoDao;
import com.yymt.modules.common.dao.antiepidemic.OrganizationDao;
import com.yymt.modules.common.entity.antiepidemic.DeviceEntity;
import com.yymt.modules.common.entity.antiepidemic.FaceAlarmInfoEntity;
import com.yymt.modules.common.entity.antiepidemic.FaceAlarmInfoParseMongoEntity;
import com.yymt.modules.common.entity.statistics.FaceAlarmStatisticsEntity;
import com.yymt.modules.common.service.antiepidemic.FaceAlarmInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static org.apache.coyote.http11.Constants.A;

/**
 * 告警信息
 *
 * @author xielin
 * @since 2020/2/26 14:16
 */
@Service
public class FaceAlarmInfoServiceImpl extends ServiceImpl<FaceAlarmInfoDao, FaceAlarmInfoEntity> implements FaceAlarmInfoService {
//-Xms512m -Xmx512m -XX:MaxNewSize=512m -XX:MaxPermSize=512m
    @Autowired
    private FaceAlarmInfoDao faceAlarmInfoDao;
    @Autowired
    private DeviceDao deviceDao;
    @Autowired
    private OrganizationDao organizationDao;
    @Autowired
    private MongoTemplate mongoTemplate;
    //通过注解引入配置
    @Resource(name = "defaultThreadPool")
    private ThreadPoolTaskExecutor executor;

    private static final String FACEALARMINFOPARSEMONGO= "faceAlarmInfoParseMongo";

    @Override
    public Map<String, Object> queryInfoById(String _id) {
//        Map<String, Object> queryInfoById = faceAlarmInfoDao.queryInfoById(id);

//        Criteria criteria=Criteria.where("_id").is(_id);
//        Query query = new Query().addCriteria(criteria);
//        FaceAlarmInfoParseMongoEntity faceAlarmInfoParseMongoEntity = mongoTemplate.findOne(query, FaceAlarmInfoParseMongoEntity.class);

        FaceAlarmInfoParseMongoEntity faceAlarmInfoParseMongoEntity = mongoTemplate.findById(_id, FaceAlarmInfoParseMongoEntity.class);
        DeviceEntity deviceEntities = deviceDao.selDeviceIPsByRemoteIP(faceAlarmInfoParseMongoEntity.getRemoteIP());

        String dataType = faceAlarmInfoParseMongoEntity.getDataType();

        Map<String, Object> messageMap =  new LinkedHashMap<>();
        messageMap.put("devID", deviceEntities.getDevID());
        messageMap.put("devName", deviceEntities.getDesc());
        messageMap.put("id", faceAlarmInfoParseMongoEntity.get_id());
        messageMap.put("alarmTime", DateUtils.msToDate(faceAlarmInfoParseMongoEntity.getTimeStamp()));

        Object content = faceAlarmInfoParseMongoEntity.getContent();
        if (content != null) {
            JSONObject jsonContent = JSON.parseObject(content.toString().replaceAll("\r\n", ""));
            if (jsonContent != null) {
                JSONObject metadata = jsonContent.getJSONObject("Metadata");

                if (metadata != null) {
                    messageMap.put("duration", metadata.getString("Duration"));
                    messageMap.put("sensorUrl", metadata.getString("SensorUrl"));

                    JSONObject img = jsonContent.getJSONObject("Img");
                    if (img != null) {
                        messageMap.put("imgURI", img.getString("URI"));
                    }

                    // 解析车辆
                    if (Constant.videoStructureData.VEHICLE.getDataType().equals(dataType)) {
                        parseVEHICLE(jsonContent, messageMap);
                    }

                    // 解析非机动车
                    if (Constant.videoStructureData.NON_MOTOR_VEHICLES.getDataType().equals(dataType)) {
                        parseNONMOTORVEHICLES(jsonContent, messageMap);
                    }

                    // 解析人脸
                    if (Constant.videoStructureData.REC_FACE.getDataType().equals(dataType)) {
                        parseRECFACE(jsonContent, messageMap);
                    }

                    // 解析行人
                    if (Constant.videoStructureData.REC_PEDESTRIAN.getDataType().equals(dataType)) {
                        parseRECPEDESTRIAN(jsonContent, messageMap);
                    }

                }
            }
        }

        return messageMap;
    }

    @Override
    public FaceAlarmStatisticsEntity queryInfoByStartTimeAndEndTimeAndOrgName(Map<String, Object> params) {

        FaceAlarmStatisticsEntity entity = new FaceAlarmStatisticsEntity();
        List<String> remoteIPList = deviceDao.selRemoteIPsByOrgName(params);
        params.put("remoteIPList", remoteIPList);
        try {
            entity = getStatistics(params);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return entity;
    }

    /*
     * 统计人脸
     * */
    public FaceAlarmStatisticsEntity getRecFaceStatistics(Map<String, Object> params,String DataType) {

        params.put("DataType", DataType);
        //获取卡点设备预警信息列表
        List<FaceAlarmInfoParseMongoEntity> alarmInfoList = getList(params);

        //初始化统计实体
        FaceAlarmStatisticsEntity entity = new FaceAlarmStatisticsEntity();

        //统计卡点信息
        entity.setFace(alarmInfoList.size());

        //违规数
        List<Map<String, Object>> violationFaceAlarmInfo = new ArrayList<>();
        List<Map<String, Object>> noMaskAlarmInfoList = new ArrayList<>();
//        alarmInfoList.stream().filter(e -> e.getViolationStatus() == 1)
        alarmInfoList.stream()
            .forEach(e -> {
                HashMap map = new HashMap();
                map.put("Id",e.get_id());
                map.put("TimeStamp",DateUtils.msToDate(e.getTimeStamp()));
                map.put("AlarmType", Constant.videoStructureData.REC_FACE.getAlarmType());
                violationFaceAlarmInfo.add(map);

                JSONObject content = JSONObject.parseObject(e.getContent());
                entity.setViolationFace(entity.getViolationFace() + 1);
                if (content.getJSONObject("Attributes") != null) {
                    String attributes = content.getJSONObject("Attributes").toJSONString();
                    if (attributes.contains("无口罩")) {
                        entity.setNoMask(entity.getNoMask() + 1);//口罩不规范数量

                        map.put("AlarmType", Constant.videoStructureData.NO_MASK.getAlarmType());
                        noMaskAlarmInfoList.add(map);
                    }
                }
            });


        // 加入报警页的列表信息（Id，AlarmType，TimeStamp）
        entity.setViolationFaceAlarmInfo(violationFaceAlarmInfo);
        entity.setNoMaskAlarmInfo(noMaskAlarmInfoList);

        return entity;
    }

    /*
     * 统计车辆
     * */
    public FaceAlarmStatisticsEntity getVehicleStatistics(Map<String, Object> params,String DataType) {

        params.put("DataType", DataType);
        //获取卡点设备预警信息列表
        List<FaceAlarmInfoParseMongoEntity> alarmInfoList = getList(params);

        //初始化统计实体
        FaceAlarmStatisticsEntity entity = new FaceAlarmStatisticsEntity();

        //统计卡点信息
        entity.setVehicle(alarmInfoList.size());

        //违规数
        List<Map<String, Object>> violationVehicleAlarmInfo = new ArrayList<>();

        alarmInfoList.stream()
                .forEach(e -> {
                    HashMap map = new HashMap();
                    map.put("Id",e.get_id());
                    map.put("TimeStamp",DateUtils.msToDate(e.getTimeStamp()));
                    map.put("AlarmType", Constant.videoStructureData.VEHICLE.getAlarmType());
                    violationVehicleAlarmInfo.add(map);

                    entity.setViolationVehicle(entity.getViolationVehicle() + 1);//
                });

        entity.setViolationVehicleAlarmInfo(violationVehicleAlarmInfo);

        return entity;
    }

    /*
     * 统计行人
     * */
    public FaceAlarmStatisticsEntity getRecPedestrianStatistics(Map<String, Object> params,String DataType) {

        params.put("DataType", DataType);
        //获取卡点设备预警信息列表
        List<FaceAlarmInfoParseMongoEntity> alarmInfoList = getList(params);

        //初始化统计实体
        FaceAlarmStatisticsEntity entity = new FaceAlarmStatisticsEntity();

        //统计卡点信息
        entity.setPedestrian(alarmInfoList.size());
        //违规数
        List<Map<String, Object>> violationPedestrianAlarmInfo = new ArrayList<>();

        alarmInfoList.stream()
                .forEach(e -> {
                    HashMap map = new HashMap();
                    map.put("Id",e.get_id());
                    map.put("TimeStamp",DateUtils.msToDate(e.getTimeStamp()));
                    map.put("AlarmType", Constant.videoStructureData.REC_PEDESTRIAN.getAlarmType());
                    violationPedestrianAlarmInfo.add(map);

                    entity.setViolationPedestrian(entity.getViolationPedestrian() + 1);//

                });

        entity.setViolationPedestrianAlarmInfo(violationPedestrianAlarmInfo);

        return entity;
    }

    /*
     * 统计非机动车辆
     * */
    public FaceAlarmStatisticsEntity getNonMotorVehiclesStatistics(Map<String, Object> params,String DataType){

        params.put("DataType", DataType);
        //获取卡点设备预警信息列表
        List<FaceAlarmInfoParseMongoEntity> alarmInfoList = getList(params);

        //初始化统计实体
        FaceAlarmStatisticsEntity entity = new FaceAlarmStatisticsEntity();

        //统计卡点信息
        entity.setNonMotorVehicle(alarmInfoList.size());
        //违规数
        List<Map<String, Object>> violationNonMotorVehicleAlarmInfo = new ArrayList<>();


        alarmInfoList.stream()
                .forEach(e -> {
                    HashMap map = new HashMap();
                    map.put("Id",e.get_id());
                    map.put("TimeStamp",DateUtils.msToDate(e.getTimeStamp()));
                    map.put("AlarmType", Constant.videoStructureData.NON_MOTOR_VEHICLES.getAlarmType());
                    violationNonMotorVehicleAlarmInfo.add(map);

                    entity.setViolationNonMotorVehicle(entity.getViolationNonMotorVehicle() + 1);//
                });

        entity.setViolationNonMotorVehicleAlarmInfo(violationNonMotorVehicleAlarmInfo);

        return entity;
    }

    /*
     * 统计所有
     * */
    private FaceAlarmStatisticsEntity getStatistics(Map<String, Object> params) throws InterruptedException, ExecutionException {

        List<Future<FaceAlarmStatisticsEntity>> futures = new ArrayList<>();

        FaceAlarmStatisticsEntity entity = new FaceAlarmStatisticsEntity();

        //统计人脸
        final Future<FaceAlarmStatisticsEntity> recFaceFuture
                = executor.submit(() -> getRecFaceStatistics(params,"RecFace"));
        setExecutor(entity,recFaceFuture);
//        futures.add(recFaceFuture);

        //统计车辆
        final Future<FaceAlarmStatisticsEntity> vehicleFuture =
                executor.submit(() -> getVehicleStatistics(params,"Vehicle"));
        setExecutor(entity,vehicleFuture);
//        futures.add(vehicleFuture);

        //统计行人
        final Future<FaceAlarmStatisticsEntity> recPedestrianFuture =
                executor.submit(() -> getRecPedestrianStatistics(params,"RecPedestrian"));
        setExecutor(entity,recPedestrianFuture);
//        futures.add(recPedestrianFuture);

        //统计非机动车
        final Future<FaceAlarmStatisticsEntity> nonMotorVehicleFuture =
                executor.submit(() -> getNonMotorVehiclesStatistics(params,"NonMotorVehicles"));
        setExecutor(entity,nonMotorVehicleFuture);

        System.out.println("11");
        System.out.println("12");
//        futures.add(nonMotorVehicleFuture);

//        setExecutor(entity,futures);

        //统计违规总数
        entity.setSum(entity.getViolationFace() + entity.getViolationPedestrian()
                + entity.getViolationVehicle() + entity.getViolationNonMotorVehicle() + entity.getNoMask());
        return entity;
    }

    /*
     * 设置
     * */
    private FaceAlarmStatisticsEntity setEntity(FaceAlarmStatisticsEntity entity, FaceAlarmStatisticsEntity getEntity) {

        if (getEntity.getFace() != 0) {

            entity.setFace(getEntity.getFace());
            entity.setNoMask(getEntity.getNoMask());
            entity.setViolationFace(getEntity.getViolationFace());
            entity.setViolationFaceAlarmInfo(getEntity.getViolationFaceAlarmInfo());
            entity.setNoMaskAlarmInfo(getEntity.getNoMaskAlarmInfo());
        } else if (getEntity.getVehicle() != 0) {

            entity.setVehicle(getEntity.getVehicle());
            entity.setViolationVehicle(getEntity.getViolationVehicle());
            entity.setViolationVehicleAlarmInfo(getEntity.getViolationVehicleAlarmInfo());
        } else if (getEntity.getPedestrian() != 0) {

            entity.setPedestrian(getEntity.getPedestrian());
            entity.setViolationPedestrian(getEntity.getViolationPedestrian());
            entity.setViolationPedestrianAlarmInfo(getEntity.getViolationPedestrianAlarmInfo());
        } else if (getEntity.getNonMotorVehicle() != 0) {

            entity.setNonMotorVehicle(getEntity.getNonMotorVehicle());
            entity.setViolationNonMotorVehicle(getEntity.getViolationNonMotorVehicle());
            entity.setViolationNonMotorVehicleAlarmInfo(getEntity.getViolationNonMotorVehicleAlarmInfo());
        }

        return entity;
    }

    private List<FaceAlarmInfoParseMongoEntity> getList(Map<String, Object> params) {
//        List<FaceAlarmInfoParseMongoEntity> alarmInfoList;
//        if (params.get("flag") != null) {
//            alarmInfoList = faceAlarmInfoDao.selInfoByDayAndRemoteIP(params);
//        } else {
//            alarmInfoList = faceAlarmInfoDao.selInfoByStartTimeAndEndTimeAndRemoteIPs(params);
//        }

//        Criteria criteria = Criteria.where("DataType").is(params.get("DataType").toString())
//                .and("TimeStamp").gte(params.get("startTime"))
//                .lte(params.get("endTime"))
//                .and("RemoteIP").in(params.get("remoteIPList"));

//        Criteria criteria = Criteria.where("RemoteIP").in("192.168.2.180");
        Criteria criteria = Criteria.where("RemoteIP").is("192.168.2.180");
//        Criteria criteria = Criteria.where("_id").is("00009D58-C650-4441-828A-05217C52FF85");
//                .and("TimeStamp").gte(params.get("startTime"))
//                .lte(params.get("endTime"))
//                .and("RemoteIP").in(params.get("remoteIPList"));

        Query query = new Query().addCriteria(criteria);
//        00009D58-C650-4441-828A-05217C52FF85
//        List<FaceAlarmInfoParseMongoEntity> alarmInfoList = mongoTemplate.findOn(query, FaceAlarmInfoParseMongoEntity.class);
        FaceAlarmInfoParseMongoEntity alarmInfoList = mongoTemplate.findOne(query, FaceAlarmInfoParseMongoEntity.class);
        System.out.println(alarmInfoList);
        return null;
    }


    /*
     * 线程执行结束后设置entity
     * */
//    private void setExecutor(FaceAlarmStatisticsEntity entity,Future<FaceAlarmStatisticsEntity> future) throws InterruptedException, ExecutionException {
    private void setExecutor(FaceAlarmStatisticsEntity entity,Future<FaceAlarmStatisticsEntity> future) throws InterruptedException, ExecutionException {
        long now = System.currentTimeMillis();
        int i = 1;
        while (true) {
//            if (executor.getThreadPoolExecutor().getCompletedTaskCount() == futures.size()) {
            if (future.isDone() && !future.isCancelled() && executor.getActiveCount() > 0) {
//                for (int i = 0; i < futures.size(); i++) {
                    FaceAlarmStatisticsEntity getEntity = future.get();//获取结果
                    setEntity(entity, getEntity);
                    System.out.println("任务" + i++ + "获取完成!" + (System.currentTimeMillis() - now) + "ms");
//                }
                break;//当前future获取结果完毕，跳出while
            } else {

                Thread.sleep(5);//每次轮询休息1毫秒（CPU纳秒级），避免CPU高速轮循耗空CPU---》新手别忘记这个
            }
        }
    }

    // 解析行人
    private void parseRECPEDESTRIAN(JSONObject jsonContent, Map<String, Object> messageMap) {

        messageMap.put("alarmType", Constant.videoStructureData.REC_PEDESTRIAN.getAlarmType());

        JSONArray alarmTypeArry = jsonContent.getJSONArray(Constant.videoStructureData.REC_PEDESTRIAN.getDataType());
        // 解析告警类型下的属性
        List<Object> listInfo = new ArrayList<>();

        for (int i = 0; i < alarmTypeArry.size(); i++) {
            JSONObject alarmTypeJson = alarmTypeArry.getJSONObject(i);
            // 解析公共属性
            Map<String, Object> tempIpMapSub = parseCommon(alarmTypeJson);
            // 解析 PedesAttr
            JSONObject pedesAttr = alarmTypeJson.getJSONObject("PedesAttr");
            if (pedesAttr != null) {

                if (pedesAttr.getJSONObject("Sex") != null) {
                    tempIpMapSub.put("Sex", pedesAttr.getJSONObject("Sex").getString("Name"));
                }
                if (pedesAttr.getJSONObject("Age") != null) {
                    tempIpMapSub.put("Age", pedesAttr.getJSONObject("Age").getString("Name"));
                }
                if (pedesAttr.getJSONObject("National") != null) {
                    tempIpMapSub.put("National", pedesAttr.getJSONObject("National").getString("Name"));
                }
                // 解析 Category
                JSONArray categoryArry = pedesAttr.getJSONArray("Category");
                List<Object> CategoryParseList = new ArrayList<>();
                if (categoryArry != null) {
                    for (int j = 0; j < categoryArry.size(); j++) {
                        JSONObject category = categoryArry.getJSONObject(j);
                        Map<String, Object> categoryParse = new HashMap<>();
                        categoryParse.put("categoryName", category.getString("CategoryName"));
                        // 解析Items
                        JSONArray itemsArry = category.getJSONArray("Items");
                        if (itemsArry != null) {
                            String[] items = new String[itemsArry.size()];
                            for (int k = 0; k < itemsArry.size(); k++) {
                                items[k] = itemsArry.getJSONObject(k).getString("Name");
                            }
                            categoryParse.put("items", items);
                        }
                        CategoryParseList.add(categoryParse);
                    }
                }
                tempIpMapSub.put("Category", CategoryParseList);
            }
            listInfo.add(tempIpMapSub);
        }

        messageMap.put("listInfo", listInfo);
    }

    // 解析人脸
    private void parseRECFACE(JSONObject jsonContent, Map<String, Object> messageMap) {

        String alarmTypeStr = jsonContent.getString(Constant.videoStructureData.REC_FACE.getDataType());
        if (alarmTypeStr.contains("无口罩")) {
            messageMap.put("alarmType", Constant.videoStructureData.NO_MASK.getAlarmType());
        } else {
            messageMap.put("alarmType", Constant.videoStructureData.REC_FACE.getAlarmType());
        }

        JSONArray alarmTypeArry = jsonContent.getJSONArray(Constant.videoStructureData.REC_FACE.getDataType());
        // 解析告警类型下的属性
        List<Object> listInfo = new ArrayList<>();

        for (int i = 0; i < alarmTypeArry.size(); i++) {
            JSONObject alarmTypeJson = alarmTypeArry.getJSONObject(i);
            // 解析公共属性
            Map<String, Object> tempIpMapSub = parseCommon(alarmTypeJson);

            // 解析Attributes
            JSONArray attributes = alarmTypeJson.getJSONArray("Attributes");
            List<Object> attributesTemp = new ArrayList<>();
            if (attributes != null) {
                for (int j = 0; j < attributes.size(); j++) {
                    JSONObject attr = attributes.getJSONObject(j);
                    Map<String, Object> person = new HashMap<>();
                    person.put("AttributeId", attr.getString("AttributeId"));
                    person.put("Name", attr.getString("Name"));
                    person.put("ValueString", attr.getString("ValueString"));
                    attributesTemp.add(person);
                }
            }
            tempIpMapSub.put("Attributes", attributesTemp);
            listInfo.add(tempIpMapSub);
        }

        messageMap.put("listInfo", listInfo);
    }

    // 解析非机动车
    private void parseNONMOTORVEHICLES(JSONObject jsonContent, Map<String, Object> messageMap) {

        messageMap.put("alarmType", Constant.videoStructureData.NON_MOTOR_VEHICLES.getAlarmType());

        JSONArray alarmTypeArry = jsonContent.getJSONArray(Constant.videoStructureData.NON_MOTOR_VEHICLES.getDataType());
        // 解析告警类型下的属性
        List<Object> listInfo = new ArrayList<>();
        for (int i = 0; i < alarmTypeArry.size(); i++) {
            JSONObject alarmTypeJson = alarmTypeArry.getJSONObject(i);
            // 解析公共属性
            Map<String, Object> tempIpMapSub = parseCommon(alarmTypeJson);
            // 解析 Attributes
            JSONArray attributes = alarmTypeJson.getJSONArray("Attributes");
            if (attributes != null) {
                List<Object> attributesList = new ArrayList<>();
                for (int j = 0; j < attributes.size(); j++) {
                    HashMap attributesMap = new HashMap<>();
                    JSONObject att = attributes.getJSONObject(j);
                    attributesMap.put("AttributeName", att.getString("AttributeName"));
                    attributesMap.put("ValueString", att.getString("ValueString"));
                    attributesList.add(attributesMap);
                }
                tempIpMapSub.put("attribute", attributesList);
            }
            listInfo.add(tempIpMapSub);
        }

        messageMap.put("listInfo", listInfo);
    }

    // 解析车辆
    private void parseVEHICLE(JSONObject jsonContent, Map<String, Object> messageMap) {

        messageMap.put("alarmType", Constant.videoStructureData.VEHICLE.getAlarmType());

        JSONArray alarmTypeArry = jsonContent.getJSONArray(Constant.videoStructureData.VEHICLE.getDataType());
        // 解析告警类型下的属性
        List<Object> listInfo = new ArrayList<>();
        for (int i = 0; i < alarmTypeArry.size(); i++) {
            JSONObject alarmTypeJson = alarmTypeArry.getJSONObject(i);
            // 解析告警类型下的公共属性
            Map<String, Object> tempIpMapSub = parseCommon(alarmTypeJson);
            // 解析 ModelType
            JSONObject modelType = alarmTypeJson.getJSONObject("ModelType");
            if (modelType != null) {
                tempIpMapSub.put("Style", modelType.getString("Style"));
                tempIpMapSub.put("Brand", modelType.getString("Brand"));
                tempIpMapSub.put("ModelYear", modelType.getString("ModelYear"));
                tempIpMapSub.put("Pose", modelType.getString("Pose"));
            }

            // 解析 Color
            JSONObject Color = alarmTypeJson.getJSONObject("Color");
            if (Color != null) {
                tempIpMapSub.put("Color", Color.getString("ColorName"));
            }
            listInfo.add(tempIpMapSub);
        }

        messageMap.put("listInfo", listInfo);
    }

    /*
     * 解析告警类型下的公共属性
     * @param alarmTypeJson 告警类型的JSON
     * @return 解析后的参数
     */
    private Map<String, Object> parseCommon(JSONObject alarmTypeJson) {
        Map<String, Object> tempIpMapSub = new HashMap<>();
        tempIpMapSub.put("AlarmTypId",alarmTypeJson.getString("Id"));
        String Img3_URI = null;
        JSONObject img = alarmTypeJson.getJSONObject("Img");
        if (img != null) {
            if (img.getJSONObject("Img") != null) {
                Img3_URI = img.getJSONObject("Img") .getString("URI");
            }
        }
        tempIpMapSub.put("Img3_URI", Img3_URI);
        return tempIpMapSub;
    }



}
