package com.zty.ztyshop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zty.ztyshop.common.CommonServiceException;
import com.zty.ztyshop.common.ErrorCodeEnum;
import com.zty.ztyshop.controller.param.BasePageParam;
import com.zty.ztyshop.controller.param.StaffInfoParam;
import com.zty.ztyshop.dao.entity.StaffInfo;
import com.zty.ztyshop.dao.mapper.StaffInfoMapper;
import com.zty.ztyshop.dao.mapper.StaffRankMapper;
import com.zty.ztyshop.service.IStaffInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
        staffInfo.setRankName(param.getRankName());
        staffInfo.setBirthday(getLocalDate(param.getBirthday()));
        staffInfo.setGender(param.getGender());
        staffInfo.setAdress(param.getAdress());
        staffInfo.setMobile(param.getMobile());
        staffInfo.setIdArd(param.getIdArd());
        LocalDate employmentDate = null == getLocalDate(param.getEmploymentDate()) ? LocalDate.now() : getLocalDate(param.getEmploymentDate());
        staffInfo.setEmploymentDate(employmentDate);
        staffInfo.setEmergencyContactName(param.getEmergencyContactName());
        staffInfo.setEmergencyContactMobile(param.getEmergencyContactMobile());
        staffInfo.setResign(1);

        return staffInfoMapper.insert(staffInfo) == 1;
    }

    @Override
    public Boolean delete(StaffInfoParam param) {
        return staffInfoMapper.deleteById(param.getId()) == 1;
    }

    @Override
    public Boolean update(StaffInfoParam param) {

        if (param.getId() == null) {
            return false;
        }

        StaffInfo staffInfo = staffInfoMapper.selectById(param.getId());
        if (staffInfo == null){
            return false;
        }

        if (StringUtils.isNotBlank(param.getName())) {
            //查询名字是否重复
            LambdaQueryWrapper<StaffInfo> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.ne(StaffInfo::getId, param.getId());
            queryWrapper.eq(StaffInfo::getName, param.getName());
            //不允许添加为已经存在的名字
            if (staffInfoMapper.selectCount(queryWrapper) > 0) {
                throw new CommonServiceException(ErrorCodeEnum.STAFF_NAME_EXIST);
            }

            staffInfo.setName(param.getName());
        }

        if (StringUtils.isNotBlank(param.getRankName())) {
            staffInfo.setRankName(param.getRankName());
        }

        if (StringUtils.isNotBlank(param.getBirthday())) {
            staffInfo.setBirthday(getLocalDate(param.getBirthday()));
        }

        if (param.getGender() != null && (param.getGender() == 0 || param.getGender() == 1)) {
            staffInfo.setGender(param.getGender());
        }

        if (StringUtils.isNotBlank(param.getAdress())) {
            staffInfo.setAdress(param.getAdress());
        }

        if (StringUtils.isNotBlank(param.getMobile())) {
            staffInfo.setMobile(param.getMobile());
        }

        if (StringUtils.isNotBlank(param.getIdArd())) {
            staffInfo.setIdArd(param.getIdArd());
        }

        if (StringUtils.isNotBlank(param.getEmploymentDate())) {
            staffInfo.setEmploymentDate(getLocalDate(param.getEmploymentDate()));
        }

        if (StringUtils.isNotBlank(param.getEmergencyContactName())) {
            staffInfo.setEmergencyContactName(param.getEmergencyContactName());
        }

        if (StringUtils.isNotBlank(param.getEmergencyContactMobile())) {
            staffInfo.setEmergencyContactMobile(param.getEmergencyContactMobile());
        }

        if (null != param.getIsActive() && (param.getIsActive() == 0 || param.getIsActive() == 1)) {
            staffInfo.setResign(param.getIsActive());
        }

        return staffInfoMapper.updateById(staffInfo) == 1;
    }

    @Override
    public Page<StaffInfo> page(BasePageParam param) {

        Page<StaffInfo> page = new Page<>(param.getPageNo(), param.getPageSize());

        Page<StaffInfo> result = staffInfoMapper.selectPage(page, null);

        return result;
    }

    /**
     * @return
     */
    @Override
    public List<StaffInfo> getAll() {
        return staffInfoMapper.selectList(null);
    }


    private LocalDate getLocalDate(String dataStr) {
        if (StringUtils.isBlank(dataStr)) {
            return null;
        }
        return LocalDate.parse(dataStr, DateTimeFormatter.ofPattern("yyyy/MM/dd"));
    }

}
