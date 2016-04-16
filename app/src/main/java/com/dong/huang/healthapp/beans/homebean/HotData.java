package com.dong.huang.healthapp.beans.homebean;

/**
 * Created by dong on 16/2/15.
 * 热门资讯对象
 */
public class HotData {
    private int id;
    private String smallImg;
    private String title;
    private String h5Img;
    private String dateShow;
    private String summary;

    public HotData() {
    }

    public HotData(int id, String smallImg, String title, String h5Img, String dateShow, String summary) {
        this.id = id;
        this.smallImg = smallImg;
        this.title = title;
        this.h5Img = h5Img;
        this.dateShow = dateShow;
        this.summary = summary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSmallImg() {
        return smallImg;
    }

    public void setSmallImg(String smallImg) {
        this.smallImg = smallImg;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getH5Img() {
        return h5Img;
    }

    public void setH5Img(String h5Img) {
        this.h5Img = h5Img;
    }

    public String getDateShow() {
        return dateShow;
    }

    public void setDateShow(String dateShow) {
        this.dateShow = dateShow;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Override
    public String toString() {
        return "HotData{" +
                "id=" + id +
                ", smallImg='" + smallImg + '\'' +
                ", title='" + title + '\'' +
                ", h5Img='" + h5Img + '\'' +
                ", dateShow='" + dateShow + '\'' +
                ", summary='" + summary + '\'' +
                '}';
    }
}
