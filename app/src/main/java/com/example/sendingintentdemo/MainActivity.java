package com.example.sendingintentdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String ACTION = "com.example.sendingintentdemo.ACTION";
    public static final String PERMISSION_PRIVATE = "com.example.sendingintentdemo.PERMISSION_PRIVATE";
    private final String TAG = "MainActivity";

    private Button sendIntentBtn;

    private BroadcastReceiver localReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(MainActivity.this, "MainActivity receives broadcast: "+intent.getAction(), Toast.LENGTH_SHORT).show();
            Log.i(TAG, "MainActivity has received intent");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sendIntentBtn = findViewById(R.id.send_intent_btn);
        sendIntentBtn.setOnClickListener( view -> {
            Intent intent = new Intent(ACTION);
            intent.setAction(ACTION);
            Log.i(TAG, "Intent is sent!");
            getApplicationContext().sendBroadcast(intent, PERMISSION_PRIVATE);
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter filter = new IntentFilter(ACTION);
        getApplicationContext().registerReceiver(localReceiver,
                filter,
                PERMISSION_PRIVATE,
                null);
    }

    @Override
    protected void onStop() {
        super.onStop();
        getApplicationContext().unregisterReceiver(localReceiver);
    }
}