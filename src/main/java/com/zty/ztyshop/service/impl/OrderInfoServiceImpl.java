package com.zty.ztyshop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.Lists;
import com.sun.security.ntlm.Client;
import com.zty.ztyshop.controller.param.BasePageParam;
import com.zty.ztyshop.controller.param.OrderInfoParam;
import com.zty.ztyshop.controller.vo.OrderInfoVO;
import com.zty.ztyshop.dao.entity.ClientInfo;
import com.zty.ztyshop.dao.entity.OrderInfo;
import com.zty.ztyshop.dao.entity.StaffInfo;
import com.zty.ztyshop.dao.mapper.ClientInfoMapper;
import com.zty.ztyshop.dao.mapper.OrderInfoMapper;
import com.zty.ztyshop.dao.mapper.StaffInfoMapper;
import com.zty.ztyshop.service.IOrderInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 李佳 zion
 * @since 2021-03-27
 */
@Service
public class OrderInfoServiceImpl extends ServiceImpl<OrderInfoMapper, OrderInfo> implements IOrderInfoService {

    @Autowired
    private OrderInfoMapper orderInfoMapper;

    @Autowired
    private StaffInfoMapper staffInfoMapper;

    @Autowired
    private ClientInfoMapper clientInfoMapper;

    @Override
    public Boolean add(OrderInfoParam param) {
        OrderInfo orderInfo = new OrderInfo();
        //客户id
        orderInfo.setClientId(param.getClientId());
        //发型师
        orderInfo.setStaffId(param.getStaffId());
        //现金
        orderInfo.setCashType(param.getCashType());
        orderInfo.setCashAccount(new BigDecimal(param.getCashAccount()));

        //剪发
        orderInfo.setCashJfAssistant(param.getCashJfAssistant());
        orderInfo.setCashJf(new BigDecimal(param.getCashJf()));

        //烫发
        orderInfo.setCashTfAssistant(param.getCashTfAssistant());
        orderInfo.setCashTf(new BigDecimal(param.getCashTf()));

        //染发
        orderInfo.setCashRfAssistant(param.getCashRfAssistant());
        orderInfo.setCashRf(new BigDecimal(param.getCashRf()));

        //头皮
        orderInfo.setCashTpAssistant(param.getCashTpAssistant());
        orderInfo.setCashTp(new BigDecimal(param.getCashTp()));

        //造型
        orderInfo.setCashZxAssistant(param.getCashZxAssistant());
        orderInfo.setCashZx(new BigDecimal(param.getCashZx()));

        //营养
        orderInfo.setCashYyAssistant(param.getCashYyAssistant());
        orderInfo.setCashYy(new BigDecimal(param.getCashYy()));


        //水洗
        orderInfo.setCashSxAssistant(param.getCashSxAssistant());
        orderInfo.setCashSx(new BigDecimal(param.getCashSx()));

        //速焗
        orderInfo.setCashSjAssistant(param.getCashSjAssistant());
        orderInfo.setCashSj(new BigDecimal(param.getCashSj()));

        //商品
        orderInfo.setCashSpAssistant(param.getCashSpAssistant());
        orderInfo.setCashSp(new BigDecimal(param.getCashSp()));
        orderInfo.setCashSpDesc(param.getCashSpDesc());

        orderInfo.setCreateAt(LocalDateTime.now());
        orderInfo.setUpdateAt(LocalDateTime.now());
        orderInfo.setIsDelete(0);

        return orderInfoMapper.insert(orderInfo) == 1;
    }

    @Override
    public Boolean delete(OrderInfoParam param) {
        LambdaUpdateWrapper<OrderInfo> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(OrderInfo::getId, param.getId());
        updateWrapper.set(OrderInfo::getIsDelete, 1);
        return orderInfoMapper.update(null, updateWrapper) == 1;
    }

