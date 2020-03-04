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

import com.yymt.dao.sport.HallSportDao;
import com.yymt.entity.sport.HallSportEntity;
import com.yymt.service.HallSportService;


@Service("hallSportService")
public class HallSportServiceImpl extends ServiceImpl<HallSportDao, HallSportEntity> implements HallSportService {

    @Override
    @DataFilter(subDept = true, user = false)
    public PageUtils queryPage(Map<String, Object> params) {
        Page<HallSportEntity> page = this.selectPage(
                new Query<HallSportEntity>(params).getPage(),
                new EntityWrapper<HallSportEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public int deleteIds(List list) {
        return baseMapper.deleteIds(list);
    }

}
