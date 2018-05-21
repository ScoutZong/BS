package com.scout_zong.request;

import java.util.Random;

import com.alibaba.fastjson.JSONObject;
import com.scout_zong.jdbc.DBContent;

public class SetDiangdanReuqest extends BaseRequest {

	public static final int TAG = 4;
	private String homename="";
	private String shijian="";
	private String jiage="";
	private String log="";
	private DBContent db;
	private String myname;
	private String phone;

	@Override
	public String getJson() {
		try {

			JSONObject object = new JSONObject();
			object.put("request", String.valueOf(db.inDingdan(homename, shijian, jiage,myname,phone,log)));
			
			return object.toString();
		} catch (Exception e) {
			// TODO: handle exception
			return "无效";
		}

	}

	public SetDiangdanReuqest(String homename,String shijian, String jiage,String myname,String phone,String log) {
		try {
			 this.homename=homename;
			 this.shijian=shijian;
			 this.jiage=jiage;
			 this.log=log;
			 this.myname=myname;
			 this.phone=phone;

			db = new DBContent();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("获取JSON出错");
		}
	}

	 



}
