package com.cs587.icampusfood.persistence.dataObjects;

/**
 * Created by longpengjiao on 9/23/15.
 */
public class TokenDBDO {
    private String token;
    private int userId;

    public void setToken(String token){
        this.token = token;
    }

    public void setUserId(int userId){
        this.userId=userId;
    }

    public String getToken(){
        return token;
    }
    public int getUserId(){
        return userId;
    }
}
