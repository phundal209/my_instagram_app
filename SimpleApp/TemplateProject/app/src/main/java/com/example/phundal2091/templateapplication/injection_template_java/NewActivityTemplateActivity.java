package com.example.phundal2091.templateapplication.injection_template_java;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.phundal2091.templateapplication.TemplateApplication;

import javax.inject.Inject;

public class NewActivityTemplateActivity extends AppCompatActivity {

    @Inject
    INewActivityTemplatePresenter newActivityTemplatePresenter;

    private NewActivityTemplateComponent component;
    NewActivityTemplateComponent component() {
        if (component == null) {
            component = DaggerNewActivityTemplateComponent.builder()
                    .applicationComponent(((TemplateApplication) getApplication()).getComponent())
                    .newActivityTemplateModule(new NewActivityTemplateModule(this))
                    // Todo: uncomment the following line if you need gfm api service or realm access injected
//                    .dataModule(new DataModule(this))
                    .build();
        }
        return component;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //todo: add actual layout reference to setContentView
//        setContentView(R.layout.activity_paged);

        component().inject(this);

        //do this after setContentView and pass in a reference to the inflated view
        //  replace null with the new value
        newActivityTemplatePresenter
                .getView()
                .withRootView(this.findViewById(android.R.id.content).getRootView());
        newActivityTemplatePresenter
                .bindControls();
    }
}
