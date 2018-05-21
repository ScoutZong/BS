package com.scout_zong.request;

import com.alibaba.fastjson.JSONObject;
import com.scout_zong.jdbc.DBContent;

public class GetxinUserReuqest extends BaseRequest {
public static final int  TAG=4;
	
	private String username;
	private String password;
	private DBContent db;
	@Override
	public String getJson() {
		try {
			JSONObject object=new JSONObject();
			 
			object.put("request", db.updata(username, password));
//			System.out.println("JSON="+object.toString());
			return object.toString();
		} catch (Exception e) {
			// TODO: handle exception
			return "无效";
		}
	}
	
	public GetxinUserReuqest(String user, String password){
		try {
			 System.out.println("username:"+user);
			  
			 this.username=user;
			 this.password=password;
			 db=new DBContent();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("获取JSON出错");
		}
		
	}
	
	
}
