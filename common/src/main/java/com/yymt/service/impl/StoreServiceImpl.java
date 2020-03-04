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

import com.yymt.dao.sport.StoreDao;
import com.yymt.entity.sport.StoreEntity;
import com.yymt.service.StoreService;


@Service("storeService")
public class StoreServiceImpl extends ServiceImpl<StoreDao, StoreEntity> implements StoreService {

    @Override
    @DataFilter(subDept = true, user = false)
    public PageUtils queryPage(Map<String, Object> params) {
        Page<StoreEntity> page = this.selectPage(
                new Query<StoreEntity>(params).getPage(),
                new EntityWrapper<StoreEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils listStore(Map<String, Object> params) {
        Page<StoreEntity> page = new Query<StoreEntity>(params).getPage();
        EntityWrapper entityWrapper = new EntityWrapper<StoreEntity>();
        SqlHelper.fillWrapper(page,entityWrapper);
        page.setRecords(baseMapper.listStore(
                page,
                params
        ));
        return new PageUtils(page);
    }

    @Override
    public PageUtils nearHallStore(Map<String, Object> params) {
        Page<StoreEntity> page = new Query<StoreEntity>(params).getPage();
        EntityWrapper entityWrapper = new EntityWrapper<StoreEntity>();
        SqlHelper.fillWrapper(page,entityWrapper);
        page.setRecords(baseMapper.nearHallStore(
                page,
                params
        ));
        return new PageUtils(page);
    }

    @Override
    public PageUtils listStoreAdmin(Map<String, Object> params) {
        Page page = new Query<StoreEntity>(params).getPage();
        EntityWrapper entityWrapper = new EntityWrapper<StoreEntity>();
        SqlHelper.fillWrapper(page,entityWrapper);
        page.setRecords(baseMapper.listStoreAdmin(
                page,
                params
        ));
        return new PageUtils(page);
    }

    @Override
    public Integer count(Map<String, Object> params) {
        return baseMapper.count(params);
    }

    @Override
    public Map<String, Object> selectByIdAdmin(Integer id) {
        return baseMapper.selectByIdAdmin(id);
    }

    @Override
    public Integer reportCount(Map<String, Object> params) {
        return baseMapper.reportCount(params);
    }

}
