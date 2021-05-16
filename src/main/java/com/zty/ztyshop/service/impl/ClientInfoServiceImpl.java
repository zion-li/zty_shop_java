package com.zty.ztyshop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zty.ztyshop.common.CommonServiceException;
import com.zty.ztyshop.common.ErrorCodeEnum;
import com.zty.ztyshop.controller.param.BasePageParam;
import com.zty.ztyshop.controller.param.ClientInfoParam;
import com.zty.ztyshop.dao.entity.ClientInfo;
import com.zty.ztyshop.dao.mapper.ClientInfoMapper;
import com.zty.ztyshop.service.IClientInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * <p>
 * 客户表 服务实现类
 * </p>
 *
 * @author 李佳 zion
 * @since 2021-03-27
 */
@Service
public class ClientInfoServiceImpl extends ServiceImpl<ClientInfoMapper, ClientInfo> implements IClientInfoService {

    @Autowired
    private ClientInfoMapper clientInfoMapper;

    @Override
    public Boolean add(ClientInfoParam param) {
        //判断用户+手机号是否存在
        if (StringUtils.isBlank(param.getName())) {
            throw new CommonServiceException(ErrorCodeEnum.CLIENT_NAME_ERROR);
        }

        if (StringUtils.isBlank(param.getModile())) {
            throw new CommonServiceException(ErrorCodeEnum.VIP_NEED_MOBILE);
        }

        //查询名字是否重复(用户名+手机号)
        LambdaQueryWrapper<ClientInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ClientInfo::getName, param.getName());
        queryWrapper.eq(ClientInfo::getModile, param.getModile());
        //不允许添加为已经存在的名字
        if (clientInfoMapper.selectCount(queryWrapper) > 0) {
            throw new CommonServiceException(ErrorCodeEnum.CLIENT_NAME_EXIST);
        }

        ClientInfo clientInfo = new ClientInfo();
        //会员名称
        clientInfo.setName(param.getName());
        clientInfo.setModile(param.getModile());
        clientInfo.setRankName(param.getRankName());
        clientInfo.setGender(param.getGender());
        clientInfo.setBirthday(getLocalDate(param.getBirthday()));
        //消费金额
        String sum = StringUtils.isBlank(param.getAccount()) ? "0" : param.getAccount();
        clientInfo.setAccount(new BigDecimal(sum));
        clientInfo.setServiceTime(0);
        clientInfo.setLastLogin(LocalDateTime.now());
        //会员，需要用户姓名+手机号，别的无所谓
        return clientInfoMapper.insert(clientInfo) == 1;
    }

    @Override
    public Boolean delete(ClientInfoParam param) {
        return clientInfoMapper.deleteById(param.getId()) == 1;
    }

    @Override
    public Boolean update(ClientInfoParam param) {

        if (param.getId() == null) {
            return false;
        }

        ClientInfo clientInfo = clientInfoMapper.selectById(param.getId());

        if (clientInfo == null) {
            return false;
        }

        //判断用户+手机号是否存在
        if (StringUtils.isNotBlank(param.getName()) || StringUtils.isNotBlank(param.getModile())) {
            //查询名字是否重复(用户名+手机号)
            LambdaQueryWrapper<ClientInfo> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.ne(ClientInfo::getId, param.getId());

            if (StringUtils.isNotBlank(param.getName())) {
                queryWrapper.eq(ClientInfo::getName, param.getName());
            } else {
                queryWrapper.eq(ClientInfo::getName, clientInfo.getName());
            }
            if (StringUtils.isNotBlank(param.getModile())) {
                queryWrapper.eq(ClientInfo::getModile, param.getModile());
            } else {
                queryWrapper.eq(ClientInfo::getModile, clientInfo.getModile());
            }
            //不允许添加为已经存在的名字
            if (clientInfoMapper.selectCount(queryWrapper) > 0) {
                throw new CommonServiceException(ErrorCodeEnum.CLIENT_NAME_EXIST);
            }
        }

        if (StringUtils.isNotBlank(param.getName())) {
            clientInfo.setName(param.getName());
        }

        if (StringUtils.isNotBlank(param.getModile())) {
            clientInfo.setModile(param.getModile());
        }

        if (StringUtils.isNotBlank(param.getRankName())) {
            clientInfo.setRankName(param.getRankName());
        }

        if (param.getGender() != null || (param.getGender() == 0 && param.getGender() == 1)) {
            clientInfo.setGender(param.getGender());
        }

        if (StringUtils.isNotBlank(param.getBirthday())) {
            clientInfo.setBirthday(getLocalDate(param.getBirthday()));
        }

        if (StringUtils.isNotBlank(param.getAccount())) {
            String sum = StringUtils.isBlank(param.getAccount()) ? "0" : param.getAccount();
            clientInfo.setAccount(new BigDecimal(sum));
        }

        if (param.getServiceTime() != null) {
            clientInfo.setServiceTime(param.getServiceTime());
        }
        clientInfo.setLastLogin(LocalDateTime.now());
        //会员，需要用户姓名+手机号，别的无所谓
        return clientInfoMapper.updateById(clientInfo) == 1;
    }

    @Override
    public Page<ClientInfo> page(BasePageParam param) {
        Page<ClientInfo> page = new Page<>(param.getPageNo(), param.getPageSize());
        Page<ClientInfo> userPage = clientInfoMapper.selectPage(page, null);
        return userPage;
    }

    @Override
    public List<ClientInfo> getAll() {
        return clientInfoMapper.selectList(null);
    }

