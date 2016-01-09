/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cs587.icampusfood.domain.business;

/**
 *
 * @author Joey
 */
public class YelpBusinessEntity {
    private String url;
    private String name;
    private String phone;
    private double rating;
    private long reviewNumber;

    public YelpBusinessEntity() {
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public long getReviewNumber() {
        return reviewNumber;
    }

    public void setReviewNumber(long reviewNumber) {
        this.reviewNumber = reviewNumber;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
}
