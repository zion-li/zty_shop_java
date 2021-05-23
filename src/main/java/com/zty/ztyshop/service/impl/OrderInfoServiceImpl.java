package com.zty.ztyshop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.Lists;
import com.zty.ztyshop.common.CommonServiceException;
import com.zty.ztyshop.common.ErrorCodeEnum;
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
import com.zty.ztyshop.service.IOrderInfoService;
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
import java.util.stream.Collectors;

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
    @Transactional(rollbackFor = Exception.class)
    public Boolean add(OrderInfoParam param) {
        //参数校验
        ClientInfo clientInfo = clientInfoMapper.selectById(param.getClientId());
        if (clientInfo == null) {
            //当前用户不存在
            throw new CommonServiceException(ErrorCodeEnum.USER_ID_NOT_EXIST_ERROR);
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
                wrapper(staffServeStatisticVO,orderInfo,staffInfo);
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
                wrapper(staffServeStatisticVO,orderInfo,staffInfo);
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
                wrapper(staffServeStatisticVO,orderInfo,staffInfo);
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
                wrapper(staffServeStatisticVO,orderInfo,staffInfo);
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
                wrapper(staffServeStatisticVO,orderInfo,staffInfo);
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
