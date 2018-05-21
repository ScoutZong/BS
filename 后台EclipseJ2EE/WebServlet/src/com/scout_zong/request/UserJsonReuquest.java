package com.scout_zong.request;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.scout_zong.jdbc.DBContent;

public class UserJsonReuquest extends BaseRequest {
	public static final int  TAG=1;
	
	private String username;
	private String password;
	private DBContent db;
	@Override
	public String getJson() {
		try {
			JSONObject object=new JSONObject();
			 
			object.put("request", db.LoginDB(username, password));
			object.put("myname", db.lianxirenDB(username));
			object.put("myphone", db.phoneDB(username));
//			System.out.println("JSON="+object.toString());
			return object.toString();
		} catch (Exception e) {
			// TODO: handle exception
			return "无效";
		}
	}
	
	public UserJsonReuquest(String user,String pass){
		try {
			 System.out.println("username:"+user);
			 System.out.println("password:"+pass);
			 this.username=user;
			 this.password=pass;
			 db=new DBContent();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("获取JSON出错");
		}
		
	}
	
	
	
	
}
