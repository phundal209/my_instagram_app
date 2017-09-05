package com.example.phundal2091.templateapplication.injection;

import com.example.phundal2091.templateapplication.MainActivity;
import com.example.phundal2091.templateapplication.injection.annotations.PerActivity;

import dagger.Component;

/**
 * Created by phundal2091 on 11/17/16.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class, SocialShareModule.class, DataModule.class})
public interface MainActivityComponent extends AbstractActivityComponent {
    void inject(MainActivity mainActivity);
}
