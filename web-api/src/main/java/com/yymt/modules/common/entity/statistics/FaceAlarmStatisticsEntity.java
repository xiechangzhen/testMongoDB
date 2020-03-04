package com.yymt.modules.common.entity.statistics;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

/**
 * 卡点流量统计
 *
 * @author xiezhen
 * @since 2020/2/28
 */
public class FaceAlarmStatisticsEntity {

    private static final long serialVersionUID = 1L;

    /*
    * 人脸
    * */
    private int Face;

    /*
     * 机动车
     * */
    private int Vehicle;

    /*
     * 行人
     * */
    private int Pedestrian;

    /*
     * 非机动车
     * */
    private int NonMotorVehicle;

    /*
     * 口罩不规范
     * */
    private int NoMask;

    /*
     * 人脸违规出入
     * */
    private int ViolationFace;

    /*
     * 机动车违规出入
     * */
    private int ViolationVehicle;

    /*
     * 行人违规出入
     * */
    private int ViolationPedestrian;

    /*
     * 非机动车违规出入
     * */
    private int ViolationNonMotorVehicle;

    /*
     * 口罩不规范出入告警信息
     */
    private List<Map<String, Object>> NoMaskAlarmInfo;

    /*
     * 人脸违规出入告警信息
     *
     */
    private List<Map<String, Object>> ViolationFaceAlarmInfo;


    /*
     * 机动车违规出入告警信息
     */
    private List<Map<String, Object>> ViolationVehicleAlarmInfo;


    /*
     * 行人违规出入告警信息
     * */
    private List<Map<String, Object>> ViolationPedestrianAlarmInfo;


    /*
     * 非机动车违规出入告警信息
     */
    private List<Map<String, Object>> ViolationNonMotorVehicleAlarmInfo;

    /*
    * 违规总数
    * */
    private int Sum;

    /*
    * 陌生人
    * */
    private int NonResident;

    @JsonProperty("Face")
    public int getFace() {
        return Face;
    }

    public void setFace(int face) {
        Face = face;
    }

    @JsonProperty("Vehicle")
    public int getVehicle() {
        return Vehicle;
    }

    public void setVehicle(int vehicle) {
        Vehicle = vehicle;
    }

    @JsonProperty("Pedestrian")
    public int getPedestrian() {
        return Pedestrian;
    }

    public void setPedestrian(int pedestrian) {
        Pedestrian = pedestrian;
    }

    @JsonProperty("NonMotorVehicle")
    public int getNonMotorVehicle() {
        return NonMotorVehicle;
    }

    public void setNonMotorVehicle(int nonMotorVehicle) {
        NonMotorVehicle = nonMotorVehicle;
    }

    @JsonProperty("NoMask")
    public int getNoMask() {
        return NoMask;
    }

    public void setNoMask(int noMask) {
        NoMask = noMask;
    }

    @JsonProperty("ViolationFace")
    public int getViolationFace() {
        return ViolationFace;
    }

    public void setViolationFace(int violationFace) {
        ViolationFace = violationFace;
    }

    @JsonProperty("ViolationVehicle")
    public int getViolationVehicle() {
        return ViolationVehicle;
    }

    public void setViolationVehicle(int violationVehicle) {
        ViolationVehicle = violationVehicle;
    }

    @JsonProperty("ViolationPedestrian")
    public int getViolationPedestrian() {
        return ViolationPedestrian;
    }

    public void setViolationPedestrian(int violationPedestrian) {
        ViolationPedestrian = violationPedestrian;
    }

    @JsonProperty("ViolationNonMotorVehicle")
    public int getViolationNonMotorVehicle() {
        return ViolationNonMotorVehicle;
    }

    public void setViolationNonMotorVehicle(int violationNonMotorVehicle) {
        ViolationNonMotorVehicle = violationNonMotorVehicle;
    }

    @JsonProperty("Sum")
    public int getSum() {
        return Sum;
    }

    public void setSum(int sum) {
        Sum = sum;
    }

    @JsonProperty("NonResident")
    public int getNonResident() {
        return NonResident;
    }

    public void setNonResident(int nonResident) {
        NonResident = nonResident;
    }

    @JsonProperty("NoMaskAlarmInfo")
    public List<Map<String, Object>> getNoMaskAlarmInfo() {
        return NoMaskAlarmInfo;
    }

    public void setNoMaskAlarmInfo(List<Map<String, Object>> noMaskAlarmInfo) {
        NoMaskAlarmInfo = noMaskAlarmInfo;
    }

    @JsonProperty("ViolationFaceAlarmInfo")
    public List<Map<String, Object>> getViolationFaceAlarmInfo() {
        return ViolationFaceAlarmInfo;
    }

    public void setViolationFaceAlarmInfo(List<Map<String, Object>> violationFaceAlarmInfo) {
        ViolationFaceAlarmInfo = violationFaceAlarmInfo;
    }

    @JsonProperty("ViolationVehicleAlarmInfo")
    public List<Map<String, Object>> getViolationVehicleAlarmInfo() {
        return ViolationVehicleAlarmInfo;
    }

    public void setViolationVehicleAlarmInfo(List<Map<String, Object>> violationVehicleAlarmInfo) {
        ViolationVehicleAlarmInfo = violationVehicleAlarmInfo;
    }

    @JsonProperty("ViolationPedestrianAlarmInfo")
    public List<Map<String, Object>> getViolationPedestrianAlarmInfo() {
        return ViolationPedestrianAlarmInfo;
    }

    public void setViolationPedestrianAlarmInfo(List<Map<String, Object>> violationPedestrianAlarmInfo) {
        ViolationPedestrianAlarmInfo = violationPedestrianAlarmInfo;
    }

    @JsonProperty("ViolationNonMotorVehicleAlarmInfo")
    public List<Map<String, Object>> getViolationNonMotorVehicleAlarmInfo() {
        return ViolationNonMotorVehicleAlarmInfo;
    }

    public void setViolationNonMotorVehicleAlarmInfo(List<Map<String, Object>> violationNonMotorVehicleAlarmInfo) {
        ViolationNonMotorVehicleAlarmInfo = violationNonMotorVehicleAlarmInfo;
    }
}
