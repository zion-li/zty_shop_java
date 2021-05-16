package com.zty.ztyshop.service;

import com.zty.ztyshop.controller.vo.UserVO;
import com.zty.ztyshop.dao.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 李佳 zion
 * @since 2021-03-21
 */
public interface ISysUserService extends IService<SysUser> {

    /**
     * 用户登录
     *
     * @param userName
     * @param password
     * @return
     */
    UserVO userLogin(String userName, String password);

    /**
     * 登出
     * @return
     */
    Boolean LogOut();
}
