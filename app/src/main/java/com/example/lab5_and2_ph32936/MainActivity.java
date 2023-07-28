package com.example.lab5_and2_ph32936;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;

import com.example.lab5_and2_ph32936.Fragment.FragmentBookmark;
import com.example.lab5_and2_ph32936.Fragment.FragmentCaiDat;
import com.example.lab5_and2_ph32936.Fragment.FragmentTrangChu;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout = findViewById(R.id.drawerLayout);
         toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.opennav, R.string.closenav);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(this);

        callFragment(new FragmentTrangChu());

    }

    @Override
    public void onBackPressed() {

        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.trangChu) {
            FragmentTrangChu fragmentTrangChu = new FragmentTrangChu();
                toolbar.setTitle("Trang chủ");
            callFragment(fragmentTrangChu);


        }else if (item.getItemId() == R.id.dauTrang){
            toolbar.setTitle("Bookmark");
            callFragment(new FragmentBookmark());

        } else if (item.getItemId() == R.id.caidat) {
            toolbar.setTitle("Cài đặt");
            callFragment(new FragmentCaiDat());
        } else if (item.getItemId() == R.id.dangxuat) {
            Intent intent = new Intent(MainActivity.this , Bai2.class);
            startActivity(intent);
        }


        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }

    private void callFragment(Fragment fragment) {

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment).commit();


    }
}