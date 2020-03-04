package com.yymt.service;

import com.baomidou.mybatisplus.service.IService;
import com.yymt.common.utils.PageUtils;
import com.yymt.entity.sport.GameSignUpEntity;

import java.util.Map;

/**
 * 赛事培训报名表
 *
 * @author cots
 * @date 2018-09-05 16:23:30
 */
public interface GameSignUpService extends IService<GameSignUpEntity> {

    PageUtils queryPage(Map<String, Object> params);
    PageUtils selectGameSignUpPage(Map<String, Object> params);
    int querySignupCount(int gameId);
}

