package com.smart_justice.smart_justice.model;

/**
 * 普通用户信息
 *
 * @author tudou
 * @version 1.0
 * @date 2020/7/11 21:11
 **/


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NormalUser {

    private Integer id;
    private Integer userId;
    private Integer vip;
    private Date vipTime;
}


/**
 * CREATE TABLE `normal_user` (
 *   `id` int(11) NOT NULL AUTO_INCREMENT,
 *   `user_id` int(11) DEFAULT NULL,
 *   `vip` int(11) DEFAULT NULL,
 *   `vip_time` datetime DEFAULT NULL,
 *   PRIMARY KEY (`id`)
 * ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
 */

