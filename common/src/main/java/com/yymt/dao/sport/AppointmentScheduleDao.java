package com.yymt.dao.sport;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.yymt.entity.sport.AppointmentScheduleEntity;

import java.util.List;

/**
 * 预约时间表
 * 
 * @author hgq
 * @date 2018-03-27 09:10:23
 */
public interface AppointmentScheduleDao extends BaseMapper<AppointmentScheduleEntity> {
    List<String> queryDistinctExpertSchedule(Long expertId);
}
