package com.example.scout_zong.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.scout_zong.activity.IndentActivity;
import com.example.scout_zong.hotelreservationsystem1_0.R;
import com.example.scout_zong.tool.bean.HomeBean;

import java.util.ArrayList;

/**
 * Created by scout_zong on 2018/4/30.
 */

public class FindAdapter extends ArrayAdapter<HomeBean> {
    private ArrayList<HomeBean> mArray;
    private Context context;
    private final LayoutInflater mInflater;



    @Override
    public int getCount() {
        return mArray.size();
    }


    @Override
    public HomeBean getItem(int position) {
        return mArray.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        try {
            HomeBean bean = getItem(position);
            FindAdapter.ViewHome mView = null;
            if (mView == null) {
                convertView = mInflater.inflate(R.layout.find_item_adapter_fragment, null);
                mView = new FindAdapter.ViewHome();
                mView.logo = (LinearLayout) convertView.findViewById(R.id.back_find_relativelayout);
                mView.name = (TextView) convertView.findViewById(R.id.find_name);
                mView.adder = (TextView) convertView.findViewById(R.id.find_adder);

            } else {
                mView = (FindAdapter.ViewHome) convertView.getTag();

            }

            //从以下开始进行Item操作
            if (bean != null) {

                mView.name.setText(bean.getName().toString());
                Log.e("namennnnn31313",bean.getName());
                mView.adder.setText(bean.getDizhi());
                mView.logo.setBackgroundResource(bean.getWaiguan());


            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("HomeAdapter", "GetView()Exception");

        }
        return convertView;
    }


    public FindAdapter(Context context, ArrayList<HomeBean> objects) {
        super(context, 0, objects);
        mArray = objects;
        this.context = context;
        mInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    private static class ViewHome {
        LinearLayout logo;
        TextView name, adder;
    }

}
