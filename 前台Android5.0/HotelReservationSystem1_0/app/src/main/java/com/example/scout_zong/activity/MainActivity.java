package com.example.scout_zong.activity;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;

import com.example.scout_zong.fragment.BaseFragment;
import com.example.scout_zong.fragment.HomepageFragment;
import com.example.scout_zong.fragment.FindFragment;
import com.example.scout_zong.fragment.MyFragment;
import com.example.scout_zong.hotelreservationsystem1_0.R;
import com.example.scout_zong.request.FindRequest;


public class MainActivity extends BaseActivity {
    private LinearLayout homepageLayout,findLayout,myLayout;/*首页，消息，收藏，我的*/

    private FindFragment mFindFragment;
    private HomepageFragment mHomepageFragment;
    private MyFragment mMyFragment;
    private String username;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        getID();
        mHomepageFragment=new HomepageFragment();

        mFindFragment=new FindFragment();

        mMyFragment=new MyFragment();
        username=getIntent().getStringExtra("Username");
        //第一次启动默认启动首页功能
        getFragment(R.id.fragment_main,mHomepageFragment);
        /**
         * "首页功能"响应事件
         * **/
        homepageLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragment(R.id.fragment_main,mHomepageFragment);

            }
        });
        /**
         * "发现功能"响应事件
         * **/
        findLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragment(R.id.fragment_main,mFindFragment);

            }
        });


        /**
         * "我的功能"响应事件
         * **/
        myLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMyFragment.setUsername(username);
               getFragment(R.id.fragment_main,mMyFragment);

            }
        });


    }
    /***
     * 获取ID
     */
    private void getID(){
        homepageLayout=(LinearLayout)findViewById(R.id.homepage_laoyut_main);
        findLayout=(LinearLayout)findViewById(R.id.find_laoyut_main);
        myLayout=(LinearLayout)findViewById(R.id.my_layout_main);
    }
    /**
     * 获取Fragment并且显示
     * **/
    private void getFragment(int id,BaseFragment baseFragment){
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(id, baseFragment);
        fragmentTransaction.commit();
    }
}
