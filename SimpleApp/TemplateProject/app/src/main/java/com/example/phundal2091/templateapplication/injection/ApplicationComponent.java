package com.example.phundal2091.templateapplication.injection;

import android.app.Application;
import android.content.SharedPreferences;

import com.example.phundal2091.templateapplication.TemplateApplication;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by phundal2091 on 11/17/16.
 */

@Singleton
@Component(modules = {AppModule.class})
public interface ApplicationComponent {
    void inject(TemplateApplication application);
    // Exported for child-components.
    Application application();
    SharedPreferences sharedPreferences();
}
