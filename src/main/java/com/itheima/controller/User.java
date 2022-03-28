package com.itheima.controller;

/**
 * @author 10908
 */
public class User {
    public int getIp() {
        return ip;
    }

    public void setIp(int ip) {
        this.ip = ip;
    }

    public int getX() {
        return X;
    }

    public void setX(int x) {
        X = x;
    }

    public int getY() {
        return Y;
    }

    public void setY(int y) {
        Y = y;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHouseImageEncoded() {
        return houseImageEncoded;
    }

    public void setHouseImageEncoded(int houseImageEncoded) {
        this.houseImageEncoded = houseImageEncoded;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getFellImageEncoded() {
        return fellImageEncoded;
    }

    public void setFellImageEncoded(int fellImageEncoded) {
        this.fellImageEncoded = fellImageEncoded;
    }

    private int ip;
    private int X;
    private int Y;
    private int id;
    private int houseImageEncoded;
    private int state;
    private int fellImageEncoded;
    private String locationTime;

    public String getLocationTime() {
        return locationTime;
    }

    public void setLocationTime(String locationTime) {
        this.locationTime = locationTime;
    }

    public String getHouseImageTime() {
        return houseImageTime;
    }

    public void setHouseImageTime(String houseImageTime) {
        this.houseImageTime = houseImageTime;
    }

    public String getStateTime() {
        return stateTime;
    }

    public void setStateTime(String stateTime) {
        this.stateTime = stateTime;
    }

    public String getShotTime() {
        return shotTime;
    }

    public void setShotTime(String shotTime) {
        this.shotTime = shotTime;
    }

    private String houseImageTime;
    private String stateTime;
    private String shotTime;

}
