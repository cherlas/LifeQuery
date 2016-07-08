package com.weather.yogurt.lifequery.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.weather.yogurt.lifequery.R;
import com.weather.yogurt.lifequery.util.HttpCallbackListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Yogurt on 16/7/8.
 */
public class ShowInformationActivity extends Activity {
    private String chooseItem;
    private String inputContent;
    private boolean isCancelDialog=false;
    private Dialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_information_activity_layout);

        showDialog();

        Intent intentFromMainInterface=getIntent();
        if (intentFromMainInterface!=null){
            boolean isFromMainInterface=intentFromMainInterface.getBooleanExtra("isFromMainInterface",true);
            if (isFromMainInterface){
                chooseItem=intentFromMainInterface.getStringExtra("chooseItem");
                inputContent=intentFromMainInterface.getStringExtra("inputContent");

            }
        }
    }

    //显示Dialog
    private void showDialog(){
        if (dialog!=null){
            dialog=new Dialog(this);
        }
    }

    //取消Dialog
    private void cancelDialog(){
        if (dialog!=null&&isCancelDialog){
            dialog.dismiss();
        }

    }

    HttpCallbackListener listener=new HttpCallbackListener() {
        @Override
        public void onFinish(String result) throws JSONException {
            JSONArray jsonArray=new JSONArray(result);
            JSONObject object=jsonArray.getJSONObject(0);
            switch (chooseItem){
                case "电话归属地":
                    String errNum=object.getString("errNum");
                    if (errNum.equals("0")){

                    }else if (errNum.equals("-1")){
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(MainInterface.this,"查询失败",Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                    break;
                case "IP地址":
                    break;
                case "邮编":
                    break;
                case "银行卡":
                    break;
                case "苹果序列号":
                    break;
                case "苹果IMEI":
                    break;
                case "汇率":
                    break;
                case "快递":
                    break;
                case "股票":
                    break;
                case "火车票":
                    break;
                case "商标":
                    break;
                case "景点门票":
                    break;
                case "万年历":
                    break;
            }
        }

        @Override
        public void onError(Exception e) {
        }
    };
}


