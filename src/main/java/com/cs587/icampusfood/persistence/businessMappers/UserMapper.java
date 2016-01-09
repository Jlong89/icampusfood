/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cs587.icampusfood.persistence.businessMappers;

import com.cs587.icampusfood.persistence.dataObjects.UserDBDO;
import java.util.List;

import org.apache.ibatis.annotations.*;

/**
 *
 * @author Joey
 */
public interface UserMapper {

    /**
     * @return all the users
     */
    @Select("SELECT \"userId\", \"userName\", password  FROM \"Users\"")
    public List<UserDBDO> getAllUsers();

    /**
     * @param user
     * @return the number of rows affected
     */
    @Insert("INSERT INTO \"Users\" (\"userId\", \"userName\", \"password\") VALUES (#{userId}, #{userName}, #{password})")
    @SelectKey(statement="SELECT nextVal('userId_seq')", keyProperty="userId", before=true, resultType=int.class)
    public int insertUser(UserDBDO user);


    @Select("SELECT max(\"userId\") from \"Users\"")
    public int getMaxUserId();


    @Select("SELECT * from \"Users\" where \"userName\"=#{userName}")
    public UserDBDO getUser(String userName);

    /**
     * @param user
     * @return the number of rows affected
     */
    @Update("UPDATE Users SET\n"
            + " userName = #{userName},\n"
            + " password = #{password}\n"
            + " WHERE userId = #{userId}")
    public int updateUser(UserDBDO user);


    /**
     * @return total number of users in DB
     */
    @Select("SELECT totalUsers()")
    public int getTotalUsers();
}
