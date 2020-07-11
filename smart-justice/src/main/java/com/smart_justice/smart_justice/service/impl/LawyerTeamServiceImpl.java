package com.smart_justice.smart_justice.service.impl;


import com.smart_justice.smart_justice.mapper.LawyerTeamMapper;
import com.smart_justice.smart_justice.model.LawyerTeam;
import com.smart_justice.smart_justice.service.LawyerTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public LawyerTeam getLawyerTeamInfo(Integer id) {
        return lawyerTeamMapper.getLawyerTeam(id);
    }

    @Override
    public boolean updateLawyerTeamInfo(LawyerTeam lawyerTeam) {
        return lawyerTeamMapper.updateLawyerTeam(lawyerTeam);
    }

    @Override
    public boolean addLawyerTeam(LawyerTeam lawyerTeam) {
        return lawyerTeamMapper.addLawyerTeam(lawyerTeam);
    }

    @Override
    public boolean updateLawyerTeamNum(Integer id, Integer num) {
        return updateLawyerTeamNum(id,num);
    }
}
