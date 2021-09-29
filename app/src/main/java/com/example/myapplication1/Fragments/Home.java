package com.example.myapplication1.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.myapplication1.LoginAuthentication.ApiClient;
import com.example.myapplication1.Models.semester_reg;
import com.example.myapplication1.academicInfoResponse;
import com.example.myapplication1.Models.acadmic_info;
import com.example.myapplication1.Models.ajenda_info;
import com.example.myapplication1.R;
import com.example.myapplication1.ajendaInfoResponse;
import com.example.myapplication1.semesterRegResponse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Home extends Fragment {
    TextView college, specialization, Linenumber, Linehoure, academicLevel, studyhoure, completinghoure,
            equationHoure, GPA, startterm, endtearm, startregistring, endregistring, startadding, endadding, startfinalexam;

    List<acadmic_info> acadmic_infos;
    List<ajenda_info> ajenda_infos;

    public Home() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
//            college = bundle.getString("College");
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);
        college = root.findViewById(R.id.college);
        specialization = root.findViewById(R.id.specialization);
        Linenumber = root.findViewById(R.id.Linenumber);
        Linehoure = root.findViewById(R.id.Linehoure);
        academicLevel = root.findViewById(R.id.academicLevel);
        studyhoure = root.findViewById(R.id.studyhoure);
        completinghoure = root.findViewById(R.id.completinghoure);
        equationHoure = root.findViewById(R.id.equationHoure);
        GPA = root.findViewById(R.id.GPA);
        startterm = root.findViewById(R.id.startterm);
        endtearm = root.findViewById(R.id.endtearm);
        startregistring = root.findViewById(R.id.startregistring);
        endregistring = root.findViewById(R.id.endregistring);
        startadding = root.findViewById(R.id.startadding);
        endadding = root.findViewById(R.id.endadding);
        startfinalexam = root.findViewById(R.id.startfinalexam);


        try {
            acdimec();
            ajenda();
        } catch (NumberFormatException ex) {
            Toast.makeText(getContext(), "hjjg", Toast.LENGTH_LONG).show();
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
                Linenumber.setText(acadmic_infos.get(0).getPlan_no());
                Linehoure.setText("138");
                academicLevel.setText(acadmic_infos.get(0).getLevel_name_ar());
                studyhoure.setText(acadmic_infos.get(0).getReg_hour());
                completinghoure.setText(acadmic_infos.get(0).getExec_hour());
                equationHoure.setText(acadmic_infos.get(0).getBalancing_hour());
                GPA.setText(acadmic_infos.get(0).getGpa());
            }

            @Override
            public void onFailure(Call<academicInfoResponse> call, Throwable t) {

            }
        });
    }

//    public void vv(String token) {
//        Call<acadmic_info> academicInfoResponseCall = ApiClient.userService(getContext()).getAcademicInfo1(token);
//        academicInfoResponseCall.enqueue(new Callback<acadmic_info>() {
//            @Override
//            public void onResponse(Call<acadmic_info> call, Response<acadmic_info> response) {
//                acadmic_info acadmic_info = response.body();
//                college.setText(acadmic_info.getCollege_name_ar());
//                specialization.setText(acadmic_info.getMajor_name_ar());
//                Linenumber.setText(acadmic_info.getPlan_no());
//                Linehoure.setText("138");
//                academicLevel.setText(acadmic_info.getLevel_name_ar());
//                studyhoure.setText(acadmic_info.getReg_hour());
//                completinghoure.setText(acadmic_info.getExec_hour());
//                equationHoure.setText(acadmic_info.getBalancing_hour());
//                GPA.setText(acadmic_info.getGpa());
//
//                Toast.makeText(getContext(), "" + acadmic_info.getGpa(), Toast.LENGTH_SHORT).show();
//
//            }
//
//            @Override
//            public void onFailure(Call<acadmic_info> call, Throwable t) {
//                Toast.makeText(getContext(), "Failed in getting academic info", Toast.LENGTH_SHORT).show();
//            }
//        });

public void ajenda(){
    Call<ajendaInfoResponse> ajendaInfoModelCall = ApiClient.userService(getContext()).getAgendaInfo();
    ajendaInfoModelCall.enqueue(new Callback<ajendaInfoResponse>() {
        @Override
        public void onResponse(Call<ajendaInfoResponse> call, Response<ajendaInfoResponse> response) {
           ajendaInfoResponse ajendaInfoResponse = response.body();
            ajenda_infos = new ArrayList<>(Arrays.asList(ajendaInfoResponse.getAjenda_info()));
            startterm.setText(ajenda_infos.get(0).getStart_semester());
            endtearm.setText(ajenda_infos.get(0).getEnd_semester());
            startregistring.setText(ajenda_infos.get(0).getStart_register_net());
            endregistring.setText(ajenda_infos.get(0).getEnd_register_net());
            startadding.setText(ajenda_infos.get(0).getStart_add_net());
            endadding.setText(ajenda_infos.get(0).getEnd_add_net());
            startfinalexam.setText(ajenda_infos.get(0).getStart_exam());
        }

        @Override
        public void onFailure(Call<ajendaInfoResponse> call, Throwable t) {
            Toast.makeText(getContext(), "Failed in getting ajenda info", Toast.LENGTH_SHORT).show();

        }
    });
}

}