/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cs587.icampusfood.dataAccess;

import com.cs587.icampusfood.domain.business.FoodLocation;
import com.cs587.icampusfood.domain.business.Profile;
import com.cs587.icampusfood.persistence.businessMappers.FoodLocationMapper;
import com.cs587.icampusfood.persistence.businessMappers.ProfileMapper;
import com.cs587.icampusfood.persistence.dataObjects.FoodLocationDBDO;
import com.cs587.icampusfood.persistence.dataObjects.ProfileDBDO;
import com.cs587.icampusfood.util.DateTimeUtil;

import java.sql.Timestamp;
import java.util.*;

import org.postgis.PGgeometry;
import org.postgis.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Joey
 */
@Service("foodService")
public class FoodLocationServiceImpl implements FoodLocationServiceInterface {

    private FoodLocationMapper foodLocationMapper;
    private ProfileMapper profileMapper;

    @Autowired
    public void setFoodLocationMapper(FoodLocationMapper foodLocationMapper) {
        this.foodLocationMapper = foodLocationMapper;
    }

    @Autowired
    public void setProfileMapper(ProfileMapper profileMapper) {
        this.profileMapper = profileMapper;
    }

    @Override
    public int insertNewFoodLocation(FoodLocation loc) {
        Calendar calendar = Calendar.getInstance();
        FoodLocationDBDO dbdo = new FoodLocationDBDO();
        dbdo.setName(loc.getName());
        dbdo.setFoodType(loc.getFoodType());
        dbdo.setAvgFoodRating(loc.getAvgFoodRating());
        dbdo.setAvgServiceRating(loc.getAvgServiceRating());
        if (DateTimeUtil.getHourFromTimeString(loc.getOpenTime()) < 0 || DateTimeUtil.getMinFromTimeString(loc.getOpenTime()) < 0)
            return -1;
        calendar.set(0, 0, 0, DateTimeUtil.getHourFromTimeString(loc.getOpenTime()), DateTimeUtil.getMinFromTimeString(loc.getOpenTime()));
        dbdo.setOpenTime(new Timestamp(calendar.getTimeInMillis()));
        calendar.set(0, 0, 0, DateTimeUtil.getHourFromTimeString(loc.getCloseTime()), DateTimeUtil.getMinFromTimeString(loc.getCloseTime()));
        dbdo.setCloseTime(new Timestamp(calendar.getTimeInMillis()));
        if (DateTimeUtil.getYearFromDateString(loc.getStartDate()) < 0 || DateTimeUtil.getMonthFromDateString(loc.getStartDate()) < 0 || DateTimeUtil.getDayFromDateString(loc.getStartDate()) < 0)
            return -1;
        calendar.set(DateTimeUtil.getYearFromDateString(loc.getStartDate()), DateTimeUtil.getMonthFromDateString(loc.getStartDate()), DateTimeUtil.getDayFromDateString(loc.getStartDate()), 0, 0);
        dbdo.setStartDate(new Timestamp(calendar.getTimeInMillis()));
        calendar.set(DateTimeUtil.getYearFromDateString(loc.getEndDate()), DateTimeUtil.getMonthFromDateString(loc.getEndDate()), DateTimeUtil.getDayFromDateString(loc.getEndDate()), 0, 0);
        dbdo.setEndDate(new Timestamp(calendar.getTimeInMillis()));

        Point newPoint = new Point(loc.getCoordinate().getXcoord(), loc.getCoordinate().getYcoord());
        dbdo.setLocation(new PGgeometry(newPoint));
        dbdo.setAvgCrowdedness(loc.getAvgCrowdedness());

        int ret = foodLocationMapper.insertNewFoodLocation(dbdo);
        return ret;
    }

    @Override
    public int insertNewFoodLocationDbdo(FoodLocationDBDO loc) {
        int ret = foodLocationMapper.insertNewFoodLocation(loc);
        return ret;
    }

    @Override
    public Map<Integer, String> getAllTypesOfFood() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "fast food");
        map.put(2, "italian");
        map.put(3, "chinese");
        map.put(4, "mexican");
        map.put(5, "snack");
        map.put(6, "bar/cafe,");
        map.put(7, "fusion");
        map.put(7, "japanese");


        return map;
    }

    @Override
    public List<FoodLocation> getFoodlocationByLocationName(String name) {
        List<FoodLocationDBDO> list = foodLocationMapper.getFoodLocation(name);
        if (list == null) return null;
        List<FoodLocation> ret = new ArrayList<>(list.size());
        for (FoodLocationDBDO x : list) ret.add(new FoodLocation(x));
        return ret;
    }

    @Override
    public List<FoodLocation> nearByRange(String longitude, String lat, double radius) {
        String pointString = "Point(" + longitude + " " + lat + ")";
        List<FoodLocationDBDO> dbdoList = foodLocationMapper.getLocsWithinRange(pointString, radius);
        List<FoodLocation> ret = new ArrayList<>(dbdoList.size());
        for (FoodLocationDBDO x : dbdoList) {
            FoodLocation y = new FoodLocation(x);
            ret.add(y);
        }
        return ret;
    }

    @Override
    public List<FoodLocation> nearByknn(String longitude, String lat, double radius, int k) {
        List<FoodLocationDBDO> dbdoList = foodLocationMapper.getKnn(k, Double.parseDouble(longitude), Double.parseDouble(lat), radius);
        List<FoodLocation> ret = new ArrayList<>(dbdoList.size());
        for (FoodLocationDBDO x : dbdoList) {
            FoodLocation y = new FoodLocation(x);
            y.setDistance(x.getDistance());
            ret.add(y);
        }
        return ret;
    }

    @Override
    public Profile getBestFoodTypeByRange(double longitude, double latitude, double radius) {
        ProfileDBDO x = profileMapper.getProfile(longitude, latitude, radius);
        if (x == null) return null;
        return new Profile(profileMapper.getProfile(longitude, latitude, radius));
    }

    @Override
    public List<FoodLocation> nearByknnTime(double longitude, double latitude, double radius, int k, int hour, int min, int sec) {
        String time = "0/0/0 " + hour + ":" + min + ":" + sec;
        List<FoodLocationDBDO> list = foodLocationMapper.getLocsWithinRangeTime(k, longitude, latitude, radius, time);
        List<FoodLocation> ret = new ArrayList<>(list.size());
        for (FoodLocationDBDO x : list) {
            ret.add(new FoodLocation(x));
        }
        return ret;
    }

    /*
    1. avgFoodRating
    2. avgServiceRating
    3. avgCrowdedness
     */
    @Override
    public List<FoodLocation> getBestFoodLocationByFoodOrCrowd(double longitude, double latitude, double radius, int k, int foodType, int category){
        String categoryStr = "avgFoodRating";
        if(category==2) categoryStr = "avgServiceRating";
        else if(category==3) categoryStr = "avgCrowdedness";
        List<FoodLocationDBDO> list = foodLocationMapper.getKBestWithinRange(k, longitude,latitude, radius, foodType, categoryStr);
        List<FoodLocation> ret = new ArrayList<>(list.size());
        for (FoodLocationDBDO x : list) {
            ret.add(new FoodLocation(x));
        }
        return ret;
    }

    @Override
    public Boolean isFriendFavorite(String userName, int locationId){
        return foodLocationMapper.isFriendFavorite(userName, locationId);
    }
}
