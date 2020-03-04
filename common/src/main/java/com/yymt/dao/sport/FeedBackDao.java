package com.yymt.dao.sport;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.yymt.entity.sport.FeedBackEntity;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

/**
 * 意见反馈表
 * 
 * @author hgq
 * @date 2018-03-06 10:58:41
 */
public interface FeedBackDao extends BaseMapper<FeedBackEntity> {

    //后台详情
    Map feedbackDetail(Integer id);
    int queryUnhandleFeedbackNum(Map<String, Object> params);
    //后台列表
    List queryFeedbackList(RowBounds rowBounds, Map<String, Object> params);
    //APP反馈列表
    List queryFeedbackListApp(RowBounds rowBounds, Map<String, Object> params);
}
