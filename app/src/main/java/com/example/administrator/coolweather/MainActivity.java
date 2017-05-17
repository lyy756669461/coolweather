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

    private List<String> dataList = new ArrayList<>();
    private List<String> dataList1 = new ArrayList<>();

    private List<String> provinces = Arrays.asList(new String[]{"北京", "浙江省", "江西省", "四川省", "江苏省", "重庆市", "河北省", "山西省", "辽宁省", "吉林省", "黑龙江省"});
    private List<String> city01 = Arrays.asList(new String[]{"北京"});
    private List<String> city02 = Arrays.asList(new String[]{"杭州", "温州", "绍兴", "湖州", "衢州", "金华", "台州", "嘉兴", "舟山", "宁波", "丽水"});
    private List<String> city = Arrays.asList(new String[]{"北京", "杭州", "温州", "绍兴", "湖州", "衢州", "金华", "台州", "嘉兴", "舟山", "宁波", "丽水"});
    private List<String> country1 = Arrays.asList(new String[]{"东城", "西城", "海淀", "朝阳", "丰台", "门头沟", "石景山"});
    private List<String> country2 = Arrays.asList(new String[]{"下沙区", "西湖区", "上城区", "拱墅区", "江干区", "萧山区"});
    private List<String> country3 = Arrays.asList(new String[]{"瓯海区", "龙湾区", "鹿城区", "永嘉县", "苍南县"});

    private int level = 1;
    private Button btn1 = null;
    private ListView listView = null;
    private ArrayAdapter<String> adapter;
    private int selectedProvinceIndex = 0;
    private int selectedcityIndex = 0;


    private void showCities(int position) {
        level = 2;
        this.btn1.setVisibility(View.VISIBLE);
        this.dataList.clear();
        if ("北京".equals(provinces.get(position))) {
            this.dataList.addAll(city01);
        } else {
            this.dataList.addAll(city02);
        }
        this.adapter.notifyDataSetChanged();
    }

    private void showCounties(int position) {
        level = 3;
        this.dataList1.clear();
        if ("北京".equals(city.get(position))) {
            this.dataList1.addAll(country1);
        } else  if ("杭州".equals(city.get(position))){
            this.dataList1.addAll(country2);
        }
        else{
            this.dataList1.addAll(country3);
        }
        adapter.notifyDataSetChanged();


    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.btn1= (Button) findViewById(R.id.button);
        listView= (ListView) findViewById(R.id.ListView);
        this.dataList.addAll(this.provinces);
        this.dataList1.addAll(this.city);
        adapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,this.dataList);
        adapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,this.dataList1);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (level == 1) {
                   selectedProvinceIndex=position;
                    showCities(position);

                } else if (level == 2) {
                    selectedcityIndex=position;
                    showCounties(selectedcityIndex);
                } else {

                }
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (level == 3) {
                    showCities(MainActivity.this.selectedcityIndex);
                } else if (level == 2) {
                    level = 1;
                    btn1.setVisibility(View.GONE);
                    MainActivity.this.dataList.clear();
                    MainActivity.this.dataList1.clear();
                    MainActivity.this.dataList.addAll(provinces);
                    MainActivity.this.dataList1.addAll(city);
                    MainActivity.this.adapter.notifyDataSetChanged();
                }
            }
        });
    }
}