package com.example.visualgmq.fileio;

import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import java.io.*;
import android.content.*;

public class PrepActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prep);

        Button returnbutton = (Button)findViewById(R.id.returnbutton);
        returnbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PrepActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        Button ibutton = (Button)findViewById(R.id.sbutton);
        ibutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor =  getSharedPreferences("test",MODE_PRIVATE).edit();
                EditText et = (EditText)findViewById(R.id.text);
                editor.putString("name",et.getText().toString());
                editor.apply();
            }
        });

        Button obutton = (Button)findViewById(R.id.obutton);
        obutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences pre = getSharedPreferences("test",MODE_PRIVATE);
                Toast.makeText(PrepActivity.this,"the name is "+pre.getString("name","null"),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
