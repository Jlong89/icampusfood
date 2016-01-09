package com.cs587.icampusfood.persistence.test.controller;

import com.cs587.icampusfood.domain.business.FoodLocation;
import com.cs587.icampusfood.persistence.dataObjects.*;
import com.cs587.icampusfood.persistence.test.domainTest.PointBean;
import com.cs587.icampusfood.persistence.test.domainTest.TestDB;
import com.cs587.icampusfood.persistence.test.domainTest.TestDBImpl;
import org.postgis.PGgeometry;
import org.postgis.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;


/**
 * Created by longpengjiao on 9/16/15.
 */
@Controller
public class TestDBController {

    public double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
    @Autowired
    private TestDBImpl testDB;


    @RequestMapping(value="/testInsertUser/userName/{userName}/password/{password}")
    public void testInsertUser(@PathVariable String userName, @PathVariable String password){
        UserDBDO newUser = new UserDBDO();
        newUser.setUserName(userName);
        newUser.setPassword(password);
        int insertedRows = testDB.insertUser(newUser);
        System.out.println("test inserting user, affected rows:" + insertedRows);
    }

    /*
    @RequestMapping(value="/getTotalUsers/")
    public void testGetTotalUsers(){
        int tot = testDB.getTotalUsers();
        System.out.println("total number of users: " + tot);
    }*/

    @RequestMapping(value="/testLogin")
    public void testLogin(){
        TokenDBDO tokenDBDO = new TokenDBDO();
        tokenDBDO.setToken("asdfasddfad");
        tokenDBDO.setUserId(10);
        int affected = testDB.login(tokenDBDO);
        System.out.println("login: insert rows = " +affected);

    }


    @RequestMapping(value="/testCheckLogin")
    public void testCheckLogin(){
        TokenDBDO tokenDBDO = null;
        tokenDBDO = testDB.checkLogin("token1");
        if(tokenDBDO!=null){
            System.out.println("Got token!");
            System.out.println("userId: "+ tokenDBDO.getUserId());
            System.out.println("token: "+ tokenDBDO.getToken());
        }
    }

    @RequestMapping(value="/testIsUserExistInToken/{userId}")
    public void testIsUserExistInTokenTable(@PathVariable String userId){
        TokenDBDO tokenDBDO = null;
        tokenDBDO = testDB.isUserExistInTokenTable(Integer.parseInt(userId));
        if(tokenDBDO!=null){
            System.out.println("Got token!");
            System.out.println("userId: "+ tokenDBDO.getUserId());
            System.out.println("token: "+ tokenDBDO.getToken());
        }else{
            System.out.println("No token: "+ userId+ " not in token table");
        }
    }

    @RequestMapping(value="/testUpdateToken/token/{token}/userId/{userId}")
    public void testUpdateToken(@PathVariable String token,@PathVariable String userId){
        int res = testDB.updateToken(token, Integer.parseInt(userId));
        System.out.println("Updated rows in Token Table: " + res);
    }

    @RequestMapping(value="/testGetUser/userName/{userName}")
    public void testGetUser(@PathVariable String userName){

        UserDBDO res = testDB.getUser(userName);
        if(res!=null){
            System.out.println("Got user!");
        }else{
            System.out.println("User does not exit!");
        }
    }

    @RequestMapping(value="/testInsertLocation")
    public void testInsertLocation(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(0,0,0,0,0,0);
        Timestamp ts = new Timestamp(calendar.getTimeInMillis());
        Point newPoint = new Point(71.232, 100);
        FoodLocationDBDO foodLocationDBDO = new FoodLocationDBDO();
        foodLocationDBDO.setName("testLocation99");
        foodLocationDBDO.setFoodType(1);
        foodLocationDBDO.setCloseTime(ts);
        foodLocationDBDO.setOpenTime(ts);
        foodLocationDBDO.setAvgFoodRating(-1);
        foodLocationDBDO.setAvgServiceRating(-1);
        foodLocationDBDO.setStartDate(ts);
        foodLocationDBDO.setEndDate(ts);
        foodLocationDBDO.setAvgCrowdedness(0);
        foodLocationDBDO.setLocation(new PGgeometry(newPoint));
        int ret = testDB.insertNewFoodLocation(foodLocationDBDO);
        if(ret>0){
            System.out.println("TEST insertNewLocation: Insert new location!!!");
        }else{
            System.out.print("TEST insertNewLocation: Unable to new location");
        }
    }


    @RequestMapping(value="/testGetFoodLocation/name/{name}")
    public void testGetFoodLocation(@PathVariable String name){
        List<FoodLocationDBDO> locations= testDB.getFoodLocation(name);
        if(locations!=null&&locations.size()>0){
            for(FoodLocationDBDO loc : locations) {
                PGgeometry geom = (PGgeometry) loc.getLocation();
                Point point = (Point) geom.getGeometry();
                System.out.println("Name: "+loc.getName());
                System.out.println("Location: X=" + point.getX() + " Y=" + point.getY());
            }
        }else{
            System.out.println("TEST No Location Found!!");
        }
    }

