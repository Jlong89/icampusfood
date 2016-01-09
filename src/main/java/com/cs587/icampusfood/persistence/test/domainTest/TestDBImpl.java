package com.cs587.icampusfood.persistence.test.domainTest;

import com.cs587.icampusfood.dataObjects.Token;
import com.cs587.icampusfood.domain.business.FoodLocation;
import com.cs587.icampusfood.persistence.businessMappers.*;
import com.cs587.icampusfood.persistence.dataObjects.*;
import com.cs587.icampusfood.persistence.test.testMappers.PointTestMapper;
import org.postgis.PGgeometry;
import org.postgis.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by longpengjiao on 9/15/15.
 */
@Service("pointTestService")
public class TestDBImpl implements TestDB {

    //private PointTestMapper pointTestMapper;
    private UserMapper userMapper;
    private TokenMapper tokenMapper;
    private FoodLocationMapper foodLocationMapper;
    private FriendsMapper friendsMapper;
    private FavoriteMapper favoriteMapper;
    private PostMapper postMapper;
    private ProfileMapper profileMapper;
    private WeekCrowdednessMapper weekCrowdMapper;

    /*
    @Autowired
    public void setPointTestMapper(PointTestMapper pointTestMapper) {
        this.pointTestMapper= pointTestMapper;
    }*/

    @Autowired
    public void setUserMapper(UserMapper userMapper) {this.userMapper = userMapper;}

    @Autowired
    public void setTokenMapper(TokenMapper tokenMapper){this.tokenMapper = tokenMapper;}

    @Autowired
    public void setFoodLocationMapper(FoodLocationMapper foodLocationMapper){this.foodLocationMapper= foodLocationMapper;}

    @Autowired
    public void setFriendsMapper(FriendsMapper friendsMapper){this.friendsMapper = friendsMapper;}

    @Autowired
    public void setFavoriteMapper(FavoriteMapper favoriteMapper){this.favoriteMapper = favoriteMapper;}

    @Autowired
    public void setFavoriteMapper(PostMapper postMapper){this.postMapper = postMapper;}

    @Autowired
    public void setProfileMapper(ProfileMapper profileMapper){this.profileMapper= profileMapper;}

    @Autowired
    public void setWeekCrowdMapper(WeekCrowdednessMapper weekCrowdednessMapper){this.weekCrowdMapper= weekCrowdednessMapper;}
    /*
    @Override
    public List<PointBean> getAllPoints(){

        List<PointRes> pointResList = pointTestMapper.getAllPoints();
        if(!pointResList.isEmpty()){
            System.out.println("size: "+pointResList.size());
        }
        List<PointBean> retList = new LinkedList<>();
        for(PointRes p : pointResList){
            PointBean pB = new PointBean();
            pB.setName(p.getName());
            //System.out.println("tttttt"+p.getName());
            //if(p.getLocation()==null) System.out.println("geom is null!!!!!!");
            PGgeometry geom = p.getLocation();
            Point point = (Point) geom.getGeometry();
            pB.setX(point.getX());
            pB.setY(point.getY());
            //System.out.println("point="+point.getX()+", "+point.getY());
            retList.add(pB);
        }
        return retList;

        /*
        List<PointBean> retList = new LinkedList<>();
        java.sql.Connection conn;
        try{
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://aahrg5vhtj4ja7.cvrzbbd6lsip.us-west-2.rds.amazonaws.com:5432/main";
            conn = DriverManager.getConnection(url, "csci587project", "iCampusFood587");
            //add geometry datatype
            ((org.postgresql.PGConnection)conn).addDataType("geometry",Class.forName("org.postgis.PGgeometry"));

            Statement s = conn.createStatement();
            ResultSet r = s.executeQuery("SELECT \"name\", \"location\"  FROM \"point\"");

            while(r.next()){
                PGgeometry geom = (PGgeometry)r.getObject("location");
                String name = r.getString("name");
                Point point = (Point) geom.getGeometry();
                PointBean pB = new PointBean();
                pB.setName(name);
                pB.setX(point.getX());
                pB.setY(point.getY());
                retList.add(pB);
            }


        }catch( Exception e ) {
            e.printStackTrace();
        }
        return retList;

    }*/

