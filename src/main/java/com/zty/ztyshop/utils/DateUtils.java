package com.zty.ztyshop.utils;

import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

/**
 * @author 李佳 lijia@autoai.com
 * @version 1.0
 * @date 2021/3/29 13:19
 */
public class DateUtils {

    public static Map<String, Integer> getLast7Days() {
        Map<String, Integer> res = Maps.newLinkedHashMap();
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        for (int i = 6; i >= 0; i--) {
            res.put(localDate.minusDays(i).format(formatter), 0);
        }
        return res;
    }

    public static Map<String, Integer> getLast30Days() {
        Map<String, Integer> res = Maps.newLinkedHashMap();
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        for (int i = 29; i >= 0; i--) {
            res.put(localDate.minusDays(i).format(formatter), 0);
        }
        return res;
    }

    public static Map<String, Integer> getLast90Days() {
        Map<String, Integer> res = Maps.newLinkedHashMap();
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        for (int i = 89; i >= 0; i--) {
            res.put(localDate.minusDays(i).format(formatter), 0);
        }
        return res;
    }

    public static Map<String, Integer> getLastYear() {
        Map<String, Integer> res = Maps.newLinkedHashMap();
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
        for (int i = 11; i >= 0; i--) {
            res.put(localDate.minusMonths(i).format(formatter), 0);
        }
        return res;
    }

    public static LocalDate getLocalDate(String dataStr) {
        if (StringUtils.isBlank(dataStr)) {
            return null;
        }
        return LocalDate.parse(dataStr, DateTimeFormatter.ofPattern("yyyy/MM/dd"));
    }
}
