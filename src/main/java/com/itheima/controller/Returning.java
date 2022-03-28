package com.itheima.controller;

public class Returning {
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    private String state;
    private String massage;
}
