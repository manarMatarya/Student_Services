package com.example.myapplication1.Fragments;

import android.app.Dialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication1.R;


public class UpdateInformation extends Fragment {

    public UpdateInformation() {
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
        View root= inflater.inflate(R.layout.fragment_update_information, container, false);
        Button saveupdate=root.findViewById(R.id.saveupdate);
        saveupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showupdateDialog();
            }
        });

        return root;
    }
    private void showupdateDialog() {
//       final AlertDialog.Builder alb=new AlertDialog.Builder(getActivity());
//       View view=getActivity().getLayoutInflater().inflate(R.layout.custm_dialog,null);

        final Dialog dialog= new Dialog(getActivity());
        dialog.setContentView(R.layout.custm_dialog);

        final TextView yes = dialog.findViewById(R.id.yes);
        final TextView msg = dialog.findViewById(R.id.msg);

        final TextView no = dialog.findViewById(R.id.no);

        dialog.setCancelable(true);
        msg.setText("هل تريد حفظ التعديلات");
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager1= getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction1=fragmentManager1.beginTransaction();
                mainInfo menu =new mainInfo();
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