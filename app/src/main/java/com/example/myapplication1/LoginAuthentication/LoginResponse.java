package com.example.myapplication1.LoginAuthentication;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class LoginResponse implements Serializable {
    private String accessToken;
    private users users;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public users getUser() {
        return users;
    }

    public void setUser(users users) {
        this.users = users;
    }
}
