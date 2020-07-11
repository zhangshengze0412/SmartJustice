package com.smart_justice.smart_justice.service.impl;

import com.smart_justice.smart_justice.mapper.UserMapper;
import com.smart_justice.smart_justice.model.User;
import com.smart_justice.smart_justice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 总用户服务实现类
 *
 * @author tudou
 * @version 1.0
 * @date 2020/7/11 21:38
 **/


public class UserServiceImpl implements UserService {


    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean registerUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public boolean updateUserInfo(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public boolean loginUser(String username, String password) {
        User user=userMapper.getUserByUsername(username);
        if (user==null){
            return false;
        }
        return user.getPassword().equals(password);
    }

    @Override
    public User getUserInfo(Integer id) {
       return userMapper.getUserById(id);
    }
}
