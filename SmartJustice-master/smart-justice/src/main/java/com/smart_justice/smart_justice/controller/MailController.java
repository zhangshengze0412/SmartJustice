package com.smart_justice.smart_justice.controller;

import com.smart_justice.smart_justice.model.NormalUser;
import com.smart_justice.smart_justice.model.User;
import com.smart_justice.smart_justice.service.MailService;
import com.smart_justice.smart_justice.service.UserService;
import com.smart_justice.smart_justice.util.JsonResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 邮箱验证Controller
 *
 * @author tudou
 * @version 1.0
 * @date 2020/7/14 10:49
 **/

@RestController
public class MailController {

    @Autowired
    private MailService mailService;

    @Autowired
    private UserService userService;


    @Autowired
    private TemplateEngine templateEngine;


    @Value("${spring.mail.username}")
    private String from;

    public static final String DOMAIN = "http://localhost:8080";

    /**
     * 用户发送验证邮箱邮件
     */
    @RequestMapping("/user/email")
    public JsonResult sendAuthUserEmail(String username,String email){
        String url = DOMAIN+"/user/auth?username="+username+"&email="+email;
        try{
            Context context=new Context();
            context.setVariable("url",url);
            String emailContent = templateEngine.process("MailTemplate",context);

            mailService.sendHtmlMail(from,email,"智邮法助验证邮箱",emailContent);
        }catch(Exception ex){
            ex.printStackTrace();
            return JsonResult.errorMsg("邮件发送失败");
        }
        return JsonResult.ok();
    }

    /**
     * 用户邮箱验证
     */
    @RequestMapping("/user/auth")
    public JsonResult authUserEmail(String username,String email){
        boolean is=mailService.authUserEmail(email,username);
        if(!is){
            return JsonResult.errorMsg("验证失败");
        }
        return JsonResult.ok();
    }


    /**
     * 企业发送验证邮箱邮件
     */
    @RequestMapping("/lawyer/email")
    public JsonResult sendAuthLawyerTeamEmail(String username,String email,HttpServletResponse response,HttpSession session){
        Integer teamId=(Integer)session.getAttribute("team_id");
        if(teamId == 0){
            return JsonResult.errorMsg("请先创建组织");
        }
        String url = DOMAIN+"/lawyer/auth?username="+username+"&email="+email+"&team_id="+teamId;

        try{
            Context context=new Context();
            context.setVariable("url",url);
            String emailContent = templateEngine.process("/MailTemplate",context);

            mailService.sendHtmlMail(from,email,"智邮法助验证邮箱",emailContent);
        }catch(Exception ex){
            ex.printStackTrace();
            return JsonResult.errorMsg("邮件发送失败");
        }
        return JsonResult.ok();
    }

    /**
     * 企业邮箱验证
     */
    @RequestMapping("/lawyer/auth")
    public JsonResult authLawyerTeamEmail(String username,String email,HttpServletResponse response,HttpSession session){
        Integer teamId=(Integer)session.getAttribute("team_id");
        if(teamId==null){
            return JsonResult.errorMsg("请用户创建组织后使用");
        }
        boolean is=mailService.authLawyerTeamEmail(email,username,teamId);
        if(!is){
            return JsonResult.errorMsg("验证失败");
        }
        return JsonResult.ok();
    }


}
