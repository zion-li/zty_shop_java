package com.zty.ztyshop.utils;

import com.google.common.collect.Maps;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

/**
 * @author 李佳 lijia@autoai.com
 * @version 1.0
 * @date 2021/3/29 13:19
 */
public class DateUtils {

    public static Map<String, Integer> getLast30Days() {
        Map<String, Integer> res = Maps.newLinkedHashMap();
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        for (int i = 29; i >= 0; i--) {
            res.put(localDate.minusDays(i).format(formatter), 0);
        }
        return res;
    }
}