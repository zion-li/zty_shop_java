package com.zty.ztyshop.dao.mapper;

import com.zty.ztyshop.controller.bo.StatisticsLast30DaysBO;
import com.zty.ztyshop.dao.entity.ClientInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 * 客户表 Mapper 接口
 * </p>
 *
 * @author 李佳 zion
 * @since 2021-05-16
 */
public interface ClientInfoMapper extends BaseMapper<ClientInfo> {

    List<StatisticsLast30DaysBO> statisticsNewLast(@Param("minDate") LocalDate minDate);

    List<StatisticsLast30DaysBO> statisticsNewLastYear(@Param("minDate") LocalDate minDate);
}
