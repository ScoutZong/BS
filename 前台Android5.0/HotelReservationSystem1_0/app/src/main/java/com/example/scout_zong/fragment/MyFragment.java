package com.example.scout_zong.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.example.scout_zong.activity.LoginActivity;
import com.example.scout_zong.adapter.lndentAdapter;
import com.example.scout_zong.dialog.ErweimaDialog;
import com.example.scout_zong.dialog.XiugaiPassDialog;
import com.example.scout_zong.hotelreservationsystem1_0.R;
import com.example.scout_zong.request.BaseRequest;
import com.example.scout_zong.request.DeletDingdanRequest;
import com.example.scout_zong.request.GetDingdanReuqest;
import com.example.scout_zong.request.RequestThread;
import com.example.scout_zong.tool.Tool;
import com.example.scout_zong.tool.bean.HomeBean;
import com.example.scout_zong.tool.bean.lndentBean;

import java.util.ArrayList;

/**
 * Created by scout_zong on 2018/4/2.
 */

public class MyFragment extends BaseFragment {
    public static final String TAG="MyFragment";

    private ListView listView;
    private LinearLayout xiugaimimaBtn;

    private Tool tool2;
    public lndentAdapter lndentAdapter;
    private GetDingdanReuqest getDingdanReuqest;
    private String username;
    private DeletDingdanRequest deletDingdanRequest;
    private int shuzuhao;
    public void setUsername(String username) {
        this.username = username;
    }


    public MyFragment() {
        super();

    }

    public void setTool2(Tool tool2) {
        this.tool2 = tool2;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.my_layout_frag, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        listView=getActivity().findViewById(R.id.listview);
        xiugaimimaBtn=getActivity().findViewById(R.id.xiugaimima_layout);
        xiugaimimaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                XiugaiPassDialog dialog=new XiugaiPassDialog(getActivity(),mTool);
                dialog.setUsername(username);
                dialog.show();
            }
        });
//        listView.setAdapter(lndentAdapter);
        getDingdanReuqest=new GetDingdanReuqest();
        startThread(getDingdanReuqest,mTool);
        getDingdanReuqest.setOnResponseEventListener(new BaseRequest.OnResponseEventListener() {
            @Override
            public void onResponse(BaseRequest request, BaseRequest.RequestResult result) {

                lndentAdapter=new lndentAdapter(getActivity(), getDingdanReuqest.getBeanArrayList(),tool2);
                listView.setAdapter(lndentAdapter);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ErweimaDialog dailog=new ErweimaDialog(getActivity(),  username);
                dailog.show();
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                deletDingdanRequest.setHomename(getDingdanReuqest.getBeanArrayList().get(i).getName());
                shuzuhao=i;
                startThread(deletDingdanRequest,mTool);

                return true;
            }
        });
        deletDingdanRequest = new DeletDingdanRequest(mTool);
        deletDingdanRequest.setOnResponseEventListener(new BaseRequest.OnResponseEventListener() {
            @Override
            public void onResponse(BaseRequest request, BaseRequest.RequestResult result) {
                if (deletDingdanRequest.isSeecss()){
                    getDingdanReuqest.getBeanArrayList().remove(shuzuhao);
                    lndentAdapter.notifyDataSetChanged();
                    Toast.makeText(getActivity(),"订单删除成功",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getActivity(),"订单删除失败",Toast.LENGTH_SHORT).show();
                }
            }
        });




    }

    public void startThread(BaseRequest request, Tool tool){
        RequestThread thread=new RequestThread(tool);
        thread.setBaseRequest(request);
        thread.start();
    }
}
