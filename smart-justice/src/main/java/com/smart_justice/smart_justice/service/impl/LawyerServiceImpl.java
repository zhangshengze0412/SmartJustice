package com.smart_justice.smart_justice.service.impl;

import com.smart_justice.smart_justice.mapper.LawyerMapper;
import com.smart_justice.smart_justice.model.Lawyer;
import com.smart_justice.smart_justice.model.LawyerTeam;
import com.smart_justice.smart_justice.service.LawyerService;
import com.smart_justice.smart_justice.service.LawyerTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 律师用户服务实现类
 *
 * @author tudou
 * @version 1.0
 * @date 2020/7/11 21:37
 **/

@Service
public class LawyerServiceImpl implements LawyerService {


    @Autowired
    private LawyerMapper lawyerMapper;


    @Override
    public Lawyer getLawyerInfoById(Integer id) {
        return lawyerMapper.getLawyerById(id);
    }

    @Override
    public Lawyer getLawyerInfoByUserId(Integer userId) {
        return lawyerMapper.getLawyerByUserId(userId);
    }

    @Override
    public boolean updateLawyerInfo(Lawyer lawyer) {
        return updateLawyerInfo(lawyer);
    }
}
