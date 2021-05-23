package com.zty.ztyshop.dao.mapper;

import com.zty.ztyshop.controller.bo.StatisticsLast30DaysBO;
import com.zty.ztyshop.dao.entity.OrderInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author 李佳 zion
 * @since 2021-05-16
 */
public interface OrderInfoMapper extends BaseMapper<OrderInfo> {

    /**
     * @return
     */
    Long accountAll();

    /**
     * 订单统计
     *
     * @param minDate
     * @return
     */
    List<StatisticsLast30DaysBO> statisticsReturn(@Param("minDate") LocalDate minDate);
}
