package com.yymt.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.yymt.common.utils.PageUtils;
import com.yymt.common.utils.Query;
import com.yymt.dao.sport.UserShareDao;
import com.yymt.entity.sport.UserShareEntity;
import com.yymt.service.UserShareService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("userShareService")
public class UserShareServiceImpl extends ServiceImpl<UserShareDao, UserShareEntity> implements UserShareService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<UserShareEntity> page = this.selectPage(
                new Query<UserShareEntity>(params).getPage(),
                new EntityWrapper<>()
        );

        return new PageUtils(page);
    }

    @Override
    public Integer queryCountById(Map<String,Object> data) {
        return baseMapper.queryCountById(data);
    }

}
