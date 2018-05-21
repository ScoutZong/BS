package com.example.scout_zong.tool;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;
import android.widget.Toast;


import com.example.scout_zong.request.BaseRequest;
import com.example.scout_zong.request.RequestThread;

import java.util.prefs.Preferences;

/**
 * 工具类，用于整个项目调用
 */

public class Tool {
    private Handler handler;


    public Handler getHandler() {
        return handler;
    }

    Context context;
    private SharedPreferences sharedPreferences;//轻量级存储，用于临时数据的保存
   private void getHandleMessage(){
       handler = new Handler() {
           @Override
           public void handleMessage(Message msg) {
               super.handleMessage(msg);
//               switch (msg.what){
//                   case 1:
                       RequestThread requestThread= (RequestThread)msg.obj;
                       requestThread.hanlderResult(BaseRequest.RequestResult.values()[ msg.arg1]);
//                       break;
//
//               }
           }
       };

   }

    public Tool(Context context) {
       this.context=context;
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        getHandleMessage();
    }

    /***
     * 设置登陆用户名
     */

    public void setLogin(String string) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("login", string);
        editor.commit();
    }

    /***
     * 得到离店时间
     * @return
     */
    public String getEndTime() {
        return sharedPreferences.getString("endtime", "");
    }

    /***
     * 设置离店时间
     * @param endTime
     */
    public void setEndTime(String endTime) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("endtime", endTime);
        editor.commit();
    }

    /***
     * 得到入店时间
     * @return
     */
    public String getStartTime() {
        return sharedPreferences.getString("starttime", "");
    }


    /***
     * 设置入店时间
     * @param startTime
     */
    public void setStartTime(String startTime) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("starttime", startTime);
        editor.commit();
    }

    /***
     * 设置住店天数
     * @param numberDay
     */
    public void setNumberDay(int numberDay){
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putInt("numberDay",numberDay);
        editor.commit();
    }

    /***
     * 得到住店天数
     * @return
     */
    public int getNumberDay(){
        return sharedPreferences.getInt("numberDay",0);
    }
    /***
     * 得到登陆
     * @return
     */
    public String getLogint() {
        return sharedPreferences.getString("login", "");
    }

    /***
     * 保存用户名
     * @param string
     */
    public void setUsername(String string) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("username", string);
        editor.commit();
    }

    /***
     * 获取用户名
     * @return
     */

    public String getUsername() {
        return sharedPreferences.getString("username", "");
    }

    /***
     * 保存密码
     * @param string
     */
    public void setPassword(String string) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("password", string);
        editor.commit();
    }

    /***
     * 获取密码
     * @return
     */
    public String getPassword() {
        return sharedPreferences.getString("password", "");
    }

    /**
     * 设置联系人
     * @param string
     */
    public void setMyname(String string) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("myname", string);
        editor.commit();
    }

    /***
     * 获取联系人
     * @return
     */
    public String getMyname() {
        return sharedPreferences.getString("myname", "");
    }
    /**
     * 设置联系人
     * @param string
     */
    public void setMyphone(String string) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("myphone", string);
        editor.commit();
    }

    /***
     * 获取联系人
     * @return
     */
    public String getphone() {
        return sharedPreferences.getString("myphone", "");
    }
    /**
     * 设置IP
     * @param string
     */
    public void setIP(String string) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("IP", string);
        editor.commit();
    }

    /***
     * 获取IP
     * @return
     */
    public String getIP() {
        return sharedPreferences.getString("IP", "");
    }
    /***
     * 设置订单数
     * @return
     */
    public void setDdingdanshu(int inta) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("dingdanshu",inta);
        editor.commit();
    }

    /***
     * 获取订单数
     * @return
     */
    public int getDingdanshu() {
        return sharedPreferences.getInt("dingdanshu",0);
    }
    /***
     * 设置价格
     * @return
     */
    public void setJiage(String string) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("jiage", string);
        editor.commit();
    }

    /***
     * 获取价格
     * @return
     */
    public String getJiage() {
        return sharedPreferences.getString("jiage", "");
    }

}


