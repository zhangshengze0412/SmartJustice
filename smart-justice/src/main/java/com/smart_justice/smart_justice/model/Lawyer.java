package com.smart_justice.smart_justice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 律师用户信息
 *
 * @author tudou
 * @version 1.0
 * @date 2020/7/11 21:14
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Lawyer {
    private Integer id;
    private Integer userId;
    private String workId;
    private Integer teamId;
    private Integer isValid;
}

/**
 * CREATE TABLE `lawyer` (
 *   `id` int(11) NOT NULL AUTO_INCREMENT,
 *   `user_id` int(11) NOT NULL,
 *   `work_id` varchar(255) NOT NULL,
 *   `team_id` int(11) NOT NULL,
 *   `is_valid` int(11) DEFAULT '0',
 *   PRIMARY KEY (`id`)
 * ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
 */