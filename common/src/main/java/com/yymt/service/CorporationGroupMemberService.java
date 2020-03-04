package com.yymt.service;

import com.baomidou.mybatisplus.service.IService;
import com.yymt.common.utils.PageUtils;
import com.yymt.entity.sport.CorporationGroupMemberEntity;

import java.util.Map;

/**
 * 团体会员信息表
 *
 * @author cots
 * @date 2018-09-05 16:23:30
 */
public interface CorporationGroupMemberService extends IService<CorporationGroupMemberEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

