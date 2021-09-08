package com.zty.ztyshop.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zty.ztyshop.controller.param.BasePageParam;
import com.zty.ztyshop.controller.param.StaffInfoParam;
import com.zty.ztyshop.controller.vo.StaffInfoVO;
import com.zty.ztyshop.dao.entity.StaffInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;


/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 李佳 zion
 * @since 2021-03-26
 */
public interface SysStaffInfoService extends IService<StaffInfo> {

    /**
     * @param param
     * @return
     */
    Boolean add(StaffInfoParam param);

    /**
     * @param param
     * @return
     */
    Boolean delete(StaffInfoParam param);

    /**
     * 更改
     *
     * @param param
     * @return
     */
    Boolean update(StaffInfoParam param);

    /**
     * 分页查询
     *
     * @param param
     * @return
     */
    Page<StaffInfo> page(BasePageParam param);

    /**
     * @return
     */
    List<StaffInfo> getAll();

    List<StaffInfo> activeList();
}
