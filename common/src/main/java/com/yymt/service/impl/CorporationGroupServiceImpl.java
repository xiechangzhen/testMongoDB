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

import com.yymt.dao.sport.CorporationGroupDao;
import com.yymt.entity.sport.CorporationGroupEntity;
import com.yymt.service.CorporationGroupService;


@Service("corporationGroupService")
public class CorporationGroupServiceImpl extends ServiceImpl<CorporationGroupDao, CorporationGroupEntity> implements CorporationGroupService {

    @Override
    @DataFilter(subDept = true, user = false)
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CorporationGroupEntity> page = this.selectPage(
                new Query<CorporationGroupEntity>(params).getPage(),
                new EntityWrapper<>()
        );

        return new PageUtils(page);
    }

    @Override
    public List listGroupMember(int id) {
        return baseMapper.listGroupMember(id);
    }

}
