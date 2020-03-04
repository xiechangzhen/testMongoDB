package com.yymt.service.sport;

import java.util.Map;

import com.baomidou.mybatisplus.service.IService;
import com.yymt.common.utils.PageUtils;
import com.yymt.entity.sport.RegisterVisitEntity;

/**
 * 登记拜访表
 *
 * @author xiaojin
 * @date 2020-02-21 11:43:31
 */
public interface RegisterVisitService extends IService<RegisterVisitEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

