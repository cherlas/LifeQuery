package com.weather.yogurt.lifequery.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

import com.baoyz.SwipeMenuListView.SwipeMenu;
import com.baoyz.SwipeMenuListView.SwipeMenuCreator;
import com.baoyz.SwipeMenuListView.SwipeMenuItem;
import com.baoyz.SwipeMenuListView.SwipeMenuListView;
import com.weather.yogurt.lifequery.R;
import com.weather.yogurt.lifequery.database.QueryDataBase;

import java.util.Arrays;
import java.util.List;

public class MainInterface extends AppCompatActivity implements View.OnClickListener{
    private Spinner spinnerChooseItem;
    private EditText searchContent;
    private SwipeMenuListView swipeMenuListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_interface);
        spinnerChooseItem= (Spinner) findViewById(R.id.spinner_choose_item);
        swipeMenuListView= (SwipeMenuListView) findViewById(R.id.history_record);
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


        //swipMenuListView
        SwipeMenuCreator creator=new SwipeMenuCreator() {
            @Override
            public void create(SwipeMenu menu) {
                // create "delete" item
                SwipeMenuItem deleteItem = new SwipeMenuItem(
                        getApplicationContext());
                // set item background
                deleteItem.setBackground(new ColorDrawable(Color.rgb(0xF9,
                        0x3F, 0x25)));
                // set item width
                deleteItem.setWidth(dp2px(90));
                // set a icon
                deleteItem.setIcon(R.drawable.ic_delete);
                // add to menu
                menu.addMenuItem(deleteItem);
            }
        };
        swipeMenuListView.setMenuCreator(creator);
        //click listener
        swipeMenuListView.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {
                switch (index){
                    case 0:
                        deleteDatabaseInformation();
                        swipeMenuListView.notifyAll();
                        break;
                }
                return false;
            }
        });

    }

    private void deleteDatabaseInformation() {

        String[] tableNameKeyWordKey=getTableNameKeyWordKey();
        String tableName=tableNameKeyWordKey[0];
        String keyWord=tableNameKeyWordKey[1];
        String key=tableNameKeyWordKey[2];

        QueryDataBase queryDataBase=QueryDataBase.getInstance(this);
        queryDataBase.deleteDatabaseInformation(tableName,keyWord,key);
    }

    private String[] getTableNameKeyWordKey() {
        String tableName="";
        String keyWord="";
        String key;
        switch ((String)spinnerChooseItem.getSelectedItem()){
            case "电话归属地":
                tableName="TelephoneHomeOwnership";
                keyWord="telephone_number";
                break;
            case "IP地址":
                tableName="IpAddress";
                keyWord="ip_address";
                break;
            case "邮编":
                tableName="ZipCode";
                keyWord="zip_code_number";
                break;
            case "银行卡":
                tableName="BankCard";
                keyWord="bank_card_number";
                break;
            case "苹果序列号":
                tableName="AppleSerialNumber";
                keyWord="apple_serial_number";
                break;
            case "苹果IMEI":
                tableName="AppleIMEINumber";
                keyWord="apple_imei_number";
                break;
            case "汇率":
                tableName="ExchangeRate";
                keyWord="exchange_rate";
                break;
            case "快递":
                tableName="Express";
                keyWord="express_number";
                break;
            case "股票":
                tableName="Shares";
                keyWord="shares";
                break;
            case "火车票":
                tableName="TrainTickets";
                keyWord="train_tickets_number";
                break;
            case "商标":
                tableName="Trademark";
                keyWord="trademark";
                break;
            case "景点门票":
                tableName="AttractionsTickets";
                keyWord="attractions_name";
                break;
            case "万年历":
                tableName="PerpetualCalendar";
                keyWord="perpetual_calendar";
                break;
        }
        key=String.valueOf(searchContent.getText());
        return new String[]{tableName,keyWord,key};
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.search_button:
                final String chooseItem= (String) spinnerChooseItem.getSelectedItem();
                final String inputContent= String.valueOf(searchContent.getText());
                Intent showInformationIntent=new Intent(MainInterface.this,ShowInformationActivity.class);
                showInformationIntent.putExtra("isFromMainInterface",true);
                showInformationIntent.putExtra("chooseItem",chooseItem);
                showInformationIntent.putExtra("inputContent",inputContent);
                startActivity(showInformationIntent);
                break;
            default:
                break;
        }

    }

    private int dp2px(int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
                getResources().getDisplayMetrics());
    }
}
