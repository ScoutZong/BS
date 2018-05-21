package com.example.scout_zong.tool.bean;

/**
 * Created by scout_zong on 2018/5/10.
 */

public class lndentBean {
    private int log;
    private int jiage;
    private String name;
    private String shijian;

    public lndentBean(int log, int jiage, String name, String shijian) {
        this.log = log;
        this.jiage = jiage;
        this.name = name;
        this.shijian = shijian;
    }

    public lndentBean() {

    }

    public void setWaiguan(int log) {
        this.log = log;
    }

    public void setJiage(int jiage) {
        this.jiage = jiage;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setShijian(String shijian) {
        this.shijian = shijian;
    }

    public int getLog() {
        return log;
    }

    public int getJiage() {
        return jiage;
    }

    public String getName() {
        return name;
    }

    public String getShijian() {
        return shijian;
    }
}
