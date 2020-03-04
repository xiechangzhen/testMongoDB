package com.yymt.service;

import com.baomidou.mybatisplus.service.IService;
import com.yymt.common.utils.PageUtils;
import com.yymt.entity.sport.CorporationGroupEntity;

import java.util.List;
import java.util.Map;

/**
 * 社团团体会员关系表
 *
 * @author cots
 * @date 2018-09-05 16:23:30
 */
public interface CorporationGroupService extends IService<CorporationGroupEntity> {

    PageUtils queryPage(Map<String, Object> params);
    List listGroupMember(int id);
}

