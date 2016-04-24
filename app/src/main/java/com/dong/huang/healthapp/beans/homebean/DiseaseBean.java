package com.dong.huang.healthapp.beans.homebean;

/**
 * @author dong {hwongrex@gmail.com}
 * @date 16/4/22
 * @time 下午11:25
 */

public class DiseaseBean {
    private String mTitle;
    private int imgRes;
    private boolean flag;
    private int arrows;

    public DiseaseBean(String title, int imgRes, boolean flag, int arrows) {
        mTitle = title;
        this.imgRes = imgRes;
        this.flag = flag;
        this.arrows = arrows;
    }

    public DiseaseBean() {
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public int getImgRes() {
        return imgRes;
    }

    public void setImgRes(int imgRes) {
        this.imgRes = imgRes;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public int getArrows() {
        return arrows;
    }

    public void setArrows(int arrows) {
        this.arrows = arrows;
    }
}
