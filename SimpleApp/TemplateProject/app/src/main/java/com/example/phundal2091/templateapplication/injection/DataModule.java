package com.example.phundal2091.templateapplication.injection;

import android.app.Activity;

import dagger.Module;

/**
 * Created by phundal2091 on 11/17/16.
 */

@Module
public class DataModule {

    private final Activity activity;

    public DataModule(Activity activity) {
        this.activity = activity;
    }
}
