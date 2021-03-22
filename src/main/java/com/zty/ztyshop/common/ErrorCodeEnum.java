package com.zty.ztyshop.common;


/**
 * @author 李佳 lijia@autoai.com
 * @version 1.0
 * @date 2021/2/22 20:46
 */
public enum ErrorCodeEnum {
    /**
     * 参数异常
     */
    PARAM_ERROR(4001, "参数异常"),
    PHONE_ERROR(4002, "手机号错误"),
    SIGN_ERROR(4003, "签名异常"),
    PHONE_EXIT(4004, "手机号已经存在，请直接登录"),
    CODE_ERROR(4005, "验证码错误"),
    PASSWORD_ERROR(4006, "用户不从在或者密码错误，请重试"),
    MD5_ERROR(4007, "MD5加密错误"),
    JWT_ERROR(4008, "验签异常"),
    REGIST_ERROR(40009, "用户注册错误，请重试"),
    USER_NOT_EXIST_ERROR(40010, "当前用户不存在，无法重置密码"),
    USER_RESET_ERROR(40011, "用户重置密码失败"),
    USER_ID_NOT_EXIST_ERROR(40012, "当前用户不存在"),
    IMAGE_ERROR(40013, "图片上传失败"),
    MINIO_ERROR(40014, "上传图片异常，请重试"),
    SYSTEM_ERROR(40015, "系统发生错误啦，请您再试一下"),
    USER_EXIST_ERROR(40016, "当前用户已存在"),
    USER_NAME_UPDATE_ERROR(40017, "30天内只能更改一次"),
    USER_NAME_REPAIR_ERROR(40018, "用户名称重复"),
    SEARCH_MYSELF_FREIND_ERROR(40019, "不允许所有自己哦"),
    ADD_FRIEND_REQUEST_REPEAT_ERROR(40020, "添加好友请求已发送"),
    DECRIPTION_ERROR(40021, "生成密钥异常"),
    AES_PUBLIC_NOT_EXIT_ERROR(40021, "当前用户没有建立非对称加密通道");

    private Integer code;

    private String desc;

    ErrorCodeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}


