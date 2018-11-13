package com.example.visualgmq.fileio;

import android.content.SharedPreferences.Editor;
import android.content.*;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import android.view.*;
import java.io.*;
import java.sql.BatchUpdateException;
import java.util.*;

import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    private FileOutputStream fos;
    private FileInputStream ios;
    private BufferedWriter bw;
    private BufferedReader br;
    private String text;

    @Override
    //use simple file.
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button obutton1 = (Button)findViewById(R.id.obutton1);
        obutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    ios = openFileInput("test.txt");
                    br = new BufferedReader(new InputStreamReader(ios));
                    Toast.makeText(MainActivity.this,br.readLine(),Toast.LENGTH_LONG).show();
                    br.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        });

        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    fos = openFileOutput("test.txt", Context.MODE_PRIVATE);
                    bw = new BufferedWriter(new OutputStreamWriter(fos));
                    EditText et = (EditText)findViewById(R.id.edittext);
                    text = et.getText().toString();
                    bw.write(text);
                    bw.close();
                    Toast.makeText(MainActivity.this,"the text has saved",Toast.LENGTH_SHORT).show();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        });

        Button bnext = (Button)findViewById(R.id.buttonnext);
        bnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,PrepActivity.class);
                startActivity(intent);
            }
        });
    }
}