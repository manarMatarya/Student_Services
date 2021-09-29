package com.example.myapplication1.Fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication1.LoginAuthentication.SessionMananger;
import com.example.myapplication1.MainActivity2;
import com.example.myapplication1.R;

import static android.support.v4.media.session.MediaSessionCompat.KEY_TOKEN;


public class splash extends Fragment {
    SharedPreferences sharedPreferences;
    SessionMananger sessionMananger;
    public splash() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View root= inflater.inflate(R.layout.fragment_splash, container, false);
       sessionMananger = new SessionMananger(getContext());
       sharedPreferences= getActivity().getSharedPreferences(getActivity().getString(R.string.app_name), Context.MODE_PRIVATE);
       //String token = sessionMananger.fetchAuthToken();
        Thread thread =new Thread(){
            @Override
            public void run() {
                super.run();
                try{
                    sleep(2000);
                    if(sharedPreferences.contains("token")){
                        Intent intent =new Intent(getContext(), MainActivity2.class);
                        startActivity(intent);
                    }
                    else{
                        FragmentManager fragmentManager1= getActivity().getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction1=fragmentManager1.beginTransaction();
                        login menu =new login();
                        fragmentTransaction1.replace(R.id.fragcounter,menu);
                        fragmentTransaction1.commit();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
        return root;
    }
}