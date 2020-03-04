package com.yymt.dao.sport;

import com.yymt.entity.sport.TemperatureEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

/**
 * 体温上报
 * 
 * @author cots
 * @date 2020-02-06 10:05:06
 */
public interface TemperatureDao extends BaseMapper<TemperatureEntity> {
    List queryList(RowBounds rowBounds, Map<String, Object> params);
    List queryListByDate(RowBounds rowBounds, Map<String, Object> params);
}
