package com.yymt.dao.sport;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.yymt.entity.sport.DeviceEntity;

/**
 * 智能手表设备
 * 
 * @author hgq
 * @date 2018-02-08 15:47:00
 */
public interface DeviceDao extends BaseMapper<DeviceEntity> {
	 boolean insertDeviceEntity(DeviceEntity entity);
	 long selectBySmartWatchId(DeviceEntity entity);
}
