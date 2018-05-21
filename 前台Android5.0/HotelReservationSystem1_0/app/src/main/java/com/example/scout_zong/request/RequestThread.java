package com.example.scout_zong.request;

import android.os.Handler;
import android.os.Message;

import com.example.scout_zong.tool.Tool;

import java.io.IOException;



import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by scout_zong on 2018/4/30.
 */

public class RequestThread extends Thread  implements Runnable{
    private String retuernString;
    private BaseRequest baseRequest;
    private Handler handler;
    private Tool tool;


    private String ceshiURLAdder="http://www.kuaidi100.com/query?type=快递公司代号&postid=快递单号";
    public RequestThread(Tool tool) {
        this.tool=tool;
        handler=tool.getHandler();
    }


    public void setBaseRequest(BaseRequest baseRequest) {
        this.baseRequest = baseRequest;
    }


    @Override
    public void run() {
        super.run();

        BaseRequest.RequestResult result = BaseRequest.RequestResult.RESULT_FAIL;
        try {
            OkHttpClient client = new OkHttpClient();//创建OkHttpClient对象
            Request request = new Request.Builder()
                    .url("http://"+"172.20.10.3"+":8080/WebServlet/" + baseRequest.getSERLATNAME() + "?nid=" + baseRequest.getTAG()+baseRequest.getURLBody())//请求接口。如果需要传参拼接到接口后面。
//                    .url(ceshiURLAdder)
                    .build();//创建Request 对象

            Response response = null;
            response = client.newCall(request).execute();//得到Response 对象
            if (response.isSuccessful()) {
                retuernString = response.body().string();
                System.out.println(retuernString);
                baseRequest.setRequestString(retuernString);
            }
            result = BaseRequest.RequestResult.RESULT_SUCCESS;

        } catch (Exception e) {
            result = BaseRequest.RequestResult.RESULT_FAIL;
            e.printStackTrace();
        }
            Message mag= new Message();
            mag.what=baseRequest.getTAG();
            mag.obj=this;
            mag.arg1 = result.ordinal();
            handler.sendMessage(mag);

    }
    // 该函数只能由ui主线程来调用，其他线程不能调用，目的是让ui主线程处理请求结果，以便界面刷新
    public void hanlderResult(BaseRequest.RequestResult result) {
            baseRequest.parseResult(result);
    }

}
