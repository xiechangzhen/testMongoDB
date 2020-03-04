package com.yymt.service;

import com.baomidou.mybatisplus.service.IService;
import com.yymt.common.utils.PageUtils;
import com.yymt.entity.sport.CommentEntity;

import java.util.Map;

/**
 * 评论表
 *
 * @author hgq
 * @date 2018-02-10 14:26:32
 */
public interface CommentService extends IService<CommentEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

