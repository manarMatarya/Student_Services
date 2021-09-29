package com.example.myapplication1.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication1.Adapters.CategoryAdapter;
import com.example.myapplication1.Models.Exams;
import com.example.myapplication1.R;

import java.util.ArrayList;

public class MidExams extends Fragment {


    public MidExams() {
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
        View root = inflater.inflate(R.layout.fragment_exams, container, false);

        final RecyclerView RvMidExams = root.findViewById(R.id.RvMidExams);
//        final TextView TvEenwan = root.findViewById(R.id.TvEenwan);
//
//        TvEenwan.setText("جدول الإختبارات النصفية");

        // RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(),2);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        RvMidExams.setLayoutManager(layoutManager);

      //  ArrayList<Exams> data = getData();
        ArrayList<Exams> exams = new ArrayList<>();
        exams.add(new Exams ("شبكات الحاسوب" , "1/8/2021" ,"الأولى","G214") );
        exams.add(new Exams ("شبكات الحاسوب" , "2/8/2021" ,"الأولى","G214") );
        exams.add(new Exams ("شبكات الحاسوب" , "3/8/2021" ,"الأولى","G214") );
        exams.add(new Exams ("شبكات الحاسوب" , "4/8/2021" ,"الأولى","G214") );
        exams.add(new Exams ("شبكات الحاسوب" , "5/8/2021" ,"الأولى","G214") );
        exams.add(new Exams ("شبكات الحاسوب" , "6/8/2021" ,"الأولى","G214") );
        exams.add(new Exams ("شبكات الحاسوب" , "7/8/2021" ,"الأولى","G214") );
        exams.add(new Exams ("شبكات الحاسوب" , "8/8/2021" ,"الأولى","G214") );
        exams.add(new Exams ("شبكات الحاسوب" , "9/8/2021" ,"الأولى","G214") );
        exams.add(new Exams ("شبكات الحاسوب" , "10/8/2021" ,"الأولى","G214") );
        //ExamsScheduleAdapter examsScheduleAdapter = new ExamsScheduleAdapter(getActivity() , exams);
        CategoryAdapter examsScheduleAdapter = new CategoryAdapter(getActivity() , exams);
        RvMidExams.setAdapter(examsScheduleAdapter);

//        Toast.makeText(getActivity(), exams.get(1)+"", Toast.LENGTH_SHORT).show();

        return root;
    }

    private ArrayList<Exams> getData() {
        ArrayList<Exams> exams = new ArrayList<>();
        exams.add(new Exams ("شبكات الحاسوب" , "1/8/2021" ,"الأولى","G214") );
        exams.add(new Exams ("شبكات الحاسوب" , "2/8/2021" ,"الأولى","G214") );
        exams.add(new Exams ("شبكات الحاسوب" , "3/8/2021" ,"الأولى","G214") );
        exams.add(new Exams ("شبكات الحاسوب" , "4/8/2021" ,"الأولى","G214") );
        exams.add(new Exams ("شبكات الحاسوب" , "5/8/2021" ,"الأولى","G214") );
        exams.add(new Exams ("شبكات الحاسوب" , "6/8/2021" ,"الأولى","G214") );
        exams.add(new Exams ("شبكات الحاسوب" , "7/8/2021" ,"الأولى","G214") );
        exams.add(new Exams ("شبكات الحاسوب" , "8/8/2021" ,"الأولى","G214") );
        exams.add(new Exams ("شبكات الحاسوب" , "9/8/2021" ,"الأولى","G214") );
        exams.add(new Exams ("شبكات الحاسوب" , "10/8/2021" ,"الأولى","G214") );
        return exams;
    }

}