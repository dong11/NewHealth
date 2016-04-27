package com.dong.huang.healthapp.beans;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by dong on 16/3/14.
 */
public class ShareBean implements Parcelable {
    private String name;
    private int imgRes;
    private int id;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ShareBean(String name, int imgRes, int id) {
        this.name = name;
        this.imgRes = imgRes;
        this.id = id;
    }

    @Override
    public String toString() {
        return "ShareBean{" +
                "name='" + name + '\'' +
                ", imgRes=" + imgRes +
                ", id=" + id +
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
        dest.writeInt(this.id);
    }

    protected ShareBean(Parcel in) {
        this.name = in.readString();
        this.imgRes = in.readInt();
        this.id = in.readInt();
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
