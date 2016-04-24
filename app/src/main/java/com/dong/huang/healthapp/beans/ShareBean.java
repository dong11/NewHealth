package com.dong.huang.healthapp.beans;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by dong on 16/3/14.
 */
public class ShareBean implements Parcelable {
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


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeInt(this.imgRes);
    }

    protected ShareBean(Parcel in) {
        this.name = in.readString();
        this.imgRes = in.readInt();
    }

    public static final Parcelable.Creator<ShareBean> CREATOR = new Parcelable.Creator<ShareBean>() {
        public ShareBean createFromParcel(Parcel source) {
            return new ShareBean(source);
        }

        public ShareBean[] newArray(int size) {
            return new ShareBean[size];
        }
    };
}
