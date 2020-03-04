package com.yymt.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.SqlHelper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.yymt.common.utils.PageUtils;
import com.yymt.common.utils.Query;
import com.yymt.dao.sport.MessageDao;
import com.yymt.entity.sport.MessageEntity;
import com.yymt.service.MessageService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("messageService")
public class MessageServiceImpl extends ServiceImpl<MessageDao, MessageEntity> implements MessageService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<MessageEntity> page = this.selectPage(
                new Query<MessageEntity>(params).getPage(),
                new EntityWrapper<MessageEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils selectMessagePage(Map<String, Object> params) {
        long userId1 = (long)params.get("userId1");
        long userId2 = Long.parseLong(params.get("userId2").toString());
        Page<List> page = new Query<List>(params).getPage();
        Wrapper<MessageEntity> wrapper = new EntityWrapper<MessageEntity>();
        SqlHelper.fillWrapper(page, wrapper);
        page.setRecords(baseMapper.selectMessagePage(
                page,
                userId1,
                userId2
        ));
        return new PageUtils(page);
    }

    @Override
    public Integer queryMessageCountByDay(Map<String, Object> params) {
        return baseMapper.queryMessageCountByDay(params);
    }

}
