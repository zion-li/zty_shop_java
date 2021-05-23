package com.zty.ztyshop.controller.vo;

import lombok.Data;

/**
 * @author 李佳 lijia@autoai.com
 * @version 1.0
 * @date 2021/5/23 19:52
 */
@Data
public class StaffServeStatisticVO {

    /**
     * 员工号
     */
    private Integer id;

    /**
     * 员工名称
     */
    private String name;
    /**
     * 服务客户数
     */
    private Integer clientNum;


    //现金业绩个数、总价格
    private Integer cashNum;
    private String cashAccount;

    //剪发业绩个数、总价格
    private Integer cashJfNum;
    private String cashJfAccount;

    //烫发业绩个数、总价格
    private Integer cashTfNum;
    private String cashTfAccount;

    //染发业绩个数、总价格
    private Integer cashRfNum;
    private String cashRfAccount;

    //头皮业绩个数、总价格
    private Integer cashTpNum;
    private String cashTpAccount;

    //造型业绩个数、总价格
    private Integer cashZxNum;
    private String cashZxAccount;

    //营养个数、总价格
    private Integer cashYyNum;
    private String cashYyAccount;


    //水洗个数、总价格
    private Integer cashSxNum;
    private String cashSxAccount;

    //速焗个数、总价格
    private Integer cashSjNum;
    private String cashSjAccount;

    //商品业绩个数、总价格
    private Integer cashSpNum;
    private String cashSpAccount;

}
