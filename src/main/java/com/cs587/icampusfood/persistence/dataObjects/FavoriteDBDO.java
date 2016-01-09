package com.cs587.icampusfood.persistence.dataObjects;

/**
 * Created by longpengjiao on 10/4/15.
 */
public class FavoriteDBDO {
    private int favoriteId;
    private int locationId;

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    private String userName;

    public int getFavoriteId() {
        return favoriteId;
    }

    public void setFavoriteId(int favoriteId) {
        this.favoriteId = favoriteId;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
