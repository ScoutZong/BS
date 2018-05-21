package com.scout_zong.tool;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.zip.GZIPOutputStream;
/**
 * 工具类
 * @author Scout
 *
 */
public class Tool {
 
 
		 /**
		  * 将图片转换为字节数组
		  * @return
		  */

		public byte[] loadImage(File file) {
			byte[] data=null;
			FileInputStream fin=null;
			ByteArrayOutputStream bout=null;
			try {
				fin =new FileInputStream(file);
				bout=new ByteArrayOutputStream((int)file.length());
				byte[] buffer= new byte[1024];
				int len = -1;
				while ((len=fin.read(buffer))!=-1) {
					bout.write(buffer,0,len);
				}
				data=bout.toByteArray();
				fin.close();
				bout.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
			return data;
			
		}
		 /**
		 2 * 把字节数组转化为字符串----"ISO-8859-1"
		 3 * @param date
		 4 * @return
		 5 */

		public  String byteToString(byte[] data)
		{
			String dataString=null;
			try {
				dataString =new String(data, "ISO-8859-1");
			} catch (Exception e) {
				// TODO: handle exception
			}
			return dataString;
		}
		/**
		 2 * 压缩字符串----"ISO-8859-1"
		 3 * @param data
		 4 * @return
		 5 */

		public  String compress(String data) {
			String finalData=null;
			try {
				ByteArrayOutputStream bout=new ByteArrayOutputStream();
				GZIPOutputStream gout= new GZIPOutputStream(bout);
				gout.write(data.getBytes("ISO-8859-1"));
				gout.finish();
				gout.close();
				finalData=bout.toString("ISO-8859-1");
			} catch (Exception e) {
				// TODO: handle exception
			}
			return finalData;
		}
	 

}
