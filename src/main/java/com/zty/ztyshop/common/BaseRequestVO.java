package com.zty.ztyshop.common;


/**
 * @author 李佳 zion 18102466330@163.com
 * @version 1.0
 * @date 2019/4/17 13:37
 */
public abstract class BaseRequestVO {
    /**
     * 公共的参数验证方法
     */
    public abstract void checkParam() throws BaseException;

}