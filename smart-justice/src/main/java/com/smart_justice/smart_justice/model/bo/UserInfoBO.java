package com.smart_justice.smart_justice.model.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 用户信息BO
 *
 * @author tudou
 * @version 1.0
 * @date 2020/7/14 15:37
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoBO {

    private Integer userId;
    private Integer teamId;
    private String username;
    private String realName;
    private Integer isValid;
    private Date registerTime;
    private String phone;
    private String email;

}
