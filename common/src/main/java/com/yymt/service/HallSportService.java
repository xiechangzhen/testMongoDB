package com.yymt.service;

import com.baomidou.mybatisplus.service.IService;
import com.yymt.common.utils.PageUtils;
import com.yymt.entity.sport.HallSportEntity;

import java.util.List;
import java.util.Map;

/**
 * 场馆项目表
 *
 * @author cots
 * @date 2018-09-05 16:23:30
 */
public interface HallSportService extends IService<HallSportEntity> {

    PageUtils queryPage(Map<String, Object> params);
    int deleteIds(List list);
}

