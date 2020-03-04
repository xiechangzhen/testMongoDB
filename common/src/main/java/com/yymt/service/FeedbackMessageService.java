package com.yymt.service;

import com.baomidou.mybatisplus.service.IService;
import com.yymt.common.utils.PageUtils;
import com.yymt.entity.sport.FeedbackMessageEntity;

import java.util.List;
import java.util.Map;

/**
 * 问题反馈回复表
 *
 * @author hgq
 * @date 2018-06-20 09:35:50
 */
public interface FeedbackMessageService extends IService<FeedbackMessageEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List messageList(Map<String, Object> params);
}

