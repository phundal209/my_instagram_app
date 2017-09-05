package com.example.phundal2091.templateapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.phundal2091.templateapplication.injection.ActivityModule;
import com.example.phundal2091.templateapplication.injection.DaggerMainActivityComponent;
import com.example.phundal2091.templateapplication.injection.DataModule;
import com.example.phundal2091.templateapplication.injection.MainActivityComponent;
import com.example.phundal2091.templateapplication.injection.SocialShareModule;

import javax.inject.Inject;

public class MainActivity extends ProgressBarCapableActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Inject
    SharedPreferences sharedPreferences;
    Button button;

    private MainActivityComponent component;
    private DrawerLayout drawer;
    private NavigationView navigationView;

    //Note: this is how injection will be used
    MainActivityComponent component() {
        if (component == null) {
            component = DaggerMainActivityComponent.builder()
                    .applicationComponent((getTemplateApplication()).getComponent())
                    .activityModule(new ActivityModule(this))
                    .socialShareModule(new SocialShareModule(this))
                    .dataModule(new DataModule(this))
                    .build();
        }
        return component;
    }

    private TemplateApplication getTemplateApplication() {
        return (TemplateApplication) getApplication();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.buttonToStartActivity2);
        final Intent intent = Henson.with(getApplicationContext())
                .gotoActivityTwo()
                .extra1("WORKS!")
                .build();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        return false;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

}
