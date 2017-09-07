package com.example.phundal2091.simpleapp.framework;

/**
 * Created by phundal on 9/6/17.
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