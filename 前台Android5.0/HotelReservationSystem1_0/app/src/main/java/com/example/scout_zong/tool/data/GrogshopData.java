package com.example.scout_zong.tool.data;

import com.example.scout_zong.tool.bean.HomeBean;

import java.util.ArrayList;

/**
 * Created by scout_zong on 2018/4/13.
 */

public class GrogshopData {
    private ArrayList<HomeBean> mList;
    private HomeBean mHomeBean;
    private GrogshopData(ArrayList<HomeBean> mList)
    {
        this.mList=mList;

    }
    public void addHomeBeanList()
    {
//        mHomeBean.setFangxing();
    }
    public ArrayList<HomeBean> getmList() {
        return mList;
    }
}
