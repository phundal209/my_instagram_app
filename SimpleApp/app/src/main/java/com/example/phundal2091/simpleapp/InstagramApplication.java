package com.example.phundal2091.simpleapp;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

import com.example.data.repository.RealmRepository;
import com.example.data.repository.UserModel;
import com.example.phundal2091.simpleapp.injection.AppModule;
import com.example.phundal2091.simpleapp.injection.ApplicationComponent;
import com.example.phundal2091.simpleapp.injection.DaggerApplicationComponent;
import com.example.services.retrofit.IRetrofitProvider;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by phundal2091 on 9/4/17.
 */

public class InstagramApplication extends MultiDexApplication {
    private ApplicationComponent applicationComponent;

    @Inject
    SharedPreferences sharedPreferences;

    @Inject
    Realm realm;

    @Inject
    IRetrofitProvider retrofitProvider;


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
        Realm.init(getApplicationContext());
        applicationComponent.inject(this);
    }

    public ApplicationComponent getComponent() {
        return applicationComponent;
    }
}
