package com.smart_justice.smart_justice.service.impl;

import com.smart_justice.smart_justice.model.User;
import com.smart_justice.smart_justice.service.UserService;

/**
 * 总用户服务实现类
 *
 * @author tudou
 * @version 1.0
 * @date 2020/7/11 21:38
 **/


public class UserServiceImpl implements UserService {
    @Override
    public boolean registerUser(User user) {
        return false;
    }

    @Override
    public boolean updateUserInfo(User user) {
        return false;
    }

    @Override
    public boolean loginUser(String username, String password) {
        return false;
    }

    @Override
    public User getUserInfo(Integer id) {
        return null;
    }
}