    @RequestMapping(value="/testFriends/username/{userName}")
    public void testGetFriends(@PathVariable String userName){
        List<FriendsDBDO> friends = testDB.getFriends(userName);
        System.out.println("TEST getFriends:" +userName+"'s friends: ");
        for(FriendsDBDO friend: friends){
            System.out.println(friend.getSlaveFriend());
        }
    }

    @RequestMapping(value="/testCheckFriend/userName/{userName}/friendName/{friendName}")
    public void testCheckFriend(@PathVariable String userName, @PathVariable String friendName){
        FriendsDBDO friendsDBDO = new FriendsDBDO();
        friendsDBDO.setMasterFriend(userName);
        friendsDBDO.setSlaveFriend(friendName);
        FriendsDBDO friend = testDB.checkFriend(friendsDBDO);
        if(friend!=null){
            System.out.println("TEST checkFriends: They are Friends!!");
        }else{
            System.out.println("TEST checkFriends: They are NOT Friends!!!!");
        }
    }

    @RequestMapping(value="/testInsertNewFriend/masterName/{masterName}/slaveName/{slaveName}")
    public  void insertNewFriend(@PathVariable String masterName, @PathVariable String slaveName){
        FriendsDBDO friendsDBDO = new FriendsDBDO();
        friendsDBDO.setMasterFriend(masterName);
        friendsDBDO.setSlaveFriend(slaveName);
        int ret = testDB.insertNewFriend(friendsDBDO);
        if(ret>0){
            System.out.println("inserted new Friend!!!");
        }else {
            System.out.println("friend not inserted!");
        }
    }


    @RequestMapping(value="/testGetFavoriteIds/userName/{userName}")
    public void testGetFavoriteIds(@PathVariable String userName){
        List<Integer> ret = testDB.getFavoritesIds(userName);
        for(int fav:ret){
            System.out.println("favorite Id:"+fav);
        }
    }

    @RequestMapping(value ="/testInsertNewFavorite/locationId/{locationId}/userName/{userName}")
    public void testInsertNewFavorite(@PathVariable int locationId, @PathVariable String userName){
        FavoriteDBDO favoriteDBDO = new FavoriteDBDO();
        favoriteDBDO.setLocationId(locationId);
        favoriteDBDO.setUserName(userName);
        int ret = testDB.insertNewFavorite(favoriteDBDO);
        if(ret>0){
            System.out.println("inserted new Favorite!!!");
        }else {
            System.out.println("Favorite not inserted!");
        }
    }

    @RequestMapping(value="testGetPosts/locationId/{locationId}")
    public void testGetPosts(@PathVariable int locationId){
        List<PostDBDO> postList = testDB.getPosts(locationId);
        if(postList.size()>0){
            for(PostDBDO post : postList) {
                System.out.println("foodRating: " + post.getFoodRating());
            }
        }else{
            System.out.println("No posts for locationId: "+locationId);
        }
    }


    @RequestMapping(value="testInsertPost/locationId/{locationId}")
    public void testInsertPost(@PathVariable int locationId){
        PostDBDO postDBDO = new PostDBDO();
        postDBDO.setLocationId(locationId);
        postDBDO.setFoodRating(3);
        postDBDO.setServiceRating(2);
        Date date= new java.util.Date();
        postDBDO.setPostTime(new Timestamp(date.getTime()));

        int ret = testDB.insertPost(postDBDO);
        if(ret>0){
            System.out.println("inserted new Post for locationId: "+locationId);
        }else{
            System.out.print("Could not insert new post");
        }
    }

    @RequestMapping(value="testGetLocsWithinRange/longitude/{longitude}/lat/{lat}/radius/{radius}")
    public void testGetLocsWithinRange(@PathVariable String longitude, @PathVariable String lat, @PathVariable double radius) {
        String pointString ="Point("+longitude+" "+lat+")";
        List<FoodLocationDBDO> list =testDB.getLocsWithinRange(pointString, radius);
        if(list.size()>0){
             for(FoodLocationDBDO foodLoc : list ){
                 PGgeometry geom = (PGgeometry) foodLoc.getLocation();
                 Point point = (Point) geom.getGeometry();
                 System.out.println("Loc Name:"+foodLoc.getName());
                 System.out.println("Location: X="+point.getX()+" Y="+point.getY());
             }
        }else{
            System.out.println("No locations found within range ");
        }
    }

    @RequestMapping(value="testGetKnn/k/{k}/longitude/{longitude}/latitude/{latitude}/radius/{radius}")
    public void testGetKnn(@PathVariable int k,@PathVariable double longitude, @PathVariable double latitude, @PathVariable double radius) {
        List<FoodLocationDBDO> list =testDB.getKnn(k, longitude, latitude, radius);
        if(list.size()>0){
            for(FoodLocationDBDO foodLoc : list ){
                System.out.println("Loc Name:"+foodLoc.getName());
                System.out.println("distance: " +foodLoc.getDistance());
                PGgeometry geom = (PGgeometry) foodLoc.getLocation();
                Point point = (Point) geom.getGeometry();
                System.out.println("Location: X="+point.getX()+" Y="+point.getY());
            }
        }else{
            System.out.println("No locations found within range ");
        }
    }

