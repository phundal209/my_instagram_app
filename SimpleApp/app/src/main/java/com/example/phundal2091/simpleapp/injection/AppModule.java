package com.example.phundal2091.simpleapp.injection;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.phundal2091.simpleapp.utils.IInstagramPreferences;
import com.example.phundal2091.simpleapp.utils.InstagramPreferences;
import com.example.services.retrofit.IRetrofitProvider;
import com.example.services.retrofit.RetrofitProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;

/**
 * Created by phundal on 9/6/17.
 */

@Module
public class AppModule {
    Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Application providesApplication() {
        return application;
    }

    @Provides
    @Singleton
    IInstagramPreferences providesInstagramPrefs() {
        return new InstagramPreferences(application);
    }

    @Provides @Singleton
    Context provideApplicationContext() {
        return application;
    }

    @Provides
    @Singleton
    IRetrofitProvider providesRetrofitProvider() {
        return new RetrofitProvider();
    }

    @Provides
    @Singleton
    SharedPreferences provideSharedPrefs() {
        return PreferenceManager.getDefaultSharedPreferences(application);
    }

    @Provides
    @Singleton
    Realm providesRealm(SharedPreferences sharedPreferences) {
        return Realm.getDefaultInstance();
    }
}
