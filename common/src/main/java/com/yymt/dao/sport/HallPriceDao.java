package com.yymt.dao.sport;

import com.yymt.entity.sport.HallPriceEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 场馆项目报价表
 * 
 * @author cots
 * @date 2018-09-05 16:23:30
 */
public interface HallPriceDao extends BaseMapper<HallPriceEntity> {
    List listHallPrice(int id);
    int deleteIds(@Param("ids") List list);
}
