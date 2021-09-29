package com.example.myapplication1.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.myapplication1.LoginAuthentication.ApiClient;
import com.example.myapplication1.Models.semester_reg;
import com.example.myapplication1.R;
import com.example.myapplication1.semesterRegResponse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Monyf extends Fragment {

     Spinner Smsmister;
     List<semester_reg> semester_regs;

    public Monyf() {
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
       View root= inflater.inflate(R.layout.fragment_mony, container, false);
        Smsmister=root.findViewById(R.id.Smsmister);

        try {
            getRegSem();
        }
        catch (NumberFormatException ex){
            Toast.makeText(getActivity(), "no internet", Toast.LENGTH_SHORT).show();
        }
        return root;
    }
    public void getRegSem(){
        Call<semesterRegResponse> semesterRegResponseCall = ApiClient.userService(getContext()).getRegisteredSemesters();
        semesterRegResponseCall.enqueue(new Callback<semesterRegResponse>() {
            @Override
            public void onResponse(Call<semesterRegResponse> call, Response<semesterRegResponse> response) {
                semesterRegResponse semesterRegResponse = response.body();
                semester_regs = new ArrayList<>(Arrays.asList(semesterRegResponse.getSemester_reg()));
                List<String> s=new ArrayList<>();
                for(int i=0;i<semester_regs.size();i++){
                    s.add(semester_regs.get(i).getSemester_name_ar()) ;
                }
                ArrayAdapter sppinerarray=new ArrayAdapter<>(getActivity(),android.R.layout.simple_spinner_dropdown_item,s);
                sppinerarray.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                Smsmister.setAdapter(sppinerarray);
            }

            @Override
            public void onFailure(Call<semesterRegResponse> call, Throwable t) {

            }
        });
    }
}