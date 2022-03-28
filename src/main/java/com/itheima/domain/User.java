package com.itheima.domain;


public class User {
    public int getIp() {
        return ip;
    }

    public void setIp(int ip) {
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
    private double X;
    private double Y;
    private int id;
    private int houseImageEncoded;
    private int state;
    private int fellImageEncoded;

}
