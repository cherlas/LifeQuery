package com.weather.yogurt.lifequery.activity;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

import com.weather.yogurt.lifequery.R;
import com.weather.yogurt.lifequery.util.HttpCallbackListener;
import com.weather.yogurt.lifequery.util.HttpUtil;

import java.util.Arrays;
import java.util.List;

public class MainInterface extends AppCompatActivity implements View.OnClickListener{
    private Spinner spinnerChooseItem;
    private EditText searchContent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_interface);
        spinnerChooseItem= (Spinner) findViewById(R.id.spinner_choose_item);
        //spinner drop down data;
        Resources resources=getResources();
        List<String> spinnerDropDownData= Arrays.asList(resources.getStringArray(R.array.spinner_drop_down_item));
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,spinnerDropDownData);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerChooseItem.setAdapter(arrayAdapter);

        searchContent= (EditText) findViewById(R.id.search_content);

        //点击搜索按钮事件
        ImageButton search= (ImageButton) findViewById(R.id.search_button);
        search.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.search_button:
                String chooseItem= (String) spinnerChooseItem.getSelectedItem();
                String inputContent= String.valueOf(searchContent.getText());

                HttpCallbackListener listener=new HttpCallbackListener() {
                    @Override
                    public void onFinish(String result) {

                    }

                    @Override
                    public void onError(Exception e) {

                    }
                };
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
                    case "股票":
                        searchAddress="http://apis.baidu.com/apistore/mobilenumber/mobilenumber?"+inputContent;
                        break;
                    case "火车票":
                        searchAddress="http://apis.baidu.com/apistore/mobilenumber/mobilenumber?"+inputContent;
                        break;
                    case "商标":
                        searchAddress="http://apis.baidu.com/apistore/mobilenumber/mobilenumber?"+inputContent;
                        break;
                    case "景点门票":
                        searchAddress="http://apis.baidu.com/apistore/mobilenumber/mobilenumber?"+inputContent;
                        break;
                    case "万年历":
                        searchAddress="http://apis.baidu.com/apistore/mobilenumber/mobilenumber?"+inputContent;
                        break;
                }
                HttpUtil.sendHttpRequest(searchAddress,listener);
                break;
            default:break;
        }

    }
}
