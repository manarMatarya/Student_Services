package com.example.myapplication1.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication1.Adapters.CategoryAdapter;
import com.example.myapplication1.Adapters.ExamsScheduleAdapter;
import com.example.myapplication1.Models.Exams;
import com.example.myapplication1.R;

import java.util.ArrayList;


public class FinalExams extends Fragment {

    public FinalExams() {
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
//        TvEenwan.setText("جدول الإختبارات النهائية");

        // RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(),2);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());

        ArrayList<Exams> data = getData();
        RvMidExams.setLayoutManager(layoutManager);
        CategoryAdapter examsScheduleAdapter = new CategoryAdapter(getActivity() , data);
        RvMidExams.setAdapter(examsScheduleAdapter);


        return root;
    }

    private ArrayList<Exams> getData() {
        ArrayList<Exams> exams = new ArrayList<>();
        exams.add(new Exams ("شبكات الحاسوب" , "1/8/2021" ,"الأولى","G214") );
        exams.add(new Exams ("شبكات الحاسوب" , "1/8/2021" ,"الأولى","G214") );
        exams.add(new Exams ("شبكات الحاسوب" , "1/8/2021" ,"الأولى","G214") );
        exams.add(new Exams ("شبكات الحاسوب" , "1/8/2021" ,"الأولى","G214") );
        exams.add(new Exams ("شبكات الحاسوب" , "1/8/2021" ,"الأولى","G214") );
        exams.add(new Exams ("شبكات الحاسوب" , "1/8/2021" ,"الأولى","G214") );
        exams.add(new Exams ("شبكات الحاسوب" , "1/8/2021" ,"الأولى","G214") );
        return exams;
    }
}