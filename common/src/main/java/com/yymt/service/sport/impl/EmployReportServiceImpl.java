package com.yymt.service.sport.impl;

import com.baomidou.mybatisplus.mapper.SqlHelper;
import com.yymt.common.annotation.DataFilter;
import com.yymt.entity.sport.FeedBackEntity;
import com.yymt.service.sport.EmployReportService;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.yymt.common.utils.PageUtils;
import com.yymt.common.utils.Query;

import com.yymt.dao.sport.EmployReportDao;
import com.yymt.entity.sport.EmployReportEntity;


@Service("employReportService")
public class EmployReportServiceImpl extends ServiceImpl<EmployReportDao, EmployReportEntity> implements EmployReportService {

    @Override
    @DataFilter(subDept = true, user = false)
    public PageUtils queryPage(Map<String, Object> params) {
        Page<EmployReportEntity> page = this.selectPage(
                new Query<EmployReportEntity>(params).getPage(),
                new EntityWrapper<EmployReportEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils queryList(Map<String, Object> params) {
            Page<EmployReportEntity> page = new Query<EmployReportEntity>(params).getPage();
            EntityWrapper entityWrapper = new EntityWrapper<EmployReportEntity>();
            SqlHelper.fillWrapper(page, entityWrapper);
            page.setRecords(baseMapper.queryList(
                    page,
                    params
            ));
            return new PageUtils(page);
    }


}
