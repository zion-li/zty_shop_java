package com.zty.ztyshop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.Lists;
import com.zty.ztyshop.common.BaseException;
import com.zty.ztyshop.common.BaseEnum;
import com.zty.ztyshop.controller.bo.StatisticsLast30DaysBO;
import com.zty.ztyshop.controller.param.BasePageParam;
import com.zty.ztyshop.controller.param.OrderInfoParam;
import com.zty.ztyshop.controller.vo.OrderInfoVO;
import com.zty.ztyshop.controller.vo.StaffServeStatisticVO;
import com.zty.ztyshop.dao.entity.ClientInfo;
import com.zty.ztyshop.dao.entity.OrderInfo;
import com.zty.ztyshop.dao.entity.StaffInfo;
import com.zty.ztyshop.dao.mapper.ClientInfoMapper;
import com.zty.ztyshop.dao.mapper.OrderInfoMapper;
import com.zty.ztyshop.dao.mapper.StaffInfoMapper;
import com.zty.ztyshop.service.SysOrderInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zty.ztyshop.utils.DateUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 李佳 zion
 * @since 2021-03-27
 */
@Service
public class SysOrderInfoServiceImpl extends ServiceImpl<OrderInfoMapper, OrderInfo> implements SysOrderInfoService {

    @Autowired
    private OrderInfoMapper orderInfoMapper;

    @Autowired
    private StaffInfoMapper staffInfoMapper;

    @Autowired
    private ClientInfoMapper clientInfoMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean add(OrderInfoParam param) {
        //参数校验
        if (null == param.getClientId()) {
            throw new BaseException(BaseEnum.PARAM_ERROR);
        }

        if (null == param.getStaffId()) {
            throw new BaseException(BaseEnum.PARAM_ERROR);
        }

        ClientInfo clientInfo = clientInfoMapper.selectById(param.getClientId());
        if (clientInfo == null) {
            //当前用户不存在
            throw new BaseException(BaseEnum.CLIENT_NOT_EXIST);
        }

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

        //时间
        orderInfo.setCreateAt(LocalDateTime.now());
        orderInfo.setUpdateAt(LocalDateTime.now());
        orderInfo.setIsDelete(0);

        if (orderInfoMapper.insert(orderInfo) == 1) {
            //更新服务次数
            clientInfo.setServiceTime(clientInfo.getServiceTime() + 1);
            //更新消费金额
            BigDecimal amount = clientInfo.getAccount().add(new BigDecimal(param.getCashAccount()));
            clientInfo.setAccount(amount);
            //最新到店时间
            clientInfo.setLastLogin(LocalDateTime.now());
            return clientInfoMapper.updateById(clientInfo) == 1;
        }
        return false;
    }

