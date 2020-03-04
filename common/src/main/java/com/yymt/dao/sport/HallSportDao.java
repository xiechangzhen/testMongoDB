package com.yymt.dao.sport;

import com.yymt.entity.sport.HallSportEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 场馆项目表
 * 
 * @author cots
 * @date 2018-09-05 16:23:30
 */
public interface HallSportDao extends BaseMapper<HallSportEntity> {
    int deleteIds(@Param("ids") List list);
	
}
