package com.yymt.service.sport;

import com.baomidou.mybatisplus.service.IService;
import com.yymt.common.utils.PageUtils;
import com.yymt.entity.sport.TemperatureEntity;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

/**
 * 体温上报
 *
 * @author cots
 * @date 2020-02-06 10:05:06
 */
public interface TemperatureService extends IService<TemperatureEntity> {

    PageUtils queryPage(Map<String, Object> params);

    PageUtils queryList(Map<String, Object> params);

    PageUtils queryListByDate(Map<String, Object> params);

}

