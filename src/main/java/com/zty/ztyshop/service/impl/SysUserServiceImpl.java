package com.zty.ztyshop.service.impl;

import com.google.common.collect.Maps;
import com.zty.ztyshop.common.CommonServiceException;
import com.zty.ztyshop.common.ErrorCodeEnum;
import com.zty.ztyshop.config.PasswordEncoder;
import com.zty.ztyshop.controller.vo.UserVO;
import com.zty.ztyshop.dao.entity.SysUser;
import com.zty.ztyshop.dao.mapper.SysUserMapper;
import com.zty.ztyshop.service.ISysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zty.ztyshop.utils.JwtUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 李佳 zion
 * @since 2021-03-21
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {


    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserVO userLogin(String userName, String password) {

        String innerPass = "";
        //密码检查
//        if (!passwordEncoder.matches(password, innerPass)) {
//            throw new CommonServiceException(ErrorCodeEnum.PASSWORD_ERROR);
//        }


        UserVO result = new UserVO();
        //生成token
        result.setToken(createToken(userName));
        return result;
    }


    private String createToken(String userName) {
        //生成token
        Map<String, Object> claim = Maps.newHashMap();
        claim.put("userName", userName);
        return JwtUtils.generate(claim);
    }

}