    @RequestMapping(value="testGetLocsWithinRangeTime/k/{k}/longitude/{longitude}/latitude/{latitude}/radius/{radius}/hours/{hours}/min/{min}/secs/{secs}")
    public void testGetLocsWithinRangeTime(@PathVariable int k,@PathVariable double longitude, @PathVariable double latitude, @PathVariable double radius,
                                           @PathVariable String hours, @PathVariable String min, @PathVariable String secs) {
        String time = "0/0/0 " + hours+ ":"+min+":"+secs;
        List<FoodLocationDBDO> list =testDB.getLocsWithinRangeTime(k, longitude, latitude, radius, time);
        if(list.size()>0){
            for(FoodLocationDBDO foodLoc : list ){
                System.out.println("Loc Name:"+foodLoc.getName());
                System.out.println("distance: " +foodLoc.getDistance());
                PGgeometry geom = (PGgeometry) foodLoc.getLocation();
                System.out.println("open Time: " + foodLoc.getOpenTime().toString());
                System.out.println("close Time: " + foodLoc.getCloseTime().toString());
            }
        }else{
            System.out.println("No locations found within range ");
        }
    }



    @RequestMapping(value="testGetProfile/longitude/{longitude}/latitude/{latitude}/radius/{radius}")
    public void getProfile(@PathVariable double longitude, @PathVariable double latitude, @PathVariable double radius) {
        ProfileDBDO profile=testDB.getProfile(longitude, latitude, radius);
        if(profile!=null){
            System.out.println("Profile: foodType = " + profile.getFoodType() +", rating="+profile.getRating());
        }else{
            System.out.println("Couldn't get profile");
        }
    }


    @RequestMapping(value="popPost")
    public void getProfile() {
        int locId = 277;
        Random r = new Random();
        int low = 11;
        int high = 22;
        for(int i=1; i<61; i++) {
            for(int j= 0; j<20; j++) {
                PostDBDO p = new PostDBDO();
                p.setLocationId(locId);
                p.setFoodRating(round(Math.random() * 5, 1));
                p.setServiceRating(round(Math.random() * 5, 1));
                p.setCrowdedness(round(Math.random() * 5, 1));
                Calendar calendar = Calendar.getInstance();
                calendar.add(Calendar.DAY_OF_MONTH, (-1 * i));
                calendar.set(Calendar.HOUR, r.nextInt(high-low)+low);
                calendar.set(Calendar.MINUTE, (int) round(Math.random() * 59, 1));
                p.setPostTime(new Timestamp(calendar.getTimeInMillis()));
                int ret = testDB.insertPost(p);
            }
        }
    }

    @RequestMapping(value="testGetWeekCrowd/locationId/{locationId}")
     public void getWeekCrowd(@PathVariable int locationId) {

        List<WeekCrowdednessDBDO> list = testDB.getWeekCrowdedness(locationId);
        if(list!=null && list.size() > 0){
            System.out.println("Got crowdedness data!!!!!!!");
            for(WeekCrowdednessDBDO c : list){
                System.out.println(c.getRowNo() +" "+ c.getDow()+ " "+ c.getHour()+ " " +c.getCrowdedness());
            }
        }else{
            System.out.println("Couldn't get crowdedness data");
        }
    }

    @RequestMapping(value="testGetKBest/k/{k}/longitude/{longitude}/latitude/{latitude}/radius/{radius}/foodType/{foodType}/category/{category}")
    public void testGetKBest(@PathVariable int k, @PathVariable int longitude, @PathVariable int latitude, @PathVariable int radius, @PathVariable int foodType, @PathVariable String category) {

        List<FoodLocationDBDO> list = testDB.getKBestWithinRange(k, longitude, latitude, radius, foodType, category);
        if(list.size()>0){
            for(FoodLocationDBDO foodLoc : list ){
                System.out.println("Loc Name:"+foodLoc.getName());
                System.out.println("distance: " +foodLoc.getDistance());
                PGgeometry geom = (PGgeometry) foodLoc.getLocation();
                Point point = (Point) geom.getGeometry();
                System.out.println("Location: X="+point.getX()+" Y="+point.getY());
            }
        }else{
            System.out.println("No locations found within range ");
        }
    }

    @RequestMapping(value="testIsFriendFavorite/userName/{userName}/locationId/{locationId}")
    public void testIsFriendFavorite(@PathVariable String userName, @PathVariable int locationId) {

        boolean res = testDB.isFriendFavorite(userName, locationId);
        if(res){
            System.out.println("TRUE");
        }else{
            System.out.println("FALSE");
        }
    }



}

