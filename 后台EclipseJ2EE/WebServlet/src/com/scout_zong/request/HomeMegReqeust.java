package com.scout_zong.request;

import java.io.File;

import com.alibaba.fastjson.JSONObject;
import com.scout_zong.tool.Tool;

public class HomeMegReqeust extends BaseRequest {
	public static final int TAG=1;
	private String request="";
	private Tool tool;
	private String tupianAdder="C:\\Serlver\\tupianziyuan\\jiudianzhaopian\\1.jpg";

	public HomeMegReqeust(String string,Tool object) {
		request=string;
		tool=object;
	}
	@Override
	public String getJson() {
		
		try {
			JSONObject object=new JSONObject();
			object.put("homename", "xierdun");
//			String aa= tool.byteToString(tool.loadImage(new File(tupianAdder)));
//			object.put("homelog", aa);
			byte[] bb=tool.loadImage(new File("C:\\Users\\Scout\\Pictures\\Saved Pictures\\timg.jpg"));
			System.out.println(bb);
			String ss= tool.byteToString(bb);
			object.put("asdf", ss);
			return ss;
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return super.getJson();
	}
	public JSONObject getjsononb() {
		try {
			JSONObject object=new JSONObject();
			object.put("homename", "xierdun");
//			String aa= tool.byteToString(tool.loadImage(new File(tupianAdder)));
//			object.put("homelog", aa);
			byte[] bb=tool.loadImage(new File("C:\\Users\\Scout\\Pictures\\Saved Pictures\\timg.jpg"));
			System.out.println(bb);
			String ss= tool.byteToString(bb);
			object.put("asdf", ss);
			return object;
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
		
	}

}
