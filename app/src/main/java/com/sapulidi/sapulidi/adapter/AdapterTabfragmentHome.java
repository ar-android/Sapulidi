package com.sapulidi.sapulidi.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.sapulidi.sapulidi.fragment.FragmentLaporanBaru;
import com.sapulidi.sapulidi.fragment.FragmentLaporanPopuler;
import com.sapulidi.sapulidi.fragment.FragmentStatistik;

/**
 * Created by ar-android on 04/12/2015.
 */
public class AdapterTabfragmentHome extends FragmentPagerAdapter {

    String[] title = new String[]{"Terbaru", "Popular", "Statistik"};

    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }

    public AdapterTabfragmentHome(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = new Fragment();
        switch (position){
            case 0:
                fragment = new FragmentLaporanBaru();
                break;
            case 1:
                fragment = new FragmentLaporanPopuler();
                break;
            case 2:
                fragment = new FragmentStatistik();
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }
}