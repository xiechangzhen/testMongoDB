package com.yymt.service.impl;

import com.yymt.common.annotation.DataFilter;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.yymt.common.utils.PageUtils;
import com.yymt.common.utils.Query;

import com.yymt.dao.sport.SportsmanDao;
import com.yymt.entity.sport.SportsmanEntity;
import com.yymt.service.SportsmanService;


@Service("sportsmanService")
public class SportsmanServiceImpl extends ServiceImpl<SportsmanDao, SportsmanEntity> implements SportsmanService {

    @Override
    @DataFilter(subDept = true, user = false)
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SportsmanEntity> page = this.selectPage(
                new Query<SportsmanEntity>(params).getPage(),
                new EntityWrapper<SportsmanEntity>()
        );

        return new PageUtils(page);
    }

}
