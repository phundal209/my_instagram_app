package com.example.phundal2091.simpleapp.ui.login;

import android.view.View;
import android.webkit.WebView;

import com.example.phundal2091.simpleapp.R;
import com.example.phundal2091.simpleapp.framework.ViewScreen;

import butterknife.Bind;

/**
 * Created by phundal on 9/6/17.
 */

public class LoginView extends ViewScreen {
    @Bind(R.id.webview)
    public WebView webview;

    public LoginView(View rootView) {
        super(rootView);
    }
}
