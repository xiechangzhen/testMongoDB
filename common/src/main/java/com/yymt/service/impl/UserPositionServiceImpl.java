package com.yymt.service.impl;

import com.yymt.common.annotation.DataFilter;
import org.springframework.stereotype.Service;

import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.yymt.common.utils.PageUtils;
import com.yymt.common.utils.Query;

import com.yymt.dao.api.UserPositionDao;
import com.yymt.entity.api.UserPositionEntity;
import com.yymt.service.UserPositionService;


@Service("userPositionService")
public class UserPositionServiceImpl extends ServiceImpl<UserPositionDao, UserPositionEntity> implements UserPositionService {

    @Override
    @DataFilter(subDept = true, user = false)
    public PageUtils queryPage(Map<String, Object> params) {
        Page<UserPositionEntity> page = this.selectPage(
                new Query<UserPositionEntity>(params).getPage(),
                new EntityWrapper<UserPositionEntity>()
        );

        return new PageUtils(page);
    }

}
