package com.yymt.dao.sport;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.yymt.entity.sport.FeedbackMessageEntity;

import java.util.List;
import java.util.Map;

/**
 * 问题反馈回复表
 * 
 * @author hgq
 * @date 2018-06-20 09:35:50
 */
public interface FeedbackMessageDao extends BaseMapper<FeedbackMessageEntity> {
    List messageList(Map<String, Object> params);
}
