package com.example.scout_zong.dialog;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.scout_zong.activity.LoginActivity;
import com.example.scout_zong.hotelreservationsystem1_0.R;
import com.example.scout_zong.request.BaseRequest;
import com.example.scout_zong.request.GengxinPassRequest;
import com.example.scout_zong.tool.Tool;

/**
 * Created by scout_zong on 2018/5/17.
 */

public class XiugaiPassDialog extends BaseDialog {
    private Context context;
    private GengxinPassRequest gengxinPassRequest;
    private EditText jiumima, xinmima, okxinmima;
    private Button okBtn;
    private String jiumimString, xinmimaString, okxinmimaString;
    private Tool tool;
    private String username1;

    public void setUsername(String username) {
        this.username1 = username;
    }

    public XiugaiPassDialog(@NonNull Context context, Tool tool) {
        super(context);
        this.context = context;
        this.tool = new Tool(context);
    }

    @Override
    protected void SettingViewDialog() {
        super.SettingViewDialog();
        setContentView(R.layout.xiugaimima_layout);
        jiumima = findViewById(R.id.jiumima);
        xinmima = findViewById(R.id.xinmima);
        okxinmima = findViewById(R.id.okxinmima);
        okBtn = findViewById(R.id.button);
        gengxinPassRequest = new GengxinPassRequest();
        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jiumimString = jiumima.getText().toString().trim();
                xinmimaString = xinmima.getText().toString().trim();
                okxinmimaString = okxinmima.getText().toString().trim();

                if (!jiumimString.equals("") || xinmimaString.equals("") || okxinmimaString.equals("")) {
                    if (!zhengze(xinmima.getText().toString().trim(), "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,16}$")) {
                        Toast.makeText(context, "密码格式错误", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if (xinmimaString.equals(okxinmimaString)) {
                        gengxinPassRequest.setUsername(username1);
                        String aaa = tool.getUsername();
                        gengxinPassRequest.setPassword(okxinmimaString);
                        startThread(gengxinPassRequest, tool);
                        XiugaiPassDialog.this.dismiss();
                    } else {
                        Toast.makeText(context, "请输入密码", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(context, "请输入密码", Toast.LENGTH_SHORT).show();
                }

            }
        });
        gengxinPassRequest.setOnResponseEventListener(new BaseRequest.OnResponseEventListener() {
            @Override
            public void onResponse(BaseRequest request, BaseRequest.RequestResult result) {
                if (gengxinPassRequest.isSeecss()) {
                    Toast.makeText(context, "密码修改成功", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, "密码修改失败", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
