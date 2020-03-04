package com.yymt.service;

import com.baomidou.mybatisplus.service.IService;
import com.yymt.common.utils.PageUtils;
import com.yymt.entity.sport.CorporationPositionEntity;

import java.util.Map;

/**
 * 社团职位表
 *
 * @author cots
 * @date 2018-09-05 16:23:30
 */
public interface CorporationPositionService extends IService<CorporationPositionEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

