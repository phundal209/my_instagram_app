package com.example.phundal2091.simpleapp;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.example.phundal2091.simpleapp.navigation.NavigationService;
import com.example.phundal2091.simpleapp.utils.InstagramPreferences;
import com.example.phundal2091.simpleapp.utils.InstagramUtilities;

/**
 * Created by phundal2091 on 9/5/17.
 */

public class InstagramWebClient extends WebViewClient {
    private static final String TAG = InstagramWebClient.class.getSimpleName();
    private Context context;
    InstagramPreferences instagramPreferences;

    public InstagramWebClient(Context context, InstagramPreferences instagramPreferences) {
        this.context = context;
        this.instagramPreferences = instagramPreferences;
    }

    @SuppressWarnings("deprecation")
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        Log.d(TAG, "URL : " + url);
        if (url.startsWith(InstagramUtilities.REDIRECT_URL)) {
            if (url.contains("access_token")) {
                String accessToken = url.split("#access_token=")[1];
                instagramPreferences.saveAuth(accessToken);
                Log.d(TAG, "Instagram TOKEN: " + instagramPreferences.getAuthToken());
                NavigationService.launchFeed(context);
            } else if (url.contains("error_reason")) {
                Toast.makeText(context, context.getString(R.string.instagram_authorize_failure),
                        Toast.LENGTH_SHORT).show();
            }
            return true;
        }
        return super.shouldOverrideUrlLoading(view, url);
    }

    @RequiresApi(Build.VERSION_CODES.N)
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
        final Uri uri = request.getUrl();
        return handleUri(uri, view);
    }

    private boolean handleUri(final Uri uri, WebView view) {
        String url = uri.toString();
        Log.i(TAG, "Uri =" + url);
        if (url.startsWith(InstagramUtilities.REDIRECT_URL)) {
            if (url.contains("access_token")) {
                String accessToken = url.split("#access_token=")[1];
                instagramPreferences.saveAuth(accessToken);
                Log.d(TAG, "Instagram TOKEN: " + instagramPreferences.getAuthToken());
                NavigationService.launchFeed(context);
            } else if (url.contains("error_reason")) {
                Toast.makeText(context, context.getString(R.string.instagram_authorize_failure),
                        Toast.LENGTH_SHORT).show();
            }
            return true;
        }
        return false;
    }

    @SuppressWarnings("deprecation")
    public static void clearCookies(Context context)
    {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1) {
            CookieManager.getInstance().removeAllCookies(null);
            CookieManager.getInstance().flush();
        } else {
            CookieSyncManager cookieSyncMngr=CookieSyncManager.createInstance(context);
            cookieSyncMngr.startSync();
            CookieManager cookieManager=CookieManager.getInstance();
            cookieManager.removeAllCookie();
            cookieManager.removeSessionCookie();
            cookieSyncMngr.stopSync();
            cookieSyncMngr.sync();
        }
    }
}
