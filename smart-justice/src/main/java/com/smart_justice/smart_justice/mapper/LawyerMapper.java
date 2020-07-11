package com.smart_justice.smart_justice.mapper;

import com.smart_justice.smart_justice.model.Lawyer;
import org.apache.ibatis.annotations.*;
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

    /**
     * 根据id获取律师用户信息
     * @param id 律师id
     * @return Lawyer
     */
    @Select("select * from lawyer where id = #{id}")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "userId",column = "user_id"),
            @Result(property = "workId",column = "work_id"),
            @Result(property = "teamId",column = "team_id"),
    })
    Lawyer getLawyer(Integer id);


    /**
     * 修改律师信息
     * @param lawyer 律师用户信息
     * @return boolean
     */
    @Update("update lawyer set team_id=#{teamId},work_id=#{work_id} where user_id=#{userId}")
    boolean updateLawyer(Lawyer lawyer);



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