package com.yymt.service.sport.impl;

import com.yymt.common.annotation.DataFilter;
import com.yymt.service.sport.EmployService;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.yymt.common.utils.PageUtils;
import com.yymt.common.utils.Query;

import com.yymt.dao.sport.EmployDao;
import com.yymt.entity.sport.EmployEntity;


@Service("employService")
public class EmployServiceImpl extends ServiceImpl<EmployDao, EmployEntity> implements EmployService {

    @Override
    @DataFilter(subDept = true, user = false)
    public PageUtils queryPage(Map<String, Object> params) {
        Page<EmployEntity> page = this.selectPage(
                new Query<EmployEntity>(params).getPage(),
                new EntityWrapper<EmployEntity>()
        );

        return new PageUtils(page);
    }

}