    @Override
    public int insertUser(UserDBDO user){
        int affectedRows = userMapper.insertUser(user);
        user.setUserId(getMaxUserId());
        System.out.println("newly inserted userId: "+ user.getUserId());
        return affectedRows;
    }

    @Override
    public int getMaxUserId(){
        return userMapper.getMaxUserId();
    }

    @Override
    public UserDBDO getUser(String userName){
        return userMapper.getUser(userName);
    }

    /*
    @Override
    public int getTotalUsers(){
        return userMapper.getTotalUsers();
    }*/

    @Override
    public int login(TokenDBDO tokenDBDO){

        return tokenMapper.login(tokenDBDO);
    }

    @Override
    public TokenDBDO checkLogin(String token){
        return tokenMapper.checkLogin(token);
    }

    @Override
    public TokenDBDO isUserExistInTokenTable(int userId){
        return tokenMapper.isUserExistInTokenTable(userId);
    }

    @Override
    public int updateToken(String token, int userId){
        TokenDBDO tokenDBDO = new TokenDBDO();
        tokenDBDO.setToken(token);
        tokenDBDO.setUserId(userId);
        return tokenMapper.updateToken(tokenDBDO);
    }



    @Override
    public int insertNewFoodLocation(FoodLocationDBDO foodLocationDBDO){

        return foodLocationMapper.insertNewFoodLocation(foodLocationDBDO);

    }

    @Override
    public List<FoodLocationDBDO> getFoodLocation(String name){
        return foodLocationMapper.getFoodLocation(name);
    }

    @Override
    public List<FriendsDBDO> getFriends(String userName){
        return friendsMapper.getFriends(userName);
    }

    @Override
    public FriendsDBDO checkFriend(FriendsDBDO friendsDBDO){
        return friendsMapper.checkFriend(friendsDBDO);
    }

    @Override
    public int insertNewFriend(FriendsDBDO friendsDBDO){
        return friendsMapper.insertNewFriend(friendsDBDO);
    }

    @Override
    public List<Integer> getFavoritesIds(String userName){
        return favoriteMapper.getFavoriteIds(userName);
    }

    @Override
    public int insertNewFavorite(FavoriteDBDO favoriteDBDO){
        return favoriteMapper.insertNewFavorite(favoriteDBDO);
    }

    @Override
    public List<PostDBDO> getPosts(int locationId){
        return postMapper.getPosts(locationId);
    }

    @Override
    public int insertPost(PostDBDO postDBDO){
        return postMapper.insertPost(postDBDO);
    }

    @Override
    public List<FoodLocationDBDO> getLocsWithinRange(String point, double radius){
        return foodLocationMapper.getLocsWithinRange(point, radius);
    }

    @Override
    public List<FoodLocationDBDO> getKnn(int k, double longitude, double latitude, double radius){
        return foodLocationMapper.getKnn(k, longitude, latitude, radius);
    }

    @Override
    public ProfileDBDO getProfile(double longitude, double latitude, double radius){
        return profileMapper.getProfile(longitude, latitude, radius);
    }

    @Override
    public List<FoodLocationDBDO> getLocsWithinRangeTime(int k, double longitude, double latitude, double radius, String time){
        return foodLocationMapper.getLocsWithinRangeTime(k, longitude, latitude, radius, time);
    }

    @Override
    public List<WeekCrowdednessDBDO> getWeekCrowdedness(int locationId){
        return weekCrowdMapper.getWeekCrowdedness(locationId);
    }

    @Override
    public List<FoodLocationDBDO> getKBestWithinRange(int k, double longitude, double latitude, double radius, int foodType, String category){
        return foodLocationMapper.getKBestWithinRange(k, longitude, latitude, radius, foodType, category);
    }

    @Override
    public boolean isFriendFavorite(String userName, int locationId){
        return foodLocationMapper.isFriendFavorite(userName, locationId);
    }


}
