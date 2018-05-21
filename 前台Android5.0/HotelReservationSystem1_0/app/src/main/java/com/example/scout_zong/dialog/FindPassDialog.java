package com.example.scout_zong.dialog;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.scout_zong.hotelreservationsystem1_0.R;
import com.example.scout_zong.request.BaseRequest;
import com.example.scout_zong.request.FindRequest;
import com.example.scout_zong.request.RequestThread;
import com.example.scout_zong.tool.Tool;

/**
 * Created by scout_zong on 2018/5/7.
 */

public class FindPassDialog extends BaseDialog {
    private Button okBtn;
    private EditText user,email;
    private FindRequest findRequest;
    private RequestThread requestThread;
    private Tool tool;
    private Context context;
    public FindPassDialog(@NonNull Context context,Tool tool) {
        super(context);
        this.tool=tool;
        this.context=context;

    }


    @Override
    protected void SettingViewDialog() {
        super.SettingViewDialog();
        setContentView(R.layout.find_pass_dialog);
        okBtn=findViewById(R.id.ok_btn);
        user=findViewById(R.id.username_register);
        email=findViewById(R.id.email_register);
        findRequest=new FindRequest();
        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (user.getText().toString().trim().equals("") || email.getText().toString().trim().equals(""))
                {
                    Toast.makeText(context,"请输入用户名邮箱",Toast.LENGTH_SHORT).show();
                }else{
                    if (!zhengze(user.getText().toString().trim(), "^[A-Za-z][A-Za-z1-9_-]+$")) {
                        Toast.makeText(getContext(), "用户名格式错误", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    findRequest.setUsername(user.getText().toString().trim());
                    if (!zhengze(email.getText().toString().trim(), "[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?")) {
                        Toast.makeText(getContext(), "邮箱格式错误", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    findRequest.setEmail(email.getText().toString().trim());
                    requestThread = new RequestThread(tool);
                    requestThread.setBaseRequest(findRequest);
                    requestThread.start();
                }
            }
        });
        findRequest.setOnResponseEventListener(new BaseRequest.OnResponseEventListener() {
            @Override
            public void onResponse(BaseRequest request,
                                   BaseRequest.RequestResult result) {
                if (findRequest.isSeecss()){
                    Toast.makeText(context,findRequest.getPassword(),Toast.LENGTH_SHORT).show();
                }else{

                    Toast.makeText(context,"密码找回失败",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
