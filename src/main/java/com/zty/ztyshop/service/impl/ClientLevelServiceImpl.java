package com.zty.ztyshop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zty.ztyshop.common.CommonServiceException;
import com.zty.ztyshop.common.ErrorCodeEnum;
import com.zty.ztyshop.controller.param.BasePageParam;
import com.zty.ztyshop.controller.param.ClientLevelParam;
import com.zty.ztyshop.dao.entity.ClientLevel;
import com.zty.ztyshop.dao.entity.StaffLevel;
import com.zty.ztyshop.dao.mapper.ClientLevelMapper;
import com.zty.ztyshop.dao.mapper.StaffLevelMapper;
import com.zty.ztyshop.service.IClientLevelService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 李佳 zion
 * @since 2021-03-27
 */
@Service
public class ClientLevelServiceImpl extends ServiceImpl<ClientLevelMapper, ClientLevel> implements IClientLevelService {
    @Autowired
    private ClientLevelMapper clientLevelMapper;

    @Override
    public Boolean add(ClientLevelParam param) {

        //查询名字是否重复
        LambdaQueryWrapper<ClientLevel> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ClientLevel::getName, param.getName());
        //不允许更改为已经存在的名字
        if (clientLevelMapper.selectCount(queryWrapper) > 0) {
            //
            throw new CommonServiceException(ErrorCodeEnum.CLIENT_LEVEL_NAME_EXIST);
        }


        ClientLevel clientLevel = new ClientLevel();
        clientLevel.setMin(param.getMin());
        clientLevel.setMax(param.getMax());
        clientLevel.setName(param.getName());
        clientLevel.setCreteAt(LocalDateTime.now());
        return clientLevelMapper.insert(clientLevel) == 1;
    }

    @Override
    public Boolean delete(ClientLevelParam param) {
        //直接删除了
        return clientLevelMapper.deleteById(param.getId()) == 1;
    }

    @Override
    public Boolean update(ClientLevelParam param) {
        //查询名字是否重复
        LambdaQueryWrapper<ClientLevel> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.ne(ClientLevel::getId, param.getId());
        queryWrapper.eq(ClientLevel::getName, param.getName());
        //不允许更改为已经存在的名字
        if (clientLevelMapper.selectCount(queryWrapper) > 0) {
            //
            throw new CommonServiceException(ErrorCodeEnum.CLIENT_LEVEL_NAME_EXIST);
        }

        LambdaUpdateWrapper<ClientLevel> updateWrapper = new LambdaUpdateWrapper<>();

        updateWrapper.eq(ClientLevel::getId, param.getId());

        if (StringUtils.isNotBlank(param.getName())) {
            updateWrapper.set(ClientLevel::getName, param.getName());
        }

        if (null != param.getMin()) {
            updateWrapper.set(ClientLevel::getMin, param.getMin());
        }

        if (null != param.getMax()) {
            updateWrapper.set(ClientLevel::getMax, param.getMax());
        }


        return clientLevelMapper.update(null, updateWrapper) == 1;
    }

    @Override
    public Page<ClientLevel> page(BasePageParam param) {
        Page<ClientLevel> page = new Page<>(param.getPageNo(), param.getPageSize());
        Page<ClientLevel> userPage = clientLevelMapper.selectPage(page, null);
        return userPage;
    }
}
