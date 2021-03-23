package com.zty.ztyshop.controller;

import com.zty.ztyshop.common.BaseResponseVO;
import com.zty.ztyshop.controller.param.LoginParam;
import com.zty.ztyshop.controller.param.LogoutParam;
import com.zty.ztyshop.dao.entity.SysUser;
import com.zty.ztyshop.service.ISysUserService;
import com.zty.ztyshop.utils.CaffeineUtils;
import com.zty.ztyshop.utils.CurrentUserUtils;
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
    private ISysUserService userService;

    @PostMapping("/login")
    public BaseResponseVO Login(@RequestBody LoginParam loginParam) {
        return BaseResponseVO.success(userService.userLogin(loginParam.getUsername(), loginParam.getPassword()));
    }

    @PostMapping("/logOut")
    public BaseResponseVO Login(@RequestBody LogoutParam logoutParam) {
        SysUser user = CurrentUserUtils.getUser();
        if (user != null) {
            CaffeineUtils.JWT_KEY.invalidate(user.getPassword());
        }
        //缓存key
        return BaseResponseVO.success();
    }


}
