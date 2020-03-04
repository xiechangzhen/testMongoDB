package com.yymt.service.impl;

import com.baomidou.mybatisplus.mapper.SqlHelper;
import com.yymt.common.annotation.DataFilter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.yymt.common.utils.PageUtils;
import com.yymt.common.utils.Query;

import com.yymt.dao.sport.HallGreatsDao;
import com.yymt.entity.sport.HallGreatsEntity;
import com.yymt.service.HallGreatsService;


@Service("hallGreatsService")
public class HallGreatsServiceImpl extends ServiceImpl<HallGreatsDao, HallGreatsEntity> implements HallGreatsService {

    @Override
    @DataFilter(subDept = true, user = false)
    public PageUtils queryPage(Map<String, Object> params) {
        Page<HallGreatsEntity> page = this.selectPage(
                new Query<HallGreatsEntity>(params).getPage(),
                new EntityWrapper<HallGreatsEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public int queryGreatCountByHallId(int id) {
        return baseMapper.queryGreatCountByHallId(id);
    }

    @Override
    public PageUtils like(Map<String, Object> params) {
        Page page = new Query<>(params).getPage();
        EntityWrapper entityWrapper = new EntityWrapper<>();
        SqlHelper.fillWrapper(page, entityWrapper);
        page.setRecords(baseMapper.like(
                page,
                params
        ));
        return new PageUtils(page);
    }

    @Override
    public int deleteIds(List list) {
        return baseMapper.deleteIds(list);
    }

}
