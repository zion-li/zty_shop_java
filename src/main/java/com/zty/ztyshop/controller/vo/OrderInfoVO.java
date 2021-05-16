package com.zty.ztyshop.controller.vo;

import com.zty.ztyshop.dao.entity.OrderInfo;
import lombok.Data;

/**
 * @author 李佳 lijia@autoai.com
 * @version 1.0
 * @date 2021/5/16 20:45
 */
@Data
public class OrderInfoVO extends OrderInfo {
    //用户
    private String clientName;
    //发型师
    private String staffName;

    //剪发助理
    private String cashJfAssistantName;

    //烫发
    private String cashTfAssistantName;
    //染发
    private String cashRfAssistantName;
    //头皮
    private String cashTpAssistantName;
    //造型
    private String cashZxAssistantName;
    //营养
    private String cashYyAssistantName;
    //水洗
    private String cashSxAssistantName;
    //速焗
    private String cashSjAssistantName;
    //商品
    private String cashSpAssistantName;
}
