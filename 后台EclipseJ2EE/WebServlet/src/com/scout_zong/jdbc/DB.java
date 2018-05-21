package com.scout_zong.jdbc;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class DB {
	protected Connection conn;
	// SQL连接
		protected   Connection getConn() {
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/Shiyan?useUnicode=true&characterEncoding=utf-8&useSSL=false";
			String username = "root";
			String password = "11111111";
			Connection conn = null;
			try {
				Class.forName(driver); // classLoader,打开数据库
				conn = (Connection) DriverManager.getConnection(url, username, password);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return conn;
		}
		// 查询语句
		protected   ResultSet getAll(String keyname,String tablename) {
			Connection conn = getConn();
			String sql = "select " + keyname + " from "+tablename;
			PreparedStatement pstmt;
			try {
				pstmt = (PreparedStatement) conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
//				int col = rs.getMetaData().getColumnCount();
//				while (rs.next()) {
//					for (int i = 1; i <= col; i++) {
//						System.out.print(rs.getString(i) + "\t");
//						if ((i == 2) && (rs.getString(i).length() < 8)) {
//							System.out.print("\t");
//						}
//					}
//					System.out.println("");
//				}
				return rs;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}
}
