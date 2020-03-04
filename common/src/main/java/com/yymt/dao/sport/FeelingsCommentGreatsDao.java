package com.yymt.dao.sport;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.yymt.entity.sport.FeelingsCommentGreatsEntity;

/**
 * 心情评论点赞表
 * 
 * @author hgq
 * @date 2018-02-28 13:11:25
 */
public interface FeelingsCommentGreatsDao extends BaseMapper<FeelingsCommentGreatsEntity> {

    int queryCommentGreatByCommentIdAndFeelingsId(FeelingsCommentGreatsEntity entity);
}
