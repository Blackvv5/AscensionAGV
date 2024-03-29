package com.itheima.controller;

/**
 * @author 10908
 */
public class User {

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public double getX() {
        return X;
    }

    public void setX(double x) {
        X = x;
    }

    public double getY() {
        return Y;
    }

    public void setY(double y) {
        Y = y;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHouseImageEncoded() {
        return houseImageEncoded;
    }

    public void setHouseImageEncoded(String houseImageEncoded) {
        this.houseImageEncoded = houseImageEncoded;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getFellImageEncoded() {
        return fellImageEncoded;
    }

    public void setFellImageEncoded(String fellImageEncoded) {
        this.fellImageEncoded = fellImageEncoded;
    }

    private String ip;
    private double X;
    private double Y;
    private int id;
    private String houseImageEncoded;
    private int state;
    private String fellImageEncoded;
    private String locationTime;
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

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


    String name;
    int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
