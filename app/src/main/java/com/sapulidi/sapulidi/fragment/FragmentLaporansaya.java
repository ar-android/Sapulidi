package com.sapulidi.sapulidi.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sapulidi.sapulidi.R;
import com.sapulidi.sapulidi.adapter.AdapterTabLaporansaya;

/**
 * Created by ar-android on 04/12/2015.
 */
public class FragmentLaporansaya extends Fragment {

    private TabLayout tabLaporanSaya;
    private ViewPager viewPager;
    private ActionBar actionBar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_laporansaya, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        actionBar.setTitle("Laporan Saya");
        tabLaporanSaya = (TabLayout)getActivity().findViewById(R.id.tabLaporanSaya);
        viewPager = (ViewPager)getActivity().findViewById(R.id.containerLaporanSaya);
        viewPager.setAdapter(new AdapterTabLaporansaya(getChildFragmentManager()));
        tabLaporanSaya.setupWithViewPager(viewPager);

    }
}