package com.tally_meals.ics;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;
import com.tally_meals.ics.Fragment.Home_fragment;
import com.tally_meals.ics.Fragment.Prefrences_fragment;
import com.tally_meals.ics.Fragment.Profile_fragment;
import com.tally_meals.ics.Fragment.Template_fragment;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.widget.Toast;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity {

    NavigationView navigationView;
    private ActionBarDrawerToggle toggle;
    DrawerLayout drawer;
    Activity activity;
    Fragment fragment;
    private FragmentManager fragmentmanager;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        activity = MainActivity.this;

        toggle = new ActionBarDrawerToggle(activity, drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        setUpNavView();

        fragment = new Home_fragment();
        fragmentmanager = getSupportFragmentManager();
        fragmentTransaction =fragmentmanager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_layout,fragment);
        fragmentTransaction.commit();
        // fragmentTransaction.addToBackStack(Home_fragment.class.getSimpleName());

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Roboto-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    private void setUpNavView()
    {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()) {

                    case R.id.nav_hhome:
                        closeDrawer();
                        fragment = new Home_fragment();
                        fragmentmanager = getSupportFragmentManager();
                        fragmentTransaction =fragmentmanager.beginTransaction();
                        fragmentTransaction.replace(R.id.fragment_layout,fragment);
                        //fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();

                        break;


                    case R.id.nav_template:
                        closeDrawer();
                        fragment = new Template_fragment();
                        fragmentmanager = getSupportFragmentManager();
                        fragmentTransaction =fragmentmanager.beginTransaction();
                        fragmentTransaction.replace(R.id.fragment_layout,fragment);
                        fragmentTransaction.addToBackStack(fragment.getTag());
                        fragmentTransaction.commit();

                        break;

                    case R.id.nav_pref:
                        closeDrawer();
                        fragment = new Prefrences_fragment();
                        fragmentmanager = getSupportFragmentManager();
                        fragmentTransaction =fragmentmanager.beginTransaction();
                        fragmentTransaction.replace(R.id.fragment_layout,fragment);
                       fragmentTransaction.addToBackStack(fragment.getTag());
                        fragmentTransaction.commit();
                        break;

                    case R.id.nav_profile:
                        closeDrawer();
                        fragment = new Profile_fragment();
                        fragmentmanager = getSupportFragmentManager();
                        fragmentTransaction =fragmentmanager.beginTransaction();
                        fragmentTransaction.replace(R.id.fragment_layout,fragment);
                        fragmentTransaction.addToBackStack(fragment.getTag());
                        fragmentTransaction.commit();
                        break;

                    case R.id.nav_share:
                        Toast.makeText(activity, "Sharing ...", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.nav_send:
                        Toast.makeText(activity, "Send ...", Toast.LENGTH_SHORT).show();
                        break;


                }
                return true;
            }
        });
    }


    public void openDrawer() {
        unlockDrawer();
        drawer.openDrawer(GravityCompat.START);    }

    public void closeDrawer() {
        drawer.closeDrawers();
    }

    public void lockDrawer(){  drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);  }

    public void unlockDrawer(){ drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED); }
}
