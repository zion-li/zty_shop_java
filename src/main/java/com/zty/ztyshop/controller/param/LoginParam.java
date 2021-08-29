package com.zty.ztyshop.controller.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author 李佳 lijia@autoai.com
 * @version 1.0
 * @date 2021/3/21 16:25
 */
@Data
@ApiModel(value = "管理员-用户登录", description = "管理员-用户登录")
public class LoginParam {

    @NotNull(message = "登录用户名称-不允许为空")
    @ApiModelProperty(value = "登录用户名称", name = "username", required = true)
    private String username;

    @NotNull(message = "登录用户密码-不允许为空")
    @ApiModelProperty(value = "登录用户密码", name = "password", required = true)
    private String password;
}
