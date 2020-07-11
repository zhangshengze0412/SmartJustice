package com.smart_justice.smart_justice.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 总用户信息Mapper
 *
 * @author tudou
 * @date 2020/7/9 23:16
 */



@Repository
@Mapper
public interface UserMapper {





}

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