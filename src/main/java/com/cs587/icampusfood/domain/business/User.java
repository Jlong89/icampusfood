/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cs587.icampusfood.domain.business;

import java.util.List;

/**
 */
public class User{
    private int userId;
    private String userName;
    private String password;
    private List<Integer> favoriateLocationIdList;
    private List<String> friends;//Username

    public User() {
    }

    public User(int userId, String userName, String password, List<Integer> favoriateLocationIdList, List<String> friends) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.favoriateLocationIdList = favoriateLocationIdList;
        this.friends = friends;
    }

    
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Integer> getFavoriateLocationIdList() {
        return favoriateLocationIdList;
    }

    public void setFavoriateLocationIdList(List<Integer> favoriateLocationIdList) {
        this.favoriateLocationIdList = favoriateLocationIdList;
    }

    public List<String> getFriends() {
        return friends;
    }

    public void setFriends(List<String> friends) {
        this.friends = friends;
    }
    
    
    
}
