package com.example.scout_zong.tool.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by scout_zong on 2018/4/13.
 */

public class HomeActAdapterBean implements Parcelable {
    private String name;
    private int shengyu;
    private int jiage;

    /***********************************/
    public HomeActAdapterBean() {
    }

    protected HomeActAdapterBean(Parcel in) {
        name = in.readString();
        shengyu = in.readInt();
        jiage = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(shengyu);
        dest.writeInt(jiage);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<HomeActAdapterBean> CREATOR = new Creator<HomeActAdapterBean>() {
        @Override
        public HomeActAdapterBean createFromParcel(Parcel in) {
            return new HomeActAdapterBean(in);
        }

        @Override
        public HomeActAdapterBean[] newArray(int size) {
            return new HomeActAdapterBean[size];
        }
    };

    public void setName(String name) {
        this.name = name;
    }

    public void setShengyu(int shengyu) {
        this.shengyu = shengyu;
    }

    public void setJiage(int jiage) {
        this.jiage = jiage;
    }

    /**********************************/
    public HomeActAdapterBean(String name, int shengyu, int jiage) {
        this.name = name;
        this.shengyu = shengyu;
        this.jiage = jiage;
    }


    public String getName() {
        return name;
    }

    public int getShengyu() {
        return shengyu;
    }

    public int getJiage() {
        return jiage;
    }
}
