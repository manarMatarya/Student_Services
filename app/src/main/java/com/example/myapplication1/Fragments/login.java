package com.example.myapplication1.Fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication1.LoginAuthentication.ApiClient;
import com.example.myapplication1.LoginAuthentication.LoginRequest;
import com.example.myapplication1.LoginAuthentication.LoginResponse;
import com.example.myapplication1.LoginAuthentication.MainActivity;
import com.example.myapplication1.LoginAuthentication.Messages;
import com.example.myapplication1.LoginAuthentication.SessionMananger;
import com.example.myapplication1.LoginAuthentication.users;
import com.example.myapplication1.MainActivity2;
import com.example.myapplication1.Models.semester_reg;
import com.example.myapplication1.R;
import com.example.myapplication1.semesterRegResponse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class login extends Fragment {
   private EditText  edtstudentnumberlogin,edtstudentpasswordlogin;
   private TextView tvforgetpassword;
   private Button bntlogin;
    SharedPreferences sharedPreferences;
   SharedPreferences.Editor editor;
    public static SessionMananger sessionMananger ;
     Messages messages=new Messages();
    List<semester_reg> semester_regs;

    public login() {
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
        // Inflate the layout for this fragment
        sessionMananger = new SessionMananger(getContext());
        View root= inflater.inflate(R.layout.fragment_login, container, false);
        edtstudentnumberlogin= root.findViewById(R.id.edtstudentnumberlogin);
        edtstudentpasswordlogin=root.findViewById(R.id.edtstudentpasswordlogin);
        bntlogin=root.findViewById(R.id.bntlogin);
        tvforgetpassword=root.findViewById(R.id.tvforgetpassword);
        sharedPreferences =getActivity(). getSharedPreferences("hi", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();



        tvforgetpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager1= getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction1=fragmentManager1.beginTransaction();
                forgetpassword forgetpassword =new forgetpassword();
                fragmentTransaction1.replace(R.id.fragcounter,forgetpassword);
                fragmentTransaction1.addToBackStack(null);
                fragmentTransaction1.commit();
            }
        });


        bntlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    LoginRequest loginRequest = new LoginRequest();
                    loginRequest.setUsername(edtstudentnumberlogin.getText().toString());
                    loginRequest.setPassword(edtstudentpasswordlogin.getText().toString());

                    loginUser(loginRequest);
                } catch (NumberFormatException ex) {
                    Toast.makeText(getContext(), messages.FIELDS_REQUIRED, Toast.LENGTH_LONG).show();
                }
            }


        });
        return  root;
    }


    public void loginUser(LoginRequest loginRequest) {

        Call<LoginResponse> loginResponseCall = ApiClient.userService(getContext()).loginUser(loginRequest);
//        Callback<LoginResponse> call;

        loginResponseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                LoginResponse loginResponse = response.body();

                try {
                    switch (response.code()) {
                        case 200:
                            sessionMananger.saveAuthToken(loginResponse.getAccessToken());
                            sessionMananger.saveUserId(edtstudentnumberlogin.getText().toString());
                            //getActiveSemester();
                            Toast.makeText(getContext(), messages.SUCCESS200, Toast.LENGTH_LONG).show();
                            Intent intent=new Intent(getActivity(),MainActivity2.class);
                            startActivity(intent);
                            break;
                        case 401:
                            Toast.makeText(getContext(), messages.ERROR401, Toast.LENGTH_LONG).show();
                            break;
                        case 422:
                            Toast.makeText(getContext(), messages.ERROR422, Toast.LENGTH_LONG).show();
                            break;
                        case 500:
                            Toast.makeText(getContext(), messages.ERROR500, Toast.LENGTH_LONG).show();
                            break;
                    }

                } catch (Exception e) {
                    Toast.makeText(getContext(), messages.CATCH, Toast.LENGTH_LONG).show();
                    Log.e("exception", e.toString());
                }
            }


            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                String message = t.getLocalizedMessage();
                Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
            }
        });

    }

    public void getActiveSemester(){

        Call<semesterRegResponse> semesterRegResponseCall = ApiClient.userService(getContext()).getRegisteredSemesters();
        semesterRegResponseCall.enqueue(new Callback<semesterRegResponse>() {

            @Override
            public void onResponse(Call<semesterRegResponse> call, Response<semesterRegResponse> response) {
                semesterRegResponse semesterRegResponse = response.body();
                semester_regs = new ArrayList<>(Arrays.asList(semesterRegResponse.getSemester_reg()));
                String active_semester = semester_regs.get(0).getSemester_name_ar() ;
                sessionMananger.saveActiveSemester(active_semester);
            }

            @Override
            public void onFailure(Call<semesterRegResponse> call, Throwable t) {
                Toast.makeText(getContext(), "Failed", Toast.LENGTH_SHORT).show();
            }
        });

    }


}