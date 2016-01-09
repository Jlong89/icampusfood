package com.cs587.icampusfood.persistence.dataObjects;

import java.sql.Timestamp;

/**
 * Created by longpengjiao on 10/25/15.
 */
public class PostDBDO {
    private int postId;
    private int locationId;
    private double foodRating;
    private double serviceRating;
    private double crowdedness;
    private Timestamp postTime;

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

    public Timestamp getPostTime() {
        return postTime;
    }

    public void setPostTime(Timestamp postTime) {
        this.postTime = postTime;
    }
}
