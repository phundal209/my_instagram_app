package com.example.phundal2091.simpleapp.utils;

/**
 * Created by phundal on 9/6/17.
 */

public interface IInstagramPreferences {
    void saveAuth(String token);

    String getAuthToken();

    void clearPreferences();

    void logout();
}
