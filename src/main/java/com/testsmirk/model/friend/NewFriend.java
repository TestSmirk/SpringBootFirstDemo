package com.testsmirk.model.friend;


import java.util.List;

/**
 * Created by testsmirk on 2017/4/25.
 */

public class NewFriend  {
    private int newFriend;
    private List<FriendModel> friendModel;

    public int getNewFriend() {
        return newFriend;
    }

    public void setNewFriend(int newFriend) {
        this.newFriend = newFriend;
    }

    public List<FriendModel> getFriendModel() {
        return friendModel;
    }

    public void setFriendModel(List<FriendModel> friendModel) {
        this.friendModel = friendModel;
    }
}
