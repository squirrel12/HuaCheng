package com.ett.csz.huacheng.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;

import com.ett.csz.huacheng.R;


public class WelcomeActivity extends Activity {
    private final int SPLASH_DISPLAY_LENGHT = 1000; //延迟1秒
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        new Handler().postDelayed(new Runnable(){
            public void run(){
                Intent mainIntent=new Intent(WelcomeActivity.this,LoginActivity.class);
                WelcomeActivity.this.startActivity(mainIntent);
                WelcomeActivity.this.finish();
            }
        },SPLASH_DISPLAY_LENGHT);
    }
}
