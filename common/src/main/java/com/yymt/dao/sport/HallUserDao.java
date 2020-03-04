package com.yymt.dao.sport;

import com.yymt.entity.sport.HallUserEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

/**
 * 用户管理的场馆表
 * 
 * @author cots
 * @date 2018-12-11 11:39:03
 */
public interface HallUserDao extends BaseMapper<HallUserEntity> {

    /**
     * 查询用户管理的场馆列表
     * */
    List listHallUser(RowBounds rowBounds, Map<String, Object> param);
	
}
