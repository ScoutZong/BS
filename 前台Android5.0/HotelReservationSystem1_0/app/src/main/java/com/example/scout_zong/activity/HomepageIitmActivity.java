package com.example.scout_zong.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.scout_zong.adapter.HomeActAdapter;
import com.example.scout_zong.dialog.BookDialog;
import com.example.scout_zong.hotelreservationsystem1_0.R;
import com.example.scout_zong.request.BaseRequest;
import com.example.scout_zong.request.RequestThread;
import com.example.scout_zong.tool.bean.HomeActAdapterBean;
import com.example.scout_zong.tool.bean.HomeBean;

import java.util.ArrayList;
import java.util.Calendar;

/**详细信息浏览界面
 * Created by scout_zong on 2018/4/10.
 */

public class HomepageIitmActivity extends BaseActivity {
    private TextView closeBtn;
    private TextView text;
    private TextView startRiQitext, outRiQitext;
    protected int Item = 0;
//    protected ArrayList<HomeBean> mListBean;
    private String homename,homeadder;
    private ListView mListView;
    private HomeActAdapter mHomeActAdapter;
    private ArrayList<HomeActAdapterBean> mAdapterList;
    private  BookDialog dailog;
    private RelativeLayout relativeLayout;
    private TextView addertext;
    public static boolean isBool=false;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        init();
        settingLiistView();


    }

    private void settingLiistView() {
//        mAdapterList = new ArrayList<HomeActAdapterBean>();
//        mAdapterList.add(new HomeActAdapterBean("单人间", 3,128));
//        mAdapterList.add(new HomeActAdapterBean("标间", 5,128));
//        mAdapterList.add(new HomeActAdapterBean("大床房【无窗户】", 79,265));
//        mAdapterList.add(new HomeActAdapterBean("大床房【有窗户】", 98,215));
         int a=mAdapterList.size();
        mHomeActAdapter = new HomeActAdapter(HomepageIitmActivity.this, mAdapterList);
        mListView.setAdapter(mHomeActAdapter);
        mHomeActAdapter.notifyDataSetChanged();
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent();
                intent.putExtra("fangxing", mAdapterList.get(i).getName().toString());
                intent.putExtra("id", i);
                intent.putExtra("homename", homename);
                intent.putExtra("jine", mAdapterList.get(i).getJiage());
                intent.setClass(HomepageIitmActivity.this, IndentActivity.class);
                startActivity(intent);
            }
        });


    }
    public void init() {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.home_tiem_activity);
        relativeLayout=findViewById(R.id.beijing_home_tiem);
        mListView = findViewById(R.id.home_tiem_listview);
        startRiQitext = findViewById(R.id.start_text_hometiem);
        outRiQitext = findViewById(R.id.out_text_hometiem);
        closeBtn = findViewById(R.id.button3);
        text = findViewById(R.id.home_tiem_name);
        addertext=findViewById(R.id.textView5);

        Item = getIntent().getIntExtra("id", 0);
//        mListBean = getIntent().getParcelableArrayListExtra("Array");
       homename=getIntent().getStringExtra("HomeName");
       homeadder=getIntent().getStringExtra("dizhi");
        mAdapterList=getIntent().getParcelableArrayListExtra("Array2");
//        text.setText(mListBean.get(Item).getName().toString());
        text.setText(homename);
        addertext.setText(homeadder);
//        String aaa=mHomeBean.getDizhi();
//        addertext.setText(mHomeBean.getDizhi());
        int a=getIntent().getIntExtra("waiguan",0);
        relativeLayout.setBackgroundResource(a);
        final Calendar ca = Calendar.getInstance();
        dailog = new BookDialog(HomepageIitmActivity.this,mTool);
        mTool.setStartTime("入住时间");
        mTool.setEndTime("离店时间");
        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        String startshijian=getIntent().getStringExtra("start");
        String over=getIntent().getStringExtra("over");
        if(isBool){
            startRiQitext.setText(startshijian);
            outRiQitext.setText(over);
        }else{
            startRiQitext.setText("开始时间");
            outRiQitext.setText("结束时间");
        }

        startRiQitext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BookDialog.BOOK_TAG=1;
                dailog.show();

            }
        });
        outRiQitext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BookDialog.BOOK_TAG=2;
                dailog.show();

            }
        });
        dailog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {
                if (mTool.getStartTime().equals(mTool.getEndTime()))
                    Toast.makeText(HomepageIitmActivity.this,"请选择正确时间",Toast.LENGTH_SHORT).show();
                startRiQitext.setText(mTool.getStartTime());
                outRiQitext.setText(mTool.getEndTime());

            }
        });
    }
}
