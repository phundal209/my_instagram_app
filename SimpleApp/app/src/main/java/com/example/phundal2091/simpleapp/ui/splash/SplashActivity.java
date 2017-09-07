package com.example.phundal2091.simpleapp.ui.splash;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.phundal2091.simpleapp.R;
import com.example.phundal2091.simpleapp.navigation.NavigationService;

public class SplashActivity extends AppCompatActivity {

    Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                NavigationService.launchLogin(SplashActivity.this);
            }
        }, 3000);

    }
}
