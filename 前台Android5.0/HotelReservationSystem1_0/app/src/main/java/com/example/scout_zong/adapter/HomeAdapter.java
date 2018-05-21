package com.example.scout_zong.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.scout_zong.activity.HomepageIitmActivity;
import com.example.scout_zong.hotelreservationsystem1_0.R;
import com.example.scout_zong.tool.bean.HomeBean;


import java.util.ArrayList;

/**
 * Created by scout_zong on 2018/4/10.
 */

public class HomeAdapter extends ArrayAdapter<HomeBean> {
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
            ViewHome mView = null;
                    if (mView == null) {
                        convertView = mInflater.inflate(R.layout.home_tiem_frag, null);
                        mView = new ViewHome();
                        mView.logo = (ImageView) convertView.findViewById(R.id.imageView);
                        mView.name = (TextView) convertView.findViewById(R.id.textView2);
                        mView.pingfen = (TextView) convertView.findViewById(R.id.pingfen);
                        mView.jiage = (TextView) convertView.findViewById(R.id.textView3);
//                        mView.juli = (TextView) convertView.findViewById(R.id.textView4);
                    } else {
                        mView = (ViewHome) convertView.getTag();

                    }

            //从以下开始进行Item操作
            if (bean != null) {
                mView.logo.setBackgroundResource(bean.getWaiguan());
                mView.name.setText(bean.getName());
                mView.pingfen.setText(bean.getPingfen());
                mView.jiage.setText(bean.getDizhi());
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("HomeAdapter", "GetView()Exception");

        }
        return convertView;
    }


    public HomeAdapter(Context context, ArrayList<HomeBean> objects) {
        super(context, 0, objects);
        mArray = objects;
        this.context = context;
        mInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    private static class ViewHome {
        ImageView logo;
        TextView name, pingfen, jiage, juli;
    }


}
