package com.smart_justice.smart_justice.controller;

import com.smart_justice.smart_justice.service.MailService;
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
    private TemplateEngine templateEngine;


    @Value("${spring.mail.username}")
    private String form;

    public static final String DOMAIN = "http://localhost:8080";

    @RequestMapping("/user/email")
    public JsonResult sendAuthUserEmail(String username,String email){
        String url = DOMAIN+"/user/auth?username="+username+"&email="+email;

        try{
            Context context=new Context();
            context.setVariable("url",url);
            String emailContent = templateEngine.process("emailTemp",context);

            mailService.sendHtmlMail(form,email,"智邮法助验证邮箱",emailContent);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return JsonResult.ok();
    }

    @RequestMapping("/user/auth")
    public String authUserEmail(String username,String email){
        boolean is=mailService.authUserEmail(email,username);
        if(!is){
            return "验证失败，请重新再试";
        }
        return "验证成功";
    }

    @RequestMapping("/lawyer/email")
    public JsonResult sendAuthLawyerTeamEmail(String username,String email){
        String url = DOMAIN+"/lawyer/auth?username="+username+"&email="+email;

        try{
            Context context=new Context();
            context.setVariable("url",url);
            String emailContent = templateEngine.process("emailTemp",context);

            mailService.sendHtmlMail(form,email,"智邮法助验证邮箱",emailContent);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return JsonResult.ok();
    }

    @RequestMapping("/lawyer/auth")
    public String authLawyerTeamEmail(String username,String email){
        boolean is=mailService.authLawyerTeamEmail(email,username);
        if(!is){
            return "验证失败，请重新再试";
        }
        return "验证成功";
    }


}
