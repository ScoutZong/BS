package com.scout_zong.serlvet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import javax.el.ArrayELResolver;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.valves.JDBCAccessLogValve;

import com.alibaba.fastjson.JSONObject;
import com.scout_zong.bean.HomeBean;
import com.scout_zong.jdbc.JDBCServlatContent;
import com.scout_zong.request.BaseRequest;
import com.scout_zong.request.DingdanShanchuRequest;
import com.scout_zong.request.GetDingdanRequest;
import com.scout_zong.request.HomeMegReqeust;
import com.scout_zong.request.HomeRequest;
import com.scout_zong.request.SetDiangdanReuqest;
import com.scout_zong.request.SousuoReuqest;
import com.scout_zong.request.UserJsonReuquest;
import com.scout_zong.tool.Tool;

//http://192.168.1.110:8080/News_Server/getSpecifyCategoryNews?cid=1&startnid=1&count=5
/**
 * Servlet implementation class OnServlet //
 */
@WebServlet("/onServlet")
public class OnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BaseRequest baseRequest;

	private Tool tool;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OnServlet() {
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
		String nidStr = request.getParameter("nid");
		tool = new Tool();
		JDBCServlatContent jdbcServlatContent = new JDBCServlatContent();
		switch (Integer.valueOf(nidStr)) {
		case HomeMegReqeust.TAG:
			baseRequest = new HomeMegReqeust(response.toString(), tool);
			break;
		case HomeRequest.TAG:
			baseRequest = new HomeRequest(jdbcServlatContent.getArrayList());
			break;
		case 3:
			baseRequest = new SousuoReuqest(request.getParameter("sousuo"));
			break;
		case SetDiangdanReuqest.TAG:
			baseRequest = new SetDiangdanReuqest(request.getParameter("homename"), request.getParameter("shijian"),
					request.getParameter("jiage"),request.getParameter("myname"),request.getParameter("myphone"), request.getParameter("log"));
			break;
		case GetDingdanRequest.TAG:
			baseRequest = new GetDingdanRequest();
			break;
		case DingdanShanchuRequest.TAG:
			baseRequest = new DingdanShanchuRequest(request.getParameter("homename"));
			break;
		default:
			break;
		}
		// http://localhost:8080/WebServlet/onServlet?nid=4&homename=Ï£¶û¶Ù&shijian=6ÔÂ15ÈÕ&jiage=128
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
