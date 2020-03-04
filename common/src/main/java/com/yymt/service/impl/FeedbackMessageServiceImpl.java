package com.yymt.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.yymt.common.utils.PageUtils;
import com.yymt.common.utils.Query;
import com.yymt.dao.sport.FeedbackMessageDao;
import com.yymt.entity.sport.FeedbackMessageEntity;
import com.yymt.service.FeedbackMessageService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("feedbackMessageService")
public class FeedbackMessageServiceImpl extends ServiceImpl<FeedbackMessageDao, FeedbackMessageEntity> implements FeedbackMessageService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<FeedbackMessageEntity> page = this.selectPage(
                new Query<FeedbackMessageEntity>(params).getPage(),
                new EntityWrapper<FeedbackMessageEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List messageList(Map<String, Object> params) {
        return baseMapper.messageList(params);
    }

}
