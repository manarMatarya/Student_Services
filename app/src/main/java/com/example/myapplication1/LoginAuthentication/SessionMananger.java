package com.example.myapplication1.LoginAuthentication;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.myapplication1.R;

public class SessionMananger {

    //    private final String FILE_NAME = "login_details";

     SharedPreferences sharedPreferences;
    public final String KEY_TOKEN = "token";
    private final String KEY_ID = "id";
    private final String ACTIVE_SEM = "activesemester";

    public SessionMananger() {
    }

    public SessionMananger(Context context) {
        sharedPreferences = context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE);
    }

    /**
     * Function to save auth token
     */
    public void saveAuthToken(String token) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_TOKEN, token);
        editor.commit();
    }

    public void saveUserId(String id) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_ID, id);
        editor.commit();
    }

    public void saveActiveSemester(String activesemester) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(ACTIVE_SEM, activesemester);
        editor.commit();
    }

    /**
     * Function to fetch auth token
     */
    public String fetchAuthToken() {
        return sharedPreferences.getString(KEY_TOKEN, null);
    }

    public String fetchUserId() {
        return sharedPreferences.getString(KEY_ID, null);
    }
    public String fetchActiveSemester() {
        return sharedPreferences.getString(ACTIVE_SEM, null);
    }

    public void clearSharedPreferences(){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.commit();

    }
}
