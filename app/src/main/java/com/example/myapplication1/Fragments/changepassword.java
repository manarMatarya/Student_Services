package com.example.myapplication1.Fragments;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication1.R;


public class changepassword extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public changepassword() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment changepassword.
     */
    // TODO: Rename and change types and number of parameters
    public static changepassword newInstance(String param1, String param2) {
        changepassword fragment = new changepassword();
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
        View view= inflater.inflate(R.layout.fragment_changepassword, container, false);
        Button bntchangpassword=view.findViewById(R.id.bntchangpassword);
        bntchangpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showupdateDialog();
            }
        });

        return view;
    }

    private void showupdateDialog() {
//       final AlertDialog.Builder alb=new AlertDialog.Builder(getActivity());
//       View view=getActivity().getLayoutInflater().inflate(R.layout.custm_dialog,null);

        final Dialog dialog= new Dialog(getActivity());
        dialog.setContentView(R.layout.custm_dialog);

        final TextView yes = dialog.findViewById(R.id.yes);
        final TextView no = dialog.findViewById(R.id.no);

        dialog.setCancelable(true);
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager1= getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction1=fragmentManager1.beginTransaction();
                Home menu =new Home();
                fragmentTransaction1.replace(R.id.fragcounter,menu);
//                    fragmentTransaction1.addToBackStack(null);
                fragmentTransaction1.commit();
                dialog.dismiss();
            }
        });
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}