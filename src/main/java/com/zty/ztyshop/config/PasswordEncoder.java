package com.zty.ztyshop.config;

/**
 * @author 李佳 lijia@autoai.com
 * @version 1.0
 * @date 2021/2/22 19:59
 */
public interface PasswordEncoder {

    String encode(CharSequence rawPassword);


    boolean matches(CharSequence rawPassword, String encodedPassword);


    default boolean upgradeEncoding(String encodedPassword) {
        return false;
    }
}
