package com.yymt.service.impl;

import com.yymt.common.annotation.DataFilter;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.yymt.common.utils.PageUtils;
import com.yymt.common.utils.Query;

import com.yymt.dao.sport.GamesGreatsDao;
import com.yymt.entity.sport.GamesGreatsEntity;
import com.yymt.service.GamesGreatsService;


@Service("gamesGreatsService")
public class GamesGreatsServiceImpl extends ServiceImpl<GamesGreatsDao, GamesGreatsEntity> implements GamesGreatsService {

    @Override
    @DataFilter(subDept = true, user = false)
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GamesGreatsEntity> page = this.selectPage(
                new Query<GamesGreatsEntity>(params).getPage(),
                new EntityWrapper<GamesGreatsEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public Integer queryGreatCountByGameId(int id) {
        return baseMapper.queryGreatCountByGameId(id);
    }

}
