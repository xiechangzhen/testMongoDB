package com.yymt.service;

import com.baomidou.mybatisplus.service.IService;
import com.yymt.common.utils.PageUtils;
import com.yymt.entity.sport.GoodsTypeEntity;

import java.util.List;
import java.util.Map;

/**
 * 商品分类表
 *
 * @author cots
 * @date 2018-12-13 08:52:56
 */
public interface GoodsTypeService extends IService<GoodsTypeEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 查询所有商品类型
     * */
    List listGoodsType();
}

