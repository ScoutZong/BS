package com.example.scout_zong.request;

import com.example.scout_zong.hotelreservationsystem1_0.R;
import com.example.scout_zong.tool.bean.HomeBean;
import com.example.scout_zong.tool.bean.lndentBean;

/**
 * Created by scout_zong on 2018/4/30.
 */


public class BaseRequest {
    // 请求结果
    public enum RequestResult {
        RESULT_FAIL, RESULT_SUCCESS, RESULT_NO_NET;
    }
    protected String URLBody="";
    private boolean isSeecss;
    private  int TAG=0;
    public   String SERLATNAME="";
    protected void setSERLATTAG(String name,int tag){
        TAG=tag;
        SERLATNAME=name;
    }



    public int getTAG() {
        return TAG;
    }

    public String getSERLATNAME() {
        return SERLATNAME;
    }

    public String requestString;

    public void setRequestString(String requestString) {
        this.requestString = requestString;
    }
    // 解析服务器端的回应数据
    public void parseResult(RequestResult result) {
             analysisJSON();
        // 将请求结果通知给调用者
        if (responseEventListener != null) {
            responseEventListener.onResponse(this, result);
        }
    }



    public void analysisJSON(){}
    // 请求结果的回调函数
    private OnResponseEventListener responseEventListener;


    // 回调接口，将请求结果通知给调用者
    public interface OnResponseEventListener {
        /**
         * 将请求结果通知给调用者
         *
         * @param request
         *            请求对象
         * @param result
         *            请求的结果
         */
        void onResponse(BaseRequest request, RequestResult result);
    }
    public void setOnResponseEventListener(
            OnResponseEventListener responseEventListener) {
        this.responseEventListener = responseEventListener;
    }
    public void setSeecss(boolean seecss) {
        isSeecss = seecss;
    }

    public boolean isSeecss() {
        return isSeecss;
    }

    public void setURLBody(String URLBody) {
        this.URLBody = URLBody;
    }

    public String getURLBody() {
        return URLBody;
    }
    protected  void init(HomeBean ben, int i){
        switch (i){
            case 1:
                ben.setWaiguan(R.drawable.jiudian1);
                break;
            case 2:
                ben.setWaiguan(R.drawable.jiudian2);
                break;
            case 3:
                ben.setWaiguan(R.drawable.jiudian3);
                break;
            case 4:
                ben.setWaiguan(R.drawable.jiudian4);
                break;
            case 5:
                ben.setWaiguan(R.drawable.jiudian5);
                break;
            case 6:
                ben.setWaiguan(R.drawable.jiudian6);
                break;
            case 7:
                ben.setWaiguan(R.drawable.jiudian7);
                break;
            case 8:
                ben.setWaiguan(R.drawable.jiudian8);
                break;
            case 9:
                ben.setWaiguan(R.drawable.jiudian9);
                break;
            case 10:
                ben.setWaiguan(R.drawable.jiudian10);
                break;
            default:
                ben.setWaiguan(R.drawable.jiudian9);
                break;
        }


    }
    protected  void initIndent(lndentBean ben, Integer i){
        switch (Integer.valueOf(i)){
            case 1:
                ben.setWaiguan(R.drawable.jiudian1);
                break;
            case 2:
                ben.setWaiguan(R.drawable.jiudian2);
                break;
            case 3:
                ben.setWaiguan(R.drawable.jiudian3);
                break;
            case 4:
                ben.setWaiguan(R.drawable.jiudian4);
                break;
            case 5:
                ben.setWaiguan(R.drawable.jiudian5);
                break;
            case 6:
                ben.setWaiguan(R.drawable.jiudian6);
                break;
            case 7:
                ben.setWaiguan(R.drawable.jiudian7);
                break;
            case 8:
                ben.setWaiguan(R.drawable.jiudian8);
                break;
            case 9:
                ben.setWaiguan(R.drawable.jiudian9);
                break;
            case 10:
                ben.setWaiguan(R.drawable.jiudian10);
                break;
            default:
                ben.setWaiguan(R.drawable.jiudian9);
                break;
        }


    }
}
