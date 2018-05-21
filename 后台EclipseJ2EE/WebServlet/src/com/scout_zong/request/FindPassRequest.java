package com.scout_zong.request;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.scout_zong.jdbc.DBContent;

public class FindPassRequest extends BaseRequest {
	public static final int TAG=2;
	private String Email="";
	private String Username="";
	private DBContent db;
	@Override
	public String getJson() {
		// TODO Auto-generated method stub
		try {
			JSONObject object=new JSONObject();
			object.put("password", db.findpass(Username));
			object.put("request", "1");
			return object.toString();
		} catch (Exception e) {
			// TODO: handle exception
			return "ÎÞÐ§";
		}
		
	}
	public FindPassRequest(String user,String email) {
		this.Username=user;
		this.Email=email;
		 db=new DBContent();
	}

}
