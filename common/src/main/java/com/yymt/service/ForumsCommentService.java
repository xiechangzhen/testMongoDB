package com.yymt.service;

import com.baomidou.mybatisplus.service.IService;
import com.yymt.common.utils.PageUtils;
import com.yymt.entity.sport.ForumsCommentEntity;

import java.util.List;
import java.util.Map;

/**
 * 帖子评论表
 *
 * @author cots
 * @date 2018-09-05 16:23:30
 */
public interface ForumsCommentService extends IService<ForumsCommentEntity> {

    PageUtils selectCommentReplyListBack(Map<String, Object> params);

    /**
     *APP获取社区评论列表
     */
    PageUtils selectCommentList(Map<String, Object> params);

    /**
     *
     * @param commentId 评论id
     * @param isLimit 是否限制子评论条数
     * @return
     */
    List selectChildCommentList(int commentId,boolean isLimit,Long userId);

    Map selectCommentDetail(int commentId);

    List selectChildCommentListWithLevel(Map<String,Object> params);

}

