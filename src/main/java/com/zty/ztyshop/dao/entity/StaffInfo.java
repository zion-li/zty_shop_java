package com.zty.ztyshop.dao.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
/**
 * <p>
 * 员工表
 * </p>
 *
 * @author 李佳 zion
 * @since 2021-11-25
 */
@Data
@ToString
public class StaffInfo extends Model<StaffInfo> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 员工名称
     */
    private String name;

    /**
     * 员工职称
     */
    private Integer rank;

    /**
     * 员工生日
     */
    private LocalDate birthday;

    /**
     * 性别(0 女，1 男)
     */
    private Boolean gender;

    /**
     * 联系地址
     */
    private String address;

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
    private LocalDate employmentDate;

    /**
     * 紧急联系人姓名
     */
    private String emergencyContactPerson;

    /**
     * 紧急联系人电话
     */
    private String emergencyContactMobile;

    /**
     * 状态（0 在职、1离职）
     */
    private Boolean isResign;
}
