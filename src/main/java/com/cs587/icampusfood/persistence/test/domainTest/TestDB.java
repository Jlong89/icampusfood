package com.cs587.icampusfood.persistence.test.domainTest;

import com.cs587.icampusfood.domain.business.FoodLocation;
import com.cs587.icampusfood.persistence.dataObjects.*;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by longpengjiao on 9/15/15.
 */
public interface TestDB {

    /**
     * @return all the points
     */
    //public List<PointBean> getAllPoints();

    /**
     * param user
     * @return: number of rows affected by insert into user table
     */
    public int insertUser(UserDBDO user);

    /**
     * @return max userId
     * used after insert to get new userId assgined to the inserted user
     */
    public int getMaxUserId();


    public UserDBDO getUser(String userName);

   // public int getTotalUsers();

    public int login(TokenDBDO tokenDBDO);

    public TokenDBDO checkLogin(String token);

    public TokenDBDO isUserExistInTokenTable(int userId);

    public int updateToken(String token, int userId);

    public int insertNewFoodLocation(FoodLocationDBDO foodLocationDBDO);

    public List<FoodLocationDBDO> getFoodLocation(String name);

    public List<FriendsDBDO> getFriends(String userName);

    public FriendsDBDO checkFriend(FriendsDBDO friendsDBDO);

    public int insertNewFriend(FriendsDBDO friendsDBDO);


    public List<Integer> getFavoritesIds(String userName);

    public int insertNewFavorite(FavoriteDBDO favoriteDBDO);

    public List<PostDBDO> getPosts(int locationId);

    public int insertPost(PostDBDO postDBDO);

    public List<FoodLocationDBDO> getLocsWithinRange(String point, double radius);

    public List<FoodLocationDBDO> getKnn(int k, double longitude, double latitude, double radius);

    public ProfileDBDO getProfile(double longitude, double latitude, double radius);

    public List<FoodLocationDBDO> getLocsWithinRangeTime(int k, double longitude, double latitude, double radius, String time);

    public List<WeekCrowdednessDBDO> getWeekCrowdedness(int locationId);

    public List<FoodLocationDBDO> getKBestWithinRange(int k, double longitude, double latitude, double radius, int foodType, String category);

    public boolean isFriendFavorite(String userName, int locationId);

}
