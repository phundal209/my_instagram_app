package com.example.phundal2091.templateapplication.framework;

/**
 * Created by phundal2091 on 11/18/16.
 */

public interface IPresenter<V extends ViewScreen, TModel> {
    /**
     * Make sure that either the constructor does butterknife view injection
     * or you explicitly call getView().withRootView() before calling this method
     */
    void bindControls();

    V getView();

    IPresenter<V, TModel> withModel(TModel model);

    TModel getModel();

    void hide();

    void show();

    void toggleVisibiility();
}