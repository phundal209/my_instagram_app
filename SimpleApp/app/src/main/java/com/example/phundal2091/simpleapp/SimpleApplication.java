package com.example.phundal2091.simpleapp;

import android.app.Application;

import com.example.data.repository.RealmRepository;

import io.realm.Realm;

/**
 * Created by phundal2091 on 9/4/17.
 */

public class SimpleApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Realm.init(getApplicationContext());
    }
}
