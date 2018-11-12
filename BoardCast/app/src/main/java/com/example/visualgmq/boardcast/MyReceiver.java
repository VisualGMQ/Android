package com.example.visualgmq.boardcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"the phone is open!!!",Toast.LENGTH_LONG).show();
        // an Intent broadcast.
        //throw new UnsupportedOperationException("Not yet implemented");
    }
}
