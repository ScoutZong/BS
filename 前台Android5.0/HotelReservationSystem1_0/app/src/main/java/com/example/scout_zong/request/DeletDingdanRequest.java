package com.example.scout_zong.request;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.scout_zong.tool.Tool;

/**
 * Created by scout_zong on 2018/5/18.
 */

public class DeletDingdanRequest extends BaseRequest {

    public void setHomename(String homename) {
        this.homename = homename;
    }

    private String homename ;
    private Tool tool;
    String aaa;
    public DeletDingdanRequest(Tool tool) {
        setSERLATTAG("onServlet",6);
        this.tool=tool;


    }

    @Override
    public String getURLBody() {
        return "&homename="+homename;
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
