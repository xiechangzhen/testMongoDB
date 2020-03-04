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

import com.yymt.dao.sport.HallUserDao;
import com.yymt.entity.sport.HallUserEntity;
import com.yymt.service.HallUserService;


@Service("hallUserService")
public class HallUserServiceImpl extends ServiceImpl<HallUserDao, HallUserEntity> implements HallUserService {

    @Override
    @DataFilter(subDept = true, user = false)
    public PageUtils queryPage(Map<String, Object> params) {
        Page<HallUserEntity> page = this.selectPage(
                new Query<HallUserEntity>(params).getPage(),
                new EntityWrapper<HallUserEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils listHallUser(Map<String, Object> param) {
        Page<HallUserEntity> page = new Query<HallUserEntity>(param).getPage();
        EntityWrapper entityWrapper = new EntityWrapper<HallUserEntity>();
        SqlHelper.fillWrapper(page, entityWrapper);
        page.setRecords(baseMapper.listHallUser(
                page,
                param
        ));

        return new PageUtils(page);
    }

}
