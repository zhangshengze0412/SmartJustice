package com.smart_justice.smart_justice.controller;

import com.smart_justice.smart_justice.model.User;
import com.smart_justice.smart_justice.model.bo.UserInfoBO;
import com.smart_justice.smart_justice.service.NormalUserService;
import com.smart_justice.smart_justice.service.UserService;
import com.smart_justice.smart_justice.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 普通用户Controller类
 *
 * @author tudou
 * @version 1.0
 * @date 2020/7/14 15:21
 **/

@RestController
public class NormalController {

    @Autowired
    private NormalUserService normalUserService;

    @Autowired
    private UserService userService;

    /**
     * 获取普通用户个人中心
     */
    @RequestMapping("/user/info")
    public JsonResult userInfo(HttpServletResponse response, HttpSession session){
        Integer userId= (Integer) session.getAttribute("user_id");
        Integer teamId= (Integer) session.getAttribute("team_id");
        String username=(String) session.getAttribute("username");
        if(userId==0||teamId!=0|| username.equals("")){
            return JsonResult.errorMsg("请用户重新登陆");
        }
        User user=userService.getUserInfo(userId);
        if(user==null){
            return JsonResult.errorMsg("请用户重新登陆");
        }
        UserInfoBO userInfoBO=new UserInfoBO(userId,teamId,username,user.getRealName(),user.getIsValid(),user.getRegisterTime(),user.getPhone(),user.getEmail());

        return JsonResult.ok(userInfoBO);
    }

    /**
     * 修改普通用户个人信息
     */
    @RequestMapping("/user/update")
    public JsonResult userInfoUpdate(@RequestParam(value = "real_name",required = false)String realName,
                                     @RequestParam(value = "phone",required = false) String phone,
                                     @RequestParam(value = "email",required = false) String email,
                                      HttpServletResponse response, HttpSession session){
        Integer userId=(Integer)session.getAttribute("user_id");
        if(userId==0){
            return JsonResult.errorMsg("请用户重新登陆");
        }
        User user=new User();
        user.setIsValid(userId);
        user.setPhone(phone);
        user.setRealName(realName);
        user.setEmail(email);
        boolean is=userService.updateUserInfo(user);
        if(!is){
            return JsonResult.errorMsg("修改个人信息失败");
        }

        return JsonResult.ok();
    }





}
