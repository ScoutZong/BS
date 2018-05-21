package com.example.scout_zong.request;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.scout_zong.tool.Tool;

/**
 * Created by scout_zong on 2018/5/16.
 */

public class SetDingdanRequest extends BaseRequest {




    private Tool tool;
    String aaa;
    public SetDingdanRequest(Tool tool) {
        setSERLATTAG("onServlet",4);
        this.tool=tool;


    }
    private String homename,shijian,jiage,myname,phone,log;

    public void setJiage(String jiage) {
        this.jiage = jiage;
    }

    public void setHomename(String homename) {
        this.homename = homename;
    }

    public void setShijian(String shijian) {
        this.shijian = shijian;
    }

    public String getShijian() {
        return shijian;
    }

    @Override
    public String getURLBody() {
        return "&homename="+homename+"&shijian="+shijian+"&jiage="+jiage+"&myname="+myname+"&myphone="+phone+"&log="+log;
    }
    public void setLog(String log){
        this.log=log;
    }

    @Override
    public void analysisJSON() {
        super.analysisJSON();
        try {
            //fastjson解析数据
            JSONObject jsonObject = JSON.parseObject(requestString);
            if (Integer.valueOf(jsonObject.getString("request"))==1) {
                setSeecss(true);

            }else{
                setSeecss(false);
            }
        }catch (Exception e){
            e.printStackTrace();

        }

    }

    public void setMyname(String myname) {
        this.myname = myname;
    }

    public void setMyphone(String phone) {
        this.phone = phone;
    }
}
