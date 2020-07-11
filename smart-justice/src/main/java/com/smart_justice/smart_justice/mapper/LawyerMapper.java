package com.smart_justice.smart_justice.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 律师用户Mapper
 *
 * @author tudou
 * @version 1.0
 * @date 2020/7/11 18:30
 **/



@Repository
@Mapper
public interface LawyerMapper {
}

/**
 * CREATE TABLE `lawyer` (
 *   `id` int(11) NOT NULL AUTO_INCREMENT,
 *   `user_id` int(11) NOT NULL,
 *   `work_id` varchar(255) NOT NULL,
 *   `team_id` int(11) NOT NULL,
 *   PRIMARY KEY (`id`)
 * ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
 */