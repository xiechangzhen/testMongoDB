package com.yymt.dao.sport;

import com.yymt.entity.sport.ForumsCommentGreatsEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * 帖子评论点赞表
 * 
 * @author cots
 * @date 2018-09-05 16:23:30
 */
public interface ForumsCommentGreatsDao extends BaseMapper<ForumsCommentGreatsEntity> {
	int queryCommentGreatCountByForumsId(Integer id);
}
