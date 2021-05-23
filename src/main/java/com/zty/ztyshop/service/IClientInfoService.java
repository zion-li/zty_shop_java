package com.zty.ztyshop.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zty.ztyshop.controller.param.BasePageParam;
import com.zty.ztyshop.controller.param.ClientInfoParam;
import com.zty.ztyshop.dao.entity.ClientInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 客户表 服务类
 * </p>
 *
 * @author 李佳 zion
 * @since 2021-03-27
 */
public interface IClientInfoService extends IService<ClientInfo> {

    /**
     * @param param
     * @return
     */
    Boolean add(ClientInfoParam param);

    /**
     * @param param
     * @return
     */
    Boolean delete(ClientInfoParam param);

    /**
     * @param param
     * @return
     */
    Boolean update(ClientInfoParam param);

    /**
     * @param param
     * @return
     */
    Page<ClientInfo> page(BasePageParam param);

    /**
     * @return
     */
    List<ClientInfo> getAll();

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


//    Map<String, Integer> statisticsNewLast30Days(Integer type);
//
//    Map<String, Integer> statisticsOldLast30Days(Integer type);
//
//    Map<String, Integer> statisticsAll(Integer type);
}
