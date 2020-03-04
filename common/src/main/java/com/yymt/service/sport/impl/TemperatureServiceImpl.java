package com.yymt.service.sport.impl;

import com.baomidou.mybatisplus.mapper.SqlHelper;
import com.yymt.common.annotation.DataFilter;
import com.yymt.entity.sport.EmployReportEntity;
import com.yymt.service.sport.TemperatureService;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.yymt.common.utils.PageUtils;
import com.yymt.common.utils.Query;

import com.yymt.dao.sport.TemperatureDao;
import com.yymt.entity.sport.TemperatureEntity;


@Service("temperatureService")
public class TemperatureServiceImpl extends ServiceImpl<TemperatureDao, TemperatureEntity> implements TemperatureService {

    @Override
    @DataFilter(subDept = true, user = false)
    public PageUtils queryPage(Map<String, Object> params) {
        Page<TemperatureEntity> page = this.selectPage(
                new Query<TemperatureEntity>(params).getPage(),
                new EntityWrapper<TemperatureEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils queryList(Map<String, Object> params) {
        Page<TemperatureEntity> page = new Query<TemperatureEntity>(params).getPage();
        EntityWrapper entityWrapper = new EntityWrapper<TemperatureEntity>();
        SqlHelper.fillWrapper(page, entityWrapper);
        page.setRecords(baseMapper.queryList(
                page,
                params
        ));
        return new PageUtils(page);
    }

    @Override
    public PageUtils queryListByDate(Map<String, Object> params) {
        Page<TemperatureEntity> page = new Query<TemperatureEntity>(params).getPage();
        EntityWrapper entityWrapper = new EntityWrapper<TemperatureEntity>();
        SqlHelper.fillWrapper(page, entityWrapper);
        page.setRecords(baseMapper.queryListByDate(
                page,
                params
        ));
        return new PageUtils(page);
    }

}
