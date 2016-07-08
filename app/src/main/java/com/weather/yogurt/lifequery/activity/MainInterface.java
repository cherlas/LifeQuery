package com.weather.yogurt.lifequery.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

import com.weather.yogurt.lifequery.R;

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
