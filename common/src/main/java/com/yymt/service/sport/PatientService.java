package com.yymt.service.sport;

import com.baomidou.mybatisplus.service.IService;
import com.yymt.common.utils.PageUtils;
import com.yymt.entity.sport.PatientEntity;

import java.util.Map;

/**
 * 病历
 *
 * @author cots
 * @date 2020-02-07 17:31:39
 */
public interface PatientService extends IService<PatientEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

