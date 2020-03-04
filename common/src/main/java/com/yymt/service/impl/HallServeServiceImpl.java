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

import com.yymt.dao.sport.HallServeDao;
import com.yymt.entity.sport.HallServeEntity;
import com.yymt.service.HallServeService;


@Service("hallServeService")
public class HallServeServiceImpl extends ServiceImpl<HallServeDao, HallServeEntity> implements HallServeService {

    @Override
    @DataFilter(subDept = true, user = false)
    public PageUtils queryPage(Map<String, Object> params) {
        Page<HallServeEntity> page = this.selectPage(
                new Query<HallServeEntity>(params).getPage(),
                new EntityWrapper<HallServeEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils listHallServe(Map<String, Object> params) {
        Page<HallServeEntity> page = new Query<HallServeEntity>(params).getPage();
        EntityWrapper entityWrapper = new EntityWrapper<HallServeEntity>();
        SqlHelper.fillWrapper(page, entityWrapper);
        page.setRecords(baseMapper.listHallServe(
                page,
                params
        ));
        return new PageUtils(page);
    }

    @Override
    public PageUtils listHallAdmin(Map<String, Object> params) {
        Page page = new Query<HallServeEntity>(params).getPage();
        EntityWrapper entityWrapper = new EntityWrapper<HallServeEntity>();
        SqlHelper.fillWrapper(page, entityWrapper);
        page.setRecords(baseMapper.listHallAdmin(
                page,
                params
        ));
        return new PageUtils(page);
    }

    @Override
    public Map<String, Object> hallServeById(Integer id) {
        return baseMapper.hallServeById(id);
    }

    @Override
    public Integer count(Map<String, Object> map) {
        return baseMapper.count(map);
    }

    @Override
    public Integer reportCount(Map<String, Object> params) {
        return baseMapper.reportCount(params);
    }

    @Override
    public PageUtils nearHallserve(Map<String, Object> params) {
        Page page = new Query<HallServeEntity>(params).getPage();
        EntityWrapper entityWrapper = new EntityWrapper();
        SqlHelper.fillWrapper(page, entityWrapper);
        page.setRecords(baseMapper.nearHallserve(
                page,
                params
        ));
        return new PageUtils(page);
    }

    @Override
    public PageUtils nearHall(Map<String, Object> params) {
        Page page = new Query<HallServeEntity>(params).getPage();
        EntityWrapper entityWrapper = new EntityWrapper();
        SqlHelper.fillWrapper(page, entityWrapper);
        page.setRecords(baseMapper.nearHall(
                page,
                params
        ));
        return new PageUtils(page);
    }

    /**
     * 获取指定标识集的场馆服务列表
     *
     * @param ids
     * @return
     */
    @Override
    public List<HallServeEntity> getHallServeListByIds(List<Integer> ids) {
        return baseMapper.getHallServeListByIds(ids);
    }

    @Override
    public int updateByHallId(Map<String, Object> map) {
        return baseMapper.updateByHallId(map);
    }

}
