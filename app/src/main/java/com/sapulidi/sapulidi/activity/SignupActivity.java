package com.sapulidi.sapulidi.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.sapulidi.sapulidi.BaseApp;
import com.sapulidi.sapulidi.R;

import java.util.HashMap;
import java.util.Map;

public class SignupActivity extends AppCompatActivity implements
        View.OnClickListener {

    private static final String TAG = "SignupActivity";
    private static final String URL = "http://santrikoding.com/apisapulidi/api/add_user/cross.php";

    private Button btnBuatAkun;
    private EditText input_email, input_name, input_nohp, input_password;
    private TextView go_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_coba);

        input_name = (EditText) findViewById(R.id.input_name);
        input_email = (EditText) findViewById(R.id.input_email);
        input_nohp = (EditText) findViewById(R.id.input_nohp);
        input_password = (EditText) findViewById(R.id.input_password);
        btnBuatAkun = (Button) findViewById(R.id.btn_signup);
        go_login = (TextView) findViewById(R.id.go_login);

        btnBuatAkun.setOnClickListener(this);
        go_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_signup:
                goSignup();
                break;
            case R.id.go_login:
                startActivity(new Intent(this, LoginActivity.class));
                break;
        }
    }

    private void goSignup() {
        final String name, email, nohp, password;
        name = input_name.getText().toString();
        email = input_email.getText().toString();
        nohp = input_nohp.getText().toString();
        password = input_password.getText().toString();

        if (name.trim().isEmpty()){
            Toast.makeText(SignupActivity.this, "Nama Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
        }else if(email.trim().isEmpty()){
            Toast.makeText(SignupActivity.this, "Email Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
        }else if(nohp.trim().isEmpty()){
            Toast.makeText(SignupActivity.this, "Nomor HP Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
        }else if(password.trim().isEmpty()){
            Toast.makeText(SignupActivity.this, "Passord Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
        }else{
            StringRequest request = new StringRequest(1, URL,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Log.d(TAG, "onResponse() returned: " + response.toString());
                            Toast.makeText(SignupActivity.this, "Pendaftaran Berhasil", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.d(TAG, "onErrorResponse() returned: " + error.toString());
                        }
                    }){

                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<>();
                    params.put("username", name);
                    params.put("fullname", name);
                    params.put("id_usergroup", "3");
                    params.put("email", email);
                    params.put("password", password);
                    params.put("phone", nohp);
                    return params;
                }
            };
            BaseApp.getsInstance().getRequestQueue().add(request);
        }
    }
}