//    @Override
//    public Map<String, Integer> statisticsNewLast30Days(Integer type) {
//        //默认，统计最近一个月，新用户增长
//        Map<String, Integer> res = DateUtils.getLast30Days();
//
//        LocalDate minDate = LocalDate.now().minusDays(29);
//
//        List<StatisticsLast30DaysBO> last30DaysBOS = clientInfoMapper.statisticsNewLast30Days(minDate);
//
//        for (StatisticsLast30DaysBO e : last30DaysBOS) {
//            if (res.containsKey(e.getDay())) {
//                res.put(e.getDay(), e.getAccount());
//            }
//        }
//
//        return res;
//    }
//
//    @Override
//    public Map<String, Integer> statisticsOldLast30Days(Integer type) {
//        //默认，统计最近一个月，新用户增长
//        Map<String, Integer> res = DateUtils.getLast30Days();
//
//        LocalDate maxDate = LocalDate.now().minusDays(29);
//
//        List<StatisticsLast30DaysBO> last30DaysBOS = clientInfoMapper.statisticsOldLast30Days(maxDate);
//
//        for (StatisticsLast30DaysBO e : last30DaysBOS) {
//            if (res.containsKey(e.getDay())) {
//                res.put(e.getDay(), e.getAccount());
//            }
//        }
//
//        return res;
//    }
//
//    @Override
//    public Map<String, Integer> statisticsAll(Integer type) {
//        //默认，统计最近一个月，新用户增长
//        Map<String, Integer> res = DateUtils.getLastYear();
//
//        LocalDate minDate = LocalDate.now().minusDays(365);
//
//        List<StatisticsLast30DaysBO> last30DaysBOS = clientInfoMapper.statisticsAll(minDate);
//
//        for (StatisticsLast30DaysBO e : last30DaysBOS) {
//            if (res.containsKey(e.getDay())) {
//                res.put(e.getDay(), e.getAccount());
//            }
//        }
//
//        return res;
//    }

    private LocalDate getLocalDate(String dataStr) {
        if (StringUtils.isBlank(dataStr)) {
            return null;
        }
        return LocalDate.parse(dataStr, DateTimeFormatter.ofPattern("yyyy/MM/dd"));
    }
}
