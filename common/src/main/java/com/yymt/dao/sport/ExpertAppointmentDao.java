package com.yymt.dao.sport;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.yymt.entity.sport.ExpertAppointmentEntity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

/**
 * 专家预约
 * 
 * @author hgq
 * @date 2018-03-02 10:56:10
 */
public interface ExpertAppointmentDao extends BaseMapper<ExpertAppointmentEntity> {
    List selectExpertAppointmentPage(RowBounds rowBounds, @Param("id") Long id, @Param("status") String status, @Param("direction") Integer direction);
    List selectExpertAppointmentCommentPage(RowBounds rowBounds, Map<String, Object> params);
    Map<String,Object> getCommentScore(Map<String, Object> params);
}
