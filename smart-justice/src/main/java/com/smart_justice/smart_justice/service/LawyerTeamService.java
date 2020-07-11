package com.smart_justice.smart_justice.service;

import com.smart_justice.smart_justice.model.LawyerTeam;

/**
 * 律师团队服务
 *
 * @author tudou
 * @version 1.0
 * @date 2020/7/11 21:24
 **/

public interface LawyerTeamService {

    /**
     * 获取律师团队信息
     * @param id 律师团队id
     * @return LawyerTeam
     */
    public LawyerTeam getLawyerTeamInfo(Integer id);


    /**
     * 修改律师团队信息
     * @param lawyerTeam 律师团队信息
     * @return boolean
     */
    public boolean updateLawyerTeamInfo(LawyerTeam lawyerTeam);


    /**
     * 增加律师团队信息
     * @param lawyerTeam 律师团队信息
     * @return boolean
     */
    public boolean addLawyerTeam(LawyerTeam lawyerTeam);

    /**
     * 增加律师团队人数
     * @param id 律师团队id
     * @param num 增加人数
     * @return boolean
     */
    public boolean updateLawyerTeamNum(Integer id,Integer num);

}
