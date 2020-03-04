package com.yymt.dao.sport;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.yymt.entity.sport.ActivityJoinEntity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

/**
 * 活动参与表
 * 
 * @author hgq
 * @date 2018-03-14 15:07:41
 */
public interface ActivityJoinDao extends BaseMapper<ActivityJoinEntity> {
    List selectJoinUserPage(RowBounds rowBounds, @Param("activityId") Integer activityId);
    Map getTotal(Map<String, Object> params);
}
