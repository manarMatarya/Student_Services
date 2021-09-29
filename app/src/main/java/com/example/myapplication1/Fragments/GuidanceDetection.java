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

import androidx.fragment.app.Fragment;


import com.example.myapplication1.Adapters.SPAdapter;
import com.example.myapplication1.LoginAuthentication.ApiClient;
import com.example.myapplication1.Models.SPchild;
import com.example.myapplication1.Models.SPparent;
import com.example.myapplication1.Models.modelForAPI;
import com.example.myapplication1.Models.transcript_semesters;
import com.example.myapplication1.Models.transcript_subjects;
import com.example.myapplication1.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class GuidanceDetection extends Fragment {
    //   RecyclerView recyclerView;
//    ArrayList<Guidence> guidences;
//     SPAdapter spAdapter;
//     GuidanceAdapter guidanceAdapter;
//    ArrayList<SPparent> listGroup;
//    HashMap<SPparent, List<SPchild>> listItem ;
    List<transcript_semesters> semester_regs;
    Spinner spinner;
    LinearLayout header;
    LinearLayout footer;
    ExpandableListView exDetection;
    List<transcript_subjects> listGroup;
    List<transcript_subjects> transubject;
    TextView tvFhour3,tvTmatlop,tvFmajmoF;
    HashMap<transcript_subjects, List<SPchild>> listItem ;
    SPAdapter adapter;
    ImageView sahemGrand;
    public GuidanceDetection() {
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
        View root = inflater.inflate(R.layout.fragment_guidance_detection, container, false);
        spinner=root.findViewById(R.id.spDetection);
        exDetection = root.findViewById(R.id.exDetection);
        header = root.findViewById(R.id.headerinfodetection);
        footer = root.findViewById(R.id.footerinfodetection);
        sahemGrand = root.findViewById(R.id.sahemDetection);
        tvFhour3 = root.findViewById(R.id.tvFhour3);
        tvTmatlop = root.findViewById(R.id.tvTmatlop);
        tvFmajmoF = root.findViewById(R.id.tvFmajmoF);
        sahemGrand.setImageResource(R.drawable.arrow3);
        listGroup=new ArrayList<transcript_subjects>() ;
        listItem = new HashMap<transcript_subjects,List<SPchild>>();
        //  recyclerView = root.findViewById(R.id.guidanceRec);
//        guidences=new ArrayList<>();
//        spAdapter = new SPAdapter(getContext(),listGroup,listItem);

//
//



        List<SPchild> list1 = new ArrayList<>();
        list1.add(new SPchild("19","30" ,"47", "96","أ") );

//                for(int i=0;i<9;i++){
//            listGroup.add(new SPparent("ITMM2301","أمن و حماية الأنظمة" , "3","96" , new SPfooter("77" , "77" , "50")) );
//            listItem.put(listGroup.get(i),list1);
//        }


       // final int _singleItemRes = R.layout.spinner_item;

        try {
            getRegSem();




            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                    Call<modelForAPI> semesterRegResponseCall = ApiClient.userService(getContext()).getTranscriptSemesters();
                    semesterRegResponseCall.enqueue(new Callback<modelForAPI>() {
                        @Override
                        public void onResponse(Call<modelForAPI> call, Response<modelForAPI> response) {
                            modelForAPI spInfo = response.body();
                            semester_regs = new ArrayList<>(Arrays.asList(spInfo.getTranscript_semesters()));
                            //List<String> s=new ArrayList<>();
                            for (int i = 0; i < semester_regs.size(); i++) {
                                if (spinner.getSelectedItem().toString().equals(semester_regs.get(i).getSemester_name_ar())) {
                                  String  id = semester_regs.get(i).getSemester_no();
                                    Toast.makeText(getActivity(), ""+id, Toast.LENGTH_SHORT).show();
                                    tvFhour3.setText(semester_regs.get(i).getExec_hour());
                                    tvTmatlop.setText(semester_regs.get(i).getSemester_gpa());
                                    tvFmajmoF.setText(semester_regs.get(i).getSemester_avg());
                                    setTransubject(id);

                                }

                            }

                        }
                        @Override
                        public void onFailure(Call<modelForAPI> call, Throwable t) {
                        }
                    });

                   // setTransubject(idd);
                            //
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
//            Toast.makeText(getActivity(), ""+spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
           // Toast.makeText(getActivity(), ""+id, Toast.LENGTH_SHORT).show();
//            setTransubject(id);
//            adapter.notifyDataSetChanged();

        }
        catch (NumberFormatException ex){
            Toast.makeText(getActivity(), "no internet", Toast.LENGTH_SHORT).show();
        }
        return root;
    }
public void getRegSem(){
        Call<modelForAPI> semesterRegResponseCall = ApiClient.userService(getContext()).getTranscriptSemesters();
        semesterRegResponseCall.enqueue(new Callback<modelForAPI>() {
            @Override
            public void onResponse(Call<modelForAPI> call, Response<modelForAPI> response) {
                modelForAPI semesterRegResponse = response.body();
                semester_regs = new ArrayList<>(Arrays.asList(semesterRegResponse.getTranscript_semesters()));
                List<String> s=new ArrayList<>();
                List<String> sem_ids=new ArrayList<>();
                for(int i=0;i<semester_regs.size();i++){
                    s.add(semester_regs.get(i).getSemester_name_ar()) ;
                    sem_ids.add(semester_regs.get(i).getSemester_no());
                }
//                ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(getContext(),
//                        R.array.app3, _singleItemRes);
//
//                adapter1.setDropDownViewResource(_singleItemRes);
//
//                spinner.setAdapter(adapter1);



                ArrayAdapter sppinerarray=new ArrayAdapter<>(getActivity(),android.R.layout.simple_spinner_dropdown_item,s);
                sppinerarray.setDropDownViewResource(R.layout.spinner_item);
                spinner.setAdapter(sppinerarray);
//                ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(getContext(),
//                        R.array.app2, _singleItemRes);
//
//                adapter1.setDropDownViewResource(_singleItemRes);
//
//                spinner.setAdapter(adapter1);
            }

            @Override
            public void onFailure(Call<modelForAPI> call, Throwable t) {

            }
        });
    }




public void setTransubject (String id){
        String param = "{\"semester_cd|=\":"+id.toString()+"}";
//        Call<modelForAPI> md = ApiClient.userService(getContext()).getTranscriptSupj();
        Call<modelForAPI> md = ApiClient.userService(getContext()).getTranscriptSupj(param);
        md.enqueue(new Callback<modelForAPI>() {
            @Override
            public void onResponse(Call<modelForAPI> call, Response<modelForAPI> response) {

                modelForAPI TranscriptSupj = response.body();
                transubject = new ArrayList<>(Arrays.asList(TranscriptSupj.getTranscript_subjects()));

                Toast.makeText(getActivity(), ""+transubject.get(0).getSubject_name_ar(), Toast.LENGTH_SHORT).show();
                //عرض التفاصيل للدرجة
                List<SPchild> list1 = new ArrayList<>();
                list1.add(new SPchild("19", "30", "47", "96", "أ"));

                adapter = new SPAdapter(getContext(), listGroup,listItem);

                for (int i = 0; i < transubject.size(); i++) {
                        listGroup.add(new transcript_subjects(transubject.get(i).getSubject_cd(),transubject.get(i).getSubject_name_ar(),transubject.get(i).getSubject_hour(),transubject.get(i).getTotal_mark()));
                        listItem.put(listGroup.get(i), list1);
                }
                adapter.notifyDataSetChanged();
                exDetection.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<modelForAPI> call, Throwable t) {
                Toast.makeText(getContext(), "Failed in getting Study Plan info", Toast.LENGTH_SHORT).show();

            }
        });
    }



}