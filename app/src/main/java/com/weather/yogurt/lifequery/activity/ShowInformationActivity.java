package com.weather.yogurt.lifequery.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.weather.yogurt.lifequery.R;
import com.weather.yogurt.lifequery.util.HttpCallbackListener;
import com.weather.yogurt.lifequery.util.HttpUtil;

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



        Intent intentFromMainInterface=getIntent();
        if (intentFromMainInterface!=null){
            boolean isFromMainInterface=intentFromMainInterface.getBooleanExtra("isFromMainInterface",true);
            if (isFromMainInterface){
                chooseItem=intentFromMainInterface.getStringExtra("chooseItem");
                inputContent=intentFromMainInterface.getStringExtra("inputContent");
                showDialog();
                requestInformation();
            }
        }
    }

    private void requestInformation() {
        String searchAddress="";
        switch (chooseItem){
            case "电话归属地": //http://apistore.baidu.com/apiworks/servicedetail/794.html
                searchAddress="http://apis.baidu.com/apistore/mobilenumber/mobilenumber?"+inputContent;
                break;
            case "IP地址": //http://apistore.baidu.com/apiworks/servicedetail/114.html
                searchAddress="http://apis.baidu.com/apistore/iplookupservice/iplookup?"+inputContent;
                break;
            case "邮编"://http://avatardata.cn/Docs/Api/b3d25cbd-449d-41c3-8765-21649658789e
                searchAddress="http://api.avatardata.cn/PostNumber/QueryPostnumber?key=[您申请的APPKEY]&postnumber="
                        +inputContent+"&page=1&rows=15?";
                break;
            case "银行卡"://http://apistore.baidu.com/apiworks/servicedetail/735.html
                searchAddress="http://apis.baidu.com/datatiny/cardinfo/cardinfo"+inputContent;
                break;
            case "苹果序列号"://...
                searchAddress="http://apis.baidu.com/apistore/mobilenumber/mobilenumber?"+inputContent;
                break;
            case "苹果IMEI"://...
                searchAddress="http://apis.baidu.com/apistore/mobilenumber/mobilenumber?"+inputContent;
                break;
            case "汇率"://http://apistore.baidu.com/apiworks/servicedetail/119.html //界面
                searchAddress="http://apis.baidu.com/apistore/currencyservice/currency?"+"fromCurrency=CNY&toCurrency=USD&amount=2";
                break;
            case "快递":
                searchAddress="http://apis.baidu.com/apistore/mobilenumber/mobilenumber?"+inputContent;
                break;
            case "股票"://http://apistore.baidu.com/apiworks/servicedetail/115.html
                searchAddress="http://apis.baidu.com/apistore/stockservice/hkstock?"+inputContent+"&list=1";
                break;
            case "火车票"://http://apistore.baidu.com/apiworks/servicedetail/697.html
                searchAddress="http://apis.baidu.com/qunar/qunar_train_service/traindetail?"+inputContent;
                String httpArg = "version=1.0&train=G101&from=%E5%8C%97%E4%BA%AC%E5%8D%97&" +
                        "to=%E4%B8%8A%E6%B5%B7%E8%99%B9%E6%A1%A5&date=2015-09-01";
                break;
            case "商标":
                searchAddress="http://apis.baidu.com/apistore/mobilenumber/mobilenumber?"+inputContent;
                break;
            case "景点门票"://http://apistore.baidu.com/apiworks/servicedetail/140.html
                searchAddress="http://apis.baidu.com/apistore/qunaerticket/querydetail?id="+inputContent;
                break;
            case "万年历"://api不可用
                searchAddress="http://apis.baidu.com/apistore/mobilenumber/mobilenumber?"+inputContent;
                break;
        }
        HttpUtil.sendHttpRequest(searchAddress,listener);
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
                    parsePhoneNumberOwnership(object);
                    break;
                case "IP地址":
                    parseIpAddress(object);
                    break;
                case "邮编":
                    parseZipCode(object);
                    break;
                case "银行卡":
                    parseBankCard(object);
                    break;
                case "苹果序列号":
                    parseAppleSerialNumber(object);
                    break;
                case "苹果IMEI":
                    parseAppleIMEINumber(object);
                    break;
                case "汇率":
                    parseExchangeRate(object);
                    break;
                case "快递":
                    parseExpress(object);
                    break;
                case "股票":
                    parseShares(object);
                    break;
                case "火车票":
                    parseTrainTickets(object);
                    break;
                case "商标":
                    parseTrademark(object);
                    break;
                case "景点门票":
                    parseAttractionsTicketsPrice(object);
                    break;
                case "万年历":
                    parsePerpetualCalendar(object);
                    break;
            }
        }

        @Override
        public void onError(Exception e) {
        }
    };

    private void parseShares(JSONObject object) {

    }

    private void parseExpress(JSONObject object) {

    }

    private void parseTrainTickets(JSONObject object) {

    }

    private void parseTrademark(JSONObject object) {

    }

    private void parseExchangeRate(JSONObject object) {

    }

    private void parseAppleIMEINumber(JSONObject object) {
    }

    private void parseAttractionsTicketsPrice(JSONObject object) {
    }

    private void parsePerpetualCalendar(JSONObject object) {

    }

    private void parseAppleSerialNumber(JSONObject object) {
    }

    private void parseBankCard(JSONObject object) {
    }

    private void parseZipCode(JSONObject object) {
    }

    private void parseIpAddress(JSONObject object) {
    }

    private void parsePhoneNumberOwnership(JSONObject object) throws JSONException {
        String errNum=object.getString("errNum");
        if (errNum.equals("0")){

        }else if (errNum.equals("-1")){
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    makeToast();
                }
            });
        }
    }

    private void makeToast() {
        Toast.makeText(ShowInformationActivity.this,"查询失败",Toast.LENGTH_SHORT).show();
        onBackPressed();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}


