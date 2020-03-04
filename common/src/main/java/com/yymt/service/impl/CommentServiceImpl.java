package com.yymt.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.yymt.common.utils.PageUtils;
import com.yymt.common.utils.Query;
import com.yymt.dao.sport.CommentDao;
import com.yymt.entity.sport.CommentEntity;
import com.yymt.service.CommentService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("commentService")
public class CommentServiceImpl extends ServiceImpl<CommentDao, CommentEntity> implements CommentService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CommentEntity> page = this.selectPage(
                new Query<CommentEntity>(params).getPage(),
                new EntityWrapper<CommentEntity>()
        );

        return new PageUtils(page);
    }

}
