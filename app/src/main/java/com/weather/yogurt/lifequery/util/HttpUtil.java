package com.weather.yogurt.lifequery.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Yogurt on 16/7/7.
 */
public class HttpUtil {
    public static void sendHttpRequest(final String address, final HttpCallbackListener listener, final String apiKey){
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection=null;
                try {
                    URL url=new URL(address);
                    connection= (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setConnectTimeout(8000);
                    connection.setReadTimeout(8000);
                    if (!apiKey.equals(""))
                        connection.setRequestProperty("apikey",apiKey);
                    InputStream is=connection.getInputStream();
                    BufferedReader reader=new BufferedReader(new InputStreamReader(is,"UTF-8"));
                    String line=null;
                    final StringBuffer response=new StringBuffer("[");
                    while ((line=reader.readLine())!=null){
                        response.append(line).append("\r\n");
                    }
                   // Log.d("HttpUtil",response.toString());
                    reader.close();
                    is.close();
                    if (listener!=null){
                        listener.onFinish(response.append("]").toString());
                    }
                }catch (Exception e){
                    if (listener!=null){
                        listener.onError(e);
                    }
                }
            }
        }).start();
    }
}
