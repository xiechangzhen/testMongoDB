package com.yymt.service.impl;

import com.yymt.common.annotation.DataFilter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.yymt.common.utils.PageUtils;
import com.yymt.common.utils.Query;

import com.yymt.dao.sport.GoodsTypeDao;
import com.yymt.entity.sport.GoodsTypeEntity;
import com.yymt.service.GoodsTypeService;


@Service("goodsTypeService")
public class GoodsTypeServiceImpl extends ServiceImpl<GoodsTypeDao, GoodsTypeEntity> implements GoodsTypeService {

    @Override
    @DataFilter(subDept = true, user = false)
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GoodsTypeEntity> page = this.selectPage(
                new Query<GoodsTypeEntity>(params).getPage(),
                new EntityWrapper<GoodsTypeEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List listGoodsType() {
        return baseMapper.listGoodsType();
    }

}
