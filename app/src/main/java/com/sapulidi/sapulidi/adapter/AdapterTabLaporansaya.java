package com.sapulidi.sapulidi.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.sapulidi.sapulidi.fragment.FragmentAll;
import com.sapulidi.sapulidi.fragment.FragmentProses;
import com.sapulidi.sapulidi.fragment.FragmentReview;
import com.sapulidi.sapulidi.fragment.FragmentSelesai;

/**
 * Created by ar-android on 04/12/2015.
 */
public class AdapterTabLaporansaya extends FragmentPagerAdapter {

    String[] title = new String[]{"All", "Review", "Proses", "Selesai"};

    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }

    public AdapterTabLaporansaya(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = new Fragment();
        switch (position){
            case 0:
                fragment = new FragmentAll();
                break;
            case 1:
                fragment = new FragmentReview();
                break;
            case 2:
                fragment = new FragmentProses();
                break;
            case 3:
                fragment = new FragmentSelesai();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 4;
    }
}
