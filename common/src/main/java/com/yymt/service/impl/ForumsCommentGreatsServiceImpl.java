package com.yymt.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.yymt.common.annotation.DataFilter;
import com.yymt.common.utils.PageUtils;
import com.yymt.common.utils.Query;
import com.yymt.dao.sport.ForumsCommentGreatsDao;
import com.yymt.entity.sport.ForumsCommentGreatsEntity;
import com.yymt.service.ForumsCommentGreatsService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("forumsCommentGreatsService")
public class ForumsCommentGreatsServiceImpl extends ServiceImpl<ForumsCommentGreatsDao, ForumsCommentGreatsEntity> implements ForumsCommentGreatsService {

    @Override
    @DataFilter(subDept = true, user = false)
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ForumsCommentGreatsEntity> page = this.selectPage(
                new Query<ForumsCommentGreatsEntity>(params).getPage(),
                new EntityWrapper<ForumsCommentGreatsEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public int queryGreatCountByForumsId(int id) {
        return baseMapper.queryCommentGreatCountByForumsId(id);
    }

}
