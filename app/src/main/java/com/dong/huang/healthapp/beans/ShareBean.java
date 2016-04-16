package com.dong.huang.healthapp.beans;

/**
 * Created by dong on 16/3/14.
 */
public class ShareBean {
    private String name;
    private int imgRes;

    public ShareBean() {
    }

    public ShareBean(String name, int imgRes) {
        this.name = name;
        this.imgRes = imgRes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImgRes() {
        return imgRes;
    }

    public void setImgRes(int imgRes) {
        this.imgRes = imgRes;
    }

    @Override
    public String toString() {
        return "ShareBean{" +
                "name='" + name + '\'' +
                ", imgRes=" + imgRes +
                '}';
    }
}
