package com.zty.ztyshop.handler;

import com.zty.ztyshop.controller.bo.SysUserBO;
import com.zty.ztyshop.dao.entity.SysUser;
import com.zty.ztyshop.service.SysUserService;
import com.zty.ztyshop.utils.CaffeineUtils;
import com.zty.ztyshop.utils.CurrentUserUtils;
import com.zty.ztyshop.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 李佳 lijia@autoai.com
 * @version 1.0
 * @date 2021/3/22 19:10
 */
@Slf4j
@Component
public class LoginHandlerInterceptor implements HandlerInterceptor {

    @Autowired
    private SysUserService sysUserService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        log.info(">>>登录校验{}", request.getRequestURI());

        String token = request.getParameter("token");

        if (StringUtils.isBlank(token)) {
            token = request.getHeader("token");
        }

        //token 不为空 && token 正确 && token没有过期
        if (StringUtils.isNotBlank(token) && CaffeineUtils.JWT_KEY.getIfPresent(token) != null
                && JwtUtils.verify(token) && !JwtUtils.isExpired(token)) {

            Claims claims = JwtUtils.getClaim(token);

            if (claims != null) {

                SysUser userInfo = sysUserService.getById((String) claims.get("userId"));

                if (null != userInfo) {
                    SysUserBO userBO = new SysUserBO();
                    BeanUtils.copyProperties(userInfo, userBO);
                    userBO.setToken(token);

                    //直接放缓存里
                    CurrentUserUtils.setUser(userBO);
                    return true;
                }
            }
        }

        //走到这，用户登录失败了
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setContentType("application/json; charset=UTF-8");
        response.getWriter().write("{\"code\":\"4003\",\"message\":\"用户验签失败，请重新登录\",\"data\":\"\"}");
        response.getWriter().flush();
        return false;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        CurrentUserUtils.clear();
    }
}
