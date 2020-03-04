package com.yymt.dao.sport;

import com.yymt.entity.sport.EmployReportEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

/**
 * 员工信息上报
 * 
 * @author cots
 * @date 2020-02-02 11:36:17
 */
public interface EmployReportDao extends BaseMapper<EmployReportEntity> {
    List queryList(RowBounds rowBounds, Map<String, Object> params);
}
