package com.zty.ztyshop.controller;

import com.zty.ztyshop.common.BaseResponseVO;
import com.zty.ztyshop.controller.param.LoginParam;
import com.zty.ztyshop.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 李佳 zion
 * @since 2021-03-21
 */
@RestController
@RequestMapping("/sysUser")
@Api(value = "管理员用户", tags = "管理员用户")
public class SysUserController {

    @Autowired
    private SysUserService userService;

    @PostMapping("/login")
    @ApiOperation(value = "登录-管理员用户", notes = "登录-管理员用户")
    public BaseResponseVO Login(@RequestBody @Validated LoginParam loginParam) {
        return BaseResponseVO.success(userService.userLogin(loginParam.getUsername(), loginParam.getPassword()));
    }

    @PostMapping("/logOut")
    @ApiOperation(value = "登出-管理员用户", notes = "登出-管理员用户")
    public BaseResponseVO LogOut() {
        return BaseResponseVO.success(userService.LogOut());
    }

}
