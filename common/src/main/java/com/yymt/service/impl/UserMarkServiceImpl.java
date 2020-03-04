package com.yymt.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.SqlHelper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.yymt.common.utils.PageUtils;
import com.yymt.common.utils.Query;
import com.yymt.dao.sport.UserMarkDao;
import com.yymt.entity.sport.UserMarkEntity;
import com.yymt.service.UserMarkService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("userMarkService")
public class UserMarkServiceImpl extends ServiceImpl<UserMarkDao, UserMarkEntity> implements UserMarkService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String userId = (String) params.get("userId");
        Page<UserMarkEntity> page = this.selectPage(
                new Query<UserMarkEntity>(params).getPage(),
                new EntityWrapper<UserMarkEntity>().where(StringUtils.isNotBlank(userId),"user_id = {0}",userId)
        );
        return new PageUtils(page);
    }

    @Override
    public int cancelMark(UserMarkEntity entity) {
        return baseMapper.cancelMark(entity);
    }

    @Override
    public PageUtils selectNewsPage(Map<String, Object> params) {
        Page<List> page = new Query<List>(params).getPage();
        Wrapper<UserMarkEntity> wrapper = new EntityWrapper<>();
        SqlHelper.fillWrapper(page, wrapper);
        page.setRecords(baseMapper.selectNewsPage(
                page,
                params
        ));
        return new PageUtils(page);
    }

    @Override
    public PageUtils selectFeelingsPage(Map<String, Object> params) {
        Page<List> page = new Query<List>(params).getPage();
        Wrapper<UserMarkEntity> wrapper = new EntityWrapper<UserMarkEntity>();
        SqlHelper.fillWrapper(page, wrapper);
        page.setRecords(baseMapper.selectFeelingsPage(
                page,
                params
        ));
        return new PageUtils(page);
    }

    @Override
    public PageUtils selectHelpPage(Map<String, Object> params) {
        Page<List> page = new Query<List>(params).getPage();
        Wrapper<UserMarkEntity> wrapper = new EntityWrapper<UserMarkEntity>();
        SqlHelper.fillWrapper(page, wrapper);
        page.setRecords(baseMapper.selectHelpPage(
                page,
                params
        ));
        return new PageUtils(page);
    }

    @Override
    public Integer queryCountById(Map<String, Object> params) {
        return baseMapper.queryCountById(params);
    }

   /* @Override
    public PageUtils selectUserMarkPage(Map<String, Object> params) {
        Page<List> page = new Query<List>(params).getPage();
        Wrapper<UserMarkEntity> wrapper = new EntityWrapper<UserMarkEntity>();
        SqlHelper.fillWrapper(page, wrapper);
        page.setRecords(baseMapper.selectUserMarkPage(
                page,
                params
        ));
        return new PageUtils(page);
    }*/

}
