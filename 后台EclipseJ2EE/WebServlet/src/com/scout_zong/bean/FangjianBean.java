package com.scout_zong.bean;

public class FangjianBean {
	private String fangjianName;
	private int jiage;
	private int shangjianshu;
	public FangjianBean(String fangjianName, int jiage, int shangjianshu) {
		super();
		this.fangjianName = fangjianName;
		this.jiage = jiage;
		this.shangjianshu = shangjianshu;
	}
	 
	public String getFangjianName() {
		return fangjianName;
	}
	public int getJiage() {
		return jiage;
	}
	public int getShangjianshu() {
		return shangjianshu;
	}
	
	
 

}
