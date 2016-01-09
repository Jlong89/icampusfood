package com.cs587.icampusfood.persistence.dataObjects;

/**
 * Created by longpengjiao on 11/17/15.
 */
public class ProfileDBDO {
    private int foodType;
    private double rating;

    public int getFoodType() {
        return foodType;
    }

    public void setFoodType(int foodType) {
        this.foodType = foodType;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
