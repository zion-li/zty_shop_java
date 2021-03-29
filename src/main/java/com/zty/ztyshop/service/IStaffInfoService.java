package com.zty.ztyshop.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zty.ztyshop.controller.param.BasePageParam;
import com.zty.ztyshop.controller.param.StaffInfoParam;
import com.zty.ztyshop.dao.entity.StaffInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zty.ztyshop.dao.entity.StaffLevel;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 李佳 zion
 * @since 2021-03-26
 */
public interface IStaffInfoService extends IService<StaffInfo> {


    Boolean add(StaffInfoParam param);

    Boolean delete(StaffInfoParam param);

    Boolean updateStaffInfo(StaffInfoParam param);

    /**
     * 分页查询
     *
     * @param param
     * @return
     */
    Page<StaffInfo> page(BasePageParam param);
}
