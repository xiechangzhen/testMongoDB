package com.yymt.modules.common.dao.antiepidemic;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yymt.modules.common.entity.antiepidemic.DeviceEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 组织结构
 *
 * @author xiezhen
 * @since 2020/2/26 14:11
 */
public interface DeviceDao extends BaseMapper<DeviceEntity> {

    /*
    * 根据deviceId获取remoteIP
    * */
    String selRemoteIPByDevId(Map<String,Object> params);

    /*
    * 根据小区名获取卡点id
    * */
    List<String> selRemoteIPsByOrgName(Map<String,Object> params);

    /*
     * 根据RemoteIP获取卡点
     * */
    DeviceEntity selDeviceIPsByRemoteIP(@Param("remoteIP") String remoteIP);
}
