package com.yymt.dao.sport;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.yymt.entity.sport.HelpCommentEntity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

/**
 * 求助评论表
 * 
 * @author hgq
 * @date 2018-03-06 15:44:37
 */
public interface HelpCommentDao extends BaseMapper<HelpCommentEntity> {
    List selectHelpCommentPage(@Param("id") Integer id);
    //后台求助评论列表
    List commentList(RowBounds rowBounds, Map<String, Object> params);
}
