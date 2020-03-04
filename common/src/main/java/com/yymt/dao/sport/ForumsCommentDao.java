package com.yymt.dao.sport;

import com.yymt.entity.sport.ForumsCommentEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

/**
 * 帖子评论表
 * 
 * @author cots
 * @date 2018-09-05 16:23:30
 */
public interface ForumsCommentDao extends BaseMapper<ForumsCommentEntity> {

    /**
     *后台-获取社区评论回复列表
     */
    List selectCommentReplyListBack(RowBounds rowBounds, Map<String, Object> params);
    /**
     *APP-获取社区评论列表
     */
    List selectCommentList(RowBounds rowBounds, Map<String, Object> params);

    Map selectCommentDetail(int commentId);

    List selectChildCommentList(@Param("commentId")int commentId, @Param("isLimit")boolean isLimit,@Param("userId")Long userId);

    List selectChildCommentListWithLevel(Map<String,Object> params);

}
