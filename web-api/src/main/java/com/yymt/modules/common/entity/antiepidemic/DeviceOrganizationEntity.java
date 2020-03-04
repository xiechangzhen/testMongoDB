package com.yymt.modules.common.entity.antiepidemic;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 设备组织关联
 *
 * @author xiezhen
 * @since 2020/2/26 14:06
 */

@TableName("DeviceOrganization")
@ApiModel(description = "设备组织关联")
public class DeviceOrganizationEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 设备id
     */
    @ApiModelProperty(value = "主键Id")
    private String DeviceId;

    /**
     * 组织id
     */
    @ApiModelProperty(value = "组织id")
    private Integer OrganizationId;

    public String getDeviceId() {
        return DeviceId;
    }

    public void setDeviceId(String deviceId) {
        DeviceId = deviceId;
    }

    public Integer getOrganizationId() {
        return OrganizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        OrganizationId = organizationId;
    }
}
