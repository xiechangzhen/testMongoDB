package com.yymt.modules.common.service.antiepidemic.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yymt.common.utils.DateUtils;
import com.yymt.modules.common.dao.antiepidemic.DeviceDao;
import com.yymt.modules.common.dao.antiepidemic.FaceAlarmInfoDao;
import com.yymt.modules.common.entity.antiepidemic.DeviceEntity;
import com.yymt.modules.common.entity.mongo.MongoInfoEntity;
import com.yymt.modules.common.entity.statistics.FaceAlarmStatisticsEntity;
import com.yymt.modules.common.service.antiepidemic.DeviceMongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * 卡点
 *
 * @author xiezhen
 * @since 2020/2/26 14:16
 */
@Service
public class DeviceMongoServiceImpl extends ServiceImpl<DeviceDao, DeviceEntity> implements DeviceMongoService {

    @Autowired
    private MongoTemplate mongoTemplate;
    //通过注解引入配置
    @Resource(name = "defaultThreadPool")
    private ThreadPoolTaskExecutor executor;

    @Override
    public FaceAlarmStatisticsEntity queryStatisticsDayAndByDevID(Map<String, Object> params) {

        Query query = new Query();
        Criteria criteria = new Criteria();
        long startTime = DateUtils.dateToms((String) params.get("day"));
        long endTime = startTime + 24 * 60 * 60 * 1000;
        Criteria gte = Criteria.where("Metadata.Timestamp").gte(startTime);
        Criteria lt = Criteria.where("Metadata.Timestamp").lt(endTime);
        Pattern pattern = Pattern.compile("^.*" + baseMapper.selRemoteIPByDevId(params) + ".*$");
        Criteria like = Criteria.where("Metadata.SensorUrl").regex(pattern);
        criteria.andOperator(gte, lt, like);
        query.addCriteria(criteria);
        List<MongoInfoEntity> list = mongoTemplate.find(query, MongoInfoEntity.class);
        FaceAlarmStatisticsEntity entity = new FaceAlarmStatisticsEntity();
        try {
            entity = getStatisticsEntity(list);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return entity;
    }

    @Override
    public FaceAlarmStatisticsEntity queryInfoByStartTimeAndEndTimeAndOrgName(Map<String, Object> params) {

        long startTime = (long)params.get("startTime");
        long endTime = (long)params.get("endTime");
        Criteria gte = Criteria.where("Metadata.Timestamp").gte(startTime);
        Criteria lte = Criteria.where("Metadata.Timestamp").lte(endTime);

        List<MongoInfoEntity> list = new ArrayList<>();
        if(params.get("orgName") != null){
            List<String> remoteIPs = baseMapper.selRemoteIPsByOrgName(params);

            for (String remoteIP : remoteIPs) {
                Query query = new Query();
                Criteria criteria = new Criteria();
                Pattern pattern = Pattern.compile("^.*" + remoteIP + ".*$");
                Criteria like = Criteria.where("Metadata.SensorUrl").regex(pattern);
                criteria.andOperator(gte, lte, like);
                query.addCriteria(criteria);
                list.addAll(mongoTemplate.find(query, MongoInfoEntity.class));
            }
        }else {
            Query query = new Query();
            Criteria criteria = new Criteria();
            criteria.andOperator(gte, lte);
            query.addCriteria(criteria);
            list = mongoTemplate.find(query, MongoInfoEntity.class);
        }


        FaceAlarmStatisticsEntity entity = new FaceAlarmStatisticsEntity();
        try {
            entity = getStatisticsEntity(list);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return entity;

    }


    private FaceAlarmStatisticsEntity getStatisticsEntity(List<MongoInfoEntity> list) throws ExecutionException, InterruptedException {

        FaceAlarmStatisticsEntity entity = new FaceAlarmStatisticsEntity();
        //人脸统计
        final Future<FaceAlarmStatisticsEntity> faceStatistics
                = executor.submit(() -> getFaceSum(list));
        setExecutor(entity,faceStatistics);
        //行人统计
        final Future<FaceAlarmStatisticsEntity> pedestrianStatistics
                = executor.submit(() -> getPedestrianSum(list));
        setExecutor(entity,pedestrianStatistics);
        //机动车统计
        final Future<FaceAlarmStatisticsEntity> vehicleStatistics
                = executor.submit(() -> getVehicleSum(list));
        setExecutor(entity,vehicleStatistics);
        //非机动车统计
        final Future<FaceAlarmStatisticsEntity> motorVehiclesStatistics
                = executor.submit(() -> getMotorVehiclesSum(list));
        setExecutor(entity,motorVehiclesStatistics);

        //统计违规总数
        entity.setSum(entity.getViolationFace() + entity.getViolationPedestrian()
                + entity.getViolationVehicle() + entity.getViolationNonMotorVehicle() + entity.getNoMask());

        return entity;
    }

    private FaceAlarmStatisticsEntity getFaceSum(List<MongoInfoEntity> list){
        FaceAlarmStatisticsEntity entity = new FaceAlarmStatisticsEntity();
        List<MongoInfoEntity> recFaceList = list.stream()
                .filter(e -> e.getRecFace() != null)
                .collect(Collectors.toList());
        if (recFaceList != null && recFaceList.size() > 0) {
            entity.setFace(recFaceList.size());
            entity.setViolationFace((int) recFaceList.stream()
                    .filter(e -> DateUtils.isViolation(
                            e.getMetadata().getLong("Timestamp")))
                    .count());
            entity.setNoMask((int) recFaceList.stream()
                    .filter(e -> e.getRecFace().toString().contains("无口罩"))
                    .count());
        }
        return entity;
    }

    private FaceAlarmStatisticsEntity getPedestrianSum(List<MongoInfoEntity> list){
        FaceAlarmStatisticsEntity entity = new FaceAlarmStatisticsEntity();
        List<MongoInfoEntity> recPedestrianList = list.stream()
                .filter(e -> e.getRecPedestrian() != null)
                .collect(Collectors.toList());
        if (recPedestrianList != null && recPedestrianList.size() > 0) {
            entity.setPedestrian(recPedestrianList.size());
            entity.setViolationPedestrian((int) recPedestrianList.stream()
                    .filter(e -> DateUtils.isViolation(
                            e.getMetadata().getLong("Timestamp")))
                    .count());
        }
        return entity;
    }

    private FaceAlarmStatisticsEntity getVehicleSum(List<MongoInfoEntity> list){
        FaceAlarmStatisticsEntity entity = new FaceAlarmStatisticsEntity();
        List<MongoInfoEntity> vehicleList = list.stream()
                .filter(e -> e.getVehicle() != null)
                .collect(Collectors.toList());
        if (vehicleList != null && vehicleList.size() > 0) {
            entity.setVehicle(vehicleList.size());
            entity.setViolationVehicle((int) vehicleList.stream()
                    .filter(e -> DateUtils.isViolation(
                            e.getMetadata().getLong("Timestamp")))
                    .count());
        }
        return entity;
    }

    private FaceAlarmStatisticsEntity getMotorVehiclesSum(List<MongoInfoEntity> list){
        FaceAlarmStatisticsEntity entity = new FaceAlarmStatisticsEntity();
        List<MongoInfoEntity> nonMotorVehiclesList = list.stream()
                .filter(e -> e.getNonMotorVehicles() != null)
                .collect(Collectors.toList());
        if (nonMotorVehiclesList != null && nonMotorVehiclesList.size() > 0) {
            entity.setNonMotorVehicle(nonMotorVehiclesList.size());
            entity.setViolationNonMotorVehicle((int) nonMotorVehiclesList.stream()
                    .filter(e -> DateUtils.isViolation(
                            e.getMetadata().getLong("Timestamp")))
                    .count());
        }
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
