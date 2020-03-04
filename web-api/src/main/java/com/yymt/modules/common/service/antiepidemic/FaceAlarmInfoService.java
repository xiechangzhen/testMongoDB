package com.yymt.modules.common.service.antiepidemic;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yymt.common.utils.R;
import com.yymt.modules.common.entity.antiepidemic.DeviceEntity;
import com.yymt.modules.common.entity.antiepidemic.FaceAlarmInfoEntity;
import com.yymt.modules.common.entity.antiepidemic.OrganizationEntity;
import com.yymt.modules.common.entity.statistics.FaceAlarmStatisticsEntity;

import java.util.List;
import java.util.Map;

/**
 * 告警管理
 *
 * @author xielin
 * @since 2020/2/26 14:15
 */
public interface FaceAlarmInfoService extends IService<FaceAlarmInfoEntity> {

    /*
     * 通过类型获取告警列表
     */
    FaceAlarmStatisticsEntity queryInfoByStartTimeAndEndTimeAndOrgName(Map<String, Object> param);

    /*
     * 根据id查询告警详情
     */
    Map<String, Object> queryInfoById(String id);

}
