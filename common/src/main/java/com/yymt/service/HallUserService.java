package com.yymt.service;

import com.baomidou.mybatisplus.service.IService;
import com.yymt.common.utils.PageUtils;
import com.yymt.entity.sport.HallUserEntity;

import java.util.List;
import java.util.Map;

/**
 * 用户管理的场馆表
 *
 * @author cots
 * @date 2018-12-11 11:39:03
 */
public interface HallUserService extends IService<HallUserEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 查询用户管理的场馆列表
     * */
    PageUtils listHallUser(Map<String, Object> param);
}

