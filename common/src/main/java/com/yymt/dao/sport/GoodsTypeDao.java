package com.yymt.dao.sport;

import com.yymt.entity.sport.GoodsTypeEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * 商品分类表
 * 
 * @author cots
 * @date 2018-12-13 08:52:56
 */
public interface GoodsTypeDao extends BaseMapper<GoodsTypeEntity> {
    /**
     * 查询所有商品类型
     * */
    List listGoodsType();
	
}
