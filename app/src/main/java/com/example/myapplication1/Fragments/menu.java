package com.example.myapplication1.Fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication1.Adapters.maneAdapter;
import com.example.myapplication1.LoginAuthentication.ApiClient;
import com.example.myapplication1.LoginAuthentication.SessionMananger;
import com.example.myapplication1.MainActivity;
import com.example.myapplication1.MainActivity2;
import com.example.myapplication1.Models.basicinfo;
import com.example.myapplication1.Models.childItem;
import com.example.myapplication1.Models.itemView;
import com.example.myapplication1.R;
import com.example.myapplication1.ajendaInfoResponse;
import com.example.myapplication1.basicinfoModel;
import com.example.myapplication1.db.DatabaseHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class menu extends Fragment {

    ExpandableListView expandableListView;
    maneAdapter adapter;
    ArrayList<itemView> listGroup;
    HashMap<itemView, List<childItem>> listItem;
    DatabaseHandler db;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    ImageView image;
    Switch aSwitch;
    List<basicinfo> basicinfos;
    SessionMananger sessionMananger;

    public menu() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_menu, container, false);
        image = v.findViewById(R.id.list_child_image);
        aSwitch = v.findViewById(R.id.switch_item);
        expandableListView = v.findViewById(R.id.expandable_listview);
        listGroup = new ArrayList<>();
        listItem = new HashMap<itemView, List<childItem>>();
        adapter = new maneAdapter(getContext(), listGroup, listItem);
        expandableListView.setAdapter(adapter);
sessionMananger = new SessionMananger(getActivity());
        db = new DatabaseHandler(getActivity());
        sharedPreferences = getActivity().getSharedPreferences("hi", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        initListData();
        return v;
    }
