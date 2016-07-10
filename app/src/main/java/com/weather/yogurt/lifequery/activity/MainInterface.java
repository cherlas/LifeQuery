package com.weather.yogurt.lifequery.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
import com.weather.yogurt.lifequery.model.TelephoneNumberOwnership;
import com.weather.yogurt.lifequery.util.Utilty;

import java.util.Arrays;
import java.util.Date;
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
        String tableName;
        switch ((String)spinnerChooseItem.getSelectedItem()){
            case "电话归属地":
                tableName=
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
}
