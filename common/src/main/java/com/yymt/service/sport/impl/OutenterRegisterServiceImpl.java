package com.yymt.service.sport.impl;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.yymt.common.annotation.DataFilter;
import com.yymt.common.utils.PageUtils;
import com.yymt.common.utils.Query;
import com.yymt.dao.sport.OutenterRegisterDao;
import com.yymt.entity.sport.OutenterRegisterEntity;
import com.yymt.service.sport.OutenterRegisterService;


@Service("outenterRegisterService")
public class OutenterRegisterServiceImpl extends ServiceImpl<OutenterRegisterDao, OutenterRegisterEntity> implements OutenterRegisterService {

    @Override
    @DataFilter(subDept = true, user = false)
    public PageUtils queryPage(Map<String, Object> params) {
        Page<OutenterRegisterEntity> page = this.selectPage(
                new Query<OutenterRegisterEntity>(params).getPage(),
                new EntityWrapper<OutenterRegisterEntity>()
        );

        return new PageUtils(page);
    }

}
