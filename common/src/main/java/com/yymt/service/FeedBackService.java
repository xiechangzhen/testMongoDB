package com.yymt.service;

import com.baomidou.mybatisplus.service.IService;
import com.yymt.common.utils.PageUtils;
import com.yymt.entity.sport.FeedBackEntity;

import java.util.Map;

/**
 * 意见反馈表
 *
 * @author hgq
 * @date 2018-03-06 10:58:41
 */
public interface FeedBackService extends IService<FeedBackEntity> {

    PageUtils queryPage(Map<String, Object> params);

    //后台反馈列表
    PageUtils queryFeedbackPage(Map<String, Object> params);
    int queryUnhandleFeedbackNum(Map<String, Object> params);

    Map feedbackDetail(Integer id);
}

