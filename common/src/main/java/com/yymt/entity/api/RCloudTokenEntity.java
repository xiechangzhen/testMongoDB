package com.yymt.entity.api;

/**
 * 描述:获取融云token实体
 * 作者:Administrator
 * 时间:2018-07-18 9:49
 **/
public class RCloudTokenEntity {
    //{"code":200, "userId":"jlk456j5", "token":"sfd9823ihufi"}
    private int code;
    private String userId;
    private String token;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
