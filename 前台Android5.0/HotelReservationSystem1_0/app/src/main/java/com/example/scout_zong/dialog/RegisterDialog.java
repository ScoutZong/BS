package com.example.scout_zong.dialog;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.scout_zong.activity.LoginActivity;
import com.example.scout_zong.activity.MainActivity;
import com.example.scout_zong.hotelreservationsystem1_0.R;
import com.example.scout_zong.request.BaseRequest;
import com.example.scout_zong.request.RegisterRequest;
import com.example.scout_zong.request.RequestThread;
import com.example.scout_zong.tool.Tool;

/**
 * Created by scout_zong on 2018/4/2.
 */

public class RegisterDialog extends BaseDialog {
    private Button okBtn;
    private EditText user, pass, myname, myphone, email;
    private RegisterRequest registerRequest;
    private RequestThread requestThread;
    private Tool tool;
    private Context context;

    public RegisterDialog(@NonNull Context context, Tool tool) {
        super(context);
        this.tool = tool;
        this.context = context;

    }

    @Override
    protected void SettingViewDialog() {
        super.SettingViewDialog();
        {
            setContentView(R.layout.register_dialog);
            okBtn = findViewById(R.id.ok_btn);
            user = findViewById(R.id.username_register);
            pass = findViewById(R.id.password_register);
            myname = findViewById(R.id.myname_register);
            myphone = findViewById(R.id.myphone_register);
            email = findViewById(R.id.email_register);
            registerRequest = new RegisterRequest();

            okBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (user.equals("") || pass.equals("") || email.equals("") || myname.equals("") || myphone.equals("")) {
                        Toast.makeText(context, "注册信息不完善", Toast.LENGTH_LONG).show();
                        return;
                    } else {
                        if (!zhengze(user.getText().toString().trim(), "^[A-Za-z][A-Za-z1-9_-]+$")) {
                            Toast.makeText(getContext(), "用户名格式错误", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        registerRequest.setUsername(user.getText().toString().trim());
                        if (!zhengze(pass.getText().toString().trim(), "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,16}$")) {
                            Toast.makeText(getContext(), "密码格式错误", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        registerRequest.setPassword(pass.getText().toString().trim());
//

                        if (!zhengze(myname.getText().toString().trim(), "^[\\u4e00-\\u9fa5]*$")) {
                            Toast.makeText(getContext(), "只支持中文名格式", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        registerRequest.setMyname(myname.getText().toString().trim());
                        if (!zhengze(myphone.getText().toString().trim(), "^1[3|4|5|8|7][0-9]\\d{8}$")) {
                            Toast.makeText(getContext(), "手机号码格式错误", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        registerRequest.setMyphone(myphone.getText().toString().trim());
                        if (!zhengze(email.getText().toString().trim(), "[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?")) {
                            Toast.makeText(getContext(), "邮箱格式错误", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        registerRequest.setEmail(email.getText().toString().trim());
                        requestThread = new RequestThread(tool);
                        requestThread.setBaseRequest(registerRequest);
                        requestThread.start();
                    }

                }
            });
            registerRequest.setOnResponseEventListener(new BaseRequest.OnResponseEventListener() {
                @Override
                public void onResponse(BaseRequest request,
                                       BaseRequest.RequestResult result) {
                    if (registerRequest.userIS) {
                        if (registerRequest.isSeecss()) {
                            Toast.makeText(context, "注册成功", Toast.LENGTH_SHORT).show();
                            RegisterDialog.this.dismiss();
                        } else {

                            Toast.makeText(context, "注册失败", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(context, "该用户已注册", Toast.LENGTH_SHORT).show();
                    }


                }
            });
        }
    }


}
