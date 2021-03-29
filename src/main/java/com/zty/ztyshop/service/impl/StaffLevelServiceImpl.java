package com.zty.ztyshop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zty.ztyshop.common.CommonServiceException;
import com.zty.ztyshop.common.ErrorCodeEnum;
import com.zty.ztyshop.controller.param.BasePageParam;
import com.zty.ztyshop.controller.param.StaffLevelParam;
import com.zty.ztyshop.dao.entity.StaffLevel;
import com.zty.ztyshop.dao.mapper.StaffLevelMapper;
import com.zty.ztyshop.service.IStaffLevelService;
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
public class StaffLevelServiceImpl extends ServiceImpl<StaffLevelMapper, StaffLevel> implements IStaffLevelService {

    @Autowired
    private StaffLevelMapper levelMapper;

    @Override
    public Page<StaffLevel> page(BasePageParam param) {
        Page<StaffLevel> page = new Page<>(param.getPageNo(), param.getPageSize());
        Page<StaffLevel> userPage = levelMapper.selectPage(page, null);
        return userPage;
    }

    @Override
    public Boolean update(StaffLevelParam param) {
        //查询名字是否重复
        LambdaQueryWrapper<StaffLevel> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.ne(StaffLevel::getId, param.getId());
        queryWrapper.eq(StaffLevel::getName, param.getName());
        //不允许更改为已经存在的名字
        if (levelMapper.selectCount(queryWrapper) > 0) {
            //
            throw new CommonServiceException(ErrorCodeEnum.LEVEL_NAME_EXIST);
        }

        LambdaUpdateWrapper<StaffLevel> updateWrapper = new LambdaUpdateWrapper<>();

        updateWrapper.eq(StaffLevel::getId, param.getId());

        if (StringUtils.isNotBlank(param.getName())) {
            updateWrapper.set(StaffLevel::getName, param.getName());
        }

        if (param.getIsActive() != null) {
            if (param.getIsActive().intValue() != 0) {
                updateWrapper.set(StaffLevel::getIsActive, 1);
            } else {
                updateWrapper.set(StaffLevel::getIsActive, 0);
            }
        }

        return levelMapper.update(null, updateWrapper) == 1;
    }

    @Override
    public Boolean delete(StaffLevelParam param) {
        //直接删除了
        return levelMapper.deleteById(param.getId()) == 1;
    }

    @Override
    public Boolean add(StaffLevelParam param) {
        //查询名字是否重复
        LambdaQueryWrapper<StaffLevel> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(StaffLevel::getName, param.getName());
        //不允许添加为已经存在的名字
        if (levelMapper.selectCount(queryWrapper) > 0) {
            throw new CommonServiceException(ErrorCodeEnum.LEVEL_NAME_EXIST);
        }

        StaffLevel newStaffInfo = new StaffLevel();
        newStaffInfo.setName(param.getName());
        newStaffInfo.setIsActive(1);
        newStaffInfo.setCreateAt(LocalDateTime.now());
        return levelMapper.insert(newStaffInfo) == 1;
    }


}
