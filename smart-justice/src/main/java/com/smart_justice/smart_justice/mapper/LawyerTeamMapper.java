package com.smart_justice.smart_justice.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 律师团队Mapper
 *
 * @author tudou
 * @date 2020/7/10 0:07
 */


@Repository
@Mapper
public interface LawyerTeamMapper {
}


/**
 * CREATE TABLE `lawyer_team` (
 *   `id` int(11) NOT NULL AUTO_INCREMENT,
 *   `name` varchar(255) DEFAULT NULL,
 *   `scale` int(11) DEFAULT '0',
 *   `num` int(11) DEFAULT '0',
 *   `phone` varchar(255) DEFAULT NULL,
 *   PRIMARY KEY (`id`)
 * ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
 */