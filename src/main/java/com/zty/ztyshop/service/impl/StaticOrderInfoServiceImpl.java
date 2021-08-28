package com.zty.ztyshop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import com.zty.ztyshop.controller.bo.StatisticsLast30DaysBO;
import com.zty.ztyshop.controller.vo.StaffServeStatisticVO;
import com.zty.ztyshop.dao.entity.OrderInfo;
import com.zty.ztyshop.dao.entity.StaffInfo;
import com.zty.ztyshop.dao.mapper.ClientInfoMapper;
import com.zty.ztyshop.dao.mapper.OrderInfoMapper;
import com.zty.ztyshop.dao.mapper.StaffInfoMapper;
import com.zty.ztyshop.service.StaticOrderInfoService;
import com.zty.ztyshop.service.SysOrderInfoService;
import com.zty.ztyshop.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

/**
 * @author 李佳 lijia@autoai.com
 * @version 1.0
 * @date 2021/8/28 11:28
 */
@Service
public class StaticOrderInfoServiceImpl extends ServiceImpl<OrderInfoMapper, OrderInfo> implements StaticOrderInfoService {
    @Autowired
    private OrderInfoMapper orderInfoMapper;

    @Autowired
    private StaffInfoMapper staffInfoMapper;

    @Autowired
    private ClientInfoMapper clientInfoMapper;

    @Override
    public String accountAll() {
        return String.valueOf(orderInfoMapper.accountAll());
    }

    @Override
    public Map<String, Integer> statisticsLast7Days() {
        //默认，统计最近一个月，新用户增长
        Map<String, Integer> res = DateUtils.getLast7Days();

        LocalDate minDate = LocalDate.now().minusDays(7);

        List<StatisticsLast30DaysBO> last30DaysBOS = orderInfoMapper.statisticsReturn(minDate);

        for (StatisticsLast30DaysBO e : last30DaysBOS) {
            if (res.containsKey(e.getDay())) {
                res.put(e.getDay(), e.getAccount());
            }
        }

        return res;
    }

    @Override
    public Map<String, Integer> statisticsLast30Days() {
        //默认，统计最近一个月，新用户增长
        Map<String, Integer> res = DateUtils.getLast30Days();

        LocalDate minDate = LocalDate.now().minusDays(30);

        List<StatisticsLast30DaysBO> last30DaysBOS = orderInfoMapper.statisticsReturn(minDate);

        for (StatisticsLast30DaysBO e : last30DaysBOS) {
            if (res.containsKey(e.getDay())) {
                res.put(e.getDay(), e.getAccount());
            }
        }

        return res;
    }

    @Override
    public Map<String, Integer> statisticsLast90Days() {
        //默认，统计最近一个月，新用户增长
        Map<String, Integer> res = DateUtils.getLast90Days();

        LocalDate minDate = LocalDate.now().minusDays(90);

        List<StatisticsLast30DaysBO> last30DaysBOS = orderInfoMapper.statisticsReturn(minDate);

        for (StatisticsLast30DaysBO e : last30DaysBOS) {
            if (res.containsKey(e.getDay())) {
                res.put(e.getDay(), e.getAccount());
            }
        }
        return res;
    }

    @Override
    public Map<String, Integer> statisticsLast365Days() {
        //默认，统计最近一个月，新用户增长
        Map<String, Integer> res = DateUtils.getLastYear();

        LocalDate minDate = LocalDate.now().minusDays(366);

        List<StatisticsLast30DaysBO> last30DaysBOS = orderInfoMapper.statisticsReturn(minDate);

        for (StatisticsLast30DaysBO e : last30DaysBOS) {

            for (Map.Entry<String, Integer> entry : res.entrySet()) {
                String mapKey = entry.getKey();
                if (e.getDay().startsWith(mapKey)) {
                    entry.setValue(entry.getValue() + e.getAccount());
                    break;
                }
            }
        }
        return res;
    }

