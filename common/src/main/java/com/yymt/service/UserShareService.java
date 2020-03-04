package com.yymt.service;

import com.baomidou.mybatisplus.service.IService;
import com.yymt.common.utils.PageUtils;
import com.yymt.entity.sport.UserShareEntity;

import java.util.Map;

/**
 * 用户分享表
 *
 * @author hgq
 * @date 2018-06-22 11:25:35
 */
public interface UserShareService extends IService<UserShareEntity> {

    PageUtils queryPage(Map<String, Object> params);

    Integer queryCountById(Map<String, Object> data);
}

