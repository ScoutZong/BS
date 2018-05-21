package com.scout_zong.request;

import java.sql.ResultSet;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.scout_zong.jdbc.DBContent;

public class DingdanShanchuRequest extends BaseRequest {

	public static final int TAG = 6;
	 
	private DBContent db;
	private String homename;

	@Override
	public String getJson() {
		try {
			 
				 JSONObject obj=new JSONObject();
				 System.out.println(homename);
				 obj.put("request", db.shanchu("Dingdan", "homename",homename));
		
			return obj.toString();
		} catch (Exception e) {
			// TODO: handle exception
			return "无效";
		}

	}

	public DingdanShanchuRequest(String homename) {
		try {
			 
			this.homename=homename;
			db = new DBContent();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("获取JSON出错");
		}
	}

	 
}
