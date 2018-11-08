package com.example.visualgmq.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import android.view.*;


public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button b1 = (Button)findViewById(R.id.button3);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Main2Activity.this,"change to the first Scene!",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Main2Activity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        Button b2 = (Button)findViewById(R.id.urlbutton);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intent);
            }
        });
        Button b3 = (Button)findViewById(R.id.diabutton);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:17344034087"));
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume(){
        super.onResume();
        Toast.makeText(Main2Activity.this,"onResume",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected  void onStart(){
        super.onStart();
        Toast.makeText(Main2Activity.this,"onStart",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected  void onStop(){
        super.onStop();
        Toast.makeText(Main2Activity.this,"onStop",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected  void onPause(){
        super.onPause();
        Toast.makeText(Main2Activity.this,"onPause",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected  void onDestroy(){
        super.onDestroy();
        Toast.makeText(Main2Activity.this,"onDestroy",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected  void onRestart(){
        super.onRestart();
        Toast.makeText(Main2Activity.this,"onRestart",Toast.LENGTH_SHORT).show();
    }
}