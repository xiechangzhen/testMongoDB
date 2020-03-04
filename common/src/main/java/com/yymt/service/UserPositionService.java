package com.yymt.service;

import com.baomidou.mybatisplus.service.IService;
import com.yymt.common.utils.PageUtils;
import com.yymt.entity.api.UserPositionEntity;

import java.util.Map;

/**
 * 用户身份表
 *
 * @author cots
 * @date 2018-12-13 10:14:43
 */
public interface UserPositionService extends IService<UserPositionEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

