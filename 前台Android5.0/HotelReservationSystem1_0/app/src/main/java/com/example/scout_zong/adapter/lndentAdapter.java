package com.example.scout_zong.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.scout_zong.hotelreservationsystem1_0.R;
import com.example.scout_zong.tool.Tool;
import com.example.scout_zong.tool.bean.HomeActAdapterBean;
import com.example.scout_zong.tool.bean.HomeBean;
import com.example.scout_zong.tool.bean.lndentBean;

import java.util.ArrayList;

/**
 * Created by scout_zong on 2018/5/10.
 */

public class lndentAdapter extends ArrayAdapter<lndentBean> {
    private ArrayList<lndentBean> mArray;
    private Context context;
    private final LayoutInflater mInflater;
    private Tool tool;


    @Override
    public int getCount() {
        return mArray.size();
    }


    @Override
    public lndentBean getItem(int position) {
        return mArray.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        try {
            lndentBean bean = getItem(position);
            lndentAdapter.ViewHome mView = null;
            if (mView == null) {
                convertView = mInflater.inflate(R.layout.indent_item_layout, null);
                mView = new lndentAdapter.ViewHome();
                mView.logo = (ImageView) convertView.findViewById(R.id.imageView);
                mView.name = (TextView) convertView.findViewById(R.id.textView2);
                mView.jiage = (TextView) convertView.findViewById(R.id.textView3);
                mView.shijian=convertView.findViewById(R.id.shijian);
            } else {
                mView = (lndentAdapter.ViewHome) convertView.getTag();

            }

            //从以下开始进行Item操作
            if (bean != null) {
                mView.name.setText(bean.getName());
                mView.shijian.setText("入住时间："+bean.getShijian());
                mView.jiage.setText("￥ " + bean.getJiage() + "");
                mView.logo.setBackgroundResource(bean.getLog());

            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("HomeAdapter", "GetView()Exception");

        }
        return convertView;
    }



    public lndentAdapter(Context context, ArrayList<lndentBean> objects, Tool tool) {
        super(context, 0, objects);
        mArray = objects;
        this.context = context;
        mInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.tool=tool;

    }

    private static class ViewHome {
        ImageView logo;
        TextView name, shijian, jiage;
    }
}
