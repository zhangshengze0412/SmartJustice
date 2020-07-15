package com.smart_justice.smart_justice.model.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 企业用户个人中心
 *
 * @author tudou
 * @version 1.0
 * @date 2020/7/14 16:26
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LawyerBO {

    private Integer userId;
    private Integer teamId;
    private String username;
    private Date registerTime;
    private String teamName;
    private String workId;
    private String phone;
    private String email;
}
