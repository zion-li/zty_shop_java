package com.zty.ztyshop.utils;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;

import java.util.concurrent.TimeUnit;

/**
 * @author 李佳 lijia@autoai.com
 * @version 1.0
 * @date 2021/2/23 20:53
 */
public class CaffeineUtils {

    public static Cache<String, Integer> JWT_KEY = Caffeine.newBuilder()
            .expireAfterWrite(7, TimeUnit.DAYS)
            .maximumSize(512)
            .build();

}
