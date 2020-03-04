package com.yymt.service;

import com.baomidou.mybatisplus.service.IService;
import com.yymt.common.utils.PageUtils;
import com.yymt.entity.sport.DistrictEntity;

import java.util.List;
import java.util.Map;

/**
 * 中国县以上行政区及行政区代码
 *
 * @author cots
 * @date 2018-09-07 10:00:52
 */
public interface DistrictService extends IService<DistrictEntity> {

    PageUtils queryPage(Map<String, Object> params);

    //app公共服务：根据体育局提供的行政区域和排序返回相关数据
    PageUtils queryDistrictByDict(Map<String, Object> params);

    List listDistrict(Map param);

    /**
     * 查询省级单位
     * */
    List listProvince(Integer level);
}

