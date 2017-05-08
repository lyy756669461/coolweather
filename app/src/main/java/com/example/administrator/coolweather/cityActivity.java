package com.example.administrator.coolweather;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class cityActivity extends AppCompatActivity {
   private  String [] city01={"北京"};
    private String[] city17={"杭州","嘉兴","绍兴","湖州"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);
        Intent intent=getIntent();
        String p=intent.getStringExtra("p");
        String[] data=null;
        if("北京".equals(p)) {
            data = city01;
        }
        else {
            data=city17;

        }

        ListView listView= (ListView) findViewById(R.id.listview1);
        listView.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data));

    }
}