    @Override
    public Boolean update(OrderInfoParam param) {
        OrderInfo orderInfo = orderInfoMapper.selectById(param.getId());
        if (orderInfo == null) {
            return false;
        }
        //客户id
        if (param.getClientId() != null) {
            orderInfo.setClientId(param.getClientId());
        }

        //发型师
        if (param.getStaffId() != null) {
            orderInfo.setStaffId(param.getStaffId());
        }

        //现金
        if (StringUtils.isNotBlank(param.getCashType())) {
            orderInfo.setCashType(param.getCashType());
        }
        if (StringUtils.isNotBlank(param.getCashAccount())) {
            orderInfo.setCashAccount(new BigDecimal(param.getCashAccount()));
        }

        //剪发
        if (param.getCashJfAssistant() != null) {
            orderInfo.setCashJfAssistant(param.getCashJfAssistant());
        }
        if (StringUtils.isNotBlank(param.getCashJf())) {
            orderInfo.setCashJf(new BigDecimal(param.getCashJf()));
        }


        //烫发
        if (param.getCashTfAssistant() != null) {
            orderInfo.setCashTfAssistant(param.getCashTfAssistant());
        }
        if (StringUtils.isNotBlank(param.getCashTf())) {
            orderInfo.setCashTf(new BigDecimal(param.getCashTf()));
        }


        //染发
        if (param.getCashRfAssistant() != null) {
            orderInfo.setCashRfAssistant(param.getCashRfAssistant());
        }
        if (StringUtils.isNotBlank(param.getCashRf())) {
            orderInfo.setCashRf(new BigDecimal(param.getCashRf()));
        }


        //头皮
        if (param.getCashTpAssistant() != null) {
            orderInfo.setCashTpAssistant(param.getCashTpAssistant());
        }
        if (StringUtils.isNotBlank(param.getCashTp())) {
            orderInfo.setCashTp(new BigDecimal(param.getCashTp()));
        }


        //造型
        if (param.getCashZxAssistant() != null) {
            orderInfo.setCashZxAssistant(param.getCashZxAssistant());
        }
        if (StringUtils.isNotBlank(param.getCashZx())) {
            orderInfo.setCashZx(new BigDecimal(param.getCashZx()));
        }


        //营养
        if (param.getCashYyAssistant() != null) {
            orderInfo.setCashYyAssistant(param.getCashYyAssistant());
        }
        if (StringUtils.isNotBlank(param.getCashYy())) {
            orderInfo.setCashYy(new BigDecimal(param.getCashYy()));
        }


        //水洗
        if (param.getCashSxAssistant() != null) {
            orderInfo.setCashSxAssistant(param.getCashSxAssistant());
        }
        if (StringUtils.isNotBlank(param.getCashSx())) {
            orderInfo.setCashSx(new BigDecimal(param.getCashSx()));
        }


        //速焗
        if (param.getCashSjAssistant() != null) {
            orderInfo.setCashSjAssistant(param.getCashSjAssistant());
        }
        if (StringUtils.isNotBlank(param.getCashSj())) {
            orderInfo.setCashSj(new BigDecimal(param.getCashSj()));
        }


        //商品
        if (param.getCashSpAssistant() != null) {
            orderInfo.setCashSpAssistant(param.getCashSpAssistant());
        }
        if (StringUtils.isNotBlank(param.getCashSp())) {
            orderInfo.setCashSp(new BigDecimal(param.getCashSp()));
        }
        if (StringUtils.isNotBlank(param.getCashSpDesc())) {
            orderInfo.setCashSpDesc(param.getCashSpDesc());
        }

        orderInfo.setUpdateAt(LocalDateTime.now());

        return orderInfoMapper.updateById(orderInfo) == 1;
    }

    @Override
    public Page<OrderInfoVO> page(BasePageParam param) {

        Page<OrderInfo> page = new Page<>(param.getPageNo(), param.getPageSize());
        Page<OrderInfo> orderInfoPage = orderInfoMapper.selectPage(page, null);


        //结果
        Page<OrderInfoVO> result = new Page<>(param.getPageNo(), param.getPageSize());
        BeanUtils.copyProperties(orderInfoPage, result);

        List<OrderInfoVO> records = Lists.newArrayList();

        for (OrderInfo o : orderInfoPage.getRecords()) {
            OrderInfoVO tmp = new OrderInfoVO();
            BeanUtils.copyProperties(o, tmp);

            //用户
            ClientInfo clientInfo = clientInfoMapper.selectById(o.getClientId());
            tmp.setClientName(clientInfo == null ? "" : clientInfo.getName());

            //发型师
            StaffInfo staffInfo;
            staffInfo = staffInfoMapper.selectById(o.getStaffId());
            tmp.setStaffName(staffInfo == null ? "" : staffInfo.getName());

            //剪发
            staffInfo = staffInfoMapper.selectById(o.getCashJfAssistant());
            tmp.setCashJfAssistantName(staffInfo == null ? "" : staffInfo.getName());

            //烫发
            staffInfo = staffInfoMapper.selectById(o.getCashTfAssistant());
            tmp.setCashTfAssistantName(staffInfo == null ? "" : staffInfo.getName());

            //染发
            staffInfo = staffInfoMapper.selectById(o.getCashRfAssistant());
            tmp.setCashRfAssistantName(staffInfo == null ? "" : staffInfo.getName());

            //头皮
            staffInfo = staffInfoMapper.selectById(o.getCashTpAssistant());
            tmp.setCashTpAssistantName(staffInfo == null ? "" : staffInfo.getName());

            //造型
            staffInfo = staffInfoMapper.selectById(o.getCashZxAssistant());
            tmp.setCashZxAssistantName(staffInfo == null ? "" : staffInfo.getName());

            //营养
            staffInfo = staffInfoMapper.selectById(o.getCashYyAssistant());
            tmp.setCashYyAssistantName(staffInfo == null ? "" : staffInfo.getName());

            //水洗
            staffInfo = staffInfoMapper.selectById(o.getCashSxAssistant());
            tmp.setCashSxAssistantName(staffInfo == null ? "" : staffInfo.getName());

            //速焗
            staffInfo = staffInfoMapper.selectById(o.getCashSjAssistant());
            tmp.setCashSjAssistantName(staffInfo == null ? "" : staffInfo.getName());

            //速焗
            staffInfo = staffInfoMapper.selectById(o.getCashSpAssistant());
            tmp.setCashSpAssistantName(staffInfo == null ? "" : staffInfo.getName());
            records.add(tmp);
        }

        result.setRecords(records);
        return result;
    }


}
