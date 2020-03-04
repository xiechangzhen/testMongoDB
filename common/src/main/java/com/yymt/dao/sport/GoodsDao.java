package com.yymt.dao.sport;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.yymt.common.utils.PageUtils;
import com.yymt.entity.sport.ForumsEntity;
import com.yymt.entity.sport.GoodsEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.apache.poi.hssf.record.RowRecord;

import java.util.List;
import java.util.Map;

/**
 * 商品
 *
 * @author cots
 * @date 2018-12-13 08:52:56
 */
public interface GoodsDao extends BaseMapper<GoodsEntity> {

    /**
     * 根据店铺id查询商品
     */
    List listGoodsByStoreId(RowBounds rowBounds, Map<String, Object> params);

    /**
     * app查询所有上新的商品
     */
    List listGoods(RowBounds rowBounds, Map<String, Object> params);

    /**
     * 删除店铺时删除店铺里面的所有商品
     */
    int deleteByStoreId(@Param("storeId") Integer storeId);

    /**
     * 后台查询商品列表
     */
    List listGoodsAdmin(RowBounds rowBounds, Map<String, Object> params);

    /**
     * 被举报数
     */
    Integer reportCount(Map<String, Object> params);

    /**
     * 后台根据id查询商品信息
     */
    Map<String, Object> selectGoodsById(@Param("id") Integer id);

    /**
     * 获取指定标识集的商品列表
     *
     * @param ids
     * @return
     */
    List<GoodsEntity> getGoodsListByIds(@Param("ids") List<Integer> ids);

}
