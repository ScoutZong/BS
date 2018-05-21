package com.example.scout_zong.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.scout_zong.activity.BaseActivity;
import com.example.scout_zong.hotelreservationsystem1_0.MainActivity;
import com.example.scout_zong.hotelreservationsystem1_0.R;
import com.example.scout_zong.request.HomeReuqest;
import com.example.scout_zong.request.RequestThread;
import com.example.scout_zong.tool.Tool;
import com.example.scout_zong.tool.bean.HomeBean;

import java.util.ArrayList;

/**
 * Created by scout_zong on 2018/4/2.
 */

public class BaseFragment extends Fragment {
    protected ArrayList<HomeBean> mListBean;
    public BaseFragment(  ) {
        super();


    }
    protected   Tool mTool;


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mTool=new Tool(getActivity());
//        requestThread=new RequestThread(mTool);
//        homeReuqest=new HomeReuqest();
//        requestThread.setBaseRequest(homeReuqest);
//        requestThread.start();
        inActivityCreated();
    }

    protected void inActivityCreated() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




//        mListBean = new ArrayList<HomeBean>();
//        mListBean.add(new HomeBean("希尔顿", "真的好", 128, R.drawable.jiudian1));
//        mListBean.add(new HomeBean("七天", "真的好", 152, R.drawable.jiudian2));
//        mListBean.add(new HomeBean("如家", "真的好", 132, R.drawable.jiudian3));
//        mListBean.add(new HomeBean("莫泰", "真的好", 0, R.drawable.jiudian4));
//        mListBean.add(new HomeBean("香格里拉", "真的好", 0, R.drawable.jiudian5));
//        mListBean.add(new HomeBean("星期八", "真的好", 0, R.drawable.jiudian6));
//        mListBean.add(new HomeBean("格林豪泰", "真的好", 0, R.drawable.jiudian7));
//        mListBean.add(new HomeBean("蓝海钧华", "真的好", 0, R.drawable.jiudian8));
        onStartCreate();

    }
    protected void onStartCreate(){}


}
