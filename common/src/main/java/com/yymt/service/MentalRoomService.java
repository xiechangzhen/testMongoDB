package com.yymt.service;

import com.baomidou.mybatisplus.service.IService;
import com.yymt.common.utils.PageUtils;
import com.yymt.entity.sport.MentalRoomEntity;

import java.util.Map;

/**
 * 心防室
 *
 * @author hgq
 * @date 2018-02-08 13:22:09
 */
public interface MentalRoomService extends IService<MentalRoomEntity> {

    PageUtils queryMentalPage(Map<String, Object> params);
}

