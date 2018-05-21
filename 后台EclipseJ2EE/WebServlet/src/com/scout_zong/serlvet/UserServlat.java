package com.scout_zong.serlvet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 

import com.alibaba.fastjson.JSONObject;
import com.scout_zong.request.BaseRequest;
import com.scout_zong.request.FindPassRequest;
import com.scout_zong.request.GetxinUserReuqest;
import com.scout_zong.request.HomeMegReqeust;
import com.scout_zong.request.RegisterRequest;
import com.scout_zong.request.UserJsonReuquest;
import com.scout_zong.tool.Tool;

/**
 * http://172.20.10.3:8080/WebServlet/UserServlat?nid=1&username=admin&password=admin2
 *http://localhost:8080/WebServlet/UserServlat?nid=1&username=admin&password=admin2
//143289721230121143
//http://yyjy.cnkipmlc.checkpass.net/getreport.html?tid=143289721230121143
 * 
 * @author Scout
 *
 */
@WebServlet("/UserServlat")
public class UserServlat extends HttpServlet {
	BaseRequest baseRequest;
	private static final long serialVersionUID = 1L;
	private Tool tool;


	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserServlat() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		tool=new Tool();
		int	nidStr=Integer.valueOf(request.getParameter("nid"));
		String username,password,email;
		switch (nidStr) {
		case UserJsonReuquest.TAG:
			  username=String.valueOf(request.getParameter("username"));
			  password = String.valueOf(request.getParameter("password"));
			baseRequest = new UserJsonReuquest(username,password);
			break;
		case FindPassRequest.TAG:
			username=String.valueOf(request.getParameter("username"));
			email=String.valueOf(request.getParameter("email"));
			baseRequest = new FindPassRequest(username,email);
			break;
		case RegisterRequest.TAG:
			username=String.valueOf(request.getParameter("username"));
			password = String.valueOf(request.getParameter("password"));
			email=String.valueOf(request.getParameter("email"));
			String myname = String.valueOf(request.getParameter("myname"));
			String myphone = String.valueOf(request.getParameter("myphone"));
			baseRequest = new RegisterRequest(username,password,email,myname,myphone);
			break;
		case GetxinUserReuqest.TAG:
			username=String.valueOf(request.getParameter("username"));
			password=String.valueOf(request.getParameter("password"));
			baseRequest = new GetxinUserReuqest(username,password);
			break;
		default:
			break;
		}
		PrintWriter out = response.getWriter();
		out.println(baseRequest.getJson());
		out.flush();
		out.close();
	 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
