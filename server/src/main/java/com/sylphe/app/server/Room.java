package com.sylphe.app.server;

import com.sylphe.app.dto.LocData;
import com.sylphe.app.dto.RoomConfig;
import com.sylphe.app.dto.UserData;
import com.sylphe.app.dto.UserProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by myks7 on 2016-03-14.
 */
class Room {
    private int roomId;
    private int maxGameMember;
//    private int currentChaserNum, currentFugitiveNum;
    private LocData centerLoc;
    private int scale;
    private List<UserData> userList;
    private int timeLimit;

    Room(int roomId, RoomConfig config){
        userList = new ArrayList<UserData>();
        this.roomId = roomId;
        maxGameMember = config.getMaxGameMember();
        scale = config.getScale();
        centerLoc = config.getCenterLoc();
        timeLimit = config.getTimeLimit();
    }

    int getRoomId() {
        return roomId;
    }

    RoomConfig getRoomConfig(){
        return new RoomConfig(roomId,centerLoc,maxGameMember,scale,timeLimit);
    }

    void addUser(UserData user){
        userList.add(user);
    }

    private UserData searchUser(int userId){
        for(UserData userData : userList){
            if(userData.getId() == userId){
                return userData;
            }
        }
        return null;
    }

    void searchUserAndUpdateLoc(UserData userData) {
        UserData user = searchUser(userData.getId());
        if (user != null) {
            user.setLocData(userData.getLocData());
        }else{
            System.out.println("searchUserAndUpdate user null error");
        }
    }

    List<UserData> getUserList() {
        return userList;
    }

    void dieUser(int userId){
        UserData userData = searchUser(userId);
        assert userData==null:"missing user";
        userData.setUserProperties(UserProperties.GHOST);
    }

    int getRoomID() {
        return roomId;
    }

    int getMaxGameMember() {
        return maxGameMember;
    }

    int getTimeLimit() {
        return timeLimit;
    }

    int getScale() {
        return scale;
    }
}
