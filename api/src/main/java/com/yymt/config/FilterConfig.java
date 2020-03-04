package com.yymt.config;

import com.yymt.common.xss.SensitiveWordFilter;
import com.yymt.common.xss.XssFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.DispatcherType;

/**
 * Filter配置
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-04-21 21:56
 */
@Configuration
public class FilterConfig {

    /**
     * 敏感词过滤
     * @return
     */
    @Bean
    public FilterRegistrationBean sensitiveWordFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setDispatcherTypes(DispatcherType.REQUEST);
        registration.setFilter(new SensitiveWordFilter());
        registration.addUrlPatterns("/sport/forums/*");
        registration.addUrlPatterns("/sport/forumscomment/*");
        registration.addUrlPatterns("/sport/games/*");
        registration.addUrlPatterns("/feedback/*");
        registration.addUrlPatterns("/message/*");
        registration.addUrlPatterns("/user/update");
        registration.addUrlPatterns("/api/register");
        registration.addUrlPatterns("/epidemicsituation/*");
        registration.setName("sensitiveWordFilter");
        registration.setOrder(Integer.MAX_VALUE - 2);
        return registration;
    }
    @Bean
    public FilterRegistrationBean xssFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setDispatcherTypes(DispatcherType.REQUEST);
        registration.setFilter(new XssFilter());
        registration.addUrlPatterns("/*");
        registration.setName("xssFilter");
        return registration;
    }
}
