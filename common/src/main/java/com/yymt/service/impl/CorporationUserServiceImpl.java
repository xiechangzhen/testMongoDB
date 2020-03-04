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

import com.yymt.dao.sport.CorporationUserDao;
import com.yymt.entity.sport.CorporationUserEntity;
import com.yymt.service.CorporationUserService;


@Service("corporationUserService")
public class CorporationUserServiceImpl extends ServiceImpl<CorporationUserDao, CorporationUserEntity> implements CorporationUserService {

    @Override
    @DataFilter(subDept = true, user = false)
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CorporationUserEntity> page = this.selectPage(
                new Query<CorporationUserEntity>(params).getPage(),
                new EntityWrapper<CorporationUserEntity>()
        );
        return new PageUtils(page);
    }

    @Override
    public List listUserCorporation(Long id) {
        return baseMapper.listUserCorporation(id);
    }
}
