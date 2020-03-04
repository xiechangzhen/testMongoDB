package com.yymt.service;

import com.baomidou.mybatisplus.service.IService;
import com.yymt.common.utils.PageUtils;
import com.yymt.entity.sport.MessageEntity;

import java.util.Map;

/**
 * 互动留言表
 *
 * @author hgq
 * @date 2018-03-14 15:07:41
 */
public interface MessageService extends IService<MessageEntity> {

    PageUtils queryPage(Map<String, Object> params);
    PageUtils selectMessagePage(Map<String, Object> params);
    Integer queryMessageCountByDay(Map<String, Object> params);
}

