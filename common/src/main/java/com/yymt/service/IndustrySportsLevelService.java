package com.yymt.service;

import com.baomidou.mybatisplus.service.IService;
import com.yymt.common.utils.PageUtils;
import com.yymt.entity.sport.IndustrySportsLevelEntity;

import java.util.Map;

/**
 * 
 *
 * @author cots
 * @date 2018-10-20 14:39:32
 */
public interface IndustrySportsLevelService extends IService<IndustrySportsLevelEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

