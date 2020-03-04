package com.yymt.service;

import com.baomidou.mybatisplus.service.IService;
import com.yymt.common.utils.PageUtils;
import com.yymt.entity.sport.CorporationGreatsEntity;

import java.util.List;
import java.util.Map;

/**
 * 组织点赞表
 *
 * @author cots
 * @date 2018-09-11 18:54:03
 */
public interface CorporationGreatsService extends IService<CorporationGreatsEntity> {

    PageUtils queryPage(Map<String, Object> params);

    Integer queryGreatCountByCorporationId(int id);

    PageUtils like(Map<String, Object> params);

    List<String> listCorporationGreatUser(int corporationId);
}

