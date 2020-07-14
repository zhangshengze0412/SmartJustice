package com.smart_justice.smart_justice.service.impl;

import com.smart_justice.smart_justice.mapper.LawyerMapper;
import com.smart_justice.smart_justice.mapper.LawyerTeamMapper;
import com.smart_justice.smart_justice.mapper.UserMapper;
import com.smart_justice.smart_justice.model.Lawyer;
import com.smart_justice.smart_justice.model.LawyerTeam;
import com.smart_justice.smart_justice.model.User;
import com.smart_justice.smart_justice.service.LawyerService;
import com.smart_justice.smart_justice.service.LawyerTeamService;
import org.apache.logging.log4j.util.Strings;
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

    @Autowired
    private LawyerTeamMapper lawyerTeamMapper;


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
    public boolean updateLawyerInfo(User user, String workId,Integer teamId) {
        LawyerTeam lawyerTeam=lawyerTeamMapper.getLawyerTeam(teamId);
        if(lawyerTeam==null){
            return false;
        }
        Lawyer lawyer=lawyerMapper.getLawyerByUserId(user.getId());
        if(!lawyer.getTeamId().equals(teamId)){
            return false;
        }
        User reUser = userMapper.getUserById(user.getId());
        if(user.getPhone()!=null){
            reUser.setPhone(user.getPhone());
        }
        if(user.getRealName()!=null){
            reUser.setRealName(user.getRealName());
        }
        if(user.getEmail()!=null){
            reUser.setEmail(user.getEmail());
            reUser.setIsValid(0);
        }
        boolean is=userMapper.updateUser(reUser);
        if(!is){
            new Exception();
            return false;
        }
        if(workId!=null){
            boolean reIs=lawyerMapper.updateLawyer(reUser.getId(),workId);
            if(!reIs){
                new Exception();
                return false;
            }
        }


        return true;
    }

}
