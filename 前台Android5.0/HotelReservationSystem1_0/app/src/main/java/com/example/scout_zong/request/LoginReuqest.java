package com.example.scout_zong.request;

/**
 * Created by scout_zong on 2018/4/30.
 */
import android.util.Log;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.scout_zong.tool.Tool;

public class LoginReuqest extends BaseRequest {

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String username,password;
    private Tool tool;
    String aaa;
    public LoginReuqest(Tool tool) {
       setSERLATTAG("UserServlat",1);
       this.tool=tool;


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
            tool.setUsername(jsonObject.getString("username"));
            tool.setPassword(jsonObject.getString("password"));
            tool.setMyphone(jsonObject.getString("myphone"));
            tool.setMyname(jsonObject.getString("myname"));
            String aaa=tool.getMyname();

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
