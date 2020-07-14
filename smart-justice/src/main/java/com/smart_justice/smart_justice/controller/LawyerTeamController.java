package com.smart_justice.smart_justice.controller;

import com.smart_justice.smart_justice.model.LawyerTeam;
import com.smart_justice.smart_justice.service.LawyerTeamService;
import com.smart_justice.smart_justice.util.JsonResult;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
@RequestMapping("/lawyer/team")
public class LawyerTeamController {


    @Autowired
    private LawyerTeamService lawyerTeamService;


    /**
     * 获取企业信息
     */
    @RequestMapping("/info")
    public JsonResult lawyerTeamInfo(Integer id,HttpServletResponse response, HttpSession session){
        Integer teamId=(Integer)session.getAttribute("team_id");
        if(teamId==null){
            return JsonResult.errorMsg("请用户重新登陆");
        }
        if(!teamId.equals(id)){
            return JsonResult.errorMsg("用户没有权限");
        }
        LawyerTeam lawyerTeam=lawyerTeamService.getLawyerTeamInfo(teamId);
        if (lawyerTeam==null){
            return JsonResult.errorMsg("获取信息失败");
        }
        return JsonResult.ok(lawyerTeam);
    }

    /**
     * 创建企业组织
     */
    @RequestMapping("/create")
    public JsonResult lawyerTeamCreate(@RequestParam(value = "team_name")String teamName,
                                       @RequestParam(value = "scale")Integer scale,
                                       @RequestParam(value = "phone")String phone,
                                       HttpServletResponse response,HttpSession session){
        Integer userId=(Integer)session.getAttribute("user_id");
        if(userId==null){
            return JsonResult.errorMsg("请用户重新登陆");
        }
        LawyerTeam lawyerTeam=new LawyerTeam();
        if(Strings.isBlank(teamName)||scale==null||Strings.isBlank(phone)){
            return JsonResult.errorMsg("请输入完整信息");
        }else{
            lawyerTeam.setName(teamName);
            lawyerTeam.setNum(1);
            lawyerTeam.setPhone(phone);
            lawyerTeam.setScale(scale);
        }
        Integer is =lawyerTeamService.addLawyerTeam(lawyerTeam,userId);
        if(is==0){
            return JsonResult.errorMsg("创建失败");
        }
        session.setAttribute("team_id",is);

        return JsonResult.ok();
    }

}
