package com.example.myapplication1.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.example.myapplication1.Adapters.acadimic_study_adapter;
import com.example.myapplication1.Adapters.maneAdapter;
import com.example.myapplication1.Models.acaminic_listitem;
import com.example.myapplication1.Models.childItem;
import com.example.myapplication1.Models.itemView;
import com.example.myapplication1.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link academic_study#newInstance} factory method to
 * create an instance of this fragment.
 */
public class academic_study extends Fragment {

    ExpandableListView expandableListView;
    acadimic_study_adapter adapter;
    ArrayList<childItem> listGroup;
    HashMap<childItem, List<acaminic_listitem>> listItem;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public academic_study() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment academic_study.
     */
    // TODO: Rename and change types and number of parameters
    public static academic_study newInstance(String param1, String param2) {
        academic_study fragment = new academic_study();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_academic_study, container, false);

        expandableListView = v.findViewById(R.id.acadimicstudy_expandable_listview);
        listGroup = new ArrayList<>();
        listItem = new HashMap<childItem, List<acaminic_listitem>>();
        adapter = new acadimic_study_adapter(getContext(),listGroup,listItem);
        expandableListView.setAdapter(adapter);
        initListData();

        return v;
    }

    private void initListData() {
        listGroup.add(new childItem("اجباري قسم"));
        listGroup.add(new childItem("اختياري قسم"));
        listGroup.add(new childItem("متطلب جامعة اجبارى"));
        listGroup.add(new childItem("متطلب كلية اجبارى"));
        listGroup.add(new childItem("مساق حر"));
        listGroup.add(new childItem("متطلبات الجامعة الاختيارية أ"));
        listGroup.add(new childItem("متطلبات الجامعة الاختيارية ب"));
        listGroup.add(new childItem("متطلبات الجامعة الاختيارية ج"));
        listGroup.add(new childItem("المجموع"));


        ArrayList<acaminic_listitem> list1 = new ArrayList<>();
        list1.add(new acaminic_listitem(90, 40, 50, 66, 88, 70, 40));

        ArrayList<acaminic_listitem> list2 = new ArrayList<>();
        list2.add(new acaminic_listitem(90, 40, 50, 66, 88, 70, 40));

        ArrayList<acaminic_listitem> list3 = new ArrayList<>();
        list3.add(new acaminic_listitem(90, 40, 50, 66, 88, 70, 40));

        ArrayList<acaminic_listitem> list4 = new ArrayList<>();
        list4.add(new acaminic_listitem(90, 40, 50, 66, 88, 70, 40));

        ArrayList<acaminic_listitem> list5 = new ArrayList<>();
        list5.add(new acaminic_listitem(90, 40, 50, 66, 88, 70, 40));

        ArrayList<acaminic_listitem> list6 = new ArrayList<>();
        list6.add(new acaminic_listitem(90, 40, 50, 66, 88, 70, 40));
        ArrayList<acaminic_listitem> list7 = new ArrayList<>();
        list7.add(new acaminic_listitem(90, 40, 50, 66, 88, 70, 40));
        ArrayList<acaminic_listitem> list8 = new ArrayList<>();
        list8.add(new acaminic_listitem(90, 40, 50, 66, 88, 70, 40));
        ArrayList<acaminic_listitem> list9 = new ArrayList<>();
        list9.add(new acaminic_listitem(90, 40, 50, 66, 88, 70, 40));

        listItem.put(listGroup.get(0), list1);
        listItem.put(listGroup.get(1), list2);
        listItem.put(listGroup.get(2), list3);
        listItem.put(listGroup.get(3), list4);
        listItem.put(listGroup.get(4), list5);
        listItem.put(listGroup.get(5), list6);
        listItem.put(listGroup.get(6), list7);
        listItem.put(listGroup.get(7), list8);
        listItem.put(listGroup.get(8), list9);


        adapter.notifyDataSetChanged();
    }
}