package com.scout_zong.bean;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class HomeBean {
	private  String name;
	private  String dizhi;
	private ArrayList<FangjianBean> fangjian;
	private String log;
	
	public HomeBean(String name,String dizhi,ArrayList<FangjianBean> fangjian,String log) {
		this.dizhi=dizhi;
		this.name=name;
		this.fangjian=fangjian;
		this.log=log;
	}
	public String getlog() {
		// TODO Auto-generated method stub
		return log;
	}
	public ArrayList<FangjianBean> getList(){
		return fangjian;
	}

	public String getName() {
		return name;
	}



	public String getDizhi() {
		return dizhi;
	}

	 
	

}
