package com.zty.ztyshop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zty.ztyshop.dao.entity.ClientInfo;

import java.util.Map;

/**
 * @author 李佳 lijia@autoai.com
 * @version 1.0
 * @date 2021/8/28 11:15
 */
public interface StaticClientInfoService extends IService<ClientInfo> {
    /**
     * 统计7天新增用户
     *
     * @return
     */
    Object statisticsLast7Days();

    /**
     * 统计30天新增用户
     *
     * @return
     */
    Map<String, Integer> statisticsLast30Days();

    /**
     * 统计90天新增用户
     *
     * @return
     */
    Map<String, Integer> statisticsLast90Days();
    /**
     * 统计365天新增用户
     *
     * @return
     */
    Map<String, Integer> statisticsLast365Days();

    Map<String, Integer> statisticsReturn7Days();

    Map<String, Integer> statisticsReturn30Days();

    Map<String, Integer> statisticsReturn90Days();

    Map<String, Integer> statisticsReturn365Days();
}
