package com.smart_justice.smart_justice.service;

import com.smart_justice.smart_justice.model.Lawyer;
import com.smart_justice.smart_justice.model.User;

/**
 * 律师用户服务
 *
 * @author tudou
 * @version 1.0
 * @date 2020/7/11 21:22
 **/



public interface LawyerService {


    /**
     * 获取律师个人信息
     * @param id 律师id
     * @return Lawyer
     */
    public Lawyer getLawyerInfoById(Integer id);

    /**
     * 获取律师个人信息
     * @param userId 律师用户id
     * @return Lawyer
     */
    public Lawyer getLawyerInfoByUserId(Integer userId);

    /**
     * 修改律师个人信息
     * @param  user 用户信息
     * @param  workId 工号
     * @return boolean
     */
    public boolean updateLawyerInfo(User user,String workId);

}
