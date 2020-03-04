package com.yymt.service.impl;

import com.baomidou.mybatisplus.mapper.SqlHelper;
import com.yymt.common.annotation.DataFilter;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.yymt.common.utils.PageUtils;
import com.yymt.common.utils.Query;

import com.yymt.dao.sport.ForumsGreatsDao;
import com.yymt.entity.sport.ForumsGreatsEntity;
import com.yymt.service.ForumsGreatsService;


@Service("forumsGreatsService")
public class ForumsGreatsServiceImpl extends ServiceImpl<ForumsGreatsDao, ForumsGreatsEntity> implements ForumsGreatsService {

    @Override
    @DataFilter(subDept = true, user = false)
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ForumsGreatsEntity> page = this.selectPage(
                new Query<ForumsGreatsEntity>(params).getPage(),
                new EntityWrapper<ForumsGreatsEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public int queryGreatCountByForumsId(int id) {
        return baseMapper.queryGreatCountByForumsId(id);
    }

    @Override
    public int cancelGreat(ForumsGreatsEntity entity) {
        return baseMapper.cancelGreat(entity);
    }

    @Override
    public PageUtils like(Map<String, Object> params) {
        Page page = new Query<>(params).getPage();
        EntityWrapper entityWrapper = new EntityWrapper<>();
        SqlHelper.fillWrapper(page, entityWrapper);
        page.setRecords(baseMapper.like(
                page,
                params
        ));
        return new PageUtils(page);
    }
}
