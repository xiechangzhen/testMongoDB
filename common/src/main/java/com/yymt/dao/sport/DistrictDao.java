package com.yymt.dao.sport;

import com.yymt.entity.sport.DistrictEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

/**
 * 中国县以上行政区及行政区代码
 * 
 * @author cots
 * @date 2018-09-07 10:00:52
 */
public interface DistrictDao extends BaseMapper<DistrictEntity> {
    List listDistrict(Map param);

    /**
     * 查询省级单位
     * */
    List listProvince(Integer level);

    /**
     * APP公共服务-城市区域：根据体育局提供的行政区域和排序返回相关数据
     */
    List queryDistrictByDict(RowBounds rowBounds, Map<String, Object> params);
}
