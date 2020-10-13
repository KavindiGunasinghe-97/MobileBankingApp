package com.uee.cdbinet;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.google.android.material.navigation.NavigationView;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;
import com.uee.cdbinet.bottomnav.CalculatorFragment;
import com.uee.cdbinet.bottomnav.ContactFragment;
import com.uee.cdbinet.bottomnav.ConvertFragment;
import com.uee.cdbinet.bottomnav.LocateFragment;
import com.uee.cdbinet.bottomnav.NewAccountFragment;
import com.uee.cdbinet.sidenav.HomeFragment;
import com.uee.cdbinet.util.Config;
import com.uee.cdbinet.util.SharedPreferenceHelper;

import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import static com.uee.cdbinet.R.id.layoutToolBar;

public class MainActivity extends AppCompatActivity {



    public static Toolbar toolbar;
    public static TextView header;
    ChipNavigationBar chipNavigationBar;
    private Fragment fragment = null;
    public int selectedBottomNav;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(layoutToolBar);
        header = (TextView) findViewById(R.id.tv_actionbarTitle);

        chipNavigationBar = findViewById(R.id.bottomNav);



        bottomMenu();

        ImageView actionbarIcon = findViewById(R.id.iv_actionbarIcon);
        final DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);


        actionbarIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                chipNavigationBar.setItemSelected(selectedBottomNav, false);

                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setItemIconTintList(null);

        NavController navController = Navigation.findNavController(this,R.id.navHostFragment);
        NavigationUI.setupWithNavController(navigationView, navController);



//        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(MenuItem menuItem) {
//                int id = menuItem.getItemId();
//                switch (id) {
//                    case R.id.nav_home:
//                        //Do some thing here
//                        // add navigation drawer item onclick method here
//                        break;
//                    case R.id.nav_logout:
//                        SharedPreferenceHelper.setSharedPreferenceString(MainActivity.this, Config.USER_NAME, null);
//                        SharedPreferences mSharedPreferences = getSharedPreferences(Config.LOGIN_TAGS, MODE_PRIVATE);
//                        SharedPreferences.Editor edit = mSharedPreferences.edit();
//                        edit.remove(Config.LOGIN_USER);
//                        edit.apply();
//
//
//                        Intent i = new Intent(MainActivity.this, LoginActivity.class);
//                        startActivity(i);
//                        finish();
//                        break;
//
//
//
//                }
//                drawerLayout.closeDrawer((int) Gravity.LEFT);
//                return false;
//            }
//        });



        Config.setHeader("Home");


    }


    private void bottomMenu() {

        chipNavigationBar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {

                selectedBottomNav = i;

                switch (i) {
                    case R.id.nav_locate:
                        fragment = new LocateFragment();
                        break;
                    case R.id.nav_calc:
                        fragment = new CalculatorFragment();
                        break;
                    case R.id.nav_convert:
                        fragment = new ConvertFragment();
                        break;
                    case R.id.nav_contact:
                        fragment = new ContactFragment();
                        break;
                    case R.id.nav_apply:
                        fragment = new NewAccountFragment();
                        break;

                }

                if (fragment != null) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.navHostFragment, fragment).commit();
                }


            }
        });



    }


}