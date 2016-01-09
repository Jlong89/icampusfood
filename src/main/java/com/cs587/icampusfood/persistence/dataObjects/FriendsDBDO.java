package com.cs587.icampusfood.persistence.dataObjects;

/**
 * Created by longpengjiao on 10/2/15.
 */
public class FriendsDBDO {
    private String masterFriend;
    private String slaveFriend;

    public String getMasterFriend() {
        return masterFriend;
    }

    public void setMasterFriend(String masterFriend) {
        this.masterFriend = masterFriend;
    }

    public String getSlaveFriend() {
        return slaveFriend;
    }

    public void setSlaveFriend(String slaveFriend) {
        this.slaveFriend = slaveFriend;
    }
}
