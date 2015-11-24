package com.junerver.testo2oapp.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Junerver on 2015/11/11.
 */
public class HttpUtil {

    public static void sendHttpRequest(final String address,final HttpCallbackListener listener) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection = null;
                try {
                    URL url = new URL(address);
                    connection = (HttpURLConnection) url.openConnection();
//                    设置请求方式
                    connection.setRequestMethod("GET");
                    connection.setConnectTimeout(8000);
                    connection.setReadTimeout(8000);
                    connection.setDoInput(true);
                    connection.setDoOutput(true);
//                    获取输入流
                    InputStream in = connection.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                    StringBuffer response = new StringBuffer();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }
                    if (listener != null) {
                        listener.onFinish(response.toString());
                    }
                } catch (Exception e) {
                    if (listener != null) {
                        listener.onError(e);
                    }
                }finally {
                    if (connection != null) {
                        connection.disconnect();
                    }
                }
            }
        }).start();

    }

    /**这个工具类的使用方法：
     * 在需要连接网络请求数据的位置使用HttpUtil.sendHttpRequest(address,new HttpCallbackListener(){
     *     @override
     *     public void onFinsh(String response){
     *         //在这里根据返回内容执行具体的逻辑
     *         //TODO
     *     }
     *     @override
     *     public void onError(Exception e){
     *         //在这里对异常进行处理
     *         //TODO
     *     }
     * });
     *
     * */

}
