package com.example.phundal2091.templateapplication.injection_template_java;

import com.example.phundal2091.templateapplication.injection.AbstractActivityComponent;
import com.example.phundal2091.templateapplication.injection.ApplicationComponent;
import com.example.phundal2091.templateapplication.injection.annotations.PerActivity;

import dagger.Component;

@PerActivity // Subtypes of AbstractActivityComponent should be decorated with @PerActivity.
@Component(dependencies = ApplicationComponent.class,
        modules = {
                NewActivityTemplateModule.class
//                , DataModule.class
        }
)
public interface NewActivityTemplateComponent extends AbstractActivityComponent {
    void inject(NewActivityTemplateActivity newActivityTemplateActivity);
}
