package com.zty.ztyshop.common;


/**
 * @author 李佳 lijia@autoai.com
 * @version 1.0
 * @date 2021/2/22 20:46
 */
public enum BaseEnum {
    /**
     * 参数异常
     */
    PASSWORD_ERROR(4001, "用户不存在或者密码错误，请重试"),
    PARAM_ERROR(4001, "参数异常"),
    PHONE_ERROR(4001, "手机号错误"),
    SIGN_ERROR(4001, "签名异常"),
    PHONE_EXIT(4001, "手机号已经存在，请直接登录"),
    CODE_ERROR(4001, "验证码错误"),
    MD5_ERROR(4001, "MD5加密错误"),
    JWT_ERROR(4001, "验签异常"),
    REGIST_ERROR(4001, "用户注册错误，请重试"),
    USER_NOT_EXIST_ERROR(4001, "当前用户不存在，无法重置密码"),
    USER_RESET_ERROR(4001, "用户重置密码失败"),
    USER_ID_NOT_EXIST_ERROR(4001, "当前用户不存在"),
    IMAGE_ERROR(4001, "图片上传失败"),
    MINIO_ERROR(4001, "上传图片异常，请重试"),
    SYSTEM_ERROR(4001, "系统发生错误啦，请您再试一下"),
    USER_EXIST_ERROR(4001, "当前用户已存在"),
    USER_NAME_UPDATE_ERROR(4001, "30天内只能更改一次"),
    USER_NAME_REPAIR_ERROR(4001, "用户名称重复"),
    SEARCH_MYSELF_FREIND_ERROR(4001, "不允许所有自己哦"),
    ADD_FRIEND_REQUEST_REPEAT_ERROR(4001, "添加好友请求已发送"),
    DECRIPTION_ERROR(4001, "生成密钥异常"),
    AES_PUBLIC_NOT_EXIT_ERROR(4001, "当前用户没有建立非对称加密通道"),
    LEVEL_NAME_EXIST(4001, "当前职称已经存在"),
    STAFF_NAME_EXIST(4001, "员工名称已存在,请给名字添加一个特殊标识"),
    STAFF_NOT_EXIST(4001, "当前员工不存在"),
    CLIENT_LEVEL_NAME_EXIST(4001, "当前等级已经存在"),
    CLIENT_NAME_ERROR(4001, "客户名称错误"),
    CLIENT_NAME_EXIST(4001, "当前客户+手机号的组合已经存在"),
    CLIENT_NOT_EXIST(4001, "当前客户不存在"),
    VIP_NEED_MOBILE(4001, "会员必须有手机号");


    private Integer code;

    private String desc;

    BaseEnum(Integer code, String desc) {
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


