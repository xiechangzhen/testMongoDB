package com.yymt.dao.sport;

import com.yymt.entity.sport.StoreEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

/**
 * 店铺表
 * 
 * @author cots
 * @date 2018-12-13 08:52:56
 */
public interface StoreDao extends BaseMapper<StoreEntity> {

    /**
     * 我的店铺列表
     * */
    List listStore(RowBounds rowBounds, Map<String, Object> params);

    /**
     * 场馆附近的店铺
     * */
    List nearHallStore(RowBounds rowBounds, Map<String, Object> params);

    /**
     * 后台店铺列表
     * */
    List listStoreAdmin(RowBounds rowBounds,Map<String, Object> params);

    /**
     * 待审核店铺记录数
     * */
    Integer count(Map<String, Object> params);

    /**
     * 后台根据id查询店铺
     * */
    Map<String, Object> selectByIdAdmin(@Param("id") Integer id);

    /**
     * 被举报的店铺记录数
     * */
    Integer reportCount(Map<String, Object> params);
	
}
