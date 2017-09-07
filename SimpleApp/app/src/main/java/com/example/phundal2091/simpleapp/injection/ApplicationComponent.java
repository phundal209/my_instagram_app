package com.example.phundal2091.simpleapp.injection;
import android.app.Application;

import com.example.phundal2091.simpleapp.InstagramApplication;
import com.example.services.retrofit.IRetrofitProvider;

import javax.inject.Singleton;

import dagger.Component;
import io.realm.Realm;

@Singleton
@Component(modules = {AppModule.class})
public interface ApplicationComponent {
    void inject(InstagramApplication application);
    // Exported for child-components.
    Application application();
    IRetrofitProvider retrofitProvider();
    Realm realm();

}