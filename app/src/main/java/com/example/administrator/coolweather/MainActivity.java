package com.example.administrator.coolweather;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class MainActivity extends AppCompatActivity {


       private String[] provinces={"北京", "浙江省", "江西省", "四川省", "江苏省", "重庆市", "河北省", "山西省", "辽宁省", "吉林省", "黑龙江省"};
       private String[] city01 = {"北京"};
       private String[] city17 ={"杭州", "温州", "绍兴", "湖州", "衢州", "金华", "台州", "嘉兴", "舟山", "宁波", "丽水"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button btn1= (Button) findViewById(R.id.button);
         btn1.setVisibility(View.GONE);
        final ListView listView= (ListView) findViewById(R.id.list_view);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,provinces);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
         @Override
         public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
             btn1.setVisibility(View.VISIBLE);
             btn1.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     ArrayAdapter<String> adapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,provinces);
                     listView.setAdapter(adapter);
                     btn1.setVisibility(View.GONE);
                 }
             });
             Toast.makeText(MainActivity.this,provinces[position], Toast.LENGTH_SHORT).show();
             String[] data=null;
             if("北京".equals(provinces[position])) {
                 data = city01;
             }
              else
             {
                 data=city17;
             }

             ArrayAdapter<String> adapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,data);
             listView.setAdapter(adapter);
         }
     });
    }
}
