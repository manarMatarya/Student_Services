package com.example.myapplication1.LoginAuthentication;

import android.content.Context;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    public static UserService userService;

     public static UserService userService(Context context){
//         HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
//         httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//         SessionMananger sessionMananger = new SessionMananger();



         Retrofit retrofit = new Retrofit.Builder()
                 .addConverterFactory(GsonConverterFactory.create())
                 .client(okhttpClient(context))
                 .baseUrl(Constatnts.BASE_URL).build();

          userService = retrofit.create(UserService.class);

         return userService;

     }





    private static OkHttpClient okhttpClient(Context context) {
        return new OkHttpClient.Builder()
                .addInterceptor(new AuthInterceptor(context))
//                .addInterceptor(new AuthInterceptor(context))
                .build();
    }
}
