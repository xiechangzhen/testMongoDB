package com.yymt.service;

import com.baomidou.mybatisplus.service.IService;
import com.yymt.common.utils.PageUtils;
import com.yymt.entity.sport.UserMarkEntity;

import java.util.Map;

/**
 * 用户收藏表
 *
 * @author hgq
 * @date 2018-02-10 14:26:32
 */
public interface UserMarkService extends IService<UserMarkEntity> {

    PageUtils queryPage(Map<String, Object> params);
    int cancelMark(UserMarkEntity entity);

    PageUtils selectNewsPage(Map<String, Object> params);
    PageUtils selectFeelingsPage(Map<String, Object> params);
    PageUtils selectHelpPage(Map<String, Object> params);

    Integer queryCountById(Map<String, Object> params);
}

