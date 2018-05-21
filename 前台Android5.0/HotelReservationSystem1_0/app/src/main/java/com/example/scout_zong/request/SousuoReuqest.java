package com.example.scout_zong.request;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.scout_zong.tool.Tool;
import com.example.scout_zong.tool.bean.HomeActAdapterBean;
import com.example.scout_zong.tool.bean.HomeBean;

import java.util.ArrayList;

/**
 * Created by scout_zong on 2018/5/16.
 */

public class SousuoReuqest extends BaseRequest {


    private Tool tool;
    private HomeBean ben;
    private HomeActAdapterBean homeActAdapterBean;
    private String sousuo;



    public ArrayList<HomeBean> getArrayList() {
        return beanArrayList;
    }

    private ArrayList<HomeBean> beanArrayList;

    public SousuoReuqest() {
        setSERLATTAG("onServlet", 3);
        beanArrayList = new ArrayList<>();



    }

    public void setSousuo(String sousuo) {
        this.sousuo = sousuo;
    }

    @Override
    public String getURLBody() {
        return "&sousuo="+sousuo;
    }


    @Override
    public void analysisJSON() {
        super.analysisJSON();
        try {
            //fastjson解析数据
//            JSONObject jsonObject = JSON.parseObject(requestString);
            JSONArray array = JSON.parseArray(requestString);
            for (int i = 0; i < array.size(); i++) {

                ben = new HomeBean();

                JSONObject jo1 = JSON.parseObject(array.get(i).toString());
                ben.setName(jo1.getString("Homename"));
                ben.setDizhi(jo1.getString("HomeAdder"));
                System.out.println(jo1.getString("Homename"));
                init(ben,jo1.getInteger("log"));
                String list = jo1.getString("list");
                JSONArray listArray = JSONArray.parseArray(list);
                for (int j = 0; j < listArray.size(); j++) {
                    homeActAdapterBean = new HomeActAdapterBean();
                    JSONObject jo2 = JSON.parseObject(listArray.get(j).toString());
                    homeActAdapterBean.setName(jo2.getString("fangjianName"));
                    homeActAdapterBean.setJiage(jo2.getInteger("jiage"));
                    homeActAdapterBean.setShengyu(jo2.getInteger("shangjianshu"));
                    ben.addData(homeActAdapterBean);

                }

                beanArrayList.add(ben);
            }

        } catch (Exception e) {
            e.printStackTrace();

        }

    }
}
