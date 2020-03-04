package com.yymt.dao.sport;

import com.yymt.entity.sport.SportsEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

/**
 * 运动项目
 * 
 * @author cots
 * @date 2018-09-05 16:23:30
 */
public interface SportsDao extends BaseMapper<SportsEntity> {
	List listSports(RowBounds rowBounds, Map<String, Object> params);
}
