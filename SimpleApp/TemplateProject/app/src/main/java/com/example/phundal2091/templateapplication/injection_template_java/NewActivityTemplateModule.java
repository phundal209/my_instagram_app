package com.example.phundal2091.templateapplication.injection_template_java;

import android.app.Activity;

import com.example.phundal2091.templateapplication.injection.annotations.PerActivity;

import dagger.Module;
import dagger.Provides;

@Module
public class NewActivityTemplateModule {
    private final Activity activity;

    public NewActivityTemplateModule(Activity activity) {
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
    INewActivityTemplatePresenter providesNewActivityTemplatePresenter() {
        return new NewActivityTemplatePresenter(activity, new NewActivityTemplateView());
    }
}
