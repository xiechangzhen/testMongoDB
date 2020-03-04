package com.yymt.service;

import com.baomidou.mybatisplus.service.IService;
import com.yymt.common.utils.PageUtils;
import com.yymt.entity.sport.ActivityJoinEntity;

import java.util.Map;

/**
 * 活动参与表
 *
 * @author hgq
 * @date 2018-03-14 15:07:41
 */
public interface ActivityJoinService extends IService<ActivityJoinEntity> {

    PageUtils queryPage(Map<String, Object> params);
    PageUtils selectJoinUserPage(Map<String, Object> params);
    Map getTotal(Map<String, Object> params);
}

