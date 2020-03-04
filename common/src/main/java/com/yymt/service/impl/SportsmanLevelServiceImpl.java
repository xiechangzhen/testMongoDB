package com.yymt.service.impl;

import com.yymt.common.annotation.DataFilter;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.yymt.common.utils.PageUtils;
import com.yymt.common.utils.Query;

import com.yymt.dao.sport.SportsmanLevelDao;
import com.yymt.entity.sport.SportsmanLevelEntity;
import com.yymt.service.SportsmanLevelService;


@Service("sportsmanLevelService")
public class SportsmanLevelServiceImpl extends ServiceImpl<SportsmanLevelDao, SportsmanLevelEntity> implements SportsmanLevelService {

    @Override
    @DataFilter(subDept = true, user = false)
    public PageUtils queryPage(Map<String, Object> params) {
        boolean type = params.get("type")!=null;
        Page<SportsmanLevelEntity> page = this.selectPage(
                new Query<SportsmanLevelEntity>(params).getPage(),
                new EntityWrapper<SportsmanLevelEntity>().and(type,"level_type={0}",params.get("type"))
                .orderBy("create_time desc")
        );
        return new PageUtils(page);
    }

}
