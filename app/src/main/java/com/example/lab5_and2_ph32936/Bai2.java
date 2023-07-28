package com.example.lab5_and2_ph32936;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.lab5_and2_ph32936.Fragment.FragmentBoSuuTap;
import com.example.lab5_and2_ph32936.Fragment.FragmentHome;
import com.example.lab5_and2_ph32936.Fragment.FragmentMap;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Bai2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2);


        BottomNavigationView navigationView = findViewById(R.id.bottomNavigation);

        callFragment(new FragmentHome());
        navigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if (item.getItemId() == R.id.homebottom) {

                    callFragment(new FragmentHome());

                }else if (item.getItemId() == R.id.bando) {

                    callFragment(new FragmentMap());

                }else if (item.getItemId() == R.id.collect) {

                    callFragment(new FragmentBoSuuTap());

                }

                return true;
            }
        });


    }

    private void callFragment(Fragment fragment) {

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.containerBottomm, fragment).commit();

    }
}