    @Override
    public Boolean delete(OrderInfoParam param) {
        LambdaUpdateWrapper<OrderInfo> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(OrderInfo::getId, param.getId());
        updateWrapper.set(OrderInfo::getIsDelete, 1);
        return orderInfoMapper.update(null, updateWrapper) == 1;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean update(OrderInfoParam param) {
        //参数校验
        if (null == param.getClientId()) {
            throw new BaseException(BaseEnum.PARAM_ERROR);
        }

        ClientInfo clientInfo = clientInfoMapper.selectById(param.getClientId());

        if (clientInfo == null) {
            //当前用户不存在
            throw new BaseException(BaseEnum.CLIENT_NOT_EXIST);
        }

        OrderInfo orderInfo = orderInfoMapper.selectById(param.getId());
        if (orderInfo == null) {
            return false;
        }

        BigDecimal cash = orderInfo.getCashAccount();

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

        if (orderInfoMapper.updateById(orderInfo) == 1) {
            //更新消费金额
            if (param.getCashAccount() != null) {
                BigDecimal amount = clientInfo.getAccount().add(new BigDecimal(param.getCashAccount()));
                if (amount.compareTo(cash) != 0) {
                    clientInfo.setAccount(clientInfo.getAccount().subtract(cash).add(amount));
                    return clientInfoMapper.updateById(clientInfo) == 1;
                }
            }
        }
        return false;
    }

    @Override
    public Page<OrderInfoVO> page(BasePageParam param) {

        Page<OrderInfo> page = new Page<>(param.getPageNo(), param.getPageSize());

        LambdaQueryWrapper<OrderInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.orderByDesc(OrderInfo::getId);

        Page<OrderInfo> orderInfoPage = orderInfoMapper.selectPage(page, queryWrapper);


        //结果
        Page<OrderInfoVO> result = new Page<>(param.getPageNo(), param.getPageSize());
        BeanUtils.copyProperties(orderInfoPage, result);

        List<OrderInfoVO> records = Lists.newArrayList();

        for (OrderInfo o : orderInfoPage.getRecords()) {
            OrderInfoVO tmp = new OrderInfoVO();
            BeanUtils.copyProperties(o, tmp);

            //用户
            ClientInfo clientInfo = clientInfoMapper.selectById(o.getClientId());
            tmp.setClientName(clientInfo == null ? "未知用户" : clientInfo.getName());

            //发型师
            StaffInfo staffInfo;
            staffInfo = staffInfoMapper.selectById(o.getStaffId());
            if (staffInfo != null) {
                if (staffInfo.getResign() == 1) {
                    tmp.setStaffName(staffInfo == null ? "未知" : staffInfo.getName());
                } else {
                    tmp.setStaffName(staffInfo == null ? "未知" : "离职-" + staffInfo.getName());
                }
            }

            //剪发
            staffInfo = staffInfoMapper.selectById(o.getCashJfAssistant());
            if (staffInfo != null) {
                if (staffInfo.getResign() == 1) {
                    tmp.setCashJfAssistantName(staffInfo == null ? "未知" : staffInfo.getName());
                } else {
                    tmp.setCashJfAssistantName(staffInfo == null ? "未知" : "离职-" + staffInfo.getName());
                }
            }


            //烫发
            staffInfo = staffInfoMapper.selectById(o.getCashTfAssistant());
            if (staffInfo != null) {
                if (staffInfo.getResign() == 1) {
                    tmp.setCashTfAssistantName(staffInfo == null ? "未知" : staffInfo.getName());
                } else {
                    tmp.setCashTfAssistantName(staffInfo == null ? "未知" : "离职-" + staffInfo.getName());
                }
            }


            //染发
            staffInfo = staffInfoMapper.selectById(o.getCashRfAssistant());
            if (staffInfo != null) {
                if (staffInfo.getResign() == 1) {
                    tmp.setCashRfAssistantName(staffInfo == null ? "未知" : staffInfo.getName());
                } else {
                    tmp.setCashRfAssistantName(staffInfo == null ? "未知" : "离职-" + staffInfo.getName());
                }
            }


            //头皮
            staffInfo = staffInfoMapper.selectById(o.getCashTpAssistant());
            if (staffInfo != null) {
                if (staffInfo.getResign() == 1) {
                    tmp.setCashTpAssistantName(staffInfo == null ? "未知" : staffInfo.getName());
                } else {
                    tmp.setCashTpAssistantName(staffInfo == null ? "未知" : "离职-" + staffInfo.getName());
                }
            }


            //造型
            staffInfo = staffInfoMapper.selectById(o.getCashZxAssistant());
            if (staffInfo != null) {
                if (staffInfo.getResign() == 1) {
                    tmp.setCashZxAssistantName(staffInfo == null ? "未知" : staffInfo.getName());
                } else {
                    tmp.setCashZxAssistantName(staffInfo == null ? "未知" : "离职-" + staffInfo.getName());
                }
            }


            //营养
            staffInfo = staffInfoMapper.selectById(o.getCashYyAssistant());
            if (staffInfo != null) {
                if (staffInfo.getResign() == 1) {
                    tmp.setCashYyAssistantName(staffInfo == null ? "未知" : staffInfo.getName());
                } else {
                    tmp.setCashYyAssistantName(staffInfo == null ? "未知" : "离职-" + staffInfo.getName());
                }
            }


            //水洗
            staffInfo = staffInfoMapper.selectById(o.getCashSxAssistant());
            if (staffInfo != null) {
                if (staffInfo.getResign() == 1) {
                    tmp.setCashSxAssistantName(staffInfo == null ? "未知" : staffInfo.getName());
                } else {
                    tmp.setCashSxAssistantName(staffInfo == null ? "未知" : "离职-" + staffInfo.getName());
                }
            }


            //速焗
            staffInfo = staffInfoMapper.selectById(o.getCashSjAssistant());
            if (staffInfo != null) {
                if (staffInfo.getResign() == 1) {
                    tmp.setCashSjAssistantName(staffInfo == null ? "未知" : staffInfo.getName());
                } else {
                    tmp.setCashSjAssistantName(staffInfo == null ? "未知" : "离职-" + staffInfo.getName());
                }
            }


            //速焗
            staffInfo = staffInfoMapper.selectById(o.getCashSpAssistant());
            if (staffInfo != null) {
                if (staffInfo.getResign() == 1) {
                    tmp.setCashSpAssistantName(staffInfo == null ? "未知" : staffInfo.getName());
                } else {
                    tmp.setCashSpAssistantName(staffInfo == null ? "未知" : "离职-" + staffInfo.getName());
                }
            }

            records.add(tmp);
        }

        result.setRecords(records);
        return result;
    }


}
