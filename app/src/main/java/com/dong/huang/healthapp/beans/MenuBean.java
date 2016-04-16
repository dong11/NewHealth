package com.dong.huang.healthapp.beans;

public class MenuBean {
    private int bitmapID;
    private String context;

    public MenuBean() {
    }

    public MenuBean(int bitmapID, String context) {
        this.bitmapID = bitmapID;
        this.context = context;
    }

    public int getBitmapID() {
        return bitmapID;
    }

    public void setBitmapID(int bitmapID) {
        this.bitmapID = bitmapID;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    @Override
    public String toString() {
        return "MenuBean{" +
                "bitmapID=" + bitmapID +
                ", context='" + context + '\'' +
                '}';
    }
}
