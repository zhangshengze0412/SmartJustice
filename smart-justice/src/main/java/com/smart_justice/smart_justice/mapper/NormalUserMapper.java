package com.smart_justice.smart_justice.mapper;

import com.smart_justice.smart_justice.model.NormalUser;
import com.smart_justice.smart_justice.model.User;
import org.apache.ibatis.annotations.*;
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

    /**
     * 增加普通用户
     * @param user 普通用户
     * @return boolean
     */
    @Insert("insert into normal_user(user_id,vip,vip_time) values(#{user_id},#{vip},#{vip_time})")
    @Options(useGeneratedKeys = true,keyProperty ="id",keyColumn = "id")
    boolean addNormalUser(NormalUser user);

    /**
     * 通过id获取总用户信息
     * @param id 普通用户id
     * @return User
     */
    @Select("select * from normal_user where id = #{id}")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "userId",column = "user_id"),
            @Result(property = "vip",column = "vip"),
            @Result(property = "vipTime",column = "vip_time"),
    })
    NormalUser getNormalUserById(Integer id);



    /**
     * 修改普通用户信息
     * @param normalUser 普通用户
     * @return boolean
     */
    @Update("update normal_user set vip=#{vip},vip_time=#{vipTime} where id=#{id}")
    boolean updateNormalUser(NormalUser normalUser);

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