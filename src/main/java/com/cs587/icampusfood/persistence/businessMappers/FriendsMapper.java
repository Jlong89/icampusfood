package com.cs587.icampusfood.persistence.businessMappers;

import com.cs587.icampusfood.persistence.dataObjects.FriendsDBDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by longpengjiao on 10/2/15.
 */
public interface FriendsMapper {

    /**
     * @param userName
     * @return
     */
    @Select("SELECT * from \"Friends\" where \"masterFriend\"=#{userName}")
    List<FriendsDBDO> getFriends(String userName);

    /**
     * @param friendsDBDO
     * @return FriendDBDO if the userName and friendName are already friends
     */
    @Select("SELECT * from \"Friends\" where \"masterFriend\"=#{masterFriend} and \"slaveFriend\"= #{slaveFriend}")
    FriendsDBDO checkFriend(FriendsDBDO friendsDBDO);

    /**
     * @param friendsDBDO
     * @return number of rows inserted into Friends table
     */
    @Insert("INSERT into \"Friends\" (\"masterFriend\", \"slaveFriend\") VALUES(#{masterFriend}, #{slaveFriend})")
    int insertNewFriend(FriendsDBDO friendsDBDO);
}
