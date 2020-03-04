package com.yymt.service;

import com.baomidou.mybatisplus.service.IService;
import com.yymt.common.utils.PageUtils;
import com.yymt.entity.sport.ForumsCommentGreatsEntity;

import java.util.Map;

/**
 * 帖子评论点赞表
 *
 * @author cots
 * @date 2018-09-05 16:23:30
 */
public interface ForumsCommentGreatsService extends IService<ForumsCommentGreatsEntity> {

    PageUtils queryPage(Map<String, Object> params);

    int queryGreatCountByForumsId(int id);
}

