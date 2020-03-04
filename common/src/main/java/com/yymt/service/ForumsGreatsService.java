package com.yymt.service;

import com.baomidou.mybatisplus.service.IService;
import com.yymt.common.utils.PageUtils;
import com.yymt.entity.sport.ForumsGreatsEntity;

import java.util.Map;

/**
 * 帖子点赞表
 *
 * @author cots
 * @date 2018-09-05 16:23:30
 */
public interface ForumsGreatsService extends IService<ForumsGreatsEntity> {

    PageUtils queryPage(Map<String, Object> params);
    int queryGreatCountByForumsId(int id);
    int cancelGreat(ForumsGreatsEntity entity);

    PageUtils like(Map<String, Object> params);
}

