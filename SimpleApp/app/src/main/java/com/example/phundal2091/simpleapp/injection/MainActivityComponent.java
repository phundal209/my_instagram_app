package com.example.phundal2091.simpleapp.injection;

import com.example.phundal2091.simpleapp.ui.login.MainActivity;
import com.example.phundal2091.simpleapp.injection.annotation.PerActivity;

import dagger.Component;
/**
 * Created by phundal on 9/6/17.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class, DataModule.class})
public interface MainActivityComponent extends AbstractActivityComponent {
    void inject(MainActivity mainActivity);
}
