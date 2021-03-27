package com.zty.ztyshop.utils;

import com.zty.ztyshop.common.CommonServiceException;
import com.zty.ztyshop.common.ErrorCodeEnum;
import com.zty.ztyshop.controller.bo.SysUserBO;
import com.zty.ztyshop.dao.entity.SysUser;

/**
 * @author 李佳 lijia@autoai.com
 * @version 1.0
 * @date 2021/2/25 19:23
 */
public class CurrentUserUtils {

    /**
     * 当前用户信息
     */
    private static final ThreadLocal<SysUserBO> currentUser = new ThreadLocal<>();


    /**
     * 保存线程中缓存的用户信息
     *
     * @param user
     */
    public static void setUser(SysUserBO user) {
        currentUser.set(user);
    }

    /**
     * 获取线程中缓存的用户信息
     *
     * @return
     */
    public static SysUserBO getUser() {
        SysUserBO user = currentUser.get();
        if (null == user) {
            throw new CommonServiceException(ErrorCodeEnum.USER_ID_NOT_EXIST_ERROR);
        }
        return user;
    }

    /**
     * 清除线程中缓存的用户信息
     */
    public static void clear() {
        currentUser.remove();
    }

}
