package com.scout_zong.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.scout_zong.bean.FangjianBean;
import com.scout_zong.bean.HomeBean;

public class JDBCServlatContent {
	private ArrayList<HomeBean> arrayList;
	private ArrayList<FangjianBean> fangxing;
	private DBContent db;

	public JDBCServlatContent() {
		db = new DBContent();
		arrayList = new ArrayList<>();
		ResultSet rs = db.getAll("*", "Home");
		try {
			while (rs.next()) {
				 
				String string=rs.getString("fangjian");
				String [] fangxingString = string.split(",");  
				String string1=rs.getString("fangjianshu");
				String [] fangjianshu = string1.split(",");  
				String string2=rs.getString("jiage");
				String [] jiage = string2.split(",");  
				fangxing = new ArrayList<>();
				for (int i = 0; i < fangxingString.length; i++) {
					 
					fangxing.add(new FangjianBean(fangxingString[i], Integer.valueOf(jiage[i]), Integer.valueOf(fangjianshu[i])));
				}
//				fangxing = new ArrayList<>();
//				fangxing.add(new FangjianBean(fangjianName, jiage, shangjianshu))
				
				arrayList.add(new HomeBean( rs.getString("name"), rs.getString("adder"), fangxing,rs.getString("log")));
				 
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

	public ArrayList<HomeBean> getArrayList() {
		return arrayList;
	}

//	private ArrayList<FangjianBean> getFangxing() {
//		fangxing = new ArrayList<>();
//		fangxing.add(new FangjianBean("单人间", 125, 12));
//		fangxing.add(new FangjianBean("大床房", 125, 12));
//		fangxing.add(new FangjianBean("标间", 125, 12));
//		return fangxing;
//
//	}

}
