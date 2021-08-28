package com.zty.ztyshop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zty.ztyshop.dao.entity.ClientRank;
import com.zty.ztyshop.dao.mapper.ClientRankMapper;
import com.zty.ztyshop.service.SysClientRankService;
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
public class SysClientRankServiceImpl extends ServiceImpl<ClientRankMapper, ClientRank> implements SysClientRankService {

    @Autowired
    private ClientRankMapper clientRankMapper;


    @Override
    public List<ClientRank> getAll() {
        LambdaQueryWrapper<ClientRank> queryWrapper = new LambdaQueryWrapper<>();

        List<ClientRank> result = clientRankMapper.selectList(queryWrapper);

        return result;
    }
}
