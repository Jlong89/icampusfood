package com.cs587.icampusfood.domain.business;

import com.cs587.icampusfood.persistence.dataObjects.ProfileDBDO;

/**
 */
public class Profile {
    private int foodType;
    private double rating;

    public Profile() {
    }

    public Profile(ProfileDBDO dbdo) {
        this.foodType = dbdo.getFoodType();
        this.rating = dbdo.getRating();
    }

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
