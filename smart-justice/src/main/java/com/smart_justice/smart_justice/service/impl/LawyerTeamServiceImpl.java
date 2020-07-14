package com.smart_justice.smart_justice.service.impl;


import com.smart_justice.smart_justice.mapper.LawyerMapper;
import com.smart_justice.smart_justice.mapper.LawyerTeamMapper;
import com.smart_justice.smart_justice.mapper.UserMapper;
import com.smart_justice.smart_justice.model.Lawyer;
import com.smart_justice.smart_justice.model.LawyerTeam;
import com.smart_justice.smart_justice.model.User;
import com.smart_justice.smart_justice.service.LawyerTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 律师团队服务实现类
 *
 * @author tudou
 * @version 1.0
 * @date 2020/7/11 21:38
 **/


@Service
public class LawyerTeamServiceImpl implements LawyerTeamService {

    @Autowired
    private LawyerTeamMapper lawyerTeamMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private LawyerMapper lawyerMapper;

    @Override
    public LawyerTeam getLawyerTeamInfo(Integer id) {
        return lawyerTeamMapper.getLawyerTeam(id);
    }

    @Override
    public boolean updateLawyerTeamInfo(LawyerTeam lawyerTeam) {
        return lawyerTeamMapper.updateLawyerTeam(lawyerTeam);
    }

    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    @Override
    public Integer addLawyerTeam(LawyerTeam lawyerTeam, Integer userId)  {
        User user=userMapper.getUserById(userId);
        if(user==null){
            return 0;
        }
        LawyerTeam lawyerTeam1=lawyerTeamMapper.getLawyerTeamByName(lawyerTeam.getName());
        if(null != lawyerTeam1){
            return 0;
        }
        Lawyer reLawyer=lawyerMapper.getLawyerByUserId(userId);
        if(reLawyer!=null){
            return 0;
        }
        lawyerTeam.setUserId(userId);
        boolean is=lawyerTeamMapper.addLawyerTeam(lawyerTeam);

        Lawyer lawyer=new Lawyer();
        lawyer.setUserId(userId);
        lawyer.setTeamId(lawyerTeam.getId());
        lawyer.setIsValid(1);
        boolean reIs=lawyerMapper.addLawyer(lawyer);
        if(!is||!reIs){
            new Exception();
            return 0;
        }

        return lawyerTeam.getId();
    }


    @Override
    public boolean updateLawyerTeamNum(Integer id, Integer num) {
        return updateLawyerTeamNum(id,num);
    }
}
