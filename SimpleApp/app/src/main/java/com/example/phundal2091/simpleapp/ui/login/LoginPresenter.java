package com.example.phundal2091.simpleapp.ui.login;

import android.content.Context;

import com.example.phundal2091.simpleapp.utils.InstagramPreferences;
import com.example.phundal2091.simpleapp.InstagramWebClient;
import com.example.phundal2091.simpleapp.framework.Presenter;
import com.example.phundal2091.simpleapp.utils.InstagramUtilities;

/**
 * Created by phundal on 9/6/17.
 */

public class LoginPresenter extends Presenter<LoginView, Object> implements ILoginPresenter {
    private InstagramPreferences instagramPreferences;

    public LoginPresenter(Context context, LoginView view) {
        super(context, view, false);
        instagramPreferences = new InstagramPreferences(context);
    }

    @Override
    public void bindControls() {
        loadWebviewContent();
    }

    @Override
    public void hide() {
        // no need to hide in this presenter
    }

    @Override
    public void show() {
        // no need to show in this presenter
    }

    /**
     * Loads a webview client in to the webview view.
     */
    @Override
    public void loadWebviewContent() {
        view.webview.setWebViewClient(new InstagramWebClient(context, instagramPreferences));
        if(instagramPreferences.getAuthToken() != null) {
            view.webview.loadUrl(InstagramUtilities.AUTH_URL);
        } else {
            view.webview.clearCache(true);
            view.webview.clearHistory();

            InstagramWebClient.clearCookies(context);
            view.webview.loadUrl(InstagramUtilities.AUTH_URL);
        }
    }
}
