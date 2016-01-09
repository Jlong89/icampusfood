/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cs587.icampusfood.domain.business;

import com.cs587.icampusfood.domain.geo.Point;
import com.cs587.icampusfood.persistence.dataObjects.FoodLocationDBDO;
import com.cs587.icampusfood.util.DateTimeUtil;
import org.postgis.PGgeometry;

/**
 */
public class FoodLocation {
    int locationId;
    private String name;
    private Point coordinate;
    private double avgFoodRating;
    private double avgServiceRating;
    private double avgCrowdedness;
    private String openTime;
    private String closeTime;
    private String startDate;
    private String endDate;//null if permanent
    private int foodType;
    private double distance;

    public FoodLocation() {
    }
    
    public FoodLocation(FoodLocationDBDO o) {
        this.locationId = o.getLocationId();
        this.name = o.getName();
        Point p = new Point();
        PGgeometry geom = (PGgeometry) o.getLocation();
        org.postgis.Point point = (org.postgis.Point) geom.getGeometry();
        p.setXcoord(point.getX());
        p.setYcoord(point.getY());
        this.coordinate = p;
        this.foodType = o.getFoodType();
        this.avgFoodRating = o.getAvgFoodRating();
        this.avgServiceRating = o.getAvgServiceRating();
        this.avgCrowdedness = o.getAvgCrowdedness();
        this.openTime = DateTimeUtil.getHourMinStringFromTimestamp(o.getOpenTime());
        this.closeTime = DateTimeUtil.getHourMinStringFromTimestamp(o.getCloseTime());
        this.startDate = DateTimeUtil.getMonthDayStringFromDate(o.getStartDate());
        if(o.getEndDate()!=null) this.endDate = DateTimeUtil.getMonthDayStringFromDate(o.getEndDate());
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Point getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Point coordinate) {
        this.coordinate = coordinate;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public double getAvgFoodRating() {
        return avgFoodRating;
    }

    public void setAvgFoodRating(double avgFoodRating) {
        this.avgFoodRating = avgFoodRating;
    }

    public double getAvgServiceRating() {
        return avgServiceRating;
    }

    public void setAvgServiceRating(double avgServiceRating) {
        this.avgServiceRating = avgServiceRating;
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    public String getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(String closeTime) {
        this.closeTime = closeTime;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public double getAvgCrowdedness() {
        return avgCrowdedness;
    }

    public void setAvgCrowdedness(double avgCrowdedness) {
        this.avgCrowdedness = avgCrowdedness;
    }

    public int getFoodType() {
        return foodType;
    }

    public void setFoodType(int foodType) {
        this.foodType = foodType;
    }
    
    

    
}
