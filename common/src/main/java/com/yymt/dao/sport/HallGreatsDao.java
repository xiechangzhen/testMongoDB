package com.yymt.dao.sport;

import com.yymt.entity.sport.HallGreatsEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

/**
 * 场馆点赞表
 * 
 * @author cots
 * @date 2018-09-14 11:13:50
 */
public interface HallGreatsDao extends BaseMapper<HallGreatsEntity> {
    int queryGreatCountByHallId(int id);
    List like(RowBounds rowBounds, Map<String, Object> params);
    int deleteIds(@Param("ids") List list);
}
