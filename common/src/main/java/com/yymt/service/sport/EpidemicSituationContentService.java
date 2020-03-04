package com.yymt.service.sport;

import com.baomidou.mybatisplus.service.IService;
import com.yymt.common.utils.PageUtils;
import com.yymt.entity.sport.EpidemicSituationContentEntity;

import java.util.Map;

/**
 * 疫情信息
 *
 * @author cots
 * @date 2020-01-28 19:34:48
 */
public interface EpidemicSituationContentService extends IService<EpidemicSituationContentEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