//    String a=getString(R.string.no);

    private void initListData() {
        listGroup.add(new itemView(getString(R.string.Reports), R.mipmap.report));
//        listGroup.add(new itemView(a+"",R.mipmap.report));
        listGroup.add(new itemView(getString(R.string.student_profile), R.mipmap.books));
        listGroup.add(new itemView(getString(R.string.ELearning), R.mipmap.open));
        listGroup.add(new itemView(getString(R.string.Other_services), R.mipmap.person));
        listGroup.add(new itemView(getString(R.string.Logout), R.mipmap.logout));

        ArrayList<childItem> list1 = new ArrayList<>();
        list1.add(new childItem(getString(R.string.financial_card), R.mipmap.mony));

        list1.add(new childItem(getString(R.string.academic_study), R.mipmap.study));
        list1.add(new childItem(getString(R.string.quarterly_schedule), R.mipmap.smallcalender));
        list1.add(new childItem(getString(R.string.Study_plan_and_grades), R.mipmap.pass));
        list1.add(new childItem(getString(R.string.Guidance_detection), R.mipmap.test));
        list1.add(new childItem(getString(R.string.midterm_exam_schedule), R.mipmap.exams));
        list1.add(new childItem(getString(R.string.final_exam_schedule), R.mipmap.exam));

        ArrayList<childItem> list2 = new ArrayList<>();
        list2.add(new childItem(getString(R.string.basic_information), R.mipmap.basicinfo));
        list2.add(new childItem(getString(R.string.Academic_data), R.mipmap.acadimicinfo));

        ArrayList<childItem> list3 = new ArrayList<>();
        list3.add(new childItem(getString(R.string.model), R.mipmap.model));


        ArrayList<childItem> list4 = new ArrayList<>();
        list4.add(new childItem(getString(R.string.Notifications_and_messages), R.mipmap.notification));
        list4.add(new childItem(getString(R.string.change_Password), R.mipmap.changepassword));
        list4.add(new childItem(getString(R.string.Deactivate_notifications), R.mipmap.yes_notifi));
        list4.add(new childItem(getString(R.string.Change_the_language), R.mipmap.language));


        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                final int selected = (int) adapter.getChildId(groupPosition, childPosition);
                Intent intent;
                switch (selected) {
                    case 0:
                        if (adapter.getGroupId(groupPosition) == 0) {
                            FragmentManager fragmentManager1 = getActivity().getSupportFragmentManager();
                            FragmentTransaction fragmentTransaction1 = fragmentManager1.beginTransaction();
                            Monyf menu = new Monyf();
                            fragmentTransaction1.replace(R.id.fragcounter, menu);
//                    fragmentTransaction1.addToBackStack(null);
                            fragmentTransaction1.commit();
                            break;
                        } else if (adapter.getGroupId(groupPosition) == 1) {
//                            if (isOnline() == true) {
//                                Toast.makeText(getActivity(), "online", Toast.LENGTH_SHORT).show();
//
//                                Call<basicinfoModel> basic = ApiClient.userService(getContext())
//                                        .getBasicInfo(login.sessionMananger.fetchAuthToken());
//                                basic.enqueue(new Callback<basicinfoModel>() {
//                                    @Override
//                                    public void onResponse(Call<basicinfoModel> call, Response<basicinfoModel> response) {
//                                        basicinfoModel basicinfoModel = response.body();
//                                        basicinfos = new ArrayList<>(Arrays.asList(basicinfoModel.getBasicinfo()));
//                                        if (db.search(basicinfos.get(0).getPassport_no()).equals(basicinfos.get(0).getPassport_no())) {
//                                            Toast.makeText(getActivity(), "5236589 موجود", Toast.LENGTH_SHORT).show();
//                                            db.serchupdate(basicinfos.get(0).getPassport_no(), basicinfos.get(0).getSname_en(), basicinfos.get(0).getFname_en(), basicinfos.get(0).getTname_en(), basicinfos.get(0).getLname_en(), basicinfos.get(0).getMobile_key(), basicinfos.get(0).getMobile_no());
//                                            FragmentManager fragmentManager1 = getActivity().getSupportFragmentManager();
//                                            FragmentTransaction fragmentTransaction1 = fragmentManager1.beginTransaction();
//                                            mainInfo menu = new mainInfo();
//                                            fragmentTransaction1.replace(R.id.fragcounter, menu);
//                                            fragmentTransaction1.commit();
//
//                                        } else {
//                                            if (db.insertBasicinfo(new basicinfo(login.sessionMananger.fetchUserId(),basicinfos.get(0).getSearch_name(),basicinfos.get(0).getFname_en(),basicinfos.get(0).getSname_en(),basicinfos.get(0).getTname_en(), basicinfos.get(0).getLname_en(),  basicinfos.get(0).getGender_name(), basicinfos.get(0).getDob(), basicinfos.get(0).getCountry_name_pob_ar(), basicinfos.get(0).getCity_name_ob_ar(), basicinfos.get(0).getRegion_name_ar(), basicinfos.get(0).getCitizen_name(), basicinfos.get(0).getGovernorate_name_ar(), basicinfos.get(0).getCity_name_ar(), basicinfos.get(0).getMobile_key(), basicinfos.get(0).getMobile_no(), basicinfos.get(0).getPassport_no(), basicinfos.get(0).getStreet()))) {
//                                                Toast.makeText(getActivity(), "insert", Toast.LENGTH_SHORT).show();
////                    sessionMananger=new SessionMananger(getApplicationContext());
////                    sessionMananger.saveIDUser("208145555");
//                                                if (editor.commit()) {
//                                                    FragmentManager fragmentManager1 = getActivity().getSupportFragmentManager();
//                                                    FragmentTransaction fragmentTransaction1 = fragmentManager1.beginTransaction();
//                                                    mainInfo menu = new mainInfo();
//                                                    fragmentTransaction1.replace(R.id.fragcounter, menu);
//                                                    fragmentTransaction1.commit();
//                                                }
//                                            } else {
//                                                Toast.makeText(getActivity(), "not insert", Toast.LENGTH_SHORT).show();
//                                            }
//                                        }
//                                    }
//
//                                    @Override
//                                    public void onFailure(Call<basicinfoModel> call, Throwable t) {
//
//                                    }
//                                });
//
//                            }
//                            else if (isOnline() == false) {
//                                Toast.makeText(getActivity(), "offline", Toast.LENGTH_SHORT).show();
////                                String id1 = sharedPreferences.getString("id", null);
//                                String id1 = login.sessionMananger.fetchUserId();
//                                if (db.searchuserid(id1).equals(id1)) {
//                                    Toast.makeText(getActivity(), "no internet,exist", Toast.LENGTH_SHORT).show();
//
//                                } else {
//                                    Toast.makeText(getActivity(), "no internet", Toast.LENGTH_SHORT).show();
//                                }
//                            }
//
//
//

                            FragmentManager fragmentManager1 = getActivity().getSupportFragmentManager();
                            FragmentTransaction fragmentTransaction1 = fragmentManager1.beginTransaction();
                            mainInfo menu = new mainInfo();
                            fragmentTransaction1.replace(R.id.fragcounter, menu);
                            fragmentTransaction1.commit();
                            break;
                        } else if (adapter.getGroupId(groupPosition) == 2) {

                            break;
                        } else if (adapter.getGroupId(groupPosition) == 3) {
                            FragmentManager fragmentManager1 = getActivity().getSupportFragmentManager();
                            FragmentTransaction fragmentTransaction1 = fragmentManager1.beginTransaction();
                            NotificationBox menu = new NotificationBox();
                            fragmentTransaction1.replace(R.id.fragcounter, menu);
//                    fragmentTransaction1.addToBackStack(null);
                            fragmentTransaction1.commit();
                            break;
                        }

                    case 1:
                        if (adapter.getGroupId(groupPosition) == 0) {
                            FragmentManager fragmentManager1 = getActivity().getSupportFragmentManager();
                            FragmentTransaction fragmentTransaction1 = fragmentManager1.beginTransaction();
                            academic_study menu = new academic_study();
                            fragmentTransaction1.replace(R.id.fragcounter, menu);
//                    fragmentTransaction1.addToBackStack(null);
                            fragmentTransaction1.commit();
                            break;
                        } else if (adapter.getGroupId(groupPosition) == 1) {
                            FragmentManager fragmentManager1 = getActivity().getSupportFragmentManager();
                            FragmentTransaction fragmentTransaction1 = fragmentManager1.beginTransaction();
                            AcadimcInformation menu = new AcadimcInformation();
                            fragmentTransaction1.replace(R.id.fragcounter, menu);
//                    fragmentTransaction1.addToBackStack(null);
                            fragmentTransaction1.commit();
                            break;
                        } else if (adapter.getGroupId(groupPosition) == 3) {
                            FragmentManager fragmentManager1 = getActivity().getSupportFragmentManager();
                            FragmentTransaction fragmentTransaction1 = fragmentManager1.beginTransaction();
                            changepassword menu = new changepassword();
                            fragmentTransaction1.replace(R.id.fragcounter, menu);
//                    fragmentTransaction1.addToBackStack(null);
                            fragmentTransaction1.commit();
                            break;
                        }

                    case 2:
                        if (adapter.getGroupId(groupPosition) == 0) {
                            FragmentManager fragmentManager1 = getActivity().getSupportFragmentManager();
                            FragmentTransaction fragmentTransaction1 = fragmentManager1.beginTransaction();
                            quarerlySchedule menu = new quarerlySchedule();
                            fragmentTransaction1.replace(R.id.fragcounter, menu);
//                    fragmentTransaction1.addToBackStack(null);
                            fragmentTransaction1.commit();
                            break;
                        } else if (adapter.getGroupId(groupPosition) == 3) {
                            shownotificationDialog();
                            break;
                        }


                    case 3:
                        if (adapter.getGroupId(groupPosition) == 0) {
                            FragmentManager fragmentManager1 = getActivity().getSupportFragmentManager();
                            FragmentTransaction fragmentTransaction1 = fragmentManager1.beginTransaction();
                            StudyPlan menu = new StudyPlan();
                            fragmentTransaction1.replace(R.id.fragcounter, menu);
//                    fragmentTransaction1.addToBackStack(null);
                            fragmentTransaction1.commit();
                            break;
                        } else if (adapter.getGroupId(groupPosition) == 3) {
                            showchooseDialog();
                            break;
                        }

                    case 4:
                        if (adapter.getGroupId(groupPosition) == 0) {
                            FragmentManager fragmentManager1 = getActivity().getSupportFragmentManager();
                            FragmentTransaction fragmentTransaction1 = fragmentManager1.beginTransaction();
                            GuidanceDetection menu = new GuidanceDetection();
                            fragmentTransaction1.replace(R.id.fragcounter, menu);
//                    fragmentTransaction1.addToBackStack(null);
                            fragmentTransaction1.commit();
                            break;
                        }
                    case 5:
                        if (adapter.getGroupId(groupPosition) == 0) {
                            FragmentManager fragmentManager1 = getActivity().getSupportFragmentManager();
                            FragmentTransaction fragmentTransaction1 = fragmentManager1.beginTransaction();
                            MidExams menu = new MidExams();
                            fragmentTransaction1.replace(R.id.fragcounter, menu);
//                    fragmentTransaction1.addToBackStack(null);
                            fragmentTransaction1.commit();
                            break;
                        }
                    case 6:
                        if (adapter.getGroupId(groupPosition) == 0) {
                            FragmentManager fragmentManager1 = getActivity().getSupportFragmentManager();
                            FragmentTransaction fragmentTransaction1 = fragmentManager1.beginTransaction();
                            FinalExams menu = new FinalExams();
                            fragmentTransaction1.replace(R.id.fragcounter, menu);
//                    fragmentTransaction1.addToBackStack(null);
                            fragmentTransaction1.commit();
                            break;
                        }


                }


                return true;
            }
        });
        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                final int selected = (int) adapter.getGroupId(groupPosition);
                switch (selected) {
                    case 4:
                        if (adapter.getGroupId(groupPosition) == 4) {

                            showlogoutDialog();
                            break;
                        }

                }
                return false;
            }
        });

        listItem.put(listGroup.get(0), list1);
        listItem.put(listGroup.get(1), list2);
        listItem.put(listGroup.get(2), list3);
        listItem.put(listGroup.get(3), list4);
        listItem.put(listGroup.get(4), new ArrayList<>());


        adapter.notifyDataSetChanged();

    }

    @Override
    public void onMultiWindowModeChanged(boolean isInMultiWindowMode) {
        super.onMultiWindowModeChanged(isInMultiWindowMode);
        if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.JELLY_BEAN_MR2) {
            expandableListView.setIndicatorBounds(expandableListView.getWidth(), expandableListView.getRight() - 40);
        } else {
            expandableListView.setIndicatorBoundsRelative(expandableListView.getWidth(), expandableListView.getRight() - 40);
        }
    }

    private void shownotificationDialog() {
//       final AlertDialog.Builder alb=new AlertDialog.Builder(getActivity());
//       View view=getActivity().getLayoutInflater().inflate(R.layout.custm_dialog,null);

        final Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.custm_dialog);

        final TextView yes = dialog.findViewById(R.id.yes);
        final TextView msg = dialog.findViewById(R.id.msg);
        final TextView no = dialog.findViewById(R.id.no);

        dialog.setCancelable(true);
        msg.setText("هل تريد الغاء تفعيل الاشعارات ؟");
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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

    private void showlogoutDialog() {
//       final AlertDialog.Builder alb=new AlertDialog.Builder(getActivity());
//       View view=getActivity().getLayoutInflater().inflate(R.layout.custm_dialog,null);

        final Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.custm_dialog);

        final TextView yes = dialog.findViewById(R.id.yes);
        final TextView no = dialog.findViewById(R.id.no);

        dialog.setCancelable(true);
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    logout();

                } catch (NumberFormatException ex) {
                    Toast.makeText(getContext(), "hjjg", Toast.LENGTH_LONG).show();
                }
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

    public void logout() {
        sessionMananger.clearSharedPreferences();
        FragmentManager fragmentManager1 = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction1 = fragmentManager1.beginTransaction();
                login login = new login();
                fragmentTransaction1.replace(R.id.fragcounter, login);
                fragmentTransaction1.commit();

                //Call<String> logout = ApiClient.userService(getContext()).logout();
//        logout.enqueue(new Callback() {
//            @Override
//            public void onResponse(Call call, Response response) {
//                login.sessionMananger.riseShardtoken();
//                FragmentManager fragmentManager1 = getActivity().getSupportFragmentManager();
//                FragmentTransaction fragmentTransaction1 = fragmentManager1.beginTransaction();
//                login menu = new login();
//                fragmentTransaction1.replace(R.id.fragcounter, menu);
//                fragmentTransaction1.commit();
//            }
//
//            @Override
//            public void onFailure(Call call, Throwable t) {
//                Toast.makeText(getContext(), "", Toast.LENGTH_SHORT).show();
//
//            }
//        });
//    }
//        logout.enqueue(new Callback<String>() {
//            @Override
//            public void onResponse(Call<String> call, Response<String> response) {
//                String data= response.body();
//                if (data.equals("done")){
//                    login.sessionMananger.riseShardtoken();
//                FragmentManager fragmentManager1 = getActivity().getSupportFragmentManager();
//                FragmentTransaction fragmentTransaction1 = fragmentManager1.beginTransaction();
//                login menu = new login();
//                fragmentTransaction1.replace(R.id.fragcounter, menu);
//                fragmentTransaction1.commit();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<String> call, Throwable t) {
//
//            }
//        });
    }

    private void showchooseDialog() {
//       final AlertDialog.Builder alb=new AlertDialog.Builder(getActivity());
//       View view=getActivity().getLayoutInflater().inflate(R.layout.laun_dialog,null);

        final Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.laun_dialog);

        final TextView yes = dialog.findViewById(R.id.yes);
        final TextView no = dialog.findViewById(R.id.no);
        final Spinner sp = dialog.findViewById(R.id.sp);

        dialog.setCancelable(true);
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String lun = sp.getSelectedItem().toString();
                if (lun.equals("English")) {
                    setApplicationlanguage("en");

                } else if (lun.equals("Arabic")) {

                    setApplicationlanguage("ar");
                } else if (lun.equals("العربية")) {
                    setApplicationlanguage("ar");
                } else
                    setApplicationlanguage("en");
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


    public  void setApplicationlanguage(String language) {
        Locale myLocale = new Locale(language);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            conf.setLocale(new Locale(language));
            res.updateConfiguration(conf, dm);
            Intent refresh = new Intent(getContext(), MainActivity2.class);
            getActivity().finish();
            startActivity(refresh);// API 17+ only.
        } else {
            conf.locale = myLocale;
            res.updateConfiguration(conf, dm);
            Intent refresh = new Intent(getContext(), MainActivity2.class);
            getActivity().finish();
            startActivity(refresh);
        }
        res.updateConfiguration(conf, dm);
    }

}