package com.example.myapplication1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.myapplication1.Fragments.GuidanceDetection;
import com.example.myapplication1.Fragments.Home;
import com.example.myapplication1.Fragments.menu;
import com.example.myapplication1.Fragments.quarerlySchedule;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity2 extends AppCompatActivity  implements BottomNavigationView.OnNavigationItemSelectedListener{
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        loadfragment(new Home());
        bottomNavigationView=findViewById(R.id.nv);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);



    }
    public boolean loadfragment(Fragment fragment){
        if(fragment!=null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragcounter,fragment).addToBackStack(null).commit();

        }
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment=null;
        switch (item.getItemId())
        {
            case R.id.home:
                fragment=new Home();
                break;
            case R.id.quarterly:
                fragment=new quarerlySchedule();
                break;
            case R.id.guidance:
                fragment=new GuidanceDetection();
                break;
            case R.id.menus:
                fragment=new menu();
                break;
        }

        return loadfragment(fragment);
    }

    @Override
    public void onBackPressed() {
        if(bottomNavigationView.getSelectedItemId()==R.id.home){
            super.onBackPressed();
            finish();
        }
        else{
            bottomNavigationView.setSelectedItemId(R.id.home);
        }

    }
}