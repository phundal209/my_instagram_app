package com.example.phundal2091.templateapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

import com.example.phundal2091.templateapplication.injection.AppModule;
import com.example.phundal2091.templateapplication.injection.ApplicationComponent;
import com.example.phundal2091.templateapplication.injection.DaggerApplicationComponent;

import javax.inject.Inject;

/**
 * Created by phundal2091 on 11/17/16.
 */

public class TemplateApplication extends MultiDexApplication {
    @Inject
    SharedPreferences sharedPreferences;

    private ApplicationComponent applicationComponent;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent.builder()
                .appModule(new AppModule(this))
                .build();

        applicationComponent.inject(this);
    }

    public ApplicationComponent getComponent() {
        return applicationComponent;
    }
}
