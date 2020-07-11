package com.smart_justice.smart_justice.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 普通用户Mapper
 *
 * @author tudou
 * @version 1.0
 * @date 2020/7/11 18:31
 **/



@Repository
@Mapper
public interface NormalUserMapper {
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