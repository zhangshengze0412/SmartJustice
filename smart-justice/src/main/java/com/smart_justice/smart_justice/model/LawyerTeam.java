package com.smart_justice.smart_justice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 律师团队你信息
 *
 * @author tudou
 * @version 1.0
 * @date 2020/7/11 21:14
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LawyerTeam {

    private Integer id;
    private String  name;
    private Integer scale;
    private Integer num;
    private String phone;
    private Integer userId;

}



/**
 * CREATE TABLE `lawyer_team` (
 *   `id` int(11) NOT NULL AUTO_INCREMENT,
 *   `name` varchar(255) NOT NULL,
 *   `scale` int(11) NOT NULL DEFAULT '0',
 *   `num` int(11) NOT NULL DEFAULT '0',
 *   `phone` varchar(255) NOT NULL,
 *   `user_id` int(11) NOT NULL,
 *   PRIMARY KEY (`id`)
 * ) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4;
 */