/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cs587.icampusfood.dataObjects;

import com.cs587.icampusfood.persistence.dataObjects.PostDBDO;
import com.cs587.icampusfood.util.DateTimeUtil;


/**
 *
 * @author Joey
 */
public class PostDo {
    private int postId;
    private int locationId;
    private double foodRating;
    private double serviceRating;
    private double crowdedness;
    private String postDate;
    private String postTime;

    public PostDo(PostDBDO dbdo) {
        this.postId = dbdo.getPostId();
        this.locationId = dbdo.getLocationId();
        this.foodRating = dbdo.getFoodRating();
        this.serviceRating = dbdo.getServiceRating();
        this.crowdedness = dbdo.getCrowdedness();
        this.postDate = DateTimeUtil.getYearMonthDayStringFromTimestamp(dbdo.getPostTime());
        this.postTime = DateTimeUtil.getHourMinStringFromTimestamp(dbdo.getPostTime());
    }

    public PostDo() {
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public double getFoodRating() {
        return foodRating;
    }

    public void setFoodRating(double foodRating) {
        this.foodRating = foodRating;
    }

    public double getServiceRating() {
        return serviceRating;
    }

    public void setServiceRating(double serviceRating) {
        this.serviceRating = serviceRating;
    }

    public double getCrowdedness() {
        return crowdedness;
    }

    public void setCrowdedness(double crowdedness) {
        this.crowdedness = crowdedness;
    }

    public String getPostTime() {
        return postTime;
    }

    public void setPostTime(String postTime) {
        this.postTime = postTime;
    }

    public String getPostDate() {
        return postDate;
    }

    public void setPostDate(String postDate) {
        this.postDate = postDate;
    }
    
    
}
