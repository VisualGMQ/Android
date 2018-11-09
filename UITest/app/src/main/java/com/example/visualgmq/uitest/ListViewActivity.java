package com.example.visualgmq.uitest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.*;
import android.widget.*;

public class ListViewActivity extends AppCompatActivity {
    private String names[]={"Apple","Orange","Banana","Mango","Coconat","Pear","milk","soup","C++","Android","C","Java","Python","Objective-C","Lua","Kotlin","Swift"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_list_view);

        ArrayAdapter<String> arr =  new ArrayAdapter<String>(ListViewActivity.this,android.R.layout.simple_list_item_1,names);
        ListView lv = (ListView)findViewById(R.id.listview);
        lv.setAdapter(arr);
    }

}
