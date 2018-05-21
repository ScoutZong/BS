package com.example.scout_zong.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.scout_zong.activity.HomepageIitmActivity;
import com.example.scout_zong.activity.IndentActivity;
import com.example.scout_zong.adapter.FindAdapter;
import com.example.scout_zong.hotelreservationsystem1_0.R;
import com.example.scout_zong.request.BaseRequest;
import com.example.scout_zong.request.HomeReuqest;
import com.example.scout_zong.request.RequestThread;

import com.example.scout_zong.tool.bean.HomeActAdapterBean;
import com.example.scout_zong.tool.bean.HomeBean;

import java.util.ArrayList;

/**
 * Created by scout_zong on 2018/4/2.
 */

public class FindFragment extends BaseFragment {
    private SwipeRefreshLayout mSwip;
    protected HomeReuqest homeReuqest;
    protected RequestThread requestThread;

    public FindFragment() {
        super();
    }

    private GridView gridView;
    private FindAdapter mFindAdapter;





    @Override
    protected void onStartCreate() {


    }

    private void init() {

        mListBean=homeReuqest.getArrayList();
        mFindAdapter = new FindAdapter(getActivity(), mListBean);
        gridView = getView().findViewById(R.id.gridvoid_mess_layout);
        gridView.setAdapter(mFindAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent();
                intent.putParcelableArrayListExtra("Array", mListBean);
                intent.putParcelableArrayListExtra("Array2",mListBean.get(i).mAdApterList);
                intent.putExtra("id", i);
                intent.putExtra("HomeName",mListBean.get(i).getName());
                intent.putExtra("dizhi",mListBean.get(i).getDizhi());
                intent.putExtra("waiguan",mListBean.get(i).getWaiguan());
                intent.setClass(getActivity(), HomepageIitmActivity.class);
                startActivity(intent);
                IndentActivity.log = mListBean.get(i).getWaiguan();
                HomepageIitmActivity.isBool=false;
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.find_layout_frag, container, false);

    }

    @Override
    public void inActivityCreated() {

        requestThread=new RequestThread(mTool);
        homeReuqest=new HomeReuqest();
        requestThread.setBaseRequest(homeReuqest);
        requestThread.start();

        homeReuqest.setOnResponseEventListener(new BaseRequest.OnResponseEventListener() {
            @Override
            public void onResponse(BaseRequest request, BaseRequest.RequestResult result) {
                init();


            }
        });

        mSwip = getView().findViewById(R.id.swipe_container);

        mSwip.setDistanceToTriggerSync(200);
        mSwip.setSize(SwipeRefreshLayout.LARGE);
        //开启一个线程用于下拉刷新规定刷新时间
        mSwip.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        requestThread.start();
                        mFindAdapter.notifyDataSetChanged();
                        mSwip.setRefreshing(false);
                    }
                }, 3000);

            }
        });


    }


}
