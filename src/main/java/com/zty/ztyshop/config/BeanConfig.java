package com.zty.ztyshop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 李佳 lijia@autoai.com
 * @version 1.0
 * @date 2021/2/22 19:57
 */
@Configuration
public class BeanConfig {


    /**
     * 默认密码处理器
     *
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
