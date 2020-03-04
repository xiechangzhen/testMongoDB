package com.yymt.service.sport.impl;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.yymt.common.annotation.DataFilter;
import com.yymt.common.utils.PageUtils;
import com.yymt.common.utils.Query;
import com.yymt.dao.sport.RegisterVisitDao;
import com.yymt.entity.sport.RegisterVisitEntity;
import com.yymt.service.sport.RegisterVisitService;


@Service("registerVisitService")
public class RegisterVisitServiceImpl extends ServiceImpl<RegisterVisitDao, RegisterVisitEntity> implements RegisterVisitService {

    @Override
    @DataFilter(subDept = true, user = false)
    public PageUtils queryPage(Map<String, Object> params) {
        Page<RegisterVisitEntity> page = this.selectPage(
                new Query<RegisterVisitEntity>(params).getPage(),
                new EntityWrapper<RegisterVisitEntity>()
        );

        return new PageUtils(page);
    }

}
