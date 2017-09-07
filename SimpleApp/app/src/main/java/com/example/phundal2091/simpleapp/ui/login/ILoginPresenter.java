package com.example.phundal2091.simpleapp.ui.login;

import android.webkit.WebView;

import com.example.phundal2091.simpleapp.framework.IPresenter;

/**
 * Created by phundal on 9/6/17.
 */

public interface ILoginPresenter extends IPresenter<LoginView, Object> {
    void loadWebviewContent();
}
