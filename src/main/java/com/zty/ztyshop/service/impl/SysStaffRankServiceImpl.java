package com.zty.ztyshop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zty.ztyshop.dao.entity.StaffRank;
import com.zty.ztyshop.dao.mapper.StaffRankMapper;
import com.zty.ztyshop.service.SysStaffRankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 李佳 zion
 * @since 2021-05-16
 */
@Service
public class SysStaffRankServiceImpl extends ServiceImpl<StaffRankMapper, StaffRank> implements SysStaffRankService {
    @Autowired
    private StaffRankMapper staffRankMapper;

    @Override
    public List<StaffRank> getAll() {
        LambdaQueryWrapper<StaffRank> queryWrapper = new LambdaQueryWrapper<>();

        List<StaffRank> result = staffRankMapper.selectList(queryWrapper);

        return result;
    }


}
