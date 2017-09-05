package com.example.phundal2091.templateapplication.injection;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.phundal2091.templateapplication.R;

import javax.inject.Singleton;

import config.IRetrofitProvider;
import config.TemplateRetrofitProvider;
import dagger.Module;
import dagger.Provides;
import rest.AsyncFactory;
import rest.IAsyncFactory;

/**
 * Created by phundal2091 on 11/17/16.
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
    SharedPreferences provideSharedPrefs() {
        return PreferenceManager.getDefaultSharedPreferences(application);
    }

    @Provides @Singleton
    Context provideApplicationContext() {
        return application;
    }

    @Provides
    @Singleton
    IAsyncFactory providesAsyncFactory(){
        return new AsyncFactory();
    }

    @Provides
    @Singleton
    IRetrofitProvider providesRetrofitProvider(SharedPreferences sharedPreferences){

        TemplateRetrofitProvider apiRetrofitProvider = new TemplateRetrofitProvider(application, sharedPreferences);
        String baseUrl = sharedPreferences.getString(SharedPreferencesKeys.PREFERRED_BASE_URL, application.getString(R.string.base_url_mobile_api));

        apiRetrofitProvider.setBaseUrl(baseUrl);
        return apiRetrofitProvider;
    }
}
