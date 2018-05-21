package com.scout_zong.request;

import java.sql.ResultSet;
import java.util.Random;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.scout_zong.jdbc.DBContent;

public class GetDingdanRequest extends BaseRequest {

	public static final int TAG = 5;
	 
	private DBContent db;

	@Override
	public String getJson() {
		try {
			JSONArray ar=new JSONArray();
			ResultSet rs=db.getDingdan();
			while (rs.next()) {
				 JSONObject obj=new JSONObject();
				 obj.put("homename", rs.getString("homename"));
				 obj.put("shijian",  rs.getString("shijian"));
				 obj.put("jiage", rs.getString("jiage"));
				 obj.put("log", rs.getString("log"));
				 System.out.println("getdingdanbaio:"+obj.toString());
				ar.add(obj);
			}
		
			
			
			return ar.toString();
		} catch (Exception e) {
			// TODO: handle exception
			return "无效";
		}

	}

	public GetDingdanRequest() {
		try {
			 

			db = new DBContent();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("获取JSON出错");
		}
	}

	 

}
