package com.example.phundal2091.templateapplication.framework;

import android.view.View;

import butterknife.ButterKnife;

/**
 * Created by phundal2091 on 11/18/16.
 */

public abstract class ViewScreen {
    View rootView;

    /**
     * With this constructor you will need to manually attach the root view after inflating
     */
    public ViewScreen(){}

    public ViewScreen(View rootView) {
        this.rootView = rootView;
    }

    public <T extends ViewScreen> T withRootView(View rootView) {
        this.rootView = rootView;
        ButterKnife.bind(this, rootView);
        return (T)this;
    }

    public View getRootView() {
        return rootView;
    }


}