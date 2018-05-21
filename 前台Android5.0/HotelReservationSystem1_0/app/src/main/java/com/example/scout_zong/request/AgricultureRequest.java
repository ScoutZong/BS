package com.example.scout_zong.request;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by scout_zong on 2018/5/6.
 */

public abstract class AgricultureRequest extends BaseRequest {
    // 存放服务器端的回应结果（成功或失败），基类只提供读取接口，具体内容由子类提供
    protected volatile boolean isSuccess = false;
    // 用户名
    protected String username = "";

    public AgricultureRequest(String username) {

        this.username = username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // 标记本次请求是否成功
    public boolean isSuccess() {
        return isSuccess;
    }



}
