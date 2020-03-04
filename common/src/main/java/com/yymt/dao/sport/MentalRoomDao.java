package com.yymt.dao.sport;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.yymt.entity.sport.MentalRoomEntity;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

/**
 * 心防室
 * 
 * @author hgq
 * @date 2018-02-08 13:22:09
 */
public interface MentalRoomDao extends BaseMapper<MentalRoomEntity> {
    List queryMentalList(RowBounds rowBounds, Map<String, Object> params);
}
