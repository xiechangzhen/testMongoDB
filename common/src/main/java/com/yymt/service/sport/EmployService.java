package com.yymt.service.sport;

import com.baomidou.mybatisplus.service.IService;
import com.yymt.common.utils.PageUtils;
import com.yymt.entity.sport.EmployEntity;

import java.util.Map;

/**
 * 员工信息表
 *
 * @author cots
 * @date 2020-02-02 11:36:17
 */
public interface EmployService extends IService<EmployEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

