package com.yymt.common.utils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yymt.common.exception.ResultEnum;

import java.util.HashMap;
import java.util.Map;

/**
 * 作者:cots
 * 时间:2018-08-13 16:18
 **/
public class RWapper{

    private int code;

    private String msg;

    private String data;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Map<String, Object> getDataMap() {
        return dataMap;
    }

    public void setDataMap(Map<String, Object> dataMap) {
        this.dataMap = dataMap;
    }

    @JsonIgnore
    private Map<String,Object> dataMap = new HashMap<>();


    public static RWapper build(ResultEnum resultEnum){
        RWapper wapper = new RWapper();
        wapper.code = resultEnum.getCode();
        wapper.msg = resultEnum.getMsg();
        return wapper;
    }


    public RWapper setCode(int code){
      this.code = code;
      return this;
    }

    public RWapper setMsg(String msg){
        this.msg = msg;
        return this;
    }

    public RWapper put(String key, Object value){
        this.dataMap.put(key,value);
        return this;
    }

    public RWapper putMap(Map map){
        this.dataMap.putAll(map);
        return this;
    }

    public RWapper encode(boolean isEncode){
         data = GsonUtil.GsonToString(dataMap);
        if(isEncode){
            try {
                this.data = DESHelper.encrypt(data);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this;
    }



    public RWapper() {
        this.code = 0;
        this.msg = "success";
    }

    public static RWapper error() {
        return error(ResultEnum.ERROR);
    }

    public static RWapper error(String msg) {
        RWapper r = new RWapper();
        r.code = 1;
        r.msg = msg;
        return r;
    }
    public static RWapper error(ResultEnum resultEnum) {
        RWapper r = new RWapper();
        r.code = resultEnum.getCode();
        r.msg = resultEnum.getMsg();
        return r;
    }

    public static RWapper ok(String msg) {
        RWapper r = new RWapper();
        r.msg = msg;
        return r;
    }


    public static RWapper ok() {
        return new RWapper();
    }
}
