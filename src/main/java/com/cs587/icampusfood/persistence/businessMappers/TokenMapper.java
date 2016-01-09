package com.cs587.icampusfood.persistence.businessMappers;

import com.cs587.icampusfood.domain.business.User;
import com.cs587.icampusfood.persistence.dataObjects.TokenDBDO;
import com.cs587.icampusfood.persistence.dataObjects.UserDBDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * Created by longpengjiao on 9/23/15.
 */
public interface TokenMapper {

    /**
     * @return token object if already logged-in
     */
    @Select("SELECT * from \"Token\" where token=#{token}")
    TokenDBDO checkLogin(String token);

    /**
     * @param tokenDBDO
     * @return number of rows affected by insert
     */
    @Insert("INSERT INTO \"Token\" (\"token\", \"userId\") values(#{token}, #{userId})")
    int login(TokenDBDO tokenDBDO);

    /**
     * @param userId
     * @return TokenDBDO corresponding to userId in Token table, if it exists, null otherwise
     */
    @Select("SELECT * from \"Token\" where \"userId\"=#{userId}")
    TokenDBDO isUserExistInTokenTable(int userId);

    /**
     * @param tokenDBDO
     * @return number of updated rows in token table by update query of user
     */
    @Update("UPDATE \"Token\" SET \"token\"=#{token} WHERE \"userId\"=#{userId}")
    int updateToken(TokenDBDO tokenDBDO);

}
