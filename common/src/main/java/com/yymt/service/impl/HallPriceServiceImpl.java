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

import com.yymt.dao.sport.HallPriceDao;
import com.yymt.entity.sport.HallPriceEntity;
import com.yymt.service.HallPriceService;


@Service("hallPriceService")
public class HallPriceServiceImpl extends ServiceImpl<HallPriceDao, HallPriceEntity> implements HallPriceService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<HallPriceEntity> page = this.selectPage(
                new Query<HallPriceEntity>(params).getPage(),
                new EntityWrapper<>()
        );

        return new PageUtils(page);
    }

    @Override
    public List listHallPrice(int id) {
        return baseMapper.listHallPrice(id);
    }

    @Override
    public int deleteIds(List list) {
        return baseMapper.deleteIds(list);
    }

}
