package com.yymt.service.impl;

import com.baomidou.mybatisplus.mapper.SqlHelper;
import com.yymt.common.annotation.DataFilter;
import com.yymt.entity.sport.ForumsEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.yymt.common.utils.PageUtils;
import com.yymt.common.utils.Query;

import com.yymt.dao.sport.GoodsDao;
import com.yymt.entity.sport.GoodsEntity;
import com.yymt.service.GoodsService;


@Service("goodsService")
public class GoodsServiceImpl extends ServiceImpl<GoodsDao, GoodsEntity> implements GoodsService {

    @Override
    @DataFilter(subDept = true, user = false)
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GoodsEntity> page = this.selectPage(
                new Query<GoodsEntity>(params).getPage(),
                new EntityWrapper<GoodsEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils listGoodsByStoreId(Map<String, Object> params) {
        Page page = new Query<GoodsEntity>(params).getPage();
        EntityWrapper entityWrapper = new EntityWrapper<GoodsEntity>();
        SqlHelper.fillWrapper(page,entityWrapper);
        page.setRecords(baseMapper.listGoodsByStoreId(
                page,
                params
        ));
        return new PageUtils(page);
    }

    @Override
    public PageUtils listGoods(Map<String, Object> params) {
        Page page = new Query<GoodsEntity>(params).getPage();
        EntityWrapper entityWrapper = new EntityWrapper();
        SqlHelper.fillWrapper(page, entityWrapper);
        page.setRecords(baseMapper.listGoods(
                page,
                params
        ));
        return new PageUtils(page);
    }

    @Override
    public int deleteByStoreId(Integer storeId) {
        return baseMapper.deleteByStoreId(storeId);
    }

    @Override
    public PageUtils listGoodsAdmin(Map<String, Object> params) {
        Page page = new Query<GoodsEntity>(params).getPage();
        EntityWrapper entityWrapper = new EntityWrapper();
        SqlHelper.fillWrapper(page,entityWrapper);
        page.setRecords(baseMapper.listGoodsAdmin(
                page,
                params
        ));
        return new PageUtils(page);
    }

    @Override
    public Integer reportCount(Map<String, Object> params) {
        return baseMapper.reportCount(params);
    }

    @Override
    public Map<String, Object> selectGoodsById(Integer id) {
        return baseMapper.selectGoodsById(id);
    }

    /**
     * 获取指定标识集的商品列表
     *
     * @param ids
     * @return
     */
    @Override
    public List<GoodsEntity> getGoodsListByIds(List<Integer> ids) {
        return baseMapper.getGoodsListByIds(ids);
    }

}
