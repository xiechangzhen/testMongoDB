package com.yymt.service;

import com.baomidou.mybatisplus.service.IService;
import com.yymt.common.utils.PageUtils;
import com.yymt.entity.sport.StoreEntity;

import java.util.Map;

/**
 * 店铺表
 *
 * @author cots
 * @date 2018-12-13 08:52:56
 */
public interface StoreService extends IService<StoreEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 我的店铺列表
     * */
    PageUtils listStore(Map<String, Object> params);

    /**
     * 场馆附近的店铺
     * */
    PageUtils nearHallStore(Map<String, Object> params);

    /**
     * 后台店铺列表
     * */
    PageUtils listStoreAdmin(Map<String, Object> params);

    /**
     * 待审核店铺记录数
     * */
    Integer count(Map<String, Object> params);

    /**
     * 后台根据id查询店铺
     * */
    Map<String, Object> selectByIdAdmin(Integer id);

    /**
     * 被举报的店铺记录数
     * */
    Integer reportCount(Map<String, Object> params);
}

