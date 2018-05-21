package com.example.scout_zong.request;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.scout_zong.tool.Tool;

/**
 * Created by scout_zong on 2018/5/10.
 */

public class FindRequest extends BaseRequest {


    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword(){return  password;}

    private String username,email,password;
    private Tool tool;

    public FindRequest() {
        setSERLATTAG("UserServlat",2);



    }

    @Override
    public String getURLBody() {
        return "&username="+username+"&email="+email;
    }

    @Override
    public void analysisJSON() {
        super.analysisJSON();
        try {
            //fastjson解析数据
            JSONObject jsonObject = JSON.parseObject(requestString);
            password=jsonObject.getString("password");
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
