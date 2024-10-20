//package com.example.navigationdrawer;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.ActionBarDrawerToggle;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.appcompat.widget.Toolbar;
//import androidx.core.view.GravityCompat;
//import androidx.drawerlayout.widget.DrawerLayout;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.MenuItem;
//import android.widget.Toast;
//
//import com.google.android.material.navigation.NavigationView;
//
//public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
//
//    private DrawerLayout drawerLayout;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        drawerLayout = findViewById(R.id.drawer_layout);
//        NavigationView navigationView = findViewById(R.id.nav_view);
//        navigationView.setNavigationItemSelectedListener(this);
//
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_nav,
//                R.string.close_nav);
//        drawerLayout.addDrawerListener(toggle);
//        toggle.syncState();
//
//        if (savedInstanceState == null) {
//            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Contact()).commit();
//            navigationView.setCheckedItem(R.id.emergency_contact);
//        }
//    }
//
//    @Override
//    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//        if (item.getItemId() == R.id.emergency_contact) {
//            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Contact()).commit();
//        } else if (item.getItemId() == R.id.emergency_alert) {
//            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Alert()).commit();
//        } else if (item.getItemId() == R.id.emergency_drills) {
//            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Drills()).commit();
//        } else if (item.getItemId() == R.id.emergency_request_assistance) {
//            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Request()).commit();
//        }
//        else if (item.getItemId() == R.id.emergency_report) {
//            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Report()).commit();
//        }
//        else if (item.getItemId() == R.id.emergency_resource) {
//            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Resource()).commit();
//        }
//        else if (item.getItemId() == R.id.emergency_notification) {
//            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Notification()).commit();
//        }
//        else if (item.getItemId() == R.id.emergency_safety) {
//            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Safety()).commit();
//        }
//        else if (item.getItemId() == R.id.emergency_setting) {
//            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Setting()).commit();
//        }
//        else if (item.getItemId() == R.id.emergency_map) {
//            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Map()).commit();
//        }
//        else if (item.getItemId() == R.id.nav_logout) {
//            Intent intent=new Intent(MainActivity.this,LoginScreen.class);
//            startActivity(intent);
//        }
//
//
//        drawerLayout.closeDrawer(GravityCompat.START);
//        return true;
//    }
//
//    @Override
//    public void onBackPressed() {
//        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
//            drawerLayout.closeDrawer(GravityCompat.START);
//        } else {
//            super.onBackPressed();
//        }
//    }
//}

package com.example.navigationdrawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_nav, R.string.close_nav);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Contact()).commit();
            navigationView.setCheckedItem(R.id.emergency_contact);
        }

        // Handle intent to load the Notification fragment
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("type") && intent.hasExtra("description")) {
            String type = intent.getStringExtra("type");
            String description = intent.getStringExtra("description");
            Notification notificationFragment = Notification.newInstance(type, description);
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, notificationFragment).commit();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.emergency_contact) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Contact()).commit();
        }  else if (item.getItemId() == R.id.emergency_drills) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Drills()).commit();
        } else if (item.getItemId() == R.id.emergency_request_assistance) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Request()).commit();
        } else if (item.getItemId() == R.id.emergency_report) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Report()).commit();
        } else if (item.getItemId() == R.id.emergency_resource) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Resource()).commit();
        } else if (item.getItemId() == R.id.emergency_notification) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Notification()).commit();
        } else if (item.getItemId() == R.id.emergency_safety) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Safety()).commit();
        } else if (item.getItemId() == R.id.emergency_setting) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Setting()).commit();
        } else if (item.getItemId() == R.id.emergency_map) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Map()).commit();
        }
        else if (item.getItemId() == R.id.nav_about) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AboutUs()).commit();
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
