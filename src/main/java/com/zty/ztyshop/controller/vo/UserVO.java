package com.zty.ztyshop.controller.vo;


import lombok.Data;

/**
 * @author 李佳 lijia@autoai.com
 * @version 1.0
 * @date 2021/2/23 10:48
 */
@Data
public class UserVO {

    /**
     * 用户名（唯一）
     */
    private String userName;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 小头像
     */
    private String faceImage;

    /**
     * 性别（0:男、1:女、2:未知）
     */
    private Integer sex;

    /**
     * 地区
     */
    private String area;

    /**
     * 用户个性签名
     */
    private String signature;

    /**
     * jwt token
     */
    private String token;
}
