package com.yymt.modules.common.service.antiepidemic.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yymt.modules.common.dao.antiepidemic.DeviceDao;
import com.yymt.modules.common.dao.antiepidemic.FaceAlarmInfoDao;
import com.yymt.modules.common.entity.antiepidemic.DeviceEntity;
import com.yymt.modules.common.entity.antiepidemic.FaceAlarmInfoParseEntity;
import com.yymt.modules.common.entity.antiepidemic.MongoEntity;
import com.yymt.modules.common.entity.statistics.FaceAlarmStatisticsEntity;
import com.yymt.modules.common.service.antiepidemic.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * 卡点
 *
 * @author xiezhen
 * @since 2020/2/26 14:16
 */
@Service
public class DeviceServiceImpl extends ServiceImpl<DeviceDao, DeviceEntity> implements DeviceService {

    @Autowired
    private FaceAlarmInfoDao faceAlarmInfoDao;
    @Autowired
    private MongoTemplate mongoTemplate;
    //通过注解引入配置
    @Resource(name = "defaultThreadPool")
    private ThreadPoolTaskExecutor executor;

    @Override
    public FaceAlarmStatisticsEntity queryStatisticsDayAndByDevID(Map<String, Object> params) {

        FaceAlarmStatisticsEntity entity = new FaceAlarmStatisticsEntity();

        //根据卡点id获取remoteIP
        params.put("remoteIP", baseMapper.selRemoteIPByDevId(params));

        params.put("flag", true);

        try {
            entity = getStatistics(params);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return entity;
    }

    @Override
    public FaceAlarmStatisticsEntity queryInfoByStartTimeAndEndTimeAndOrgName(Map<String, Object> params) {

        FaceAlarmStatisticsEntity entity = new FaceAlarmStatisticsEntity();

        try {
            entity = getStatistics(params);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return entity;
    }

    @Override
    public List<MongoEntity> insertMongo() {

        return mongoTemplate.findAll(MongoEntity.class,"FaceAlarmInfo");
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
        //统计车辆
        final Future<FaceAlarmStatisticsEntity> vehicleFuture =
                executor.submit(() -> getVehicleStatistics(params,"Vehicle"));
        setExecutor(entity,vehicleFuture);
        //统计行人
        final Future<FaceAlarmStatisticsEntity> recPedestrianFuture =
            executor.submit(() -> getRecPedestrianStatistics(params,"RecPedestrian"));
        setExecutor(entity,recPedestrianFuture);
        //统计非机动车
        final Future<FaceAlarmStatisticsEntity> nonMotorVehicleFuture =
            executor.submit(() -> getNonMotorVehiclesStatistics(params,"NonMotorVehicles"));
        setExecutor(entity,nonMotorVehicleFuture);

        //统计违规总数
        entity.setSum(entity.getViolationFace() + entity.getViolationPedestrian()
                + entity.getViolationVehicle() + entity.getViolationNonMotorVehicle() + entity.getNoMask());
        return entity;
    }

    /*
     * 统计人脸
     * */
    public FaceAlarmStatisticsEntity getRecFaceStatistics(Map<String, Object> params,String DataType) {

        params.put("DataType", DataType);
        //获取卡点设备预警信息列表
        List<FaceAlarmInfoParseEntity> alarmInfoList = getList(params);

        //初始化统计实体
        FaceAlarmStatisticsEntity entity = new FaceAlarmStatisticsEntity();

        //统计卡点信息
        entity.setFace(alarmInfoList.size());
        //违规数
        Long violationNum = alarmInfoList.stream().filter(e -> e.getViolationStatus() == 1).count();
        entity.setViolationFace(violationNum.intValue());

        alarmInfoList.forEach(e -> {

            JSONObject content = JSONObject.parseObject(e.getContent());

            if (content.getJSONObject("Attributes") != null) {
                String attributes = content.getJSONObject("Attributes").toJSONString();
                if (attributes.contains("无口罩")) {
                    entity.setNoMask(entity.getNoMask() + 1);//口罩不规范数量
                }
            }
        });

        return entity;
    }

    /*
     * 统计车辆
     * */
    public FaceAlarmStatisticsEntity getVehicleStatistics(Map<String, Object> params,String DataType) {

        params.put("DataType", DataType);
        //获取卡点设备预警信息列表
        List<FaceAlarmInfoParseEntity> alarmInfoList = getList(params);

        //初始化统计实体
        FaceAlarmStatisticsEntity entity = new FaceAlarmStatisticsEntity();

        //统计卡点信息
        entity.setVehicle(alarmInfoList.size());
        //违规数
        Long violationNum = alarmInfoList.stream().filter(e -> e.getViolationStatus() == 1).count();
        entity.setViolationVehicle(violationNum.intValue());

        return entity;
    }

    /*
     * 统计行人
     */
    public FaceAlarmStatisticsEntity getRecPedestrianStatistics(Map<String, Object> params,String DataType) {

        params.put("DataType", DataType);
        //获取卡点设备预警信息列表
        List<FaceAlarmInfoParseEntity> alarmInfoList = getList(params);

        //初始化统计实体
        FaceAlarmStatisticsEntity entity = new FaceAlarmStatisticsEntity();

        //统计卡点信息
        entity.setPedestrian(alarmInfoList.size());
        //违规数
        Long violationNum = alarmInfoList.stream().filter(e -> e.getViolationStatus() == 1).count();
        entity.setViolationPedestrian(violationNum.intValue());

        return entity;
    }

    /*
     * 统计非机动车辆
     */
    public FaceAlarmStatisticsEntity getNonMotorVehiclesStatistics(Map<String, Object> params,String DataType){

        params.put("DataType", DataType);
        //获取卡点设备预警信息列表
        List<FaceAlarmInfoParseEntity> alarmInfoList = getList(params);

        //初始化统计实体
        FaceAlarmStatisticsEntity entity = new FaceAlarmStatisticsEntity();

        //统计卡点信息
        entity.setNonMotorVehicle(alarmInfoList.size());
        //违规数
        Long violationNum = alarmInfoList.stream().filter(e -> e.getViolationStatus() == 1).count();
        entity.setViolationNonMotorVehicle(violationNum.intValue());

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
        } else if (getEntity.getVehicle() != 0) {

            entity.setVehicle(getEntity.getVehicle());
            entity.setViolationVehicle(getEntity.getViolationVehicle());
        } else if (getEntity.getPedestrian() != 0) {

            entity.setPedestrian(getEntity.getPedestrian());
            entity.setViolationPedestrian(getEntity.getViolationPedestrian());
        } else if (getEntity.getNonMotorVehicle() != 0) {

            entity.setNonMotorVehicle(getEntity.getNonMotorVehicle());
            entity.setViolationNonMotorVehicle(getEntity.getViolationNonMotorVehicle());
        }

        return entity;
    }

    private List<FaceAlarmInfoParseEntity> getList(Map<String, Object> params) {
        List<FaceAlarmInfoParseEntity> alarmInfoList;
        if (params.get("flag") != null) {
            alarmInfoList = faceAlarmInfoDao.selInfoByDayAndRemoteIP(params);
        } else {
            alarmInfoList = faceAlarmInfoDao.selInfoByStartTimeAndEndTimeAndRemoteIPs(params);
        }
        return alarmInfoList;
    }

    /*
    * 线程执行结束后设置entity
    */
    private void setExecutor(FaceAlarmStatisticsEntity entity,Future<FaceAlarmStatisticsEntity> future) throws InterruptedException, ExecutionException {
        long now = System.currentTimeMillis();
        int i = 1;
        while (true) {
            if (future.isDone() && !future.isCancelled()) {
                FaceAlarmStatisticsEntity getEntity = future.get();//获取结果
                setEntity(entity, getEntity);
                System.out.println("任务" + i++ + "获取完成!" + (System.currentTimeMillis() - now) + "ms");
                break;//当前future获取结果完毕，跳出while
            } else {
                Thread.sleep(1);//每次轮询休息1毫秒（CPU纳秒级），避免CPU高速轮循耗空CPU---》新手别忘记这个
            }
        }
    }
}
