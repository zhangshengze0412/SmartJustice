package com.smart_justice.smart_justice.service;

import com.smart_justice.smart_justice.model.User;

/**
 * 总用户服务
 *
 * @author tudou
 * @version 1.0
 * @date 2020/7/11 21:17
 **/



public interface UserService {


    /**
     * 注册服务
     * @param user 总用户
     * @return boolean
     */
    public boolean registerUser(User user);

    /**
     * 修改总用户信息
     * @param user 总用户
     * @return boolean
     */
    public boolean updateUserInfo(User user);


    /**
     * 登陆服务
     * @param username 用户名
     * @param password 密码
     * @return boolean
     */
    public boolean loginUser(String username,String password);


    /**
     * 获取用户信息
     * @param id 用户id
     * @return User
     */
    public User getUserInfo(Integer id);

    /**
     * 获取用户信息
     * @param username 用户名
     * @return User
     */
    public User getUserInfo(String username);

    /**
     * 用户名是否存在
     * @param username 总用户名
     * @return boolean
     */
    public boolean isUsernameExist(String username);

    /**
     * 用户邮箱是否存在
     * @param email 用户邮箱
     * @return boolean
     */
    public boolean isUserEmailExist(String email);
}
