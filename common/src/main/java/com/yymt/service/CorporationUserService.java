package com.yymt.service;

import com.baomidou.mybatisplus.service.IService;
import com.yymt.common.utils.PageUtils;
import com.yymt.entity.sport.CorporationUserEntity;

import java.util.List;
import java.util.Map;

/**
 * 用户社团表
 *
 * @author cots
 * @date 2018-09-05 16:23:30
 */
public interface CorporationUserService extends IService<CorporationUserEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List listUserCorporation(Long id);
}

