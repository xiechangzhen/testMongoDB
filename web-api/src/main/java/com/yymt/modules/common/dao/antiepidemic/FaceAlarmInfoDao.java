package com.yymt.modules.common.dao.antiepidemic;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yymt.modules.common.entity.antiepidemic.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 告警管理
 *
 * @author xielin
 * @since 2020/2/26 14:11
 */
public interface FaceAlarmInfoDao extends BaseMapper<FaceAlarmInfoEntity> {

    /*
     * 根据告警Id获取告警详情
     * */
    Map<String, Object> queryInfoById(String id);

    /*
    * 根据卡点ip和时间获取告警信息
    * */
    List<FaceAlarmInfoParseEntity> selInfoByDayAndRemoteIP(Map<String,Object> params);

    /*
    * 根据卡点ip和开始结束时间获取告警信息
    * */
    List<FaceAlarmInfoParseEntity> selInfoByStartTimeAndEndTimeAndRemoteIPs(Map<String,Object> params);

    List<String> selContent();

    // 暂时转mongoDB用
    List<FaceAlarmInfoParseMongoEntity>  selAll();
}
