package com.example.scout_zong.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.scout_zong.activity.HomepageIitmActivity;
import com.example.scout_zong.activity.IndentActivity;
import com.example.scout_zong.adapter.FindAdapter;
import com.example.scout_zong.adapter.HomeAdapter;
import com.example.scout_zong.hotelreservationsystem1_0.R;
import com.example.scout_zong.request.BaseRequest;
import com.example.scout_zong.request.RequestThread;
import com.example.scout_zong.request.SousuoReuqest;
import com.example.scout_zong.tool.Tool;
import com.example.scout_zong.tool.bean.HomeBean;

import java.util.ArrayList;

/**
 * Created by scout_zong on 2018/5/7.
 */

public class SousouDialog extends Dialog {
    private EditText sousuo;
    private Button okBtn;
    private String jiudianName;
    private ListView mList;
    private HomeAdapter mHomeAdapter;
    private Context context;
    private ArrayList<HomeBean> mListBean;
    private RequestThread mThread;
    private SousuoReuqest sousuoReuqest;
    private Tool mTool;
    public String start,over;
    public SousouDialog(@NonNull Context context,ArrayList<HomeBean> mListBean,Tool mTool) {
        super(context, android.R.style.Theme_Light_NoTitleBar_Fullscreen);
        setOwnerActivity((Activity)context);
        this.context=context;
        this.mListBean=mListBean;
        this.mTool=mTool;

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sousuo_dialog);
        sousuo=findViewById(R.id.sousuo_edittext);
        okBtn=findViewById(R.id.ok_btn);
        mList =findViewById(R.id.listview);
        sousuoReuqest=new SousuoReuqest();
        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jiudianName=sousuo.getText().toString().trim();
                sousuoReuqest.setSousuo(jiudianName);
                mThread=new RequestThread(mTool);

                mThread.setBaseRequest(sousuoReuqest);
                mThread.start();


            }
        });
        sousuoReuqest.setOnResponseEventListener(new BaseRequest.OnResponseEventListener() {
            @Override
            public void onResponse(BaseRequest request, BaseRequest.RequestResult result) {
                init();


            }
        });
    }
    private void init() {
        mListBean=sousuoReuqest.getArrayList();

        mHomeAdapter = new HomeAdapter(this.context, this.mListBean);
        mList.setAdapter(mHomeAdapter);
        mList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent();
                intent.putParcelableArrayListExtra("Array", mListBean);
                intent.putParcelableArrayListExtra("Array2",mListBean.get(i).mAdApterList);
                intent.putExtra("id", i);
                intent.putExtra("HomeName",mListBean.get(i).getName());
                intent.putExtra("dizhi",mListBean.get(i).getDizhi());
                intent.putExtra("waiguan",mListBean.get(i).getWaiguan());
                intent.putExtra("start",start);
                intent.putExtra("over",over);
                HomepageIitmActivity.isBool=true;
                intent.setClass(context, HomepageIitmActivity.class);
                context.startActivity(intent);
                IndentActivity.log = mListBean.get(i).getWaiguan();
                SousouDialog.this.dismiss();

            }
        });


    }

    public void setShijian(String start,String over) {
        this.start=start;
        this.over=over;
    }
}
