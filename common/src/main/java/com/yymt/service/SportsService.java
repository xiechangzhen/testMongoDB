package com.yymt.service;

import com.baomidou.mybatisplus.service.IService;
import com.yymt.common.utils.PageUtils;
import com.yymt.entity.sport.SportsEntity;

import java.util.List;
import java.util.Map;

/**
 * 运动项目
 *
 * @author cots
 * @date 2018-09-05 16:23:30
 */
public interface SportsService extends IService<SportsEntity> {

    PageUtils queryPage(Map<String, Object> params);
    PageUtils listSports(Map<String, Object> params);
}

