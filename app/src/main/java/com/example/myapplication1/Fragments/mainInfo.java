package com.example.myapplication1.Fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.myapplication1.LoginAuthentication.ApiClient;
import com.example.myapplication1.Models.basicinfo;
import com.example.myapplication1.R;
import com.example.myapplication1.basicinfoModel;
import com.example.myapplication1.db.DatabaseHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class mainInfo extends Fragment {
//    private SessionMananger sessionMananger;
    EditText name,citizen,gender,idNum,nameinenglish,dateOfBirth,city,placeOfBirth,governorate,cite,neighborhood
        ,street;
    SharedPreferences sharedPreferences;

    DatabaseHandler db;
    List<basicinfo> basicinfos;

    public mainInfo() {
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
        View root= inflater.inflate(R.layout.fragment_main_info, container, false);
        ImageView idedit=root.findViewById(R.id.idedit);
         name=root.findViewById(R.id.name);
        citizen=root.findViewById(R.id.citizen);
        gender=root.findViewById(R.id.gender);
        idNum=root.findViewById(R.id.idNum);
        nameinenglish=root.findViewById(R.id.nameinenglish);
        dateOfBirth=root.findViewById(R.id.dateOfBirth);
        city=root.findViewById(R.id.city);
        placeOfBirth=root.findViewById(R.id.placeOfBirth);
        governorate=root.findViewById(R.id.governorate);
        cite=root.findViewById(R.id.cite);
        neighborhood=root.findViewById(R.id.neighborhood);
        street=root.findViewById(R.id.street);
//        sharedPreferences =getActivity(). getSharedPreferences("hi", Context.MODE_PRIVATE);

        db=new DatabaseHandler(getActivity());

//        sessionMananger= new SessionMananger(getContext());
//        idedit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                FragmentManager fragmentManager1= getActivity().getSupportFragmentManager();
//                FragmentTransaction fragmentTransaction1=fragmentManager1.beginTransaction();
//                UpdateInformation menu =new UpdateInformation();
//                fragmentTransaction1.replace(R.id.fragcounter,menu);
////                    fragmentTransaction1.addToBackStack(null);
//                fragmentTransaction1.commit();
//            }
//        });

        try {
//            Toast.makeText(getActivity(), ""+login.sessionMananger.fetchUserId(), Toast.LENGTH_SHORT).show();
//            ArrayList<basicinfo>setvalue=db.getall(login.sessionMananger.fetchUserId());
//            name.setText(setvalue.get(0).getSearch_name());
//            nameinenglish.setText(setvalue.get(0).getFname_en()+" "+setvalue.get(0).getSname_en()+" "+setvalue.get(0).getTname_en()+" "+setvalue.get(0).getLname_en());
//            idNum.setText(setvalue.get(0).getPassport_no());
//            gender.setText(setvalue.get(0).getGender_name());
//            citizen.setText(setvalue.get(0).getCitizen_name());
//            dateOfBirth.setText(setvalue.get(0).getDob());
//            city.setText(setvalue.get(0).getCity_name_ar());
//            placeOfBirth.setText(setvalue.get(0).getCountry_name_pob_ar());
//            governorate.setText(setvalue.get(0).getGovernorate_name_ar());
//            cite.setText(setvalue.get(0).getRegion_name_ar());
//            neighborhood.setText(setvalue.get(0).getCity_name_ob_ar());
//            street.setText(setvalue.get(0).getStreet());
//            getBasicInfo(login.sessionMananger.fetchAuthToken());
//            Toast.makeText(getContext(), login.sessionMananger.fetchAuthToken(), Toast.LENGTH_SHORT).show();
            getBasicInfo();
        } catch (NumberFormatException ex) {
            Toast.makeText(getContext(),"hjjg" , Toast.LENGTH_LONG).show();
        }




        return root;
    }




 public void getBasicInfo(){
     Call<basicinfoModel> basic = ApiClient.userService(getContext())
             .getBasicInfo();
     basic.enqueue(new Callback<basicinfoModel>() {
         @Override
         public void onResponse(Call<basicinfoModel> call, Response<basicinfoModel> response) {
             basicinfoModel basicinfoModel = response.body();
             basicinfos = new ArrayList<>(Arrays.asList(basicinfoModel.getBasicinfo()));

             name.setText(basicinfos.get(0).getSearch_name());
            nameinenglish.setText(basicinfos.get(0).getFname_en()+" "+basicinfos.get(0).getSname_en()+""+basicinfos.get(0).getTname_en()+""+basicinfos.get(0).getLname_en());
            idNum.setText(basicinfos.get(0).getPassport_no());
            gender.setText(basicinfos.get(0).getGender_name());
            citizen.setText(basicinfos.get(0).getCitizen_name());
            dateOfBirth.setText(basicinfos.get(0).getDob());
            city.setText(basicinfos.get(0).getCity_name_ar());
            placeOfBirth.setText(basicinfos.get(0).getCountry_name_pob_ar());
            governorate.setText(basicinfos.get(0).getGovernorate_name_ar());
            cite.setText(basicinfos.get(0).getCity_name_ob_ar());
            neighborhood.setText(basicinfos.get(0).getRegion_name_ar());
            street.setText(basicinfos.get(0).getStreet());
         }

         @Override
         public void onFailure(Call<basicinfoModel> call, Throwable t) {

         }
     });
 }

}