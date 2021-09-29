package com.example.myapplication1.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.myapplication1.Adapters.CourseAdapter;
import com.example.myapplication1.LoginAuthentication.ApiClient;
import com.example.myapplication1.Models.course;
import com.example.myapplication1.Models.semester_reg;
import com.example.myapplication1.Models.semester_table;
import com.example.myapplication1.R;
import com.example.myapplication1.semesterRegResponse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class quarerlySchedule extends Fragment {
    List<course> modelList;
    List<semester_table> semester_tables;
    RecyclerView recyclerView;
    CourseAdapter mAdapter;
    Spinner Sssmester;
    TextView sunday,monday,thersday,day,wensday,tusday;
    CardView csunday,cmonday,cthersday,cwensday,ctusday;
    List<semester_reg> semester_regs;

    public quarerlySchedule() {
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
        View root= inflater.inflate(R.layout.fragment_quarerly_schedule, container, false);
        modelList =new ArrayList<course>();
        semester_tables =new ArrayList<semester_table>();
//        semester_tables.add(new semester_table("ITCS300","English","101","10-12"));
//        semester_tables.add(new semester_table("ITCS300","English","101","1"));



        recyclerView =root. findViewById(R.id.recyclerView);
        Sssmester =root. findViewById(R.id.Sssmester);
        day =root. findViewById(R.id.day);
        sunday =root. findViewById(R.id.sunday);
        monday =root. findViewById(R.id.monday);
        thersday =root. findViewById(R.id.thersday);
        wensday =root. findViewById(R.id.wensday);
        tusday =root. findViewById(R.id.tusday);
        csunday =root. findViewById(R.id.csunday);
        cmonday =root. findViewById(R.id.cmonday);
        cthersday =root. findViewById(R.id.cthersday);
        cwensday =root. findViewById(R.id.cwensday);
        ctusday =root. findViewById(R.id.ctusday);

        recyclerView.setLayoutManager(new LinearLayoutManager(null));
        mAdapter = new CourseAdapter(getActivity(), semester_tables);
        recyclerView.setAdapter(mAdapter);
        csunday.setCardBackgroundColor(getResources().getColor(R.color.colorp));
        sunday.setTextColor(getResources().getColor(R.color.colorW));

        cmonday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                day.setText("الاثنين");
                cmonday.setCardBackgroundColor(getResources().getColor(R.color.colorp));
                monday.setTextColor(getResources().getColor(R.color.colorW));
                csunday.setCardBackgroundColor(getResources().getColor(R.color.colorW));
                sunday.setTextColor(getResources().getColor(R.color.colorp));
                cthersday.setCardBackgroundColor(getResources().getColor(R.color.colorW));
                thersday.setTextColor(getResources().getColor(R.color.colorp));
                cwensday.setCardBackgroundColor(getResources().getColor(R.color.colorW));
                wensday.setTextColor(getResources().getColor(R.color.colorp));
                ctusday.setCardBackgroundColor(getResources().getColor(R.color.colorW));
                tusday.setTextColor(getResources().getColor(R.color.colorp));

//                modelList =new ArrayList<>();
                modelList.add(new course("موبايل 2","101","GWH201","12:00-10:00"));
                modelList.add(new course("اللغة العربية","101","GWH201","12:00-10:00"));

                recyclerView.setLayoutManager(new LinearLayoutManager(null));
                mAdapter = new CourseAdapter(getActivity(), semester_tables);
                recyclerView.setAdapter(mAdapter);
            }
        });
        csunday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                day.setText("الأحد");
                csunday.setCardBackgroundColor(getResources().getColor(R.color.colorp));
                sunday.setTextColor(getResources().getColor(R.color.colorW));
                cmonday.setCardBackgroundColor(getResources().getColor(R.color.colorW));
                monday.setTextColor(getResources().getColor(R.color.colorp));
                cthersday.setCardBackgroundColor(getResources().getColor(R.color.colorW));
                thersday.setTextColor(getResources().getColor(R.color.colorp));
                cwensday.setCardBackgroundColor(getResources().getColor(R.color.colorW));
                wensday.setTextColor(getResources().getColor(R.color.colorp));
                ctusday.setCardBackgroundColor(getResources().getColor(R.color.colorW));
                tusday.setTextColor(getResources().getColor(R.color.colorp));

