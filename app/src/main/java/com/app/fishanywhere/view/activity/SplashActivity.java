package com.app.fishanywhere.view.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Handler;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.app.fishanywhere.R;

public class SplashActivity extends AppCompatActivity {
    private static int SPLASH_DELAY=3000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        setStatusBarColor();
        startNext();

    }

    private void startNext() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
//                Bundle  bundle = (Bundle) getIntent().getExtras().get("google.delivered_priority");
                // This method will be executed once the timer is over
                if (getIntent().hasExtra("pushnotification")||
                        (getIntent()!=null&&
                        getIntent().getExtras()!=null&&   getIntent().getExtras().get("google.delivered_priority")!=null&&
                        getIntent().getExtras().get("google.delivered_priority").equals("high"))) {
                    Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                    intent.putExtra("pushnotification", "yes");
                    startActivity(intent);
                    finish();
                } else {
                    Intent i = new Intent(SplashActivity.this, InfoActivity.class);
                    startActivity(i);
                    finish();
                }

            }
        }, SPLASH_DELAY);
    }

    private void setStatusBarColor() {
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(Color.WHITE);
        }
    }

}
