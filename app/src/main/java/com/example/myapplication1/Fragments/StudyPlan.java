package com.example.myapplication1.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;


import com.example.myapplication1.Adapters.SPAdapter;
import com.example.myapplication1.Adapters.StudyPlanAdapter;
import com.example.myapplication1.LoginAuthentication.ApiClient;
import com.example.myapplication1.Models.SPchild;
import com.example.myapplication1.Models.SPparent;
import com.example.myapplication1.Models.modelForAPI;
import com.example.myapplication1.Models.studyplan_info;
import com.example.myapplication1.Models.studyplan_main;
import com.example.myapplication1.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class StudyPlan extends Fragment {

    LinearLayout header;
    LinearLayout footer;
    CardView grand;
    ExpandableListView elStudyPlan;
    ImageView sahemGrand;
    List<studyplan_info> listGroup;
    List<studyplan_main> stM;
    List<studyplan_info> stinfo;
    HashMap<studyplan_info, List<SPchild>> listItem;
    StudyPlanAdapter adapter;
    Spinner spStudyPlan;
    TextView tvFmatlop;

    public StudyPlan() {
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
        View root = inflater.inflate(R.layout.fragment_study_plan, container, false);

        grand = root.findViewById(R.id.grandcard);
        elStudyPlan = root.findViewById(R.id.elStudyPlan);
        sahemGrand = root.findViewById(R.id.sahemGrand);
        header = root.findViewById(R.id.headerinfo);
        footer = root.findViewById(R.id.footerinfo);
        spStudyPlan = root.findViewById(R.id.spStudyPlan);
        tvFmatlop = root.findViewById(R.id.tvFmatlop);
//        header.setVisibility(View.GONE);
//        footer.setVisibility(View.GONE);
//        elStudyPlan.setVisibility(View.GONE);
//        sahemGrand.setImageResource(R.drawable.arrow3);


        listGroup = new ArrayList<studyplan_info>();
        listItem = new HashMap<studyplan_info, List<SPchild>>();


//
        List<SPchild> list1 = new ArrayList<>();
        list1.add(new SPchild("19", "30", "47", "96", "أ"));

//        for(int i=0;i<9;i++){
//            listGroup.add(new SPparent("ITMM2301","أمن و حماية الأنظمة" , "3","96" , new SPfooter("77" , "77" , "50")) );
//            listItem.put(listGroup.get(i),list1);
//        }

//        grand.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(elStudyPlan.getVisibility() == View.GONE){
//                    elStudyPlan.setVisibility(View.VISIBLE);
//                    header.setVisibility(View.VISIBLE);
//                    footer.setVisibility(View.VISIBLE);
//                    sahemGrand.setImageResource(R.drawable.up_arrow3);
//                }else{
//                    elStudyPlan.setVisibility(View.GONE);
//                    header.setVisibility(View.GONE);
//                    footer.setVisibility(View.GONE);
//                    sahemGrand.setImageResource(R.drawable.arrow3);
//                }
//            }
//        });
        try {
            getSpinnerInfo();
//            String id= getidSpiner(spStudyPlan.getSelectedItem().toString());
//            StudyPlanG(id);
            spStudyPlan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                    Call<modelForAPI> SpinerInfo = ApiClient.userService(getContext()).getStudyplanMain();
                    SpinerInfo.enqueue(new Callback<modelForAPI>() {
                        @Override
                        public void onResponse(Call<modelForAPI> call, Response<modelForAPI> response) {
                            modelForAPI spInfo = response.body();
                            stM = new ArrayList<>(Arrays.asList(spInfo.getStudyplan_main()));
                            //List<String> s=new ArrayList<>();
                            for (int i = 0; i < stM.size(); i++) {
                                if (spStudyPlan.getSelectedItem().toString().equals(stM.get(i).getType_name())) {
                                   String id = stM.get(i).getPlan_subject_type_cd();
                                    tvFmatlop.setText(stM.get(i).getHour_mandatory());//مطلوب انجازه
                                    //مطلوب انجازه
                                    Toast.makeText(getActivity(), ""+stM.get(i).getType_name(), Toast.LENGTH_SHORT).show();
                                    Toast.makeText(getActivity(), ""+stM.get(i).getHour_mandatory(), Toast.LENGTH_SHORT).show();
//                                    StudyPlanG();
//                                    adapter.notifyDataSetChanged();
                                }
                            }
                        }

                        @Override
                        public void onFailure(Call<modelForAPI> call, Throwable t) {
                        }
                    });
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        } catch (NumberFormatException ex) {
            Toast.makeText(getActivity(), "no internet", Toast.LENGTH_SHORT).show();
        }
            return root;
        }
        public void getSpinnerInfo () {
            Call<modelForAPI> SpinerInfo = ApiClient.userService(getContext()).getStudyplanMain();
            SpinerInfo.enqueue(new Callback<modelForAPI>() {
                @Override
                public void onResponse(Call<modelForAPI> call, Response<modelForAPI> response) {
                    modelForAPI spInfo = response.body();
                    stM = new ArrayList<>(Arrays.asList(spInfo.getStudyplan_main()));
                    List<String> s = new ArrayList<>();
                    for (int i = 0; i < stM.size(); i++) {
                        s.add(stM.get(i).getType_name());
                    }
                    ArrayAdapter sppinerarray = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, s);
                    sppinerarray.setDropDownViewResource(R.layout.spinner_item);
                    spStudyPlan.setAdapter(sppinerarray);
                }

                @Override
                public void onFailure(Call<modelForAPI> call, Throwable t) {
                }
            });
        }
        public String getidSpiner (final String name){
            final String[] id = {""};
            Call<modelForAPI> SpinerInfo = ApiClient.userService(getContext()).getStudyplanMain();
            SpinerInfo.enqueue(new Callback<modelForAPI>() {
                @Override
                public void onResponse(Call<modelForAPI> call, Response<modelForAPI> response) {
                    modelForAPI spInfo = response.body();
                    stM = new ArrayList<>(Arrays.asList(spInfo.getStudyplan_main()));
                    //List<String> s=new ArrayList<>();
                    for (int i = 0; i < stM.size(); i++) {
                        if (name.equals(stM.get(i).getType_name())) {
                            id[0] = stM.get(i).getPlan_subject_type_cd();
                            tvFmatlop.setText(stM.get(i).getHour_mandatory());//مطلوب انجازه
                        }
                    }
                }

                @Override
                public void onFailure(Call<modelForAPI> call, Throwable t) {
                }
            });
            return id[0];
        }
        public void StudyPlanG (){
            Call<modelForAPI> md = ApiClient.userService(getContext()).getStudyplanInfo();
            md.enqueue(new Callback<modelForAPI>() {
                @Override
                public void onResponse(Call<modelForAPI> call, Response<modelForAPI> response) {
                    modelForAPI studyplaninfo = response.body();
                    stinfo = new ArrayList<>(Arrays.asList(studyplaninfo.getStudyplan_info()));
                    //عرض التفاصيل للدرجة
                    List<SPchild> list1 = new ArrayList<>();
                    list1.add(new SPchild("19", "30", "47", "96", "أ"));

                    for (int i = 0; i < stinfo.size(); i++) {
                            listGroup.add(new studyplan_info(stinfo.get(i).getSubject_cd(), stinfo.get(i).getSubject_name_ar(), stinfo.get(i).getSubject_hour(), stinfo.get(i).getSubject_status()));
                            listItem.put(listGroup.get(i), list1);
                    }
                    adapter = new StudyPlanAdapter(getContext(), listGroup, listItem);
                    elStudyPlan.setAdapter(adapter);
                }

                @Override
                public void onFailure(Call<modelForAPI> call, Throwable t) {
                    Toast.makeText(getContext(), "Failed in getting Study Plan info", Toast.LENGTH_SHORT).show();

                }
            });
        }
    }
