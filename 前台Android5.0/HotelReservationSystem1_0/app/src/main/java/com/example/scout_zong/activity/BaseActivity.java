package com.example.scout_zong.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.scout_zong.request.HomeReuqest;
import com.example.scout_zong.request.RequestThread;
import com.example.scout_zong.tool.Tool;
import com.example.scout_zong.tool.bean.HomeBean;

import java.util.ArrayList;

public class BaseActivity extends Activity {

    public static Tool mTool;

    protected String fangxing;
    protected int jiage;
    protected String username1;

    public void setUsername(String username) {
        this.username1 = username;
    }

    public String getUsername() {
        return username1;
    }

    public Tool getmTool() {
        return mTool;
    }

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTool = new Tool(this);



    }


}
