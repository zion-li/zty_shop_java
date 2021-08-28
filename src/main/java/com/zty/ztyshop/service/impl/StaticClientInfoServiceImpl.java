package com.zty.ztyshop.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zty.ztyshop.controller.bo.StatisticsLast30DaysBO;
import com.zty.ztyshop.dao.entity.ClientInfo;
import com.zty.ztyshop.dao.mapper.ClientInfoMapper;
import com.zty.ztyshop.service.StaticClientInfoService;
import com.zty.ztyshop.service.SysClientInfoService;
import com.zty.ztyshop.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * @author 李佳 lijia@autoai.com
 * @version 1.0
 * @date 2021/8/28 11:17
 */
@Service
public class StaticClientInfoServiceImpl extends ServiceImpl<ClientInfoMapper, ClientInfo> implements StaticClientInfoService {

    @Autowired
    private ClientInfoMapper clientInfoMapper;

    @Override
    public Map<String, Integer> statisticsLast7Days() {
        //默认，统计最近一个月，新用户增长
        Map<String, Integer> res = DateUtils.getLast7Days();

        LocalDate minDate = LocalDate.now().minusDays(7);

        List<StatisticsLast30DaysBO> last30DaysBOS = clientInfoMapper.statisticsNewLast(minDate);

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

        List<StatisticsLast30DaysBO> last30DaysBOS = clientInfoMapper.statisticsNewLast(minDate);

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

        List<StatisticsLast30DaysBO> last30DaysBOS = clientInfoMapper.statisticsNewLast(minDate);

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

        List<StatisticsLast30DaysBO> last30DaysBOS = clientInfoMapper.statisticsNewLast(minDate);

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
    public Map<String, Integer> statisticsReturn7Days() {
        //默认，统计最近一个月，新用户增长
        Map<String, Integer> res = DateUtils.getLast7Days();

        LocalDate minDate = LocalDate.now().minusDays(7);

        List<StatisticsLast30DaysBO> last30DaysBOS = clientInfoMapper.statisticsReturn(minDate);

        for (StatisticsLast30DaysBO e : last30DaysBOS) {
            if (res.containsKey(e.getDay())) {
                res.put(e.getDay(), e.getAccount());
            }
        }

        return res;
    }

    @Override
    public Map<String, Integer> statisticsReturn30Days() {
        //默认，统计最近一个月，新用户增长
        Map<String, Integer> res = DateUtils.getLast30Days();

        LocalDate minDate = LocalDate.now().minusDays(30);

        List<StatisticsLast30DaysBO> last30DaysBOS = clientInfoMapper.statisticsReturn(minDate);

        for (StatisticsLast30DaysBO e : last30DaysBOS) {
            if (res.containsKey(e.getDay())) {
                res.put(e.getDay(), e.getAccount());
            }
        }

        return res;
    }

    @Override
    public Map<String, Integer> statisticsReturn90Days() {
        //默认，统计最近一个月，新用户增长
        Map<String, Integer> res = DateUtils.getLast90Days();

        LocalDate minDate = LocalDate.now().minusDays(90);

        List<StatisticsLast30DaysBO> last30DaysBOS = clientInfoMapper.statisticsReturn(minDate);

        for (StatisticsLast30DaysBO e : last30DaysBOS) {
            if (res.containsKey(e.getDay())) {
                res.put(e.getDay(), e.getAccount());
            }
        }
        return res;
    }

    @Override
    public Map<String, Integer> statisticsReturn365Days() {
        //默认，统计最近一个月，新用户增长
        Map<String, Integer> res = DateUtils.getLastYear();

        LocalDate minDate = LocalDate.now().minusDays(366);

        List<StatisticsLast30DaysBO> last30DaysBOS = clientInfoMapper.statisticsReturn(minDate);

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
}
