package com.zty.ztyshop.controller.param;

import lombok.Data;

import java.util.Date;

/**
 * @author 李佳 lijia@autoai.com
 * @version 1.0
 * @date 2021/3/27 14:00
 */
@Data
public class StaffInfoParam {

    private Integer id;

    /**
     * 员工名称
     */
    private String name;

    /**
     * 员工生日
     */
    private String birthday;

    /**
     * 性别(0 女，1 男)
     */
    private Integer gender;

    /**
     * 联系地址
     */
    private String adress;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 身份证号
     */
    private String idArd;

    /**
     * 入职时间
     */
    private String employmentDate;


    /**
     * 紧急联系人姓名
     */
    private String emergencyContactName;

    /**
     * 紧急联系人电话
     */
    private String emergencyContactMobile;

    /**
     * 状态（0 离职、1正常）
     */
    private Integer isActive;
    /**
     * 职称
     */
    private String rankName;
}
