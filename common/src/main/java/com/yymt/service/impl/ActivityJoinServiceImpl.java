package com.yymt.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.SqlHelper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.yymt.common.utils.PageUtils;
import com.yymt.common.utils.Query;
import com.yymt.dao.sport.ActivityJoinDao;
import com.yymt.entity.sport.ActivityJoinEntity;
import com.yymt.service.ActivityJoinService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("activityJoinService")
public class ActivityJoinServiceImpl extends ServiceImpl<ActivityJoinDao, ActivityJoinEntity> implements ActivityJoinService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ActivityJoinEntity> page = this.selectPage(
                new Query<ActivityJoinEntity>(params).getPage(),
                new EntityWrapper<>()
        );
        return new PageUtils(page);
    }

    @Override
    public PageUtils selectJoinUserPage(Map<String, Object> params) {
        int activityId = (int)params.get("activityId");
        Page<List> page = new Query<List>(params).getPage();
        Wrapper<ActivityJoinEntity> wrapper = new EntityWrapper<>();
        SqlHelper.fillWrapper(page, wrapper);
        page.setRecords(baseMapper.selectJoinUserPage(
                page,
                activityId
        ));
        return new PageUtils(page);
    }

    @Override
    public Map getTotal(Map<String, Object> params) {
        return baseMapper.getTotal(params);
    }

}
