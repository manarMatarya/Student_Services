package com.example.myapplication1.LoginAuthentication;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication1.R;

public class MainActivity extends AppCompatActivity {
LoginResponse loginResponse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        if(intent.getExtras() != null){
           loginResponse = (LoginResponse) intent.getSerializableExtra("username");

        }
    }
}