    @Override
    public List<StaffServeStatisticVO> statistics1Days() {
        List<StaffServeStatisticVO> result = Lists.newArrayList();
        //找到所有的员工
        List<StaffInfo> staffInfos = staffInfoMapper.selectList(null);

        //找到所有的订单
        LambdaQueryWrapper<OrderInfo> queryWrapper = new LambdaQueryWrapper();

        queryWrapper.between(OrderInfo::getCreateAt, LocalDateTime.of(LocalDate.now(), LocalTime.MIN), LocalDateTime.now());

        List<OrderInfo> orderInfos = orderInfoMapper.selectList(queryWrapper);

        for (StaffInfo staffInfo : staffInfos) {
            StaffServeStatisticVO staffServeStatisticVO = new StaffServeStatisticVO();
            staffServeStatisticVO.setId(staffInfo.getId());
            staffServeStatisticVO.setName(staffInfo.getName());

            for (OrderInfo orderInfo : orderInfos) {
                wrapper(staffServeStatisticVO, orderInfo, staffInfo);
            }
            result.add(staffServeStatisticVO);
        }
        return result;
    }

    @Override
    public List<StaffServeStatisticVO> statistics7Days() {
        List<StaffServeStatisticVO> result = Lists.newArrayList();
        //找到所有的员工
        List<StaffInfo> staffInfos = staffInfoMapper.selectList(null);

        //找到所有的订单
        LambdaQueryWrapper<OrderInfo> queryWrapper = new LambdaQueryWrapper();

        queryWrapper.between(OrderInfo::getCreateAt, LocalDateTime.of(LocalDate.now(), LocalTime.MIN).minusDays(6), LocalDateTime.now());

        List<OrderInfo> orderInfos = orderInfoMapper.selectList(queryWrapper);

        for (StaffInfo staffInfo : staffInfos) {
            StaffServeStatisticVO staffServeStatisticVO = new StaffServeStatisticVO();
            staffServeStatisticVO.setId(staffInfo.getId());
            staffServeStatisticVO.setName(staffInfo.getName());

            for (OrderInfo orderInfo : orderInfos) {
                wrapper(staffServeStatisticVO, orderInfo, staffInfo);
            }
            result.add(staffServeStatisticVO);
        }
        return result;
    }

    @Override
    public List<StaffServeStatisticVO> statistics30Days() {
        List<StaffServeStatisticVO> result = Lists.newArrayList();
        //找到所有的员工
        List<StaffInfo> staffInfos = staffInfoMapper.selectList(null);

        //找到所有的订单
        LambdaQueryWrapper<OrderInfo> queryWrapper = new LambdaQueryWrapper();

        queryWrapper.between(OrderInfo::getCreateAt, LocalDateTime.of(LocalDate.now(), LocalTime.MIN).minusDays(29), LocalDateTime.now());

        List<OrderInfo> orderInfos = orderInfoMapper.selectList(queryWrapper);

        for (StaffInfo staffInfo : staffInfos) {
            StaffServeStatisticVO staffServeStatisticVO = new StaffServeStatisticVO();
            staffServeStatisticVO.setId(staffInfo.getId());
            staffServeStatisticVO.setName(staffInfo.getName());

            for (OrderInfo orderInfo : orderInfos) {
                wrapper(staffServeStatisticVO, orderInfo, staffInfo);
            }
            result.add(staffServeStatisticVO);
        }
        return result;
    }

    @Override
    public List<StaffServeStatisticVO> statistics90Days() {
        List<StaffServeStatisticVO> result = Lists.newArrayList();
        //找到所有的员工
        List<StaffInfo> staffInfos = staffInfoMapper.selectList(null);

        //找到所有的订单
        LambdaQueryWrapper<OrderInfo> queryWrapper = new LambdaQueryWrapper();

        queryWrapper.between(OrderInfo::getCreateAt, LocalDateTime.of(LocalDate.now(), LocalTime.MIN).minusDays(89), LocalDateTime.now());

        List<OrderInfo> orderInfos = orderInfoMapper.selectList(queryWrapper);

        for (StaffInfo staffInfo : staffInfos) {
            StaffServeStatisticVO staffServeStatisticVO = new StaffServeStatisticVO();
            staffServeStatisticVO.setId(staffInfo.getId());
            staffServeStatisticVO.setName(staffInfo.getName());

            for (OrderInfo orderInfo : orderInfos) {
                wrapper(staffServeStatisticVO, orderInfo, staffInfo);
            }
            result.add(staffServeStatisticVO);
        }
        return result;
    }

