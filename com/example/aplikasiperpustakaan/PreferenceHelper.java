package com.example.aplikasiperpustakaan;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceHelper {
    public static SharedPreferences app_prefs;
    public static Context context;
    public static SharedPreferences.Editor editor;
    private final String INTRO = "";
    private final String NAMA = "";
    private final String PASSWORD = "";
    private final String USERNAME = "";

    public PreferenceHelper(Context context2) {
        context = context2;
        app_prefs = context2.getSharedPreferences("shared", 0);
    }

    public void putIsLogin(boolean loginorout) {
        SharedPreferences.Editor edit = app_prefs.edit();
        edit.putBoolean("", loginorout);
        edit.commit();
    }

    public boolean getIsLogin() {
        return app_prefs.getBoolean("", false);
    }

    public void putNama(String loginorout) {
        SharedPreferences.Editor edit = app_prefs.edit();
        edit.putString("", loginorout);
        edit.commit();
    }

    public String getNama() {
        return app_prefs.getString("", "");
    }

    public void putUsername(String loginorout) {
        SharedPreferences.Editor edit = app_prefs.edit();
        edit.putString("", loginorout);
        edit.commit();
    }

    public String getUsername() {
        return app_prefs.getString("", "");
    }

    public void putPassword(String loginorout) {
        SharedPreferences.Editor edit = app_prefs.edit();
        edit.putString("", loginorout);
        edit.commit();
    }

    public String getPassword() {
        return app_prefs.getString("", "");
    }
}
