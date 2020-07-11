package com.smart_justice.smart_justice.controller;

import com.smart_justice.smart_justice.model.User;
import com.smart_justice.smart_justice.service.UserService;
import com.smart_justice.smart_justice.util.JsonResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/register")
    public JsonResult register(@RequestParam(value = "username",required = false)String username, @RequestParam(value = "password",required = false) String password, @RequestParam(value = "real_name",required = false) String realName, @RequestParam(value = "email",required = false) String email, HttpServletResponse response, HttpSession session){
        if(StringUtils.isBlank(username)||StringUtils.isBlank(password)){
            return JsonResult.errorMsg("用户名或密码不能为空");
        }
        //查询用户名是否存在
        boolean isExist = userService.isUsernameExist(username);
        if(isExist){
            return JsonResult.errorMsg("用户名已经存在");
        }

        User user=new User(username,password,realName,new Date());
        boolean is=userService.registerUser(user);
        if(is){
            return JsonResult.errorMsg("注册失败");
        }

        return JsonResult.ok();
    }

}
