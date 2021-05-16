package com.zty.ztyshop.controller.param;

import lombok.Data;

/**
 * @author 李佳 lijia@autoai.com
 * @version 1.0
 * @date 2021/5/16 12:02
 */
@Data
public class OrderInfoParam {
    //id
    private Integer id;
    //用户唯一标识
    private Integer clientId;
    //发型师
    private Integer staffId;

    //现金
    private String cashType;
    private String cashAccount;

    //剪发业绩
    private Integer cashJfAssistant;
    private String cashJf;

    //烫发业绩
    private Integer cashTfAssistant;
    private String cashTf;

    //染发业绩
    private Integer cashRfAssistant;
    private String cashRf;

    //头皮业绩
    private Integer cashTpAssistant;
    private String cashTp;

    //造型业绩
    private Integer cashZxAssistant;
    private String cashZx;

    //营养
    private Integer cashYyAssistant;
    private String cashYy;


    //水洗
    private Integer cashSxAssistant;
    private String cashSx;

    //速焗
    private Integer cashSjAssistant;
    private String cashSj;

    //商品业绩
    private Integer cashSpAssistant;
    private String cashSp;
    private String cashSpDesc;
}
