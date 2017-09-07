package com.example.phundal2091.simpleapp.ui.feed;

import android.app.Activity;

import com.example.data.repository.RealmRepository;
import com.example.phundal2091.simpleapp.injection.annotation.PerActivity;
import com.example.phundal2091.simpleapp.services.IInstagramService;
import com.example.phundal2091.simpleapp.services.InstagramService;
import com.example.phundal2091.simpleapp.utils.InstagramPreferences;
import com.example.services.observers.IApiService;
import com.example.services.retrofit.IRetrofitProvider;

import dagger.Module;
import dagger.Provides;

/**
 * Created by phundal on 9/6/17.
 */

@Module
public class FeedModule {
    private final Activity activity;

    public FeedModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @PerActivity
    Activity activity() {
        return activity;
    }

    @Provides
    @PerActivity
    IInstagramService providesInstagramService(IRetrofitProvider retrofitProvider, IApiService apiService) {
        return new InstagramService(activity, retrofitProvider, apiService, new InstagramPreferences(activity));
    }

    @Provides
    @PerActivity
    IFeedPresenter providesFeedPresenter(RealmRepository realmRepository, IApiService apiService, IInstagramService instagramService) {
        return new FeedPresenter(activity, new FeedView(), realmRepository, apiService, instagramService);
    }
}
