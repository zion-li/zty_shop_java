package com.zty.ztyshop.config;

import com.zty.ztyshop.handler.LoginHandlerInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
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
            = Arrays.asList("/sysUser/login",
            "/staffInfo/rank",
            "/swagger-ui.html",
            "/configuration/ui",
            "/swagger-resources/**",
            "/configuration/security",
            "/v3/api-docs",
            "/webjars/**",
            "/swagger-ui/**",
            "/*/favicon.ico",
            "/favicon.ico",
            "/error");


    @Autowired
    private LoginHandlerInterceptor loginHandler;

    //跨域访问 配置
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginHandler)
                .addPathPatterns("/**")
                .excludePathPatterns(EXCLUDE_PATH);
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", buildConfig());
        return new CorsFilter(source);
    }

    private CorsConfiguration buildConfig() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOriginPattern("*");
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedMethod("*");
        corsConfiguration.setAllowCredentials(true);
        return corsConfiguration;
    }
}