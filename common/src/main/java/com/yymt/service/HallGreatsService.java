package com.yymt.service;

import com.baomidou.mybatisplus.service.IService;
import com.yymt.common.utils.PageUtils;
import com.yymt.entity.sport.HallGreatsEntity;

import java.util.List;
import java.util.Map;

/**
 * 场馆点赞表
 *
 * @author cots
 * @date 2018-09-14 11:13:50
 */
public interface HallGreatsService extends IService<HallGreatsEntity> {

    PageUtils queryPage(Map<String, Object> params);
    int queryGreatCountByHallId(int id);
    PageUtils like(Map<String, Object> params);
    int deleteIds(List list);
}

