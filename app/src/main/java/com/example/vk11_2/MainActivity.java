package com.example.vk11_2;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout = null;
    NavigationView navigationView = null;
    Toolbar toolbar = null;
    FragmentHome fragmenthome = new FragmentHome();
    FragmentSettings fragmentsettings = new FragmentSettings();
    ActionBarDrawerToggle drawerToggle = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = (DrawerLayout) findViewById(R.id.my_drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        drawerToggle = setupDrawerToggle();
        drawerToggle.setDrawerIndicatorEnabled(true);
        drawerToggle.syncState();

        drawerLayout.addDrawerListener(drawerToggle);

        setFragment(fragmenthome);
        setupDrawerContent(navigationView);


    }

    public void setFragment(Fragment fragmenthome) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.flContent, fragmenthome).commit();
    }

    private ActionBarDrawerToggle setupDrawerToggle() {
        return new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.nav_open,  R.string.nav_close);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }

        return super.onOptionsItemSelected(item);

    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        selectDrawerItem(menuItem);
                        return true;
                    }
                });
    }

    public void selectDrawerItem(MenuItem menuItem) {
        Fragment fragment = null;

        if(menuItem.getItemId() == R.id.nav_settings) {
            fragment = fragmentsettings;
        } else {
            fragment = fragmenthome;
        }

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.flContent,fragment);
        transaction.commit();

        // Highlight the selected item has been done by NavigationView
        menuItem.setChecked(true);
        // Set action bar title
        setTitle(menuItem.getTitle());
        // Close the navigation drawer
        drawerLayout.closeDrawers();
    }

    /*@Override
    public void onStart(){ //ottaa vastaan arvon FragmentSettings
        super.onStart(); //try-catch
        try{
            String text = getIntent().getExtras().get("key1").toString();
            sendValueToFragement();

        }catch(Exception e){
            System.out.println("virhe MainActivity");
        }

    }*/

    public void getValueFromFragment(){
        Intent intent = getIntent();
        String text = intent.getStringExtra("key1");
        System.out.println("FragementSetting saatu arvo:" + text);
        sendValueToFragement();
    }

    public void sendValueToFragement(){
        Bundle bundle = new Bundle();
        bundle.putString("key2","estä");
        fragmenthome.setArguments(bundle); //lähetetään arvon FragementHome

    }


}