//                modelList =new ArrayList<>();
                modelList.add(new course("اللغة العربية","101","GWH201","12:00 - 10:00"));
                modelList.add(new course("اللغة العربية","101","GWH201","12:00 - 10:00"));
                modelList.add(new course("اللغة العربية","101","GWH201","12:00 - 10:00"));

                recyclerView.setLayoutManager(new LinearLayoutManager(null));
                mAdapter = new CourseAdapter(getActivity(), semester_tables);
                recyclerView.setAdapter(mAdapter);
            }
        });
        cthersday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                day.setText("الثلاثاء");
                cthersday.setCardBackgroundColor(getResources().getColor(R.color.colorp));
                thersday.setTextColor(getResources().getColor(R.color.colorW));
                csunday.setCardBackgroundColor(getResources().getColor(R.color.colorW));
                sunday.setTextColor(getResources().getColor(R.color.colorp));
                cmonday.setCardBackgroundColor(getResources().getColor(R.color.colorW));
                monday.setTextColor(getResources().getColor(R.color.colorp));
                cwensday.setCardBackgroundColor(getResources().getColor(R.color.colorW));
                wensday.setTextColor(getResources().getColor(R.color.colorp));
                ctusday.setCardBackgroundColor(getResources().getColor(R.color.colorW));
                tusday.setTextColor(getResources().getColor(R.color.colorp));

//                modelList =new ArrayList<>();
                modelList.add(new course("اللغة العبرية","101","GWH201","12:00-10:00"));
                modelList.add(new course("اللغة العبرية","101","GWH201","12:00-10:00"));
                modelList.add(new course("اللغة العربية","101","GWH201","12:00-10:00"));
                modelList.add(new course("اللغة العربية","101","GWH201","12:00-10:00"));

                recyclerView.setLayoutManager(new LinearLayoutManager(null));
                mAdapter = new CourseAdapter(getActivity(), semester_tables);
                recyclerView.setAdapter(mAdapter);
            }
        });
        cwensday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                day.setText("الأربعاء");
                cwensday.setCardBackgroundColor(getResources().getColor(R.color.colorp));
                wensday.setTextColor(getResources().getColor(R.color.colorW));
                csunday.setCardBackgroundColor(getResources().getColor(R.color.colorW));
                sunday.setTextColor(getResources().getColor(R.color.colorp));
                cthersday.setCardBackgroundColor(getResources().getColor(R.color.colorW));
                thersday.setTextColor(getResources().getColor(R.color.colorp));
                cmonday.setCardBackgroundColor(getResources().getColor(R.color.colorW));
                monday.setTextColor(getResources().getColor(R.color.colorp));
                ctusday.setCardBackgroundColor(getResources().getColor(R.color.colorW));
                tusday.setTextColor(getResources().getColor(R.color.colorp));

//                modelList =new ArrayList<>();
                modelList.add(new course("موبايل 2","101","GWH201","12:00-10:00"));
                modelList.add(new course("ويب 2","101","GWH201","12:00-10:00"));
                modelList.add(new course("موبايل 2","101","GWH201","12:00-10:00"));
                modelList.add(new course("ويب 2","101","GWH201","12:00-10:00"));

                recyclerView.setLayoutManager(new LinearLayoutManager(null));
                mAdapter = new CourseAdapter(getActivity(), semester_tables);
                recyclerView.setAdapter(mAdapter);
            }
        });
        ctusday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                day.setText("الخميس");
                ctusday.setCardBackgroundColor(getResources().getColor(R.color.colorp));
                tusday.setTextColor(getResources().getColor(R.color.colorW));
                csunday.setCardBackgroundColor(getResources().getColor(R.color.colorW));
                sunday.setTextColor(getResources().getColor(R.color.colorp));
                cthersday.setCardBackgroundColor(getResources().getColor(R.color.colorW));
                thersday.setTextColor(getResources().getColor(R.color.colorp));
                cwensday.setCardBackgroundColor(getResources().getColor(R.color.colorW));
                wensday.setTextColor(getResources().getColor(R.color.colorp));
                cmonday.setCardBackgroundColor(getResources().getColor(R.color.colorW));
                monday.setTextColor(getResources().getColor(R.color.colorp));

                modelList =new ArrayList<>();
                modelList.add(new course("اللغة العربية","101","GWH201","12:00-10:00"));
                modelList.add(new course("اللغة العربية","101","GWH201","12:00-10:00"));
                modelList.add(new course("اللغة العربية","101","GWH201","12:00-10:00"));

                recyclerView.setLayoutManager(new LinearLayoutManager(null));
                mAdapter = new CourseAdapter(getActivity(), semester_tables);
                recyclerView.setAdapter(mAdapter);
            }
        });

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
                Sssmester.setAdapter(sppinerarray);
            }

            @Override
            public void onFailure(Call<semesterRegResponse> call, Throwable t) {

            }
        });
    }
//    public void getSemesterTable(){
//        Call<List<semester_table>> listCall = ApiClient.userService(getContext()).getSemesterTable();
//        listCall.enqueue(new Callback<List<semester_table>>() {
//            @Override
//            public void onResponse(Call<List<semester_table>> call, Response<List<semester_table>> response) {
//
//            }
//
//            @Override
//            public void onFailure(Call<List<semester_table>> call, Throwable t) {
//
//            }
//        });


//    }
}