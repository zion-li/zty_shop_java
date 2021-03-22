package com.zty.ztyshop.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

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
    final String[] notLoginInterceptPaths = {"/static/**","/sysUser/login","/error/**","/login"};


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
    }
}