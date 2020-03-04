package com.yymt.service;

import com.baomidou.mybatisplus.service.IService;
import com.yymt.common.utils.PageUtils;
import com.yymt.entity.sport.SportsmanLevelEntity;

import java.util.Map;

/**
 * 运动员等级
 *
 * @author cots
 * @date 2018-09-05 16:23:30
 */
public interface SportsmanLevelService extends IService<SportsmanLevelEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

