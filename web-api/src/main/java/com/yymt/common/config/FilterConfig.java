package com.yymt.common.config;

import com.yymt.common.xss.SensitiveWordFilter;
import com.yymt.common.xss.XssFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.DelegatingFilterProxy;

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
        registration.addUrlPatterns("/help/*");
        registration.addUrlPatterns("/feelings/*");
        registration.addUrlPatterns("/helpcomment/*");
        registration.addUrlPatterns("/feelingscomment/*");
        registration.addUrlPatterns("/feedback/*");
        registration.addUrlPatterns("/message/*");
        registration.setName("sensitiveWordFilter");
        registration.setOrder(Integer.MAX_VALUE - 2);
        return registration;
    }

    @Bean
    public FilterRegistrationBean shiroFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new DelegatingFilterProxy("shiroFilter"));
        //该值缺省为false，表示生命周期由SpringApplicationContext管理，设置为true则表示由ServletContainer管理
        registration.addInitParameter("targetFilterLifecycle", "true");
        registration.setEnabled(true);
        registration.setOrder(Integer.MAX_VALUE - 1);
        registration.addUrlPatterns("/*");
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
