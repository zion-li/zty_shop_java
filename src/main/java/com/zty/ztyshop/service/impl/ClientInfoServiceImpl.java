package com.zty.ztyshop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zty.ztyshop.common.CommonServiceException;
import com.zty.ztyshop.common.ErrorCodeEnum;
import com.zty.ztyshop.controller.bo.StatisticsLast30DaysBO;
import com.zty.ztyshop.controller.param.BasePageParam;
import com.zty.ztyshop.controller.param.ClientInfoParam;
import com.zty.ztyshop.dao.entity.ClientInfo;
import com.zty.ztyshop.dao.entity.ClientLevel;
import com.zty.ztyshop.dao.entity.StaffLevel;
import com.zty.ztyshop.dao.mapper.ClientInfoMapper;
import com.zty.ztyshop.service.IClientInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zty.ztyshop.utils.DateUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

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

        if (null != param.getIsVip() && 1 == param.getIsVip().intValue()) {
            if (StringUtils.isBlank(param.getModile())) {
                throw new CommonServiceException(ErrorCodeEnum.VIP_NEED_MOBILE);
            }
        }

        //查询名字是否重复
        LambdaQueryWrapper<ClientInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ClientInfo::getName, param.getName());
        if (StringUtils.isNotBlank(param.getModile())) {
            queryWrapper.eq(ClientInfo::getModile, param.getModile());
        }

        //不允许添加为已经存在的名字
        if (clientInfoMapper.selectCount(queryWrapper) > 0) {
            throw new CommonServiceException(ErrorCodeEnum.CLIENT_NAME_EXIST);
        }


        ClientInfo clientInfo = new ClientInfo();
        //会员
        clientInfo.setName(param.getName());
        clientInfo.setGender(param.getGender());
        clientInfo.setModile(param.getModile());
        clientInfo.setIsVip((null == param.getIsVip()) ? 0 : 1);
        clientInfo.setClientLevel(param.getClientLevel());
        //消费金额
        String sum = StringUtils.isBlank(param.getAccount()) ? "0" : param.getAccount();
        clientInfo.setAccount(new BigDecimal(sum));
        clientInfo.setBirthday(getLocalDate(param.getBirthday()));
        clientInfo.setLastLogin(LocalDateTime.now());
        clientInfo.setCreateAt(LocalDateTime.now());

        //会员，需要用户姓名+手机号，别的无所谓
        return clientInfoMapper.insert(clientInfo) == 1;
    }

    @Override
    public Boolean delete(ClientInfoParam param) {
        return clientInfoMapper.deleteById(param.getId()) == 1;
    }

    @Override
    public Boolean update(ClientInfoParam param) {
        //判断用户+手机号是否存在
        if (StringUtils.isBlank(param.getName())) {
            throw new CommonServiceException(ErrorCodeEnum.CLIENT_NAME_ERROR);
        }

        //查询名字是否重复
        LambdaQueryWrapper<ClientInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.ne(ClientInfo::getId, param.getId());
        queryWrapper.eq(ClientInfo::getName, param.getName());
        if (StringUtils.isNotBlank(param.getModile())) {
            queryWrapper.eq(ClientInfo::getModile, param.getModile());
        }

        //不允许添加为已经存在的名字
        if (clientInfoMapper.selectCount(queryWrapper) > 0) {
            throw new CommonServiceException(ErrorCodeEnum.CLIENT_NAME_EXIST);
        }


        LambdaUpdateWrapper<ClientInfo> updateWrapper = new LambdaUpdateWrapper<>();

        updateWrapper.eq(ClientInfo::getId, param.getId());

        if (StringUtils.isNotBlank(param.getName())) {
            updateWrapper.set(ClientInfo::getName, param.getName());
        }

        if (null != param.getGender()) {
            updateWrapper.set(ClientInfo::getGender, param.getGender());
        }

        if (StringUtils.isNotBlank(param.getModile())) {
            updateWrapper.set(ClientInfo::getModile, param.getModile());
        }
        if (null != param.getIsVip()) {
            updateWrapper.set(ClientInfo::getIsVip, param.getIsVip());
        }

        if (null != param.getClientLevel()) {
            updateWrapper.set(ClientInfo::getClientLevel, param.getClientLevel());
        }

        if (StringUtils.isNotBlank(param.getAccount())) {
            updateWrapper.set(ClientInfo::getModile, param.getAccount());
        }

        if (StringUtils.isNotBlank(param.getBirthday())) {
            updateWrapper.set(ClientInfo::getBirthday, getLocalDate(param.getBirthday()));
        }
        //会员，需要用户姓名+手机号，别的无所谓
        return clientInfoMapper.update(null, updateWrapper) == 1;
    }

    @Override
    public Page<ClientInfo> page(BasePageParam param) {
        Page<ClientInfo> page = new Page<>(param.getPageNo(), param.getPageSize());
        Page<ClientInfo> userPage = clientInfoMapper.selectPage(page, null);
        return userPage;
    }

    @Override
    public Map<String, Integer> statisticsNewLast30Days(Integer type) {
        //默认，统计最近一个月，新用户增长
        Map<String, Integer> res = DateUtils.getLast30Days();

        LocalDate minDate = LocalDate.now().minusDays(29);

        List<StatisticsLast30DaysBO> last30DaysBOS = clientInfoMapper.statisticsNewLast30Days(minDate);

        for (StatisticsLast30DaysBO e : last30DaysBOS) {
            if (res.containsKey(e.getDay())) {
                res.put(e.getDay(), e.getAccount());
            }
        }

        return res;
    }

    @Override
    public Map<String, Integer> statisticsOldLast30Days(Integer type) {
        //默认，统计最近一个月，新用户增长
        Map<String, Integer> res = DateUtils.getLast30Days();

        LocalDate maxDate = LocalDate.now().minusDays(29);

        List<StatisticsLast30DaysBO> last30DaysBOS = clientInfoMapper.statisticsOldLast30Days(maxDate);

        for (StatisticsLast30DaysBO e : last30DaysBOS) {
            if (res.containsKey(e.getDay())) {
                res.put(e.getDay(), e.getAccount());
            }
        }

        return res;
    }

    @Override
    public Map<String, Integer> statisticsAll(Integer type) {
        //默认，统计最近一个月，新用户增长
        Map<String, Integer> res = DateUtils.getLastYear();

        LocalDate minDate = LocalDate.now().minusDays(365);

        List<StatisticsLast30DaysBO> last30DaysBOS = clientInfoMapper.statisticsAll(minDate);

        for (StatisticsLast30DaysBO e : last30DaysBOS) {
            if (res.containsKey(e.getDay())) {
                res.put(e.getDay(), e.getAccount());
            }
        }

        return res;
    }

    private LocalDate getLocalDate(String dataStr) {
        if (StringUtils.isBlank(dataStr)) {
            return null;
        }
        return LocalDate.parse(dataStr, DateTimeFormatter.ofPattern("yyyy/MM/dd"));
    }
}
