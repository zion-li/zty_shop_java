package com.zty.ztyshop.controller.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;


/**
 * @author 李佳 lijia@autoai.com
 * @version 1.0
 * @date 2021/3/29 9:56
 */
@Data
@ApiModel(value = "客户信息参数", description = "客户信息参数")
public class ClientInfoParam {

    @ApiModelProperty(value = "主键", name = "id")
    private Integer id;

    /**
     * 顾客姓名
     */
    @ApiModelProperty(value = "顾客姓名", name = "name")
    private String name;

    /**
     * 等级
     */
    @ApiModelProperty(value = "等级", name = "rankName")
    private String rankName;

    /**
     * 性别（0女、1男）
     */
    @ApiModelProperty(value = "性别（0女、1男）", name = "gender")
    private Integer gender;

    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号", name = "modile")
    private String modile;

    /**
     * 顾客生日
     */
    @ApiModelProperty(value = "顾客生日(yyyy/MM/dd)", name = "birthday")
    private String birthday;

    /**
     * 消费金额
     */
    @ApiModelProperty(value = "消费金额（元）", name = "account")
    private String account;

    /**
     * 服务次数
     */
    @ApiModelProperty(value = "服务次数", name = "serviceTime")
    private Integer serviceTime;
}
