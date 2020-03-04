package com.yymt.modules.common.entity.mongo;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * todo
 *
 * @author xiezhen
 * @since 2020/3/4
 */
@Document(collection = "FaceAlarmInfo")
public class MongoInfoEntity {

    private JSONObject Metadata;

    private JSONArray RecFace;

    private JSONArray RecPedestrian;

    private JSONArray Vehicle;

    private JSONArray NonMotorVehicles;

    public JSONObject getMetadata() {
        return Metadata;
    }

    public void setMetadata(JSONObject metadata) {
        Metadata = metadata;
    }

    public JSONArray getRecFace() {
        return RecFace;
    }

    public void setRecFace(JSONArray recFace) {
        RecFace = recFace;
    }

    public JSONArray getRecPedestrian() {
        return RecPedestrian;
    }

    public void setRecPedestrian(JSONArray recPedestrian) {
        RecPedestrian = recPedestrian;
    }

    public JSONArray getVehicle() {
        return Vehicle;
    }

    public void setVehicle(JSONArray vehicle) {
        Vehicle = vehicle;
    }

    public JSONArray getNonMotorVehicles() {
        return NonMotorVehicles;
    }

    public void setNonMotorVehicles(JSONArray nonMotorVehicles) {
        NonMotorVehicles = nonMotorVehicles;
    }
}
