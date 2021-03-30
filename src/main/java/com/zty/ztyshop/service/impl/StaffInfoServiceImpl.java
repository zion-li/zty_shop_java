package com.zty.ztyshop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.Lists;
import com.zty.ztyshop.common.CommonServiceException;
import com.zty.ztyshop.common.ErrorCodeEnum;
import com.zty.ztyshop.controller.param.BasePageParam;
import com.zty.ztyshop.controller.param.StaffInfoParam;
import com.zty.ztyshop.controller.vo.StaffInfoVO;
import com.zty.ztyshop.dao.entity.StaffInfo;
import com.zty.ztyshop.dao.entity.StaffLevel;
import com.zty.ztyshop.dao.mapper.StaffInfoMapper;
import com.zty.ztyshop.dao.mapper.StaffLevelMapper;
import com.zty.ztyshop.service.IStaffInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 李佳 zion
 * @since 2021-03-26
 */
@Service
public class StaffInfoServiceImpl extends ServiceImpl<StaffInfoMapper, StaffInfo> implements IStaffInfoService {

    @Autowired
    private StaffInfoMapper staffInfoMapper;

    @Autowired
    private StaffLevelMapper staffLevelMapper;


    @Override
    public Boolean add(StaffInfoParam param) {

        //查询名字是否重复
        LambdaQueryWrapper<StaffInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(StaffInfo::getName, param.getName());
        //不允许添加为已经存在的名字
        if (staffInfoMapper.selectCount(queryWrapper) > 0) {
            throw new CommonServiceException(ErrorCodeEnum.STAFF_NAME_EXIST);
        }


        StaffInfo staffInfo = new StaffInfo();
        staffInfo.setName(param.getName());
        staffInfo.setBirthday(getLocalDate(param.getBirthday()));
        staffInfo.setGender(param.getGender());
        staffInfo.setAdress(param.getAdress());
        staffInfo.setMobile(param.getMobile());
        staffInfo.setIdArd(param.getIdArd());
        LocalDate employmentDate = null == getLocalDate(param.getEmploymentDate()) ? LocalDate.now() : getLocalDate(param.getEmploymentDate());
        staffInfo.setEmploymentDate(employmentDate);
        staffInfo.setStaffLevel(param.getStaffLevel());
        staffInfo.setEmergencyContactName(param.getEmergencyContactName());
        staffInfo.setEmergencyContactMobile(param.getEmergencyContactMobile());
        staffInfo.setIsActive(1);
        staffInfo.setCreateAt(LocalDateTime.now());
        staffInfo.setUpdateAt(LocalDateTime.now());

        return staffInfoMapper.insert(staffInfo) == 1;
    }

    @Override
    public Boolean delete(StaffInfoParam param) {
        return staffInfoMapper.deleteById(param.getId()) == 1;
    }

    @Override
    public Boolean updateStaffInfo(StaffInfoParam param) {
        //查询名字是否重复
        LambdaQueryWrapper<StaffInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.ne(StaffInfo::getId, param.getId());
        queryWrapper.eq(StaffInfo::getName, param.getName());
        //不允许添加为已经存在的名字
        if (staffInfoMapper.selectCount(queryWrapper) > 0) {
            throw new CommonServiceException(ErrorCodeEnum.STAFF_NAME_EXIST);
        }

        LambdaUpdateWrapper<StaffInfo> updateWrapper = new LambdaUpdateWrapper<>();

        updateWrapper.eq(StaffInfo::getId, param.getId());

        if (StringUtils.isNotBlank(param.getName())) {
            updateWrapper.set(StaffInfo::getName, param.getName());
        }

        if (StringUtils.isNotBlank(param.getBirthday())) {
            updateWrapper.set(StaffInfo::getBirthday, getLocalDate(param.getBirthday()));
        }

        if (param.getGender() != null) {
            if (param.getGender() != 0) {
                updateWrapper.set(StaffInfo::getGender, 1);
            } else {
                updateWrapper.set(StaffInfo::getGender, 0);
            }
        }

        if (StringUtils.isNotBlank(param.getAdress())) {
            updateWrapper.set(StaffInfo::getAdress, param.getAdress());
        }

        if (StringUtils.isNotBlank(param.getMobile())) {
            updateWrapper.set(StaffInfo::getMobile, param.getMobile());
        }

        if (StringUtils.isNotBlank(param.getIdArd())) {
            updateWrapper.set(StaffInfo::getIdArd, param.getIdArd());
        }

        if (StringUtils.isNotBlank(param.getEmploymentDate())) {
            updateWrapper.set(StaffInfo::getEmploymentDate, getLocalDate(param.getEmploymentDate()));
        }

        if (null != param.getStaffLevel()) {
            updateWrapper.set(StaffInfo::getStaffLevel, param.getStaffLevel());
        }

        if (StringUtils.isNotBlank(param.getEmergencyContactName())) {
            updateWrapper.set(StaffInfo::getEmergencyContactName, param.getEmergencyContactName());
        }


        if (StringUtils.isNotBlank(param.getEmergencyContactMobile())) {
            updateWrapper.set(StaffInfo::getEmergencyContactMobile, param.getEmergencyContactMobile());
        }

        if (null != param.getIsActive()) {
            if (param.getIsActive().intValue() != 0) {
                updateWrapper.set(StaffInfo::getIsActive, 1);
            } else {
                updateWrapper.set(StaffInfo::getIsActive, 0);
            }
        }

        updateWrapper.set(StaffInfo::getUpdateAt, LocalDateTime.now());

        return staffInfoMapper.update(null, updateWrapper) == 1;
    }

    @Override
    public Page<StaffInfoVO> page(BasePageParam param) {

        Page<StaffInfo> page = new Page<>(param.getPageNo(), param.getPageSize());
        Page<StaffInfo> userPage = staffInfoMapper.selectPage(page, null);

        //
        List<StaffLevel> staffLevels = staffLevelMapper.selectList(new QueryWrapper<>());


        List<StaffInfoVO> res = Lists.newArrayList();
        for (StaffInfo e : userPage.getRecords()) {
            StaffInfoVO per = new StaffInfoVO();
            BeanUtils.copyProperties(e, per);
            if (!CollectionUtils.isEmpty(staffLevels)) {
                for (StaffLevel s : staffLevels) {
                    if (e.getStaffLevel().intValue() == s.getId().intValue()) {
                        per.setStaffName(s.getName());
                        break;
                    }
                }
            }
            res.add(per);
        }
        Page<StaffInfoVO> resPage = new Page<>();
        resPage.setRecords(res);
        resPage.setSize(userPage.getSize());
        resPage.setTotal(userPage.getTotal());
        resPage.setPages(userPage.getPages());
        resPage.setCurrent(userPage.getCurrent());

        return resPage;
    }

    private LocalDate getLocalDate(String dataStr) {
        if (StringUtils.isBlank(dataStr)) {
            return null;
        }
        return LocalDate.parse(dataStr, DateTimeFormatter.ofPattern("yyyy/MM/dd"));
    }


}
