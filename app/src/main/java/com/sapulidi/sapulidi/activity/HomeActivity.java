package com.sapulidi.sapulidi.activity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.sapulidi.sapulidi.R;
import com.sapulidi.sapulidi.fragment.FragmentHome;
import com.sapulidi.sapulidi.fragment.FragmentKritikSaran;
import com.sapulidi.sapulidi.fragment.FragmentLaporansaya;
import com.sapulidi.sapulidi.fragment.FragmentProfile;

/**
 * Created by ar-android on 03/12/2015.
 */
public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private int activeMenu;
    private NavigationView navigationView;
    private ActionBarDrawerToggle toggle;

    private Handler handlerSaveId = new Handler();
    private long DRAWER_CLOSE_DELAY = 350;
    private String ID_MENU_ACTIVE = "IdMenuActive";

    private FragmentManager mFragmentManager;
    private FragmentTransaction mFragmentTransaction;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (null == savedInstanceState) {
            activeMenu = R.id.menuHome;
        } else {
            activeMenu = savedInstanceState.getInt(ID_MENU_ACTIVE);
        }

        navigationView = (NavigationView) findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().findItem(activeMenu).setChecked(true);

        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();

        switchFragment(activeMenu);

    }

    /**
     * for switch active fragment by sevedInstanState
     *
     * @param activeMenu
     */
    private void switchFragment(int activeMenu) {
        switch (activeMenu) {
            case R.id.menuHome:
                setFragment(new FragmentHome());
                break;
            case R.id.profile:
                setFragment(new FragmentProfile());
                break;
            case R.id.laporan_saya:
                setFragment(new FragmentLaporansaya());
                break;
            case R.id.kritik_saran:
                setFragment(new FragmentKritikSaran());
                break;
            case R.id.about:
                setFragment(new FragmentAbout());
                break;
            case R.id.logout:
                logout();
            default:
                break;
        }
    }

    /**
     * Logout
     */
    private void logout() {
        finish();
    }

    /**
     * replace fragment by activemenu id
     *
     * @param fragment
     */
    private void setFragment(Fragment fragment) {
        mFragmentManager = getSupportFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.replace(R.id.container, fragment).commit();

        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment).commit();
        drawerLayout.closeDrawer(GravityCompat.START);
    }

    @Override
    public boolean onNavigationItemSelected(final MenuItem menuItem) {
        menuItem.setChecked(true);
        activeMenu = menuItem.getItemId();
        drawerLayout.closeDrawer(GravityCompat.START);
        handlerSaveId.postDelayed(new Runnable() {
            @Override
            public void run() {
                switchFragment(menuItem.getItemId());
            }
        }, DRAWER_CLOSE_DELAY);

        return true;
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        toggle.onConfigurationChanged(newConfig);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    /**
     * to case active id menu
     *
     * @param outState
     */
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(ID_MENU_ACTIVE, activeMenu);
    }
}