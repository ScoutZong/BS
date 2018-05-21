package com.example.scout_zong.fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.scout_zong.activity.HomepageIitmActivity;
import com.example.scout_zong.adapter.HomeAdapter;
import com.example.scout_zong.dialog.BookDialog;
import com.example.scout_zong.dialog.SousouDialog;
import com.example.scout_zong.hotelreservationsystem1_0.R;
import com.example.scout_zong.request.HomeReuqest;
import com.example.scout_zong.request.RequestThread;
import com.example.scout_zong.tool.bean.HomeBean;

import java.util.ArrayList;

/**
 * Created by scout_zong on 2018/4/2.
 */

public class HomepageFragment extends BaseFragment {
    public static final String TAG = "HomepageFragment";
    private BookDialog dailog;
    private TextView startText,overText,sousuoText;



    public HomepageFragment() {
        super();

    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.homepage_layout_frag, container, false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        dailog = new BookDialog(getActivity(),mTool);

        startText=getView().findViewById(R.id.start_text_hometiem);
        overText=getView().findViewById(R.id.out_text_hometiem);
        sousuoText=getView().findViewById(R.id.sousuo_btn);
        startText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BookDialog.BOOK_TAG=1;
                dailog.show();

            }
        });
        overText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BookDialog.BOOK_TAG=2;
                dailog.show();

            }
        });
        sousuoText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SousouDialog dialog=new SousouDialog(getActivity(),mListBean,mTool);
                dialog.setShijian(mTool.getStartTime(),mTool.getEndTime());
                dialog.show();


            }
        });


        dailog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {
                if (mTool.getStartTime().equals(mTool.getEndTime()))
                    Toast.makeText(getActivity(),"请选择却时间",Toast.LENGTH_SHORT).show();
                startText.setText(mTool.getStartTime());
                overText.setText(mTool.getEndTime());


            }
        });
    }


}

