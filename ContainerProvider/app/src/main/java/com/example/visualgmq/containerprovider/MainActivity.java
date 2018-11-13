package com.example.visualgmq.containerprovider;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import android.view.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button diabutton = (Button)findViewById(R.id.dialbutton);
        diabutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ActivityCompat.checkSelfPermission(MainActivity.this,"android.permission.CALL_PHONE") != PackageManager.PERMISSION_GRANTED)
                    ActivityCompat.requestPermissions(MainActivity.this,new String[]{"android.permission.CALL_PHONE"},1);
                else
                    call();
            }
        });
    }

    private void call(){
        try {
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:17355481727"));
            startActivity(intent);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,String[] permission,int[] grantResults){
        if(requestCode == 1)
            if(permission.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                call();
            }else{
                Toast.makeText(MainActivity.this,"the permission haven't got",Toast.LENGTH_LONG);
            }
    }
}
