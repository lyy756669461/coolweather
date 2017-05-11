package com.example.administrator.coolweather;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class cityActivity extends AppCompatActivity {
    private String[] city01 = {"北京"};
    private String[] city17 = {"杭州", "温州", "绍兴", "湖州", "衢州", "金华", "台州", "嘉兴", "舟山", "宁波", "丽水"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);
        Intent intent = getIntent();
        String p = intent.getStringExtra("p");
        String[] data = null;
        if ("北京".equals(p)) {
            data = city01;
        } else {
            data = city17;

        }

        ListView listView = (ListView) findViewById(R.id.listview1);
        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data));

            }
    }



