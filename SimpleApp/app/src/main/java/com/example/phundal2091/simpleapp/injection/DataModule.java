package com.example.phundal2091.simpleapp.injection;

import android.app.Activity;

import com.example.data.repository.RealmRepository;
import com.example.phundal2091.simpleapp.injection.annotation.PerActivity;
import com.example.services.observers.ApiService;
import com.example.services.observers.IApiService;
import com.example.services.retrofit.IRetrofitProvider;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;

/**
 * Created by phundal on 9/6/17.
 */
@Module
public class DataModule {
    private final Activity activity;

    public DataModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @PerActivity
    RealmRepository provideRealmRepository(Realm realm) {
        return new RealmRepository(realm);
    }

    @Provides
    @PerActivity
    IApiService providesApiService(IRetrofitProvider retrofitProvider) {
        return new ApiService(retrofitProvider);
    }

}
