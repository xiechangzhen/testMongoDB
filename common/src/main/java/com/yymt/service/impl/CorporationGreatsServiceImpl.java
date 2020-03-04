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

import com.yymt.dao.sport.CorporationGreatsDao;
import com.yymt.entity.sport.CorporationGreatsEntity;
import com.yymt.service.CorporationGreatsService;


@Service("corporationGreatsService")
public class CorporationGreatsServiceImpl extends ServiceImpl<CorporationGreatsDao, CorporationGreatsEntity> implements CorporationGreatsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CorporationGreatsEntity> page = this.selectPage(
                new Query<CorporationGreatsEntity>(params).getPage(),
                new EntityWrapper<>()
        );

        return new PageUtils(page);
    }

    @Override
    public Integer queryGreatCountByCorporationId(int id) {
        return baseMapper.queryGreatCountByCorporationId(id);
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
    public List<String> listCorporationGreatUser(int corporationId) {
        return baseMapper.listCorporationGreatUser(corporationId);
    }

}
