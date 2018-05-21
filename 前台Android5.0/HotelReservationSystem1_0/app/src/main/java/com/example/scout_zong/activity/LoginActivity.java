package com.example.scout_zong.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.scout_zong.dialog.ErweimaDialog;
import com.example.scout_zong.dialog.FindPassDialog;
import com.example.scout_zong.dialog.RegisterDialog;
import com.example.scout_zong.hotelreservationsystem1_0.R;
import com.example.scout_zong.request.BaseRequest;
import com.example.scout_zong.request.LoginReuqest;
import com.example.scout_zong.request.RequestThread;

public class LoginActivity extends BaseActivity {
    private Button loginBtn, registerBtn,findpassBtn;/*登陆Login，注册Register*/
    private  String username, password;
    private TextView skipText;
    private EditText userEd, passEd;
    private Intent in;
    private LoginReuqest loginReuqest;
    private   EditText ip;
    private RequestThread requestThread;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        in = new Intent(this, MainActivity.class);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.login_main);
        Log.e("LoginSHp", mTool.getLogint());
        loginBtn = (Button) findViewById(R.id.login_btn_login);
        registerBtn = (Button) findViewById(R.id.register_btn_login);
        skipText = (TextView) findViewById(R.id.skip_text_login);
        ip=findViewById(R.id.editText123312);

        findpassBtn=findViewById(R.id.findpass_btn_login);
        userEd = findViewById(R.id.username_edit_login);
        passEd = findViewById(R.id.password_edit_login);

        loginReuqest = new LoginReuqest(mTool);
        mTool.setDdingdanshu(0);
        //
//        startActivity(in);
        //
        loginReuqest.setOnResponseEventListener(new BaseRequest.OnResponseEventListener() {
                    @Override
                    public void onResponse(BaseRequest request,
                                           BaseRequest.RequestResult result) {
                        // 处理用户登录请求的结果
                        // dismissLoadDialog();
                        boolean a = loginReuqest.isSeecss();
//                        Toast.makeText(LoginActivity.this,loginReuqest.requestString,Toast.LENGTH_SHORT).show();
//                        Toast.makeText(LoginActivity.this,mTool.getUsername()+mTool.getMyname(),Toast.LENGTH_SHORT).show();
                        if (loginReuqest.isSeecss()){
                            IndentActivity.isSuss=false;
                            Intent intent=new Intent();
                            intent.setClass(LoginActivity.this,MainActivity.class);
                            String aaa=userEd.getText().toString().trim();
                            intent.putExtra("Username", userEd.getText().toString().trim());
                            startActivity(intent);
//                            startActivity(in);
                            finish();
                        }else{

                            Toast.makeText(LoginActivity.this,"登陆失败",Toast.LENGTH_SHORT).show();
                        }

                    }
                });

        /**
         * 登陆功能
         * **/
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTool.setLogin("1");
                /*检测是否有文字*/
                username = userEd.getText().toString().trim();
                password = passEd.getText().toString().trim();
                if (username.equals("") || password.equals("")) {
                    Toast.makeText(LoginActivity.this, "请输入用户名密码", Toast.LENGTH_LONG).show();
                    return;
                }else {
                    if (!zhengze(userEd.getText().toString().trim(), "^[A-Za-z][A-Za-z1-9_-]+$")) {
                        Toast.makeText(LoginActivity.this, "用户名格式错误", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    if (!zhengze(passEd.getText().toString().trim(), "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,16}$")) {
                        Toast.makeText(LoginActivity.this, "密码格式错误", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    requestThread=new RequestThread(mTool);
                     mTool.setIP(ip.getText().toString().trim());
                    requestThread.setBaseRequest(loginReuqest);
                     loginReuqest.setUsername(username);
                     loginReuqest.setPassword(password);
                     mTool.setUsername(username);
                     setUsername(username);
                     mTool.setPassword(password);
                     loginReuqest.setURLBody("&username="+username+"&password="+password);
                    requestThread.start();


                    }

            }
        });
        /**
         * 跳过登录注册功能
         **/
        skipText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mTool.setUsername("");
                startActivity(in);
                finish();
            }
        });
        /**
         * 注册功能
         * **/
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RegisterDialog dialog = new RegisterDialog(LoginActivity.this,mTool);
                dialog.show();
            }
        });
        /***
         * 找回密码功能
         */
        findpassBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FindPassDialog dialog=new FindPassDialog(LoginActivity.this,mTool);
                dialog.show();
            }
        });

    }

    /*************用于双击退出Activity***********/
    private boolean mIsExit;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (mIsExit) {
                this.finish();

            } else {
                Toast.makeText(this, "再按一次退出", Toast.LENGTH_SHORT).show();
                mIsExit = true;
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mIsExit = false;
                    }
                }, 2000);
            }
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }


    private boolean zhengze(String string, String zhengze) {
        String qq = string;

        String regex = zhengze;

        boolean flag = qq.matches(regex);
        return flag;
    }
}
