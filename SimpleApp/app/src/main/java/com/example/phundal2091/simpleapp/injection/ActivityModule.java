package com.example.phundal2091.simpleapp.injection;

import android.app.Activity;

import com.example.phundal2091.simpleapp.injection.annotation.PerActivity;
import com.example.phundal2091.simpleapp.ui.login.ILoginPresenter;
import com.example.phundal2091.simpleapp.ui.login.LoginPresenter;
import com.example.phundal2091.simpleapp.ui.login.LoginView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by phundal on 9/6/17.
 */
@Module
public class ActivityModule {
    private final Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    /**
     * Expose the activity to dependents in the graph.
     */
    @Provides
    @PerActivity
    Activity activity() {
        return activity;
    }

    @Provides
    @PerActivity
    ILoginPresenter loginPresenter() {
        return new LoginPresenter(activity, new LoginView(activity
                .findViewById(android.R.id.content)));
    }
}
