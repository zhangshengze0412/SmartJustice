package com.smart_justice.smart_justice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Date;

/**
 * 总用户
 *
 * @author tudou
 * @version 1.0
 * @date 2020/7/11 21:06
 **/

/**
 * CREATE TABLE `user` (
 *   `id` int(11) NOT NULL AUTO_INCREMENT,
 *   `username` varchar(255) NOT NULL,
 *   `password` varchar(255) NOT NULL,
 *   `real_name` varchar(255) DEFAULT NULL,
 *   `phone` varchar(255) DEFAULT '0',
 *   `email` varchar(255) DEFAULT NULL,
 *   `register_time` datetime DEFAULT NULL,
 *   PRIMARY KEY (`id`)
 * ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
 */

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

}
