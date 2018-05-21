package com.scout_zong.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class DBContent extends DB {
	// 登陆
	public int LoginDB(String username, String password) {
		int isInt = 3;
		try {
			if (conn == null)
				conn = getConn();
			String sql = "select * from User where username=? and password=? ";
			PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
			// 设定参数

			pstmt.setString(1, username);
			pstmt.setString(2, password);

			// 获取查询的结果集
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				System.out.println("登录成功！");
				isInt = 1;
			} else {
				System.out.println("登录失败！");
				isInt = 0;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isInt;

	}
	// 登陆联系人
		public String lianxirenDB(String username) {
			String isInt = "";
			try {
				if (conn == null)
					conn = getConn();
				String sql = "select * from User where username=?  ";
				PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
				// 设定参数

				pstmt.setString(1, username);
				

				// 获取查询的结果集
				ResultSet rs = pstmt.executeQuery();

				if (rs.next()) {
					System.out.println("登录成功！");
					isInt = rs.getString("myname");
					System.out.println("得到用户名："+rs.getString("myname"));
					System.out.println("得到用户名："+rs.getString("myphone"));
				} else {
					System.out.println("登录失败！");
					isInt = "";
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return isInt;

		}
		// 登陆手机号
				public String phoneDB(String username) {
					String isInt = "";
					try {
						if (conn == null)
							conn = getConn();
						String sql = "select * from User where username=?  ";
						PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
						// 设定参数

						pstmt.setString(1, username);
						

						// 获取查询的结果集
						ResultSet rs = pstmt.executeQuery();

						if (rs.next()) {
							System.out.println("登录成功！");
							isInt = rs.getString("myphone");
							System.out.println("得到手机号："+rs.getString("myphone"));
						} else {
							System.out.println("登录失败！");
							isInt = "";
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return isInt;

				}

	public int registerDB(String user, String pass, String email, String myname, String myphone, String nicheng) {
		try {

			if (conn == null)
				conn = getConn();

			Statement stat = null;
			String sql = "INSERT INTO User (username,password,myname,myphone,email,nicheng) " + "VALUES ('" + user
					+ "','" + pass + "','" + myname + "','" + myphone + "','" + email + "','" + nicheng + "')";

			stat = (Statement) conn.createStatement();

		 
			stat.executeUpdate(sql);

			System.out.println(sql);

			 

			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		return 1;
	}

	public int inDingdan(String homename, String shijian, String jiage,String myname,String phone,String log) {
		try {

			if (conn == null)
				conn = getConn();

			Statement stat = null;
			String sql = "INSERT INTO Dingdan (homename,shijian,jiage,myname,phone,log) " + "VALUES ('" + homename
					+ "','" + shijian + "','" + jiage +"','"+myname+"','"+phone+"','"+log+ "')";

			stat = (Statement) conn.createStatement();

			 
			stat.executeUpdate(sql);

			System.out.println(sql);

			 return 1;

			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public String findpass(String username) {
		String returnString = "";
		try {
			if (conn == null)
				conn = getConn();
			String sql = "SELECT * FROM User WHERE username=?";
			PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
			// 设定参数

			pstmt.setString(1, username);

			// 获取查询的结果集
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				returnString = rs.getString("password");

			} else {

				returnString = "";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnString;

	}

	// 查询语句，查询所有数据
	protected ResultSet getAll(String string, String tableName) {
		Connection conn = getConn();
		String sql = "select " + string + " from " + tableName;
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			return rs;
			// int col = rs.getMetaData().getColumnCount();
			//
			// while (rs.next()) {
			// for (int i = 1; i <= col; i++) {
			// System.out.print(rs.getString(i) + "\t");
			// if ((i == 2) && (rs.getString(i).length() < 8)) {
			// System.out.print("\t");
			// }
			// }
			// System.out.println("");
			// }
			//
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ResultSet getDingdan() {
		Connection conn = getConn();
		String sql = "select * from Dingdan";
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			return rs;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ResultSet mehuchaxun(String string) {
		try {
			if (conn == null)
				conn = getConn();
			String sql = "select * from Home" + " where name like ? ";
			PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
			// 设定参数

			pstmt.setString(1, "%" + string + "%");

			// 获取查询的结果集
			ResultSet rs = pstmt.executeQuery();
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public  int shanchu(String tablename,String lieming,String string) {
		String sql = "delete from "+tablename+" where "+lieming+"='"+string+"'";
		try {
			if (conn == null)
				conn = getConn();
			Statement stat = null; 
			stat = (Statement) conn.createStatement();
			stat.executeUpdate(sql);
			System.out.println(sql);
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	public  int  updata(String name,String string) {
		int action=0;
		Connection conn = getConn();
		String sql = "select * from User  where username='"+name+"'";
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String username=rs.getString("username");
				String password=rs.getString("password");
				String email=rs.getString("email");
				String myname=rs.getString("myname");
				String myphone=rs.getString("myphone");
				String nicheng=rs.getString("nicheng");
				 System.out.println(username+password+email+myname+myphone+nicheng);
				 action=  shanchu("User","username",rs.getString("username"));
				 action= registerDB(username, string, email, myname, myphone, nicheng);
				 
			}
			action= 1;
		} catch (SQLException e) {
			e.printStackTrace();
			action= 0;
		}
		 return action;
		 
	}
}
