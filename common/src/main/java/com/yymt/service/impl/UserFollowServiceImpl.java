package com.yymt.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.SqlHelper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.yymt.common.utils.PageUtils;
import com.yymt.common.utils.Query;
import com.yymt.dao.sport.UserFollowDao;
import com.yymt.entity.sport.UserFollowEntity;
import com.yymt.service.UserFollowService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("userFollowService")
public class UserFollowServiceImpl extends ServiceImpl<UserFollowDao, UserFollowEntity> implements UserFollowService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<UserFollowEntity> page = this.selectPage(
                new Query<UserFollowEntity>(params).getPage(),
                new EntityWrapper<UserFollowEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils selectUserFollowPage(Map<String, Object> params) {
//        long userId = (long) params.get("userId");
//        String type = (String) params.get("type") == null ? "":params.get("type").toString();
//        boolean isFollow = (boolean) params.get("isFollow");//isFollow  true 获取关注列表  false 获取粉丝列表
        Page<List> page = new Query<List>(params).getPage();
        Wrapper<UserFollowEntity> wrapper = new EntityWrapper<>();
        SqlHelper.fillWrapper(page, wrapper);
        page.setRecords(baseMapper.selectUserFollowPage(
                page,
                params
        ));
        return new PageUtils(page);
    }

    @Override
    public Map<String, Object> userFriendsCount(Map<String, Object> params) {
        return baseMapper.userFriendsCount(params);
    }

    @Override
    public List<String> queryFansPushClientId(Long userId) {
        return baseMapper.queryFansPushClientId(userId);
    }

    @Override
    public Integer isFollowOrFans(Map<String, Object> param) {
        return baseMapper.isFollowOrFans(param);
    }

    @Override
    public PageUtils selectFansList(Map<String, Object> params) {
        Page<List> page = new Query<List>(params).getPage();
        Wrapper<UserFollowEntity> wrapper = new EntityWrapper<>();
        SqlHelper.fillWrapper(page, wrapper);
        page.setRecords(baseMapper.selectFansList(
                page,
                params
        ));
        return new PageUtils(page);
    }

    @Override
    public PageUtils selectFollowList(Map<String, Object> params) {
        Page<List> page = new Query<List>(params).getPage();
        Wrapper<UserFollowEntity> wrapper = new EntityWrapper<>();
        SqlHelper.fillWrapper(page, wrapper);
        page.setRecords(baseMapper.selectFollowList(
                page,
                params
        ));
        return new PageUtils(page);
    }

}
