package com.zty.ztyshop.common;


import lombok.Data;

/**
 * @author 李佳 zion 18102466330@163.com
 * @version 1.0
 * @date 2019/4/17 13:38
 */
@Data
public class BaseException extends RuntimeException {

    private Integer code;
    private String message;

    public BaseException(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public BaseException(BaseEnum codeEnum) {
        this.code = codeEnum.getCode();
        this.message = codeEnum.getDesc();
    }


}