package com.cs587.icampusfood.persistence.dataObjects;
import org.postgis.PGgeometry;
import org.postgis.Point;


import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by longpengjiao on 9/28/15.
 */
public class FoodLocationDBDO implements Serializable {

    private int locationId;
    private String name;
    private int foodType;
    private double avgFoodRating;
    private double avgServiceRating;
    private Timestamp openTime;
    private Timestamp closeTime;
    private Timestamp startDate;
    private Timestamp endDate;
    private double distance;

    private double avgCrowdedness;
    private Object location;

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }




    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFoodType() {
        return foodType;
    }

    public void setFoodType(int foodType) {
        this.foodType = foodType;
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

    public Object getLocation() {
        return location;
    }

    public void setLocation(Object location) {

        this.location = location;
    }

    public Timestamp getOpenTime() {
        return openTime;
    }

    public void setOpenTime(Timestamp openTime) {
        this.openTime = openTime;
    }

    public Timestamp getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Timestamp closeTime) {
        this.closeTime = closeTime;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    public double getAvgCrowdedness() {
        return avgCrowdedness;
    }

    public void setAvgCrowdedness(double avgCrowdedness) {
        this.avgCrowdedness = avgCrowdedness;
    }

}
