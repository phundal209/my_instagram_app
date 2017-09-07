package com.example.phundal2091.simpleapp.ui.feed;

import com.example.phundal2091.simpleapp.injection.AbstractActivityComponent;
import com.example.phundal2091.simpleapp.injection.ApplicationComponent;
import com.example.phundal2091.simpleapp.injection.DataModule;
import com.example.phundal2091.simpleapp.injection.annotation.PerActivity;

import dagger.Component;

/**
 * Created by phundal on 9/6/17.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class,
                modules = { FeedModule.class,
                            DataModule.class }
)
public interface IFeedComponent extends AbstractActivityComponent {
    void inject(FeedActivity feedActivity);
}
