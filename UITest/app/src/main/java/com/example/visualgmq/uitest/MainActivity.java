package com.example.visualgmq.uitest;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import android.view.*;
import android.content.*;

public class MainActivity extends AppCompatActivity {
    static boolean bimg = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Button
        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"you clicked the button",Toast.LENGTH_SHORT).show();
            }
        });

        //EditText
        Button submit = (Button)findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                EditText et = (EditText)findViewById(R.id.edittext);
                String text = et.getText().toString();
                Toast.makeText(MainActivity.this,text,Toast.LENGTH_LONG).show();
            }
        });

        Button imgbutton = (Button)findViewById(R.id.imgbutton);
        imgbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageView img = (ImageView)findViewById(R.id.img);
                if(!bimg) {
                    img.setImageResource(R.mipmap.ai);
                    bimg=!bimg;
                }
                else {
                    img.setImageResource(R.mipmap.cv);
                    bimg=!bimg;
                }
            }
        });

        //ProgressBar
        final Button pbbutton = (Button)findViewById(R.id.showpb);
        pbbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                ProgressBar pb = (ProgressBar)findViewById(R.id.pb);
                if(pb.getVisibility() == View.INVISIBLE || pb.getVisibility() == View.GONE) {
                    pb.setVisibility(View.VISIBLE);
                    pbbutton.setText("click to hide ProgressBar");
                }else{
                    pb.setVisibility(View.GONE);
                    pbbutton.setText("click to show ProgressBar");
                }
            }
        });

        //AlterDialog
        Button diabutton = (Button)findViewById(R.id.dialbutton);
        diabutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                AlertDialog.Builder ad = new AlertDialog.Builder(MainActivity.this);
                ad.setTitle("Info");
                ad.setMessage("this is a AlertDialog");
                ad.setCancelable(false);
                ad.setPositiveButton("OK",new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog,int which){
                        Toast.makeText(MainActivity.this,"you selected OK",Toast.LENGTH_SHORT).show();
                    }
                });
                ad.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this,"you selected cancel",Toast.LENGTH_SHORT).show();
                    }
                });
                ad.show();
            }
        });

        //NextScene
        Button nextScene = (Button)findViewById(R.id.nextbutton);
        nextScene.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ListViewActivity.class);
                startActivity(intent);
            }
        });
    }
}
