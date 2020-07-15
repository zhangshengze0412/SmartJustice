package com.smart_justice.smart_justice.service.impl;

import com.smart_justice.smart_justice.mapper.NormalUserMapper;
import com.smart_justice.smart_justice.model.NormalUser;
import com.smart_justice.smart_justice.service.NormalUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 普通用户服务实现类
 *
 * @author tudou
 * @version 1.0
 * @date 2020/7/11 21:36
 **/


@Service
public class NormalUserServiceImpl implements NormalUserService {

    @Autowired
    private NormalUserMapper normalUserMapper;

    @Override
    public boolean addNormalUser(NormalUser normalUser) {
        return normalUserMapper.addNormalUser(normalUser);
    }

    @Override
    public NormalUser getNormalUser(Integer id) {
        return normalUserMapper.getNormalUserById(id);
    }

    @Override
    public boolean updateNormalUser(NormalUser normalUser) {
        return normalUserMapper.updateNormalUser(normalUser);
    }
}
