package com.sapulidi.sapulidi.activity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.sapulidi.sapulidi.R;

public class ActivityAddlaporan extends AppCompatActivity implements TextWatcher, View.OnClickListener {

    private static final String TAG = "ActivityAddlaporan";

    private EditText input_lokasi, input_keterangan;
    private TextView textchar;
    private ImageView input_photo, input_file;
    private int lengthText = 800;
    private AutoCompleteTextView input_category;
    private Button kirim_laporan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_addlaporan);

        setToolbar();

        input_keterangan = (EditText) findViewById(R.id.input_keterangan);
        textchar = (TextView) findViewById(R.id.tvchar);
        input_category = (AutoCompleteTextView) findViewById(R.id.input_category);
        input_photo = (ImageView) findViewById(R.id.input_photo);
        kirim_laporan = (Button) findViewById(R.id.kirim_laporan);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, getResources().getStringArray(R.array.Kategory));
        input_category.setAdapter(adapter);

        setMaxLength(input_keterangan, lengthText);
        input_keterangan.addTextChangedListener(this);
        input_photo.setOnClickListener(this);
        kirim_laporan.setOnClickListener(this);

    }

    private void setToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            toolbar.setTitle("Tambah Laporan");
            toolbar.setTitleTextColor(Color.WHITE);
            toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                }
            });
        }
    }

    void setMaxLength(EditText view, int length) {
        InputFilter curFilters[];
        InputFilter.LengthFilter lengthFilter;
        int idx;

        lengthFilter = new InputFilter.LengthFilter(length);

        curFilters = view.getFilters();
        if (curFilters != null) {
            for (idx = 0; idx < curFilters.length; idx++) {
                if (curFilters[idx] instanceof InputFilter.LengthFilter) {
                    curFilters[idx] = lengthFilter;
                    return;
                }
            }
            InputFilter newFilters[] = new InputFilter[curFilters.length + 1];
            System.arraycopy(curFilters, 0, newFilters, 0, curFilters.length);
            newFilters[curFilters.length] = lengthFilter;
            view.setFilters(newFilters);
        } else {
            view.setFilters(new InputFilter[]{lengthFilter});
        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        textchar.setText(String.valueOf(lengthText - input_keterangan.length()) + " /" + "360");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch(requestCode) {
            case 100:
                if(resultCode == RESULT_OK){
                    Uri selectedImage = data.getData();
                    Log.d(TAG, "onActivityResult() returned: " + selectedImage.toString());
                    Toast.makeText(ActivityAddlaporan.this, selectedImage.toString(), Toast.LENGTH_SHORT).show();
                }
                break;
            case 1:
                if(resultCode == RESULT_OK){
                    Uri selectedImage = data.getData();
                    Log.d(TAG, "onActivityResult() returned: " + selectedImage.toString());
                    Toast.makeText(ActivityAddlaporan.this, selectedImage.toString(), Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.input_photo:
                pickPhoto();
                break;
            case R.id.kirim_laporan:
                goToHome();
                break;
        }
    }

    private void pickPhoto() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("Pilih Photo !!!");

        alertDialogBuilder.setPositiveButton("Camera", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                selectFromCamera();
            }
        });

        alertDialogBuilder.setNegativeButton("Gallery", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                selectFromGallery();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    void selectFromGallery(){
        Intent pickPhoto = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(pickPhoto, 1);//one can be replaced with any action code
    }

    void selectFromCamera() {
        Intent takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(takePicture, 100);//zero can be replaced with any action code
    }


    private void goToHome() {
        ProgressDialog progress = ProgressDialog.show(this, "", "Proses...");

        new Thread() {
            public void run() {
                try {
                    sleep(30000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
        Toast.makeText(ActivityAddlaporan.this, "Laporan terkirim", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(getApplicationContext(), HomeActivity.class));
        finish();
    }
}