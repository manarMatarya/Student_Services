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

import com.example.myapplication1.Adapters.NotificationAdapter;
import com.example.myapplication1.LoginAuthentication.ApiClient;
import com.example.myapplication1.Models.Notifications;
import com.example.myapplication1.Models.acadmic_info;
import com.example.myapplication1.Models.modelForAPI;
import com.example.myapplication1.Models.sms_recived;
import com.example.myapplication1.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class notifications extends Fragment {

    RecyclerView rec;
    List<sms_recived> notifications;
    NotificationAdapter adapter;
    TextView message;
    List<sms_recived> sms_reciveds;

    public notifications() {
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
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);

        message = root.findViewById(R.id.tvmessage);
        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.notification_container, new messages()).addToBackStack(null).commit();
            }
        });
        rec = root.findViewById(R.id.notificationrec);
        notifications=new ArrayList<>();
        notifications.add(new sms_recived("ALAQSA-REG.","رقم الطالب 2301181706 , برمجة الهواتف النقال = 95 ."));
        notifications.add(new sms_recived("ALAQSA-REG.","رقم الطالب 2301181706 , برمجة الهواتف النقال = 95 ."));
        notifications.add(new sms_recived("ALAQSA-REG.","رقم الطالب 2301181706 , برمجة الهواتف النقال = 95 ."));
        notifications.add(new sms_recived("ALAQSA-REG.","رقم الطالب 2301181706 , برمجة الهواتف النقال = 95 ."));

        adapter = new NotificationAdapter(sms_reciveds,getContext());
                rec.setAdapter(adapter);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
                rec.setLayoutManager(linearLayoutManager);
                rec.setVisibility(View.VISIBLE);

        try {
           getSmsReceived();
        }  catch (NumberFormatException ex) {
            Toast.makeText(getContext(), "hjjg", Toast.LENGTH_LONG).show();

    }
    return root;
    }

//    public void getSmsReceived() {
//        Call<List<sms_recived>> smsCall = ApiClient.userService(getContext()).getSmsReceived();
//        smsCall.enqueue(new Callback<List<sms_recived>>() {
//            @Override
//            public void onResponse(Call<List<sms_recived>> call, Response<List<sms_recived>> response) {
//                List<sms_recived> smsList = response.body();
//
////                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
////                rec.setLayoutManager(linearLayoutManager);
////                adapter = new NotificationAdapter(smsList,getContext());
////                rec.setAdapter(adapter);
////                rec.setVisibility(View.VISIBLE);
//                adapter = new NotificationAdapter(smsList,getContext());
//                rec.setAdapter(adapter);
//                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
//                rec.setLayoutManager(linearLayoutManager);
//                rec.setVisibility(View.VISIBLE);
//
//            }
//
//            @Override
//            public void onFailure(Call<List<sms_recived>> call, Throwable t) {
//                Toast.makeText(getContext(), "خطأ في عرض الرسائل", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }

    public void getSmsReceived(){
        Call<modelForAPI> modelForAPICall = ApiClient.userService(getContext()).getSmsReceivd();
        modelForAPICall.enqueue(new Callback<modelForAPI>() {
            @Override
            public void onResponse(Call<modelForAPI> call, Response<modelForAPI> response) {
                modelForAPI modelForAPI = response.body();
                sms_reciveds= new ArrayList<>(Arrays.asList(modelForAPI.getSms_recived()));

//                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
//                adapter = new NotificationAdapter(sms_reciveds,getContext());
//                rec.setLayoutManager(linearLayoutManager);
//                rec.setAdapter(adapter);
//                rec.setVisibility(View.VISIBLE);   adapter = new NotificationAdapter(sms_reciveds,getContext());

//                adapter = new NotificationAdapter(sms_reciveds,getContext());
//                rec.setAdapter(adapter);
//                rec.setHasFixedSize(true);
//                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
//                rec.setLayoutManager(linearLayoutManager);
//                rec.setVisibility(View.VISIBLE);
                Toast.makeText(getActivity(), ""+sms_reciveds.get(0).getMsg_code(), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<modelForAPI> call, Throwable t) {

            }
        });

    }
}