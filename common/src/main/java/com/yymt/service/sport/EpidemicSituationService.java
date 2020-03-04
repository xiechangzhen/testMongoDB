package com.yymt.service.sport;

import com.baomidou.mybatisplus.service.IService;
import com.yymt.common.utils.PageUtils;
import com.yymt.entity.sport.EpidemicSituationEntity;

import java.util.Map;

/**
 * 疫情上报信息表
 *
 * @author cots
 * @date 2020-01-28 17:28:09
 */
public interface EpidemicSituationService extends IService<EpidemicSituationEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

