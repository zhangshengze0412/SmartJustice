package com.smart_justice.smart_justice.service.impl;

import com.smart_justice.smart_justice.mapper.LawyerMapper;
import com.smart_justice.smart_justice.mapper.UserMapper;
import com.smart_justice.smart_justice.model.Lawyer;
import com.smart_justice.smart_justice.model.LawyerTeam;
import com.smart_justice.smart_justice.model.User;
import com.smart_justice.smart_justice.service.LawyerService;
import com.smart_justice.smart_justice.service.LawyerTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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

    @Autowired
    private UserMapper userMapper;


    @Override
    public Lawyer getLawyerInfoById(Integer id) {
        return lawyerMapper.getLawyerById(id);
    }

    @Override
    public Lawyer getLawyerInfoByUserId(Integer userId) {
        return lawyerMapper.getLawyerByUserId(userId);
    }


    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    @Override
    public boolean updateLawyerInfo(User user, String workId) {
        User reUser = userMapper.getUserById(user.getId());
        if(!"".equals(user.getPhone())){
            reUser.setPhone(user.getPhone());
        }
        if(!"".equals(user.getRealName())){
            reUser.setRealName(user.getRealName());
        }
        if(!"".equals(user.getEmail())){
            reUser.setEmail(user.getEmail());
            reUser.setIsValid(0);
        }
        Lawyer lawyer=lawyerMapper.getLawyerByUserId(user.getId());
        if(!"".equals(workId)){
            lawyer.setWorkId(workId);
        }
        try {
            userMapper.updateUser(reUser);
            lawyerMapper.updateLawyer(reUser.getId(),workId);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
