package com.yymt.modules.common.entity.antiepidemic;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;

import java.util.Date;

/**
 * 设备
 *
 * @author xiezhen
 * @since 2020/2/26 14:00
 */

@TableName("Device")
@ApiModel(description = "设备")
public class DeviceEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 主键Id
     */
    @TableId
    private String DevID;

    private String RemoteIP;

    private Integer Port;

    private Date RegisterDate;

    private Date HeartTime;

    private Boolean IsOneline;

    private String Desc;

    private Integer SIPID;

    private String DeviceInfo;

    private Integer hasSMS;

    private Integer SMSId;

    private String DeviceMenu;

    private String Longitude;

    private String Latitude;

    private Integer IsAnaly;

    private String NvrID;

    private Integer NvrChannel;

    private String Remark;

    private String Account;

    private String Password;

    private Integer StreamType;

    @TableField(exist = false)
    private String SensorUrl;

    public String getDevID() {
        return DevID;
    }

    public void setDevID(String devID) {
        DevID = devID;
    }

    public String getRemoteIP() {
        return RemoteIP;
    }

    public void setRemoteIP(String remoteIP) {
        RemoteIP = remoteIP;
    }

    public Integer getPort() {
        return Port;
    }

    public void setPort(Integer port) {
        Port = port;
    }

    public Date getRegisterDate() {
        return RegisterDate;
    }

    public void setRegisterDate(Date registerDate) {
        RegisterDate = registerDate;
    }

    public Date getHeartTime() {
        return HeartTime;
    }

    public void setHeartTime(Date heartTime) {
        HeartTime = heartTime;
    }

    public Boolean getOneline() {
        return IsOneline;
    }

    public void setOneline(Boolean oneline) {
        IsOneline = oneline;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }

    public Integer getSIPID() {
        return SIPID;
    }

    public void setSIPID(Integer SIPID) {
        this.SIPID = SIPID;
    }

    public String getDeviceInfo() {
        return DeviceInfo;
    }

    public void setDeviceInfo(String deviceInfo) {
        DeviceInfo = deviceInfo;
    }

    public Integer getHasSMS() {
        return hasSMS;
    }

    public void setHasSMS(Integer hasSMS) {
        this.hasSMS = hasSMS;
    }

    public Integer getSMSId() {
        return SMSId;
    }

    public void setSMSId(Integer SMSId) {
        this.SMSId = SMSId;
    }

    public String getDeviceMenu() {
        return DeviceMenu;
    }

    public void setDeviceMenu(String deviceMenu) {
        DeviceMenu = deviceMenu;
    }

    public String getLongitude() {
        return Longitude;
    }

    public void setLongitude(String longitude) {
        Longitude = longitude;
    }

    public String getLatitude() {
        return Latitude;
    }

    public void setLatitude(String latitude) {
        Latitude = latitude;
    }

    public Integer getIsAnaly() {
        return IsAnaly;
    }

    public void setIsAnaly(Integer isAnaly) {
        IsAnaly = isAnaly;
    }

    public String getNvrID() {
        return NvrID;
    }

    public void setNvrID(String nvrID) {
        NvrID = nvrID;
    }

    public Integer getNvrChannel() {
        return NvrChannel;
    }

    public void setNvrChannel(Integer nvrChannel) {
        NvrChannel = nvrChannel;
    }

    public String getRemark() {
        return Remark;
    }

    public void setRemark(String remark) {
        Remark = remark;
    }

    public String getAccount() {
        return Account;
    }

    public void setAccount(String account) {
        Account = account;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public Integer getStreamType() {
        return StreamType;
    }

    public void setStreamType(Integer streamType) {
        StreamType = streamType;
    }

    public String getSensorUrl() {
        return SensorUrl;
    }

    public void setSensorUrl(String sensorUrl) {
        SensorUrl = sensorUrl;
    }
}
