package com.example.myapplication1.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication1.LoginAuthentication.ApiClient;
import com.example.myapplication1.Models.acadmic_info;
import com.example.myapplication1.R;
import com.example.myapplication1.academicInfoResponse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AcadimcInformation extends Fragment {
    TextView college, specialization, academicLevel, studyhoure, completinghoure,
    equationHoure, GPA, typeth,dateth,GPAth;

    List<acadmic_info> acadmic_infos;
    public AcadimcInformation() {
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

        View root= inflater.inflate(R.layout.fragment_acadimc_information, container, false);
        college = root.findViewById(R.id.college);
        specialization = root.findViewById(R.id.specialization);
        academicLevel = root.findViewById(R.id.academicLevel);
        studyhoure = root.findViewById(R.id.studyhoure);
        completinghoure = root.findViewById(R.id.completinghoure);
        equationHoure = root.findViewById(R.id.equationHoure);
        GPA = root.findViewById(R.id.GPA);
        dateth = root.findViewById(R.id.dateth);
        typeth = root.findViewById(R.id.typeth);
        GPAth = root.findViewById(R.id.GPAth);

        try {
            acdimec();
        }
        catch (NumberFormatException ex) {
            Toast.makeText(getContext(), "Check Your Internet", Toast.LENGTH_LONG).show();
        }
        return root;
    }

    public void acdimec() {
        Call<academicInfoResponse> academicInfoModelCall = ApiClient.userService(getContext()).getAcademicInfo();
        academicInfoModelCall.enqueue(new Callback<academicInfoResponse>() {
            @Override
            public void onResponse(Call<academicInfoResponse> call, Response<academicInfoResponse> response) {
                academicInfoResponse academicInfoResponse = response.body();
                acadmic_infos = new ArrayList<>(Arrays.asList(academicInfoResponse.getAcadmic_infos()));
                college.setText(acadmic_infos.get(0).getCollege_name_ar());
                specialization.setText(acadmic_infos.get(0).getMajor_name_ar());
                academicLevel.setText(acadmic_infos.get(0).getLevel_name_ar());
                studyhoure.setText(acadmic_infos.get(0).getReg_hour());
                completinghoure.setText(acadmic_infos.get(0).getExec_hour());
                equationHoure.setText(acadmic_infos.get(0).getBalancing_hour());
                GPA.setText(acadmic_infos.get(0).getGpa());
                typeth.setText(acadmic_infos.get(0).getCertificate_type_name_ar());
                GPAth.setText(acadmic_infos.get(0).getHs_avg());
                dateth.setText(acadmic_infos.get(0).getHs_date());
            }

            @Override
            public void onFailure(Call<academicInfoResponse> call, Throwable t) {

            }
        });
    }
}