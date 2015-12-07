package com.sapulidi.sapulidi.fragment;

import android.content.Intent;
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

import com.melnykov.fab.FloatingActionButton;
import com.sapulidi.sapulidi.R;
import com.sapulidi.sapulidi.activity.ActivityAddlaporan;
import com.sapulidi.sapulidi.adapter.AdapterTabfragmentHome;

/**
 * Created by ar-android on 04/12/2015.
 */
public class FragmentHome extends Fragment {

    private TabLayout tabLayout;
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
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        actionBar.setTitle("Home");

        tabLayout = (TabLayout) getActivity().findViewById(R.id.tabFragmentHome);
        viewPager = (ViewPager) getActivity().findViewById(R.id.containerHome);
        viewPager.setAdapter(new AdapterTabfragmentHome(getChildFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);

        FloatingActionButton fab = (FloatingActionButton) getActivity().findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), ActivityAddlaporan.class));
            }
        });
    }
}