package com.smart_justice.smart_justice.mapper;

import com.smart_justice.smart_justice.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Indexed;
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


    /**
     * 增加用户
     * @param user 总用户
     * @return boolean
     */
    @Insert("insert into user(username,password,real_name,email,register_time) values(#{username},#{password},#{realName},#{email},#{registerTime})")
    @Options(useGeneratedKeys = true,keyProperty ="id",keyColumn = "id")
    boolean addUser(User user);

    /**
     * 通过id获取总用户信息
     * @param id 总用户id
     * @return User
     */
    @Select("select * from user where id = #{id}")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "password",column = "password"),
            @Result(property = "realName",column = "real_name"),
            @Result(property = "phone",column ="phone"),
            @Result(property = "email",column = "email"),
            @Result(property = "registerTime",column = "register_time"),
            @Result(property = "isValid",column = "is_valid")
    })
    User getUserById(Integer id);

    /**
     * 通过username获取总用户信息
     * @param username 总用户用户名
     * @return User
     */
    @Select("select * from user where username = #{username}")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "password",column = "password"),
            @Result(property = "realName",column = "real_name"),
            @Result(property = "phone",column ="phone"),
            @Result(property = "email",column = "email"),
            @Result(property = "registerTime",column = "register_time"),
            @Result(property = "isValid",column = "is_valid")
    })
    User getUserByUsername(String username);


    /**
     * 修改用户信息
     * TODO:缺少内容
     * @param user 总用户
     * @return boolean
     */
    boolean updateUser(User user);

}

/**
 * CREATE TABLE `user` (
 *   `id` int(11) NOT NULL AUTO_INCREMENT,
 *   `username` varchar(255) NOT NULL,
 *   `password` varchar(255) NOT NULL,
 *   `real_name` varchar(255) DEFAULT NULL,
 *   `phone` varchar(255) DEFAULT NULL,
 *   `email` varchar(255) DEFAULT NULL,
 *   `register_time` datetime DEFAULT NULL,
 *   `is_valid` int(11) DEFAULT 0,
 *   PRIMARY KEY (`id`)
 * ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
 */