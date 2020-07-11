package com.smart_justice.smart_justice.service;

import com.smart_justice.smart_justice.model.NormalUser;

/**
 * 普通用户服务
 *
 * @author tudou
 * @version 1.0
 * @date 2020/7/11 21:29
 **/



public interface NormalUserService {

    /**
     * 增加普通用户信息
     * @param normalUser 普通用户
     * @return boolean
     */
    public boolean addNormalUser(NormalUser normalUser);


    /**
     * 获取普通用户信息
     * @param id 普通用户id
     * @return NormalUser
     */
    public NormalUser addNormalUser(Integer id);

    /**
     * 修改普通用户信息
     * @param normalUser 普通用户信息
     * @return boolean
     */
    public boolean updateNormalUser(NormalUser normalUser);

}
