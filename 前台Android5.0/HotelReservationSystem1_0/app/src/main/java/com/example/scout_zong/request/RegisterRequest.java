package com.example.scout_zong.request;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.scout_zong.tool.Tool;

/**
 * Created by scout_zong on 2018/5/10.
 */

public class RegisterRequest extends BaseRequest {
    public boolean userIS=true;
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMyname(String myname) {
        this.myname = myname;
    }

    public void setMyphone(String myphone) {
        this.myphone = myphone;
    }

    private String username,password,email,myname,myphone;
    private Tool tool;

    public RegisterRequest() {
        setSERLATTAG("UserServlat",3);


    }

    @Override
    public String getURLBody() {
        return "&username="+username+"&password="+password+"&email="+email+"&myname="+myname+"&myphone="+myphone;
    }

    @Override
    public void analysisJSON() {
        super.analysisJSON();
        try {
            //fastjson解析数据
            JSONObject jsonObject = JSON.parseObject(requestString);
            if (Integer.valueOf(jsonObject.getString("userrequest"))==1){
                if (Integer.valueOf(jsonObject.getString("request"))==1) {
                    setSeecss(true);
                    userIS=true;
                }else{
                    setSeecss(false);
                }
            }else {
                userIS=false;
            }

        }catch (Exception e){
            e.printStackTrace();

        }

    }
}
