package com.scout_zong.request;

import java.net.PasswordAuthentication;
import java.security.KeyStore.PrivateKeyEntry;
import java.util.Random;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.scout_zong.jdbc.DBContent;

public class RegisterRequest extends BaseRequest {
	public static final int TAG = 3;
	private String username = "";
	private String passwprd = "";
	private String email = "";
	private String myname = "";
	private String myPhone = "";
	private DBContent db;

	@Override
	public String getJson() {
		try {

			JSONObject object = new JSONObject();
			int isBool=db.LoginDB(username, passwprd);
			if(isBool!=1) {
				object.put("request",
						Integer.valueOf(db.registerDB(username, passwprd, email, myname, myPhone, "YH" + suijishu())));
				System.out.println(object.toString());
				object.put("userrequest", "1");
			}else {
				object.put("userrequest", "0");
			}
		
			
			return object.toString();
		} catch (Exception e) {
			// TODO: handle exception
			return "无效";
		}

	}

	public RegisterRequest(String user, String pass, String email, String myname, String phone) {
		try {
			System.out.println(user);
			System.out.println(pass);
			System.out.println(email);
			System.out.println(myname);
			System.out.println(phone);
			this.username=user;
			this.passwprd=pass;
			this.email=email;
			this.myname=myname;
			this.myPhone=phone;

			db = new DBContent();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("获取JSON出错");
		}
	}

	private String suijishu() {
		StringBuilder str = new StringBuilder();// 定义变长字符串
		Random random = new Random();
		// 随机生成数字，并添加到字符串
		for (int i = 0; i < 8; i++) {
			str.append(random.nextInt(10));
		}
		// 将字符串转换为数字并输出
		int num = Integer.parseInt(str.toString());
		return num + "";
	}

}
