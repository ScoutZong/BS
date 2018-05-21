package com.example.scout_zong.request;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.scout_zong.tool.Tool;
import com.example.scout_zong.tool.bean.HomeActAdapterBean;
import com.example.scout_zong.tool.bean.HomeBean;
import com.example.scout_zong.tool.bean.lndentBean;

import java.util.ArrayList;

/**
 * Created by scout_zong on 2018/5/17.
 */

public class GetDingdanReuqest extends BaseRequest {

    private Tool tool;
    private lndentBean ben;




    private ArrayList<lndentBean> beanArrayList;
    public GetDingdanReuqest() {
        setSERLATTAG("onServlet",5);
        beanArrayList=new ArrayList<>();


    }

    public ArrayList<lndentBean> getBeanArrayList() {
        return beanArrayList;
    }

    @Override
    public String getURLBody() {
        return "";
    }

    @Override
    public void analysisJSON() {
        super.analysisJSON();
        try {
            //fastjson解析数据

            JSONArray array= JSON.parseArray(requestString);
            for (int i=0;i< array.size();i++) {
                ben=new lndentBean();

                JSONObject jo1=JSON.parseObject(array.get(i).toString());
                ben.setName(jo1.getString("homename"));
                ben.setShijian(jo1.getString("shijian"));
                ben.setJiage(jo1.getInteger("jiage"));
                System.out.println(jo1.getString("Homename"));
                initIndent(ben,jo1.getInteger("log"));
                beanArrayList.add(ben);
            }

        }catch (Exception e){
            e.printStackTrace();

        }

    }

}
