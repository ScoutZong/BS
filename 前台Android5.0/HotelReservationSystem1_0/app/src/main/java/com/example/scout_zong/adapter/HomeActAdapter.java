package com.example.scout_zong.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.ArrayMap;
import android.util.Log;
import android.util.MutableBoolean;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.scout_zong.hotelreservationsystem1_0.R;
import com.example.scout_zong.tool.bean.HomeActAdapterBean;
import com.example.scout_zong.tool.bean.HomeBean;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by scout_zong on 2018/4/13.
 */

public class HomeActAdapter extends ArrayAdapter<HomeActAdapterBean> {

    private ArrayList<HomeActAdapterBean> mList;
    private Context context;
    private final LayoutInflater mInflater;


    @Override
    public int getCount() {
        return mList.size();
    }


    @Override
    public HomeActAdapterBean getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        try {

            HomeActAdapterBean mBean = getItem(position);
            HomeActAdapter.ViewHomeAct mView = null;

                if (mView == null) {
                    convertView = mInflater.inflate(R.layout.home_activity_itemlayout, null);
                    mView = new HomeActAdapter.ViewHomeAct();
                    mView.name = convertView.findViewById(R.id.name_homeact_text);
                    mView.jiage=convertView.findViewById(R.id.jiage_text);
                    mView.fangjian = convertView.findViewById(R.id.fangjianNub_homeact_text);
                    mView.mlayout = convertView.findViewById(R.id.layout_homeact);

                } else {
                    mView = (HomeActAdapter.ViewHomeAct) convertView.getTag();
                }

            //从以下开始进行Item操作
            if (mBean != null) {
                    mView.name.setText(mBean.getName());
                    mView.fangjian.setText("剩余房间 "+mBean.getShengyu()+" 间");
                    mView.jiage.setText("$"+mBean.getJiage());



            }
            Log.e("HomeActAd------->",mBean.getName()+"");
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("HomeActActivityAdapter", "GetView()Exception");

        }
        return convertView;

    }


    public HomeActAdapter(Context context, ArrayList<HomeActAdapterBean> objects) {
        super(context, 0, objects);
        mList = objects;
        this.context = context;
        mInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    private static class ViewHomeAct {
        LinearLayout mlayout;
        TextView name, fangjian,jiage;
    }
}
