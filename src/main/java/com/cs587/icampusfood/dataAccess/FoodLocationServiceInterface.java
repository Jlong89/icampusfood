/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cs587.icampusfood.dataAccess;

import com.cs587.icampusfood.domain.business.FoodLocation;
import com.cs587.icampusfood.domain.business.Profile;
import com.cs587.icampusfood.persistence.dataObjects.FoodLocationDBDO;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Joey
 */
public interface FoodLocationServiceInterface {
    
    int insertNewFoodLocation(FoodLocation loc);

    int insertNewFoodLocationDbdo(FoodLocationDBDO loc);
    
    Map<Integer, String> getAllTypesOfFood();

    List<FoodLocation> getFoodlocationByLocationName(String name);

    List<FoodLocation> nearByRange(String longitude, String lat, double radius);

    List<FoodLocation> nearByknn(String longitude, String lat, double radius, int k);

    List<FoodLocation> nearByknnTime(double longitude, double lat, double radius, int k, int hour, int min, int sec);

    List<FoodLocation> getBestFoodLocationByFoodOrCrowd(double longitude, double latitude, double radius, int k, int type, int category);

    Profile getBestFoodTypeByRange(double longitude, double latitude, double radius);

    Boolean isFriendFavorite(String userName, int locationId);
}
