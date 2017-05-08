package com.example.administrator.coolweather;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class CountyActivity extends AppCompatActivity {
    private  String [] county126={"上城区","下城区","西湖区","拱墅区","江干区","滨江区","萧山区"};
    private String[] county132={"鹿城区","瓯海区","龙湾区","湖州","衢州","金华","台州","温州","舟山","宁波","丽水"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_county);
        Intent intent=getIntent();
        String p=intent.getStringExtra("p");
        String[] data=null;
        if("上城区".equals(p)) {
            data = county126;
        }
        else {
            data=county132;

        }

        ListView listView= (ListView) findViewById(R.id.listview2);
        listView.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data));


    }
}

