package com.example.phundal2091.simpleapp.navigation;

import android.content.Context;
import android.content.Intent;

import com.example.phundal2091.simpleapp.ui.feed.FeedActivity;
import com.example.phundal2091.simpleapp.ui.login.MainActivity;

/**
 * Created by phundal2091 on 9/5/17.
 */

public class NavigationService {
    public static void launchFeed(Context context) {
        Intent intent = new Intent(context, FeedActivity.class);
        context.startActivity(intent);
    }

    public static void launchLogin(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }
}
