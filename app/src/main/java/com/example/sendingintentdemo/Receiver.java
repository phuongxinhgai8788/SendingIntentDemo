package com.example.sendingintentdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class Receiver extends BroadcastReceiver {
    private final String TAG = "Receiver";
    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent != null){
            String action = intent.getAction();
            switch (action){
                case MainActivity.ACTION:
                    Toast.makeText(context, "Receiver receives intent: "+intent.getAction(), Toast.LENGTH_SHORT).show();
                    Log.i(TAG, "Receiver receives intent");
                    break;
            }
        }
    }
}
