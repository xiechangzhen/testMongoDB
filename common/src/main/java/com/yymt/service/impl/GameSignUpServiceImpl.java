package com.yymt.service.impl;

import com.baomidou.mybatisplus.mapper.SqlHelper;
import com.yymt.common.annotation.DataFilter;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.yymt.common.utils.PageUtils;
import com.yymt.common.utils.Query;

import com.yymt.dao.sport.GameSignUpDao;
import com.yymt.entity.sport.GameSignUpEntity;
import com.yymt.service.GameSignUpService;


@Service("gameSignUpService")
public class GameSignUpServiceImpl extends ServiceImpl<GameSignUpDao, GameSignUpEntity> implements GameSignUpService {

    @Override
    @DataFilter(subDept = true, user = false)
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GameSignUpEntity> page = this.selectPage(
                new Query<GameSignUpEntity>(params).getPage(),
                new EntityWrapper<GameSignUpEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils selectGameSignUpPage(Map<String, Object> params) {
        Page page = new Query<>(params).getPage();
        EntityWrapper entityWrapper = new EntityWrapper<>();
        SqlHelper.fillWrapper(page, entityWrapper);
        page.setRecords(baseMapper.selectGameSignUpPage(
                page,
                params
        ));
        return new PageUtils(page);
    }

    @Override
    public int querySignupCount(int gameId) {
        return baseMapper.querySignupCount(gameId);
    }

}
