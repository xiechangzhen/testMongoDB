package com.yymt.common.config;

import cn.jiguang.common.ClientConfig;
import cn.jiguang.common.connection.HttpProxy;
import cn.jpush.api.JPushClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 描述:${DESCRIPTION}
 * 作者:Administrator
 * 时间:2018-05-17 20:09
 **/
@Configuration
public class PushConfig {

    @Bean
   public JPushClient jPushClient(@Value("${jpush.appKey}")String appKey,
                                  @Value("${jpush.masterSecret}")String masterSecret,
                                  @Value("${proxy.isProxy}") boolean isProxy,
                                  @Value("${proxy.proxyHost}") String proxyHost,
                                  @Value("${proxy.proxyPort}") int proxyPort
                                  ){
       ClientConfig clientConfig = ClientConfig.getInstance();
        HttpProxy httpProxy = null;
       if(isProxy){
            httpProxy = new HttpProxy(proxyHost,proxyPort);
       }
       JPushClient jpushClient = new JPushClient(masterSecret, appKey, httpProxy, clientConfig);
       return jpushClient;
   }
}
