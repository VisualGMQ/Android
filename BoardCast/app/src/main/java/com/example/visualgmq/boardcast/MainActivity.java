package com.example.visualgmq.boardcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import android.view.*;

public class MainActivity extends AppCompatActivity {

    private IntentFilter intentFilter1,intentFilter2;
    private NetworkChangeBC networkChangeBC;
    private SelfReceiver selfReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("com.self.action.SELF_BC");
                sendBroadcast(intent);
            }
        });

        networkChangeBC = new NetworkChangeBC();
        intentFilter1 = new IntentFilter();
        intentFilter1.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver(networkChangeBC,intentFilter1);

        intentFilter2 = new IntentFilter();
        intentFilter2.addAction("com.self.action.SELF_BC");
        selfReceiver = new SelfReceiver();
        registerReceiver(selfReceiver,intentFilter2);
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        unregisterReceiver(networkChangeBC);
        unregisterReceiver(selfReceiver);
    }

    class NetworkChangeBC extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent){
            ConnectivityManager connectionManager = (ConnectivityManager)getSystemService(CONNECTIVITY_SERVICE);
            NetworkInfo networkinfo = connectionManager.getActiveNetworkInfo();
            if(networkinfo!=null)
                if(networkinfo.isAvailable())
                    Toast.makeText(context,"the Network is available!",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(context,"the Network is not avaliable!",Toast.LENGTH_SHORT).show();

        }
    }


   class SelfReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            // TODO: This method is called when the BroadcastReceiver is receiving
            // an Intent broadcast.
            Toast.makeText(context,"I have received the BroadCast",Toast.LENGTH_LONG).show();
        }
    }
}
