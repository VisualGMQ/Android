package com.example.visualgmq.uitest;

import com.example.visualgmq.uitest.MainActivity;
import android.app.Activity;
import android.content.Context;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class titleLayout extends LinearLayout {
    public titleLayout(Context context, AttributeSet attrs){
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.title,this);
        Button infobutton = (Button)findViewById(R.id.infobutton);
        infobutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"this is self-define component!",Toast.LENGTH_SHORT).show();
            }
        });

        Button hidebutton = (Button)findViewById(R.id.hidebutton);
        hidebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
    }
}
