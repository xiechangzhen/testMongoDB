package com.yymt.modules.common.service.antiepidemic;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yymt.modules.common.entity.antiepidemic.DeviceEntity;
import com.yymt.modules.common.entity.antiepidemic.MongoEntity;
import com.yymt.modules.common.entity.statistics.FaceAlarmStatisticsEntity;

import java.util.List;
import java.util.Map;

/**
 * 卡点
 *
 * @author xiezhen
 * @since 2020/2/26 14:15
 */
public interface DeviceService extends IService<DeviceEntity> {

    /*
     * 按日期和设备编号查询卡点的流量统计
     * */
    FaceAlarmStatisticsEntity queryStatisticsDayAndByDevID(Map<String, Object> params);

    /*
     * 根据小区名和开始结束时间获取告警信息
     * */
    FaceAlarmStatisticsEntity queryInfoByStartTimeAndEndTimeAndOrgName(Map<String, Object> params);

    List<MongoEntity> insertMongo();
}
