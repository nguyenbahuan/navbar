package com.example.navbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavAction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.window.OnBackInvokedDispatcher;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity  {

    //bien
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //set fragment home
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_layout, new HomeFragment())
                    .commit();
        }
        //hooks
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);
        //toolbar


        //Hide or show Item

        //navbar

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout, toolbar, R.string.nav_drawer_open,R.string.nav_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.black));


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if(id == R.id.nav_home) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                    fragmentR(new HomeFragment());
                }else if(id == R.id.nav_statistical) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                    fragmentR(new StatisticalFragment());
                }else if(id == R.id.nav_menu) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                    fragmentR(new MenuFragment());
                }else if(id == R.id.nav_table) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                    fragmentR(new TableFragment());
                }else if(id == R.id.nav_staff) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                    fragmentR(new StaffFragment());
                }

                return true;
        }});


        //
//        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(R.id.nav_menu,R.id.nav_staff,R.id.nav_table,R.id.nav_statistical).setOpenableLayout(drawerLayout).build();
//        NavController navController = Navigation.findNavController(this,R.id.nav_home);
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
//        NavigationUI.setupWithNavController(navigationView, navController);


    }
    @Override
    public void onBackPressed() {
        int count = getSupportFragmentManager().getBackStackEntryCount();
        if(count == 0 ) {
            super.onBackPressed();
        }else  {
            getSupportFragmentManager().popBackStack();
        }
    }





private  void  fragmentR(Fragment fragment ) {
    FragmentManager fragmentManager = getSupportFragmentManager();
    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
    fragmentTransaction.replace(R.id.fragment_layout,fragment,null);
    fragmentTransaction.addToBackStack(null).commit();
}



}