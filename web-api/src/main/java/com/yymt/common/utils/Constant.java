package com.yymt.common.utils;

import org.omg.CORBA.UNKNOWN;

public class Constant {

    public final static String DATE_TIME_FORMAT_CN = "yyyy/MM/dd HH:mm:ss";

    public enum videoStructureData {
        // 未知 0
//        UNKNOWN ("Unknown", "陌生人出入", "未知"),
        // 车辆 1
        VEHICLE ("Vehicle", "机动车违规出行", "机动车违规"),
        // 非机动车 (2 二轮车 3三轮车)
        NON_MOTOR_VEHICLES ("NonMotorVehicles", "非机动车违规出行 ", "非机动车违规"),
        // 行人 4
        REC_PEDESTRIAN ("RecPedestrian", "人员违规出行", "人员违规"),
        // 人脸 1024
        REC_FACE ("RecFace", "人脸违规出行", "人脸违规"),

        // 未带口罩
        NO_MASK ("RecFace", "口罩不规范", "人脸未带口罩");

        /**
         * 数据的类型
         */
        private String dataType;
        /**
         * 告警类型
         */
        private String alarmType;
        /**
         * 告警描述
         */
        private String alarmDesc;

        videoStructureData(String dataType, String alarmType, String alarmDesc) {
            this.dataType = dataType;
            this.alarmType = alarmType;
            this.alarmDesc = alarmDesc;
        }

        public String getDataType() {
            return dataType;
        }

        public String getAlarmType() {
            return alarmType;
        }

        public String getAlarmDesc() {
            return alarmDesc;
        }
    }

}
