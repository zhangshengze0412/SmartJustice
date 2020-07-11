package com.smart_justice.smart_justice.mapper;

import com.smart_justice.smart_justice.model.Lawyer;
import com.smart_justice.smart_justice.model.LawyerTeam;
import org.apache.ibatis.annotations.*;
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

    /**
     * 根据id获取律师团队信息
     * @param id 律师团队id
     * @return Lawyer
     */
    @Select("select * from lawyer_team where id = #{id}")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "name",column = "name"),
            @Result(property = "scale",column = "scale"),
            @Result(property = "num",column = "num"),
            @Result(property = "phone",column = "phone"),
    })
    LawyerTeam getLawyerTeam(Integer id);

    /**
     * 增加律师团队信息
     * @param lawyerTeam 律师团队信息
     * @return boolean
     */
    @Insert("insert into lawyer_team(name,scale,num,phone) values(#{name},#{scale},#{num},#{phone})")
    @Options(useGeneratedKeys = true,keyProperty ="id",keyColumn = "id")
    boolean addLawyerTeam(LawyerTeam lawyerTeam);

    /**
     * 增加律师团队人数
     * @param id 律师团队id
     * @param num 增加人数
     * @return boolean
     */
    @Update("update lawyer_team set num=num+#{num} where id = #{id}")
    boolean updateLawyerTeamNum(Integer id,Integer num);

    /**
     * 修改律师团队信息
     * TODO:缺少内容
     * @param lawyerTeam 律师团队
     * @return boolean
     */
    boolean updateLawyerTeam(LawyerTeam lawyerTeam);



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