package com.zty.ztyshop.controller;

import com.zty.ztyshop.common.BaseResponseVO;
import com.zty.ztyshop.controller.param.LoginParam;
import com.zty.ztyshop.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class SysUserController {

    @Autowired
    private SysUserService userService;

    @PostMapping("/login")
    public BaseResponseVO Login(@RequestBody LoginParam loginParam) {
        return BaseResponseVO.success(userService.userLogin(loginParam.getUsername(), loginParam.getPassword()));
    }

    @PostMapping("/logOut")
    public BaseResponseVO LogOut() {
        return BaseResponseVO.success(userService.LogOut());
    }

}
