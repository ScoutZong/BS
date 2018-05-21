package com.example.scout_zong.request;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.scout_zong.tool.Tool;

/**
 * Created by scout_zong on 2018/5/17.
 */

public class GengxinPassRequest extends BaseRequest {


    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String username,password;


    public GengxinPassRequest( ) {
        setSERLATTAG("UserServlat",4);



    }

    @Override
    public String getURLBody() {
        return "&username="+username+"&password="+password;
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

}
