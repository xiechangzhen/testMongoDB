package com.yymt.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.SqlHelper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.yymt.common.annotation.DataFilter;
import com.yymt.common.utils.PageUtils;
import com.yymt.common.utils.Query;
import com.yymt.dao.sport.ForumsCommentDao;
import com.yymt.entity.sport.ForumsCommentEntity;
import com.yymt.service.ForumsCommentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("forumsCommentService")
public class ForumsCommentServiceImpl extends ServiceImpl<ForumsCommentDao, ForumsCommentEntity> implements ForumsCommentService {

    @Override
    @DataFilter(subDept = true, user = false)
    public PageUtils selectCommentReplyListBack(Map<String, Object> params) {
        Page<ForumsCommentEntity> page = new Query<ForumsCommentEntity>(params).getPage();
        EntityWrapper entityWrapper = new EntityWrapper<ForumsCommentEntity>();
        SqlHelper.fillWrapper(page, entityWrapper);
        page.setRecords(baseMapper.selectCommentReplyListBack(
                page,
                params
        ));
        return new PageUtils(page);
    }

    @Override
    public PageUtils selectCommentList(Map<String, Object> params) {
        Page<ForumsCommentEntity> page = new Query<ForumsCommentEntity>(params).getPage();
        EntityWrapper entityWrapper = new EntityWrapper<ForumsCommentEntity>();
        SqlHelper.fillWrapper(page, entityWrapper);
        page.setRecords(baseMapper.selectCommentList(
                page,
                params
        ));
        return new PageUtils(page);
    }

    @Override
    public List selectChildCommentList(int commentId,boolean isLimit,Long userId) {
        return baseMapper.selectChildCommentList(commentId,isLimit,userId);
    }

    @Override
    public Map selectCommentDetail(int commentId) {
        return baseMapper.selectCommentDetail(commentId);
    }

    @Override
    public List selectChildCommentListWithLevel(Map<String, Object> params) {
        return baseMapper.selectChildCommentListWithLevel(params);
    }

}
