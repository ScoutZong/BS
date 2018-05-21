package com.scout_zong.request;

import java.awt.List;
import java.util.ArrayList;

import javax.management.loading.MLet;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.scout_zong.bean.HomeBean;
import com.scout_zong.jdbc.DBContent;

public class HomeRequest extends BaseRequest {
	public static final int TAG=2;
	private ArrayList<HomeBean> array;

	@Override
	public String getJson() {
		try {
			JSONObject object;
			JSONArray array=new JSONArray();
			for (int i = 0; i < this.array.size(); i++) {
				object=new JSONObject();
				HomeBean bean=this. array.get(i);
				object.put("Homename",bean.getName());
				object.put("HomeAdder",bean.getDizhi());
				object.put("list", bean.getList());
				object.put("log", bean.getlog());
				array.add(object);
				System.out.println("asdfasdfasdfasdf");
			}
			
			return array.toString();
		} catch (Exception e) {
			// TODO: handle exception
			return "1";
		}
		 
		
	}
     
	public HomeRequest(ArrayList<HomeBean> array) {
		
		this.array=array;
	}

}
