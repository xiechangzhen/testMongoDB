package com.yymt.service.impl;

import com.baomidou.mybatisplus.mapper.SqlHelper;
import com.yymt.common.annotation.DataFilter;
import com.yymt.entity.sport.HallEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.yymt.common.utils.PageUtils;
import com.yymt.common.utils.Query;

import com.yymt.dao.sport.SportsDao;
import com.yymt.entity.sport.SportsEntity;
import com.yymt.service.SportsService;


@Service("sportsService")
public class SportsServiceImpl extends ServiceImpl<SportsDao, SportsEntity> implements SportsService {

    @Override
    @DataFilter(subDept = true, user = false)
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SportsEntity> page = this.selectPage(
                new Query<SportsEntity>(params).getPage(),
                new EntityWrapper<SportsEntity>().orderBy("create_time desc")
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils listSports(Map<String, Object> params) {
        Page<SportsEntity> page = new Query<SportsEntity>(params).getPage();
        page.setSize(1000);
        EntityWrapper entityWrapper = new EntityWrapper<HallEntity>();
        SqlHelper.fillWrapper(page, entityWrapper);
        page.setRecords(baseMapper.listSports(
                page,
                params
        ));
        return new PageUtils(page);
    }
}
