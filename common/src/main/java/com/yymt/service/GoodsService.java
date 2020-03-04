package com.yymt.service;

import com.baomidou.mybatisplus.service.IService;
import com.yymt.common.utils.PageUtils;
import com.yymt.entity.sport.ForumsEntity;
import com.yymt.entity.sport.GoodsEntity;

import java.util.List;
import java.util.Map;

/**
 * 商品
 *
 * @author cots
 * @date 2018-12-13 08:52:56
 */
public interface GoodsService extends IService<GoodsEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 根据店铺id查询商品
     */
    PageUtils listGoodsByStoreId(Map<String, Object> params);

    /**
     * app查询所有上新的商品
     */
    PageUtils listGoods(Map<String, Object> params);

    /**
     * 删除店铺时删除店铺里面的所有商品
     */
    int deleteByStoreId(Integer storeId);

    /**
     * 后台查询商品列表
     */
    PageUtils listGoodsAdmin(Map<String, Object> params);

    /**
     * 被举报数
     */
    Integer reportCount(Map<String, Object> params);

    /**
     * 后台根据id查询商品信息
     */
    Map<String, Object> selectGoodsById(Integer id);

    /**
     * 获取指定标识集的商品列表
     *
     * @param ids
     * @return
     */
    List<GoodsEntity> getGoodsListByIds(List<Integer> ids);
}

