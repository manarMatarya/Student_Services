package com.example.myapplication1.LoginAuthentication;

import android.content.Context;
import android.util.Log;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class AuthInterceptor implements Interceptor {
     private final SessionMananger sessionMananger ;
//     private  SessionMananger sessionMananger;

    public AuthInterceptor(Context context) {
        sessionMananger = new SessionMananger(context);
    }
//

    @NotNull
        @Override
        public Response intercept(Chain chain) throws IOException {
        Request.Builder newRequest  = chain.request().newBuilder();
        Log.e("search", newRequest.get().toString());
         String token = sessionMananger.fetchAuthToken();
        if(token!=null){
        newRequest.addHeader("accessToken", token);}
            return chain.proceed(newRequest.build());
        }
}
