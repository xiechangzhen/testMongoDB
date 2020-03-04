package com.yymt.dao.sport;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.yymt.entity.sport.UserShareEntity;

import java.util.Map;

/**
 * 用户分享表
 * 
 * @author hgq
 * @date 2018-06-22 11:25:35
 */
public interface UserShareDao extends BaseMapper<UserShareEntity> {

    Integer queryCountById(Map<String, Object> data);
	
}
