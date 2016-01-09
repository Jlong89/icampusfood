/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cs587.icampusfood.controller;

import com.cs587.icampusfood.dataAccess.DataServiceImpl;
import com.cs587.icampusfood.dataAccess.FoodLocationServiceImpl;
import com.cs587.icampusfood.dataAccess.PostServiceImpl;
import com.cs587.icampusfood.dataAccess.UserServiceImpl;
import com.cs587.icampusfood.dataObjects.FavoriateDo;
import com.cs587.icampusfood.dataObjects.FriendDo;
import com.cs587.icampusfood.dataObjects.PostDo;
import com.cs587.icampusfood.dataObjects.Token;
import com.cs587.icampusfood.domain.business.*;
import com.cs587.icampusfood.persistence.businessMappers.FavoriteMapper;
import com.cs587.icampusfood.persistence.businessMappers.FoodLocationMapper;
import com.cs587.icampusfood.persistence.businessMappers.FriendsMapper;
import com.cs587.icampusfood.persistence.dataObjects.FavoriteDBDO;
import com.cs587.icampusfood.persistence.dataObjects.FoodLocationDBDO;
import com.cs587.icampusfood.persistence.dataObjects.FriendsDBDO;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Joey
 */
@RestController
@RequestMapping("/rest")
public class RESTfulAPIController {
    
    private UserServiceImpl userService;
    private FoodLocationServiceImpl foodLocationService;
    private FavoriteMapper favoriteMapper;
    private FriendsMapper friendsMapper;
    private PostServiceImpl postService;
    private DataServiceImpl dataService;

    @Autowired
    public void setDataService(DataServiceImpl dataService) {
        this.dataService = dataService;
    }

