package com.yymt.dao.sport;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.yymt.entity.sport.FeelingsCommentEntity;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

/**
 * 心情评论表
 * 
 * @author hgq
 * @date 2018-02-28 13:11:25
 */
public interface FeelingsCommentDao extends BaseMapper<FeelingsCommentEntity> {

    List selectMyPage(Map<String, Object> param);
    //后台心情评论列表
    List commentList(RowBounds rowBounds, Map<String, Object> params);

}
