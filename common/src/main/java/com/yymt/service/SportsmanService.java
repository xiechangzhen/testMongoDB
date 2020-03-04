package com.yymt.service;

import com.baomidou.mybatisplus.service.IService;
import com.yymt.common.utils.PageUtils;
import com.yymt.entity.sport.SportsmanEntity;

import java.util.Map;

/**
 * 运动员等级
 *
 * @author cots
 * @date 2018-08-22 08:52:52
 */
public interface SportsmanService extends IService<SportsmanEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

