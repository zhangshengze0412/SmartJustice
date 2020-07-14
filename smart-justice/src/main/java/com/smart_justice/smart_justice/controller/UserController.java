package com.smart_justice.smart_justice.controller;

import com.smart_justice.smart_justice.model.Lawyer;
import com.smart_justice.smart_justice.model.User;
import com.smart_justice.smart_justice.service.LawyerService;
import com.smart_justice.smart_justice.service.UserService;
import com.smart_justice.smart_justice.util.JsonResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * 总用户Controller类
 *
 * @author tudou
 * @date 2020/7/11 23:48
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private LawyerService lawyerService;

    /**
     * 注册
     */
    @RequestMapping("/register")
    public JsonResult register(@RequestParam(value = "username")String username,
                               @RequestParam(value = "password") String password,
                               @RequestParam(value = "real_name") String realName,
                               @RequestParam(value = "email") String email, HttpServletResponse response, HttpSession session){
        if(StringUtils.isBlank(username)||StringUtils.isBlank(password)){
            return JsonResult.errorMsg("用户名或密码不能为空");
        }
        //查询用户名是否存在
        boolean isExist = userService.isUsernameExist(username);
        if(isExist){
            return JsonResult.errorMsg("用户名已经存在");
        }

        User user=new User(username,password,realName,email,new Date());
        boolean is=userService.registerUser(user);
        if(!is){
            return JsonResult.errorMsg("注册失败");
        }

        return JsonResult.ok();
    }

    /**
     * 登陆
     */
    @RequestMapping("/login")
    public JsonResult login(@RequestParam(value = "username") String username,
                            @RequestParam(value = "password")String password,
                            HttpServletResponse response,HttpSession session){
        if(StringUtils.isBlank(username)||StringUtils.isBlank(password)){
            return JsonResult.errorMsg("用户名或密码不能为空");
        }
        boolean is = userService.loginUser(username,password);
        if(!is){
            return JsonResult.errorMsg("用户名或密码不正确");
        }
        User user=userService.getUserInfo(username);
        if(user!=null){
            if(user.getIsValid()==0){
                return JsonResult.errorMsg("该用户未激活邮箱");
            }
            Lawyer lawyer=lawyerService.getLawyerInfoByUserId(user.getId());
            if(lawyer!=null){
                session.setAttribute("user_id",user.getId());
                session.setAttribute("username",user.getUsername());
                session.setAttribute("team_id",lawyer.getTeamId());
            }
        }

        return JsonResult.ok();
    }

}
