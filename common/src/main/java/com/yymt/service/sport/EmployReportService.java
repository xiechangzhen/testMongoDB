package com.yymt.service.sport;

import com.baomidou.mybatisplus.service.IService;
import com.yymt.common.utils.PageUtils;
import com.yymt.entity.sport.EmployReportEntity;

import java.util.List;
import java.util.Map;

/**
 * 员工信息上报
 *
 * @author cots
 * @date 2020-02-02 11:36:17
 */
public interface EmployReportService extends IService<EmployReportEntity> {

    PageUtils queryPage(Map<String, Object> params);

    PageUtils queryList(Map<String, Object> params);
}

