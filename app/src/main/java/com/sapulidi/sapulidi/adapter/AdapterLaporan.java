package com.sapulidi.sapulidi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.sapulidi.sapulidi.R;
import com.sapulidi.sapulidi.model.ModelLaporan;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by ar-android on 06/12/2015.
 */
public class AdapterLaporan extends BaseAdapter {

    private LayoutInflater inflater;
    private Context context;
    private ArrayList<ModelLaporan> data;

    public AdapterLaporan(Context context, ArrayList<ModelLaporan> data) {
        inflater = LayoutInflater.from(context);
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.item_laporan, null);

        CircleImageView img;
        TextView nama_pelapor, time_pelaporan, status_laporan, judul_laporan, isi_laporan;

        img = (CircleImageView) convertView.findViewById(R.id.image_pelapor);
        nama_pelapor = (TextView) convertView.findViewById(R.id.nama_pelapor);
        time_pelaporan = (TextView) convertView.findViewById(R.id.time_pelaporan);
        status_laporan = (TextView) convertView.findViewById(R.id.status_laporan);
        judul_laporan = (TextView) convertView.findViewById(R.id.judul_laporan);

        img.setImageResource(data.get(position).getImg_user());
        nama_pelapor.setText(data.get(position).getUser_post());
        time_pelaporan.setText(data.get(position).getDate_time());
        status_laporan.setText(data.get(position).getType());
        judul_laporan.setText(data.get(position).getContent());

        return convertView;
    }
}