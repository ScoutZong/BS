package com.example.scout_zong.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.example.scout_zong.request.BaseRequest;
import com.example.scout_zong.request.RequestThread;
import com.example.scout_zong.tool.Tool;


/**
 * Created by scout_zong on 2018/4/2.
 */

public class BaseDialog extends Dialog {

    public BaseDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        SettingViewDialog();

    }
    protected  void SettingViewDialog(){}


    public void startThread(BaseRequest request, Tool tool){
        RequestThread thread=new RequestThread(tool);
        thread.setBaseRequest(request);
        thread.start();
    }

    protected boolean zhengze(String string, String zhengze) {
        String qq = string;

        String regex = zhengze;

        boolean flag = qq.matches(regex);
        return flag;
    }
}
