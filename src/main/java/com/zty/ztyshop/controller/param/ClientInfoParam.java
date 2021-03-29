package com.zty.ztyshop.controller.param;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;


/**
 * @author 李佳 lijia@autoai.com
 * @version 1.0
 * @date 2021/3/29 9:56
 */
@Data
public class ClientInfoParam {

    private Integer id;

    /**
     * 顾客姓名
     */
    private String name;

    /**
     * 性别（0女、1男）
     */
    private Integer gender;

    /**
     * 手机号
     */
    private String modile;

    /**
     * 是否（会员1 ，否 0）
     */
    private Integer isVip;

    /**
     * 用户等级
     */
    private Integer clientLevel;

    /**
     * 顾客生日
     */
    private String birthday;

    private String account;
}
