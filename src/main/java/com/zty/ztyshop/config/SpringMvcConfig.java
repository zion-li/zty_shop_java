package com.zty.ztyshop.config;

import com.zty.ztyshop.handler.LoginHandlerInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.List;

/**
 * @author 李佳 lijia@autoai.com
 * @version 1.0
 * @date 2021/3/21 16:05
 */
@Configuration
public class SpringMvcConfig implements WebMvcConfigurer {

    /**
     * 不需要登录拦截的url
     */
    private static final List<String> EXCLUDE_PATH
            = Arrays.asList("/sysUser/login");


    @Autowired
    private LoginHandlerInterceptor loginHandler;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginHandler)
                .addPathPatterns("/**")
                .excludePathPatterns(EXCLUDE_PATH);

    }
}