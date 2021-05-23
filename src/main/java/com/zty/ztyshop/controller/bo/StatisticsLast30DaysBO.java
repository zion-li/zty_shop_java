package com.zty.ztyshop.controller.bo;

import lombok.Data;

/**
 * @author 李佳 lijia@autoai.com
 * @version 1.0
 * @date 2021/5/23 11:30
 */
@Data
public class StatisticsLast30DaysBO {
    private String day;
    private Integer account;
}
