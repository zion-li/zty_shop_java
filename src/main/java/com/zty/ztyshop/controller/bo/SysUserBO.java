package com.zty.ztyshop.controller.bo;

/**
 * @author 李佳 lijia@autoai.com
 * @version 1.0
 * @date 2021/5/16 9:14
 */
public class SysUserBO {
    private String userId;

    private String userName;

    private String token;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
