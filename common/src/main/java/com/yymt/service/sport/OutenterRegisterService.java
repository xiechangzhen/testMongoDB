package com.yymt.service.sport;

import java.util.Map;

import com.baomidou.mybatisplus.service.IService;
import com.yymt.common.utils.PageUtils;
import com.yymt.entity.sport.OutenterRegisterEntity;

/**
 * 出入登记表
 *
 * @author xiaojin
 * @date 2020-02-11 14:57:10
 */
public interface OutenterRegisterService extends IService<OutenterRegisterEntity> {

	PageUtils queryPage(Map<String, Object> params);
}
