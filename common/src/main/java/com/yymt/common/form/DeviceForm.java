package com.yymt.common.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 描述:${DESCRIPTION}
 * 作者:Administrator
 * 时间:2018-02-08 16:09
 **/
@ApiModel(value = "设备表单")
public class DeviceForm {

    @ApiModelProperty(value = "命令字")
    @NotBlank(message="命令字不能为空")
    private String command;

    @ApiModelProperty(value = "设备ID")
    private String smartWatchDevId;

    @ApiModelProperty(value = "厂商编号")
    private String manuId;

    @ApiModelProperty(value = "时间")
    private String date;

    @ApiModelProperty(value = "纬度")
    private String nlatitude;

    @ApiModelProperty(value = "经度")
    private String elongitude;

    @ApiModelProperty(value = "速度")
    private String speed;

    @ApiModelProperty(value = "报警类型(1：SOS报警；2：低电量报警)")
    private String alarmId;

    @ApiModelProperty(value = "心率")
    private String heartRate;

    @ApiModelProperty(value = "设备在线状态")
    private String devStatus;

    public String getDevStatus() {
        return devStatus;
    }

    public void setDevStatus(String devStatus) {
        this.devStatus = devStatus;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getSmartWatchDevId() {
        return smartWatchDevId;
    }

    public void setSmartWatchDevId(String smartWatchDevId) {
        this.smartWatchDevId = smartWatchDevId;
    }

    public String getManuId() {
        return manuId;
    }

    public void setManuId(String manuId) {
        this.manuId = manuId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNlatitude() {
        return nlatitude;
    }

    public void setNlatitude(String nlatitude) {
        this.nlatitude = nlatitude;
    }

    public String getElongitude() {
        return elongitude;
    }

    public void setElongitude(String elongitude) {
        this.elongitude = elongitude;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getAlarmId() {
        return alarmId;
    }

    public void setAlarmId(String alarmId) {
        this.alarmId = alarmId;
    }

    public String getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(String heartRate) {
        this.heartRate = heartRate;
    }
}