    @Autowired
    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }
    
    @Autowired
    public void setFoodLocationService(FoodLocationServiceImpl foodLocationService) {
        this.foodLocationService = foodLocationService;
    }
    
    @Autowired
    public void setFavoriteMapper(FavoriteMapper favoriteMapper) {
        this.favoriteMapper = favoriteMapper;
    }
    
    @Autowired
    public void setFriendsMapper(FriendsMapper friendsMapper){
        this.friendsMapper = friendsMapper;
    }
    
    @Autowired
    public void setPostService(PostServiceImpl postService){
        this.postService = postService;
    }
    
    @RequestMapping(value="/insertuser", method=RequestMethod.POST)
    public User inertUser(@RequestBody User user){
        user.setUserId(userService.saveUser(user));
        return user;
    }
    
    @RequestMapping(value="/getusers", method=RequestMethod.GET)
    public List<User> getUsers() {
        //System.out.println("GetUsers...");
        return userService.getAllUsers();
    }
    
    @RequestMapping(value="/checklogin", method=RequestMethod.POST)
    public boolean checkLogin(@RequestBody Token token) {
        //System.out.println("@@@@@@@@@Token="+token.getToken());
        return userService.checkLogin(token.getToken());
    }
    
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public Token login(@RequestBody User user) {
        Token token = new Token();
        String tokenString = userService.login(user);
        if(tokenString!=null) {
            token.setToken(tokenString);
            
        }else{
            token.setToken(null);
        }
        return token;//return new token
    }
    
    @RequestMapping(value="/addnewfoodlocation", method=RequestMethod.POST)
    public boolean addNewFoodLocation(@RequestBody FoodLocation loc) {
        return foodLocationService.insertNewFoodLocation(loc)==1;
    }
    
    @RequestMapping(value="/getfoodlocationbyname", method=RequestMethod.POST)
    public List<FoodLocation> getFoodlocationbyName(@RequestBody FoodLocation loc) {
        return foodLocationService.getFoodlocationByLocationName(loc.getName());
    }
    
    @RequestMapping(value="/getfoodtypes", method=RequestMethod.GET)
    public Map<Integer, String> getFoodTypes() {
        return foodLocationService.getAllTypesOfFood();
    }
    
    @RequestMapping(value="/addNewFavorite", method=RequestMethod.POST)
    public int insertNewFavoriteByUsername(@RequestBody FavoriateDo favoriateDo) {
        FavoriteDBDO dbdo = new FavoriteDBDO();
        dbdo.setLocationId(favoriateDo.getLocationId());
        dbdo.setUserName(favoriateDo.getUserName());
        return favoriteMapper.insertNewFavorite(dbdo);
    }
    
    @RequestMapping(value="/addNewFriend", method=RequestMethod.POST)
    public int insertNewFriendByUsername(@RequestBody FriendDo friendDo) {
        FriendsDBDO dbdo = new FriendsDBDO();
        dbdo.setMasterFriend(friendDo.getUserName());
        dbdo.setSlaveFriend(friendDo.getFriendUserName());
        return friendsMapper.insertNewFriend(dbdo);
    }
    
    @RequestMapping(value="/addNewPost", method=RequestMethod.POST)
    public int insertNewPost(@RequestBody PostDo PostDo) {
        return postService.insertPost(PostDo);
    }
    
    @RequestMapping(value="/getPostsByLocId", method=RequestMethod.GET)
    public List<PostDo> insertNewPost(@RequestParam("locId") int locationId) {
        return postService.getPosts(locationId);
    }

    @RequestMapping(value="/nearByRange", method=RequestMethod.GET)
    public List<FoodLocation> nearByRange(@RequestParam("longitude") String longitude, @RequestParam("latitude") String lat, @RequestParam("radius") double radius) {
        return foodLocationService.nearByRange(longitude,lat, radius);
    }

    @RequestMapping(value="/nearByRangeKNN", method=RequestMethod.GET)
    public List<FoodLocation> nearByRange(@RequestParam("longitude") String longitude, @RequestParam("latitude") String lat, @RequestParam("radius") double radius, @RequestParam("k") int k) {
        return foodLocationService.nearByknn(longitude,lat, radius, k);
    }

    @RequestMapping(value="/getBestFoodTypeByRange", method=RequestMethod.GET)//http://localhost:8080/icampusfood/rest/getBestFoodTypeByRange.mvc?longitude=100&latitude=100&radius=100
    public Profile profile(@RequestParam("longitude") double longitude, @RequestParam("latitude") double lat, @RequestParam("radius") double radius) {
        return foodLocationService.getBestFoodTypeByRange(longitude,lat,radius);
    }

    @RequestMapping(value="/nearByRangeKNNTime", method=RequestMethod.GET)
    public List<FoodLocation> nearByRangeKNNTime(@RequestParam("longitude") double longitude, @RequestParam("latitude") double lat, @RequestParam("radius") double radius, @RequestParam("k") int k, @RequestParam("hour") int hour ,@RequestParam("min") int min ,@RequestParam("sec") int sec) {
        return foodLocationService.nearByknnTime(longitude,lat, radius, k, hour, min, sec);
    }

    @RequestMapping(value="/weeklyData", method=RequestMethod.GET)
    public List<CrowdData> nearByRangeKNNTime(@RequestParam("locationId") int locationId) {
        return dataService.getWeeklyCrowdData(locationId);
    }


    @RequestMapping(value="/getBestByTypeOrCrowd", method=RequestMethod.GET)//http://localhost:8080/icampusfood/rest/getBestByTypeOrCrowd.mvc?longitude=-118.2829198&latitude=34.0242493&radius=3000&k=3&foodType=1&category=1
    public List<FoodLocation> getBestByTypeOrCrowd(@RequestParam("longitude") double longitude, @RequestParam("latitude") double latitude, @RequestParam("radius") double radius, @RequestParam("k") int k, @RequestParam("foodType") int foodType,  @RequestParam("category") int category) {
        return foodLocationService.getBestFoodLocationByFoodOrCrowd(longitude, latitude, radius, k, foodType, category);
    }

    @RequestMapping(value="/isFriendFavorite", method=RequestMethod.GET)//http://localhost:8080/icampusfood/rest/isFriendFavorite.mvc?username=rayyy&locationId=342
    public Boolean isFriendFavorite(@RequestParam("username") String username, @RequestParam("locationId") int locationId) {
        return foodLocationService.isFriendFavorite(username, locationId);
    }


    /*
    Yelp
     */
    @RequestMapping(value = "/yelptest")
    public YelpBusinessEntity yelptest() {
        YelpApi api = new YelpApi();
        YelpBusinessEntity e = api.queryYelpBusinessEntityByBusinessId("vege-paradise-san-gabriel");
        //log.debug("@@@@@@@@@@@@@@@@@ DEBUG: yelp business name:"+e.getName());
        //log.debug("@@@@@@@@@@@@@@@@@ DEBUG: yelp business phone:"+e.getPhone());
        //log.debug("@@@@@@@@@@@@@@@@@ DEBUG: yelp business rating:"+e.getRating());
        return e;
    }

    @RequestMapping(value = "/yelptest2")
    public void yelptest2() {
        YelpApi api = new YelpApi();
        List<FoodLocationDBDO> list = api.queryYelpFoodByGet();
        for(FoodLocationDBDO loc : list) foodLocationService.insertNewFoodLocationDbdo(loc);
    }

    
}
