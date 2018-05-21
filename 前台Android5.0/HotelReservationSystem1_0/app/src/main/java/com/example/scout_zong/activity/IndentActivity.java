package com.example.scout_zong.activity;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

import com.example.scout_zong.hotelreservationsystem1_0.R;
import com.example.scout_zong.request.BaseRequest;
import com.example.scout_zong.request.RequestThread;
import com.example.scout_zong.request.SetDingdanRequest;
import com.example.scout_zong.tool.Tool;
import com.example.scout_zong.tool.bean.HomeBean;

import java.util.ArrayList;

/**订单界面
 * Created by scout_zong on 2018/4/14.
 */

public class IndentActivity extends BaseActivity {
    private TextView homeNameText,fangxingText,cloneBtn,okBtn,jineText,myname,myphone;
    private TextView tianshuText,startTianText,overTianText;
    private String homename,fangxing;
    private int jiage;
    public static int log=R.drawable.jiudian1;
    public static String homename2="";
    private SetDingdanRequest dingdanRequest;
    public static boolean isSuss=true;





    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dingdanRequest=new SetDingdanRequest(mTool);

        if(isSuss){
            startActivity(new Intent(this,LoginActivity.class));
            this.finish();
        }
        homename = getIntent().getStringExtra("homename").toString();
        fangxing = getIntent().getStringExtra("fangxing").toString();
        jiage = getIntent().getIntExtra("jine",0);
        this.requestWindowFeature(1);
        setContentView(R.layout.indent_activity_layout);
        homeNameText=findViewById(R.id.name_home_indent_text);
        fangxingText=findViewById(R.id.name_fangxing_indent_text);
        cloneBtn=findViewById(R.id.clone_indent_text);
        myname=findViewById(R.id.username_indent_text);

        myname.setText(mTool.getMyname());
        myphone=findViewById(R.id.phone_indent_text);
        myphone.setText("联系电话："+mTool.getphone());
        tianshuText=findViewById(R.id.tianshu_indent_text);
        jineText=findViewById(R.id.jine_text);
        okBtn=findViewById(R.id.ok_btn);
        startTianText=findViewById(R.id.timstart_indent_text);
        overTianText=findViewById(R.id.outtim_indent_text);
        startTianText.setText("入住:"+mTool.getStartTime());
        overTianText.setText("离店:"+mTool.getEndTime());
        homeNameText.setText(homename);
        fangxingText.setText(fangxing);
        tianshuText.setText("入住天数 "+mTool.getNumberDay()+" 天");
        jiage=mTool.getNumberDay()*jiage;
        jineText.setText("$"+jiage);
        myname.setText(mTool.getMyname());
        myphone.setText(mTool.getphone());

        cloneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IndentActivity.this.finish();
            }
        });
       okBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               dingdanRequest.setHomename(homename);
               dingdanRequest.setShijian(mTool.getStartTime());
               int a=(int)(Math.random()*10);
               dingdanRequest.setLog(String.valueOf(a));
               dingdanRequest.setJiage(jiage+"");
               dingdanRequest.setMyname(mTool.getMyname());
               dingdanRequest.setMyphone(mTool.getphone());
               startThread(dingdanRequest,mTool);
                int dingdanshu=mTool.getDingdanshu()+1;
                mTool.setDdingdanshu(dingdanshu);
                mTool.setJiage(jiage+"");
                homename2=homename;
                IndentActivity.this.finish();
           }
       });
       dingdanRequest.setOnResponseEventListener(new BaseRequest.OnResponseEventListener() {
           @Override
           public void onResponse(BaseRequest request, BaseRequest.RequestResult result) {
                String string=dingdanRequest.isSeecss()?"预订成功":"预订失败";
                Toast.makeText(IndentActivity.this,string,Toast.LENGTH_SHORT).show();
           }
       });

    }
public void startThread(BaseRequest request, Tool tool){
    RequestThread thread=new RequestThread(tool);
    thread.setBaseRequest(request);
    thread.start();
}

}
