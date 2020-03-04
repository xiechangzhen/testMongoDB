package com.yymt.common.utils;

import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.AndroidNotification;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;

import java.util.Collection;

/**
 * 作者:Administrator
 * 时间:2018-05-17 19:59
 **/
public class JPushUtils {

    public static PushPayload buildPushObject(String message,Collection usernameCollection) {

        return PushPayload.newBuilder()
                .setPlatform(Platform.android_ios())
                .setAudience(Audience.alias(usernameCollection))
                .setMessage(Message.newBuilder().setTitle("消息").setMsgContent(message).build())
                .build();
    }

    /**
     *1:咨询师审核通过/失败
     *2:用户预约
     *3:发布文章通过/失败 推送给咨询师
     *4:咨询师文章通过发送消息给粉丝
     *5:收到评价
     *6:收到留言消息
     * @param message
     * @param type
     * @param meesgaeId
     * @param alisCollection
     * @return
     */
    public static PushPayload buildPushAlertObject(String message,int type,long meesgaeId,Collection alisCollection) {

        return PushPayload.newBuilder()
                .setPlatform(Platform.android_ios())
                .setAudience(Audience.alias(alisCollection))
                .setNotification(Notification.newBuilder()
                        .addPlatformNotification(IosNotification.newBuilder()
                                .setAlert(message)
//                                .setBadge(5)
                                .setSound("happy")
                                .addExtra("type", type)
                                .addExtra("id",meesgaeId)
                                .build())
                        .addPlatformNotification(AndroidNotification.newBuilder().setTitle("新通知提醒")
                        .setAlert(message)
                        .addExtra("type", type)
                        .addExtra("id",meesgaeId).build())
                .build()).build();
    }


    /**
     * 广播，群发所有人
     * @return
     */
    public static PushPayload buildPushBrodcast(String message,int type,long meesgaeId){
        return PushPayload.newBuilder()
                .setPlatform(Platform.all())
                .setAudience(Audience.all())
                .setNotification(Notification.newBuilder()
                        .addPlatformNotification(IosNotification.newBuilder()
                                .setAlert(message)
//                                .setBadge(5)
                                .setSound("happy")
                                .addExtra("type", type)
                                .addExtra("id",meesgaeId)
                                .build())
                        .addPlatformNotification(AndroidNotification.newBuilder().setTitle(message)
                                .setAlert(message)
                                .addExtra("type", type)
                                .addExtra("id",meesgaeId).build())
                        .build()).build();
    }



    public static PushPayload buildPushAlertObjectToIOS(String message,int type,long meesgaeId,Collection alisCollection) {

        return PushPayload.newBuilder()
                .setPlatform(Platform.android_ios())
                .setAudience(Audience.alias(alisCollection))
                .setNotification(Notification.newBuilder()
                        .addPlatformNotification(IosNotification.newBuilder()
                                .setAlert(message)
//                                .setBadge(5)
                                .setSound("happy")
                                .addExtra("type", type)
                                .addExtra("id",meesgaeId)
                                .build())
                        .build()).build();
    }

}