    @Override
    public List<StaffServeStatisticVO> statistics365Days() {
        List<StaffServeStatisticVO> result = Lists.newArrayList();
        //找到所有的员工
        List<StaffInfo> staffInfos = staffInfoMapper.selectList(null);

        //找到所有的订单
        LambdaQueryWrapper<OrderInfo> queryWrapper = new LambdaQueryWrapper();

        queryWrapper.between(OrderInfo::getCreateAt, LocalDateTime.of(LocalDate.now(), LocalTime.MIN).minusDays(364), LocalDateTime.now());

        List<OrderInfo> orderInfos = orderInfoMapper.selectList(queryWrapper);

        for (StaffInfo staffInfo : staffInfos) {
            StaffServeStatisticVO staffServeStatisticVO = new StaffServeStatisticVO();
            staffServeStatisticVO.setId(staffInfo.getId());
            staffServeStatisticVO.setName(staffInfo.getName());

            for (OrderInfo orderInfo : orderInfos) {
                wrapper(staffServeStatisticVO, orderInfo, staffInfo);
            }
            result.add(staffServeStatisticVO);
        }
        return result;
    }

    private void wrapper(StaffServeStatisticVO staffServeStatisticVO, OrderInfo orderInfo, StaffInfo staffInfo) {
        //客户数
        if (orderInfo.getStaffId().equals(staffInfo.getId())) {
            //服务客户数
            staffServeStatisticVO.setClientNum(1 + (staffServeStatisticVO.getClientNum() == null ? 0 : staffServeStatisticVO.getClientNum()));
            //现金业绩(数量)
            staffServeStatisticVO.setCashNum(1 + (staffServeStatisticVO.getCashNum() == null ? 0 : staffServeStatisticVO.getCashNum()));
            //现金业绩(金额)
            String oldAccount = staffServeStatisticVO.getCashAccount() == null ? "0" : staffServeStatisticVO.getCashAccount();
            BigDecimal newAccount = orderInfo.getCashAccount() == null ? new BigDecimal("0") : orderInfo.getCashAccount();
            staffServeStatisticVO.setCashAccount(newAccount.add(new BigDecimal(oldAccount)).toString());
        }
        //剪发业绩个数、总价格
        if (orderInfo.getCashJfAssistant().equals(staffInfo.getId())) {
            staffServeStatisticVO.setCashJfNum(1 + (staffServeStatisticVO.getCashJfNum() == null ? 0 : staffServeStatisticVO.getCashJfNum()));
            String old = staffServeStatisticVO.getCashJfAccount() == null ? "0" : staffServeStatisticVO.getCashJfAccount();
            String newAccount = orderInfo.getCashJf().add(new BigDecimal(old)).toString();
            staffServeStatisticVO.setCashJfAccount(newAccount);
        }
        //烫发业绩个数、总价格
        if (orderInfo.getCashTfAssistant().equals(staffInfo.getId())) {
            staffServeStatisticVO.setCashTfNum(1 + (staffServeStatisticVO.getCashTfNum() == null ? 0 : staffServeStatisticVO.getCashTfNum()));
            String old = staffServeStatisticVO.getCashTfAccount() == null ? "0" : staffServeStatisticVO.getCashTfAccount();
            String newAccount = orderInfo.getCashTf().add(new BigDecimal(old)).toString();
            staffServeStatisticVO.setCashTfAccount(newAccount);
        }

        //染发业绩个数、总价格
        if (orderInfo.getCashRfAssistant().equals(staffInfo.getId())) {
            staffServeStatisticVO.setCashRfNum(1 + (staffServeStatisticVO.getCashRfNum() == null ? 0 : staffServeStatisticVO.getCashRfNum()));
            String old = staffServeStatisticVO.getCashRfAccount() == null ? "0" : staffServeStatisticVO.getCashRfAccount();
            String newAccount = orderInfo.getCashTf().add(new BigDecimal(old)).toString();
            staffServeStatisticVO.setCashRfAccount(newAccount);
        }
        //头皮业绩个数、总价格
        if (orderInfo.getCashTpAssistant().equals(staffInfo.getId())) {
            staffServeStatisticVO.setCashTpNum(1 + (staffServeStatisticVO.getCashTpNum() == null ? 0 : staffServeStatisticVO.getCashTpNum()));
            String old = staffServeStatisticVO.getCashTpAccount() == null ? "0" : staffServeStatisticVO.getCashTpAccount();
            String newAccount = orderInfo.getCashTf().add(new BigDecimal(old)).toString();
            staffServeStatisticVO.setCashTpAccount(newAccount);
        }

        //造型业绩个数、总价格
        if (orderInfo.getCashZxAssistant().equals(staffInfo.getId())) {
            staffServeStatisticVO.setCashZxNum(1 + (staffServeStatisticVO.getCashZxNum() == null ? 0 : staffServeStatisticVO.getCashZxNum()));
            String old = staffServeStatisticVO.getCashZxAccount() == null ? "0" : staffServeStatisticVO.getCashZxAccount();
            String newAccount = orderInfo.getCashTf().add(new BigDecimal(old)).toString();
            staffServeStatisticVO.setCashZxAccount(newAccount);
        }

        //营养业绩个数、总价格
        if (orderInfo.getCashYyAssistant().equals(staffInfo.getId())) {
            staffServeStatisticVO.setCashYyNum(1 + (staffServeStatisticVO.getCashYyNum() == null ? 0 : staffServeStatisticVO.getCashYyNum()));
            String old = staffServeStatisticVO.getCashYyAccount() == null ? "0" : staffServeStatisticVO.getCashYyAccount();
            String newAccount = orderInfo.getCashTf().add(new BigDecimal(old)).toString();
            staffServeStatisticVO.setCashYyAccount(newAccount);
        }

        //水洗业绩个数、总价格
        if (orderInfo.getCashSxAssistant().equals(staffInfo.getId())) {
            staffServeStatisticVO.setCashSxNum(1 + (staffServeStatisticVO.getCashSxNum() == null ? 0 : staffServeStatisticVO.getCashSxNum()));
            String old = staffServeStatisticVO.getCashSxAccount() == null ? "0" : staffServeStatisticVO.getCashSxAccount();
            String newAccount = orderInfo.getCashTf().add(new BigDecimal(old)).toString();
            staffServeStatisticVO.setCashSxAccount(newAccount);
        }

        //速焗业绩个数、总价格
        if (orderInfo.getCashSjAssistant().equals(staffInfo.getId())) {
            staffServeStatisticVO.setCashSjNum(1 + (staffServeStatisticVO.getCashSjNum() == null ? 0 : staffServeStatisticVO.getCashSjNum()));
            String old = staffServeStatisticVO.getCashSjAccount() == null ? "0" : staffServeStatisticVO.getCashSjAccount();
            String newAccount = orderInfo.getCashTf().add(new BigDecimal(old)).toString();
            staffServeStatisticVO.setCashSjAccount(newAccount);
        }

        //商品业绩个数、总价格
        if (orderInfo.getCashSpAssistant().equals(staffInfo.getId())) {
            staffServeStatisticVO.setCashSpNum(1 + (staffServeStatisticVO.getCashSpNum() == null ? 0 : staffServeStatisticVO.getCashSpNum()));
            String old = staffServeStatisticVO.getCashSpAccount() == null ? "0" : staffServeStatisticVO.getCashSpAccount();
            String newAccount = orderInfo.getCashTf().add(new BigDecimal(old)).toString();
            staffServeStatisticVO.setCashSpAccount(newAccount);
        }
    }
}
