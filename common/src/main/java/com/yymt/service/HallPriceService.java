package com.yymt.service;

import com.baomidou.mybatisplus.service.IService;
import com.yymt.common.utils.PageUtils;
import com.yymt.entity.sport.HallPriceEntity;

import java.util.List;
import java.util.Map;

/**
 * 场馆项目报价表
 *
 * @author cots
 * @date 2018-09-05 16:23:30
 */
public interface HallPriceService extends IService<HallPriceEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List listHallPrice(int id);

    int deleteIds(List list);
}

