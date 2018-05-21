package com.example.scout_zong.tool.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.ArrayMap;
import android.util.Log;

import java.util.ArrayList;

public class HomeBean implements Parcelable {
    private String name;
    private String pingfen;
    private int jiage;
    private String dizhi;
    private int waiguan;
    public ArrayList<HomeActAdapterBean> mAdApterList;

    public HomeBean(String name, String pingfen, int jiage, int waiguan) {
        this.name = name;
        this.pingfen = pingfen;
        this.jiage = jiage;
        this.waiguan = waiguan;

    }
//    public HomeBean(String name, String dizhi, int waiguan,ArrayList<lndentBean> lndentBeans) {
//        this.name = name;
//        this.pingfen = pingfen;
//        this.dizhi = dizhi;
//        this.waiguan = waiguan;
//        this.lndentBeans=lndentBeans;
//
//    }


    public void setWaiguan(int waiguan) {
        this.waiguan = waiguan;
    }

    /**<---------------------------></--------------------------->**/





    public HomeBean() {
            mAdApterList=new ArrayList<HomeActAdapterBean>();
    }
    public void addData(HomeActAdapterBean Bean){
        mAdApterList.add(Bean);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDizhi(String dizhi) {
        this.dizhi = dizhi;
    }
    public String getDizhi() {
        return dizhi;
    }

    /**<-------------------------->**/







    public String getName() {
        return name;
    }

    public String getPingfen() {
        return pingfen;
    }

    public int getJiage() {
        return jiage;
    }

    public int getWaiguan() {
        return waiguan;
    }

    protected HomeBean(Parcel in) {
        name = in.readString();
        pingfen = in.readString();
        jiage = in.readInt();
        waiguan = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(pingfen);
        dest.writeInt(jiage);
        dest.writeInt(waiguan);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<HomeBean> CREATOR = new Creator<HomeBean>() {
        @Override
        public HomeBean createFromParcel(Parcel in) {
            return new HomeBean(in);
        }

        @Override
        public HomeBean[] newArray(int size) {
            return new HomeBean[size];
        }
    };


}
