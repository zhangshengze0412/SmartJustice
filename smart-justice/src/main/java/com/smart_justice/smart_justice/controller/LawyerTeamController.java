package com.smart_justice.smart_justice.controller;

import com.smart_justice.smart_justice.model.LawyerTeam;
import com.smart_justice.smart_justice.service.LawyerTeamService;
import com.smart_justice.smart_justice.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 企业团队Controller类
 *
 * @author tudou
 * @version 1.0
 * @date 2020/7/14 15:20
 **/


@RestController
public class LawyerTeamController {


    @Autowired
    private LawyerTeamService lawyerTeamService;


    /**
     * 获取企业信息
     */
    public JsonResult lawyerTeamInfo(Integer id,HttpServletResponse response, HttpSession session){
        Integer teamId=(Integer)session.getAttribute("team_id");
        if(!teamId.equals(id)){
            return JsonResult.errorMsg("用户没有权限");
        }
        LawyerTeam lawyerTeam=lawyerTeamService.getLawyerTeamInfo(teamId);
        if (lawyerTeam==null){
            return JsonResult.errorMsg("获取信息失败");
        }
        return JsonResult.ok(lawyerTeam);
    }

}
