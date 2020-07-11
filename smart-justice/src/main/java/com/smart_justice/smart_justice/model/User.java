package com.smart_justice.smart_justice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.sql.Time;
import java.util.Date;

/**
 * 总用户
 *
 * @author tudou
 * @version 1.0
 * @date 2020/7/11 21:06
 **/


@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Integer id;
    private String username;
    private String password;
    private String realName;
    private String phone;
    private Date registerTime;
    private Integer isValid;

    public User(String username, String password,String realName,Date registerTime){
        this.username=username;
        this.password=password;
        this.realName=realName;
        this.registerTime=registerTime;
    }

}
