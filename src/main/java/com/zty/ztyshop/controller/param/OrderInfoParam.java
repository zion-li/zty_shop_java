package com.zty.ztyshop.controller.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 李佳 lijia@autoai.com
 * @version 1.0
 * @date 2021/5/16 12:02
 */
@Data
@ApiModel(value = "管理员-订单信息", description = "管理员-订单信息")
public class OrderInfoParam {
    //id
    @ApiModelProperty(value = "主键 删除更新用", name = "id")
    private Integer id;

    //用户唯一标识
    @ApiModelProperty(value = "用户ID（）", name = "clientId")
    private Integer clientId;

    //发型师
    @ApiModelProperty(value = "发型师-人员ID", name = "staffId")
    private Integer staffId;

    //现金
    @ApiModelProperty(value = "现金（类型）做成输入框吧", name = "cashType")
    private String cashType;


    @ApiModelProperty(value = "现金-金额（元）那种带上下箭头可以调整数字的", name = "cashAccount")
    private String cashAccount;

    //剪发业绩
    @ApiModelProperty(value = "剪发-人员ID", name = "cashJfAssistant")
    private Integer cashJfAssistant;
    @ApiModelProperty(value = "剪发-金额（元）", name = "cashJf")
    private String cashJf;

    //烫发业绩
    @ApiModelProperty(value = "烫发-人员ID", name = "cashTfAssistant")
    private Integer cashTfAssistant;
    @ApiModelProperty(value = "烫发-金额（元）", name = "cashTf")
    private String cashTf;

    //染发业绩
    @ApiModelProperty(value = "染发-人员ID", name = "cashRfAssistant")
    private Integer cashRfAssistant;
    @ApiModelProperty(value = "染发-金额（元）", name = "cashRf")
    private String cashRf;

    //头皮业绩
    @ApiModelProperty(value = "头皮-人员ID", name = "cashTpAssistant")
    private Integer cashTpAssistant;
    @ApiModelProperty(value = "头皮-金额（元）", name = "cashTp")
    private String cashTp;

    //造型业绩
    @ApiModelProperty(value = "造型-人员ID", name = "cashZxAssistant")
    private Integer cashZxAssistant;
    @ApiModelProperty(value = "造型-金额（元）", name = "cashZx")
    private String cashZx;

    //营养
    @ApiModelProperty(value = "营养-人员ID", name = "cashYyAssistant")
    private Integer cashYyAssistant;
    @ApiModelProperty(value = "营养-金额（元）", name = "cashYy")
    private String cashYy;


    //水洗
    @ApiModelProperty(value = "水洗-人员ID", name = "cashSxAssistant")
    private Integer cashSxAssistant;
    @ApiModelProperty(value = "水洗-金额（元）", name = "cashSx")
    private String cashSx;

    //速焗
    @ApiModelProperty(value = "速焗-人员ID", name = "cashSjAssistant")
    private Integer cashSjAssistant;
    @ApiModelProperty(value = "速焗--金额（元）", name = "cashSj")
    private String cashSj;

    //商品业绩
    @ApiModelProperty(value = "商品-人员ID", name = "cashSpAssistant")
    private Integer cashSpAssistant;
    @ApiModelProperty(value = "商品-金额（元）", name = "cashSp")
    private String cashSp;
    @ApiModelProperty(value = "商品-描述", name = "cashSpDesc")
    private String cashSpDesc;
}
