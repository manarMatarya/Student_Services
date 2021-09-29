package com.example.myapplication1.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import com.example.myapplication1.R;


public class forgetpassword extends Fragment {
    private EditText edtstudentnumberforgetpass,edtstudntIDforgetpass,edtbirthdayforgetpass,edtavregeforgetpass;
    private Button bntresivepassword;
    public forgetpassword() {
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
        View root= inflater.inflate(R.layout.fragment_forgetpassword, container, false);
        edtstudentnumberforgetpass= root.findViewById(R.id.edtstudentnumberforgetpass);
        edtstudntIDforgetpass=root.findViewById(R.id.edtstudntIDforgetpass);
        edtbirthdayforgetpass=root.findViewById(R.id.edtbirthdayforgetpass);
        edtavregeforgetpass=root.findViewById(R.id.edtavregeforgetpass);
        bntresivepassword=root.findViewById(R.id.bntresivepassword);

        bntresivepassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number=   edtstudentnumberforgetpass.getText().toString();
                String avg=   edtavregeforgetpass.getText().toString();
                String ID=   edtstudntIDforgetpass.getText().toString();
                String birthday=   edtbirthdayforgetpass.getText().toString();

            }
        });
        return root;
    }
}