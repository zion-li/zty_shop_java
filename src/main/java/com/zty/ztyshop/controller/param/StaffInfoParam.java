package com.zty.ztyshop.controller.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author 李佳 lijia@autoai.com
 * @version 1.0
 * @date 2021/3/27 14:00
 */
@Data
@ApiModel(value = "员工信息", description = "员工信息")
public class StaffInfoParam {

    @ApiModelProperty(value = "主键", name = "id")
    private Integer id;

    /**
     * 员工名称
     */
    @ApiModelProperty(value = "员工名称", name = "name")
    private String name;

    /**
     * 员工生日
     */
    @ApiModelProperty(value = "员工生日(yyyy/MM/dd)", name = "birthday")
    private String birthday;

    /**
     * 性别(0 女，1 男)
     */
    @ApiModelProperty(value = "性别(0 女，1 男)", name = "gender")
    private Integer gender;

    /**
     * 联系地址
     */
    @ApiModelProperty(value = "联系地址", name = "adress")
    private String adress;

    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号", name = "mobile")
    private String mobile;

    /**
     * 身份证号
     */
    @ApiModelProperty(value = "身份证号", name = "idArd")
    private String idArd;

    /**
     * 入职时间
     */
    @ApiModelProperty(value = "入职时间(yyyy/MM/dd)", name = "employmentDate")
    private String employmentDate;


    /**
     * 紧急联系人姓名
     */
    @ApiModelProperty(value = "紧急联系人姓名", name = "emergencyContactName")
    private String emergencyContactName;

    /**
     * 紧急联系人电话
     */
    @ApiModelProperty(value = "紧急联系人电话", name = "emergencyContactMobile")
    private String emergencyContactMobile;

    /**
     * 状态（0 离职、1正常）
     */
    @ApiModelProperty(value = "状态（0 离职、1正常）", name = "isActive")
    private Integer isActive;
    /**
     * 职称
     */
    @ApiModelProperty(value = "职称", name = "rankName")
    private String rankName;
}
