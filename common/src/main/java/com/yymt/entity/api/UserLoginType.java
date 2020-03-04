package com.yymt.entity.api;

/**
 * Created by yyt on 2018/9/20.
 */
public enum UserLoginType {
    LocalUser("本系统用户"),
    WeiXin("微信用户"),
    QQ("QQ用户"),
    WeiBo("微博用户");


    UserLoginType(String desc) {
        this.desc = desc;
    }

    private String desc;

    public String getDesc() {
        return this.desc;
    }
}
