package com.example.phundal2091.simpleapp.ui.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.phundal2091.simpleapp.InstagramApplication;
import com.example.phundal2091.simpleapp.injection.ActivityModule;
import com.example.phundal2091.simpleapp.injection.DaggerMainActivityComponent;
import com.example.phundal2091.simpleapp.injection.DataModule;
import com.example.phundal2091.simpleapp.injection.MainActivityComponent;
import com.example.phundal2091.simpleapp.R;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    private MainActivityComponent component;
    @Inject
    ILoginPresenter loginPresenter;

    MainActivityComponent component() {
        if (component == null) {
            component = DaggerMainActivityComponent.builder()
                    .applicationComponent((getInstagramApplication()).getComponent())
                    .activityModule(new ActivityModule(this))
                    .dataModule(new DataModule(this))
                    .build();
        }
        return component;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        component().inject(this);

        loginPresenter
                .getView()
                .withRootView(this.findViewById(android.R.id.content).getRootView());
        loginPresenter.bindControls();

    }

    private InstagramApplication getInstagramApplication() {
        return (InstagramApplication) getApplication();
    }

    @Override
    protected void onResume() {
        super.onResume();
        loginPresenter.loadWebviewContent();
    }
}
