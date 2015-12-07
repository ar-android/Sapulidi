package com.sapulidi.sapulidi.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.sapulidi.sapulidi.R;

/**
 * Created by ar-android on 04/12/2015.
 */
public class FragmentKritikSaran extends Fragment {

    private ActionBar actionBar;
    private RadioButton kritik, saran;
    private EditText input_kritiksaran;
    private Button send;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_kriksaran, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        actionBar.setTitle("Kritik dan Saran");

        kritik = (RadioButton) getActivity().findViewById(R.id.kritik);
        saran = (RadioButton) getActivity().findViewById(R.id.saran);
        input_kritiksaran = (EditText) getActivity().findViewById(R.id.input_kritiksaran);
        send = (Button) getActivity().findViewById(R.id.btn_send_kritiksaran);


    }
}