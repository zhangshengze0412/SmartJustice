package com.smart_justice.smart_justice.service;

import com.smart_justice.smart_justice.model.Lawyer;

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
    public Lawyer getLawyerInfo(Integer id);

    /**
     * 修改律师个人信息
     * @param lawyer 律师用户信息
     * @return boolean
     */
    public boolean updateLawyerInfo(Lawyer lawyer);

}
