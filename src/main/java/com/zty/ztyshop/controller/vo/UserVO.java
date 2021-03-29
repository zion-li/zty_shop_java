package com.zty.ztyshop.controller.vo;


import lombok.Data;

/**
 * @author 李佳 lijia@autoai.com
 * @version 1.0
 * @date 2021/2/23 10:48
 */
@Data
public class UserVO {

    private Integer userId;

    /**
     * 用户名（唯一）
     */
    private String userName;

    /**
     * jwt token
     */
    private String token;
}
