package com.zty.ztyshop.dao.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.zty.ztyshop.controller.bo.StatisticsLast30DaysBO;
import com.zty.ztyshop.controller.param.ClientInfoParam;
import com.zty.ztyshop.dao.entity.ClientInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 客户表 Mapper 接口
 * </p>
 *
 * @author 李佳 zion
 * @since 2021-03-27
 */
public interface ClientInfoMapper extends BaseMapper<ClientInfo> {
    /**
     * @param minDate
     * @return
     */
    List<StatisticsLast30DaysBO> statisticsNewLast30Days(@Param("minDate") LocalDate minDate);

    /**
     * @param maxDate
     * @return
     */
    List<StatisticsLast30DaysBO> statisticsOldLast30Days(@Param("maxDate") LocalDate maxDate);

    List<StatisticsLast30DaysBO> statisticsAll(@Param("minDate") LocalDate minDate);
}
