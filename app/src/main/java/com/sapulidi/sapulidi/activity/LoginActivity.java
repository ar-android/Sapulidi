package com.sapulidi.sapulidi.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.sapulidi.sapulidi.BaseApp;
import com.sapulidi.sapulidi.R;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView link_signup;
    private Button btn_login;
    private EditText input_email, input_password;
    private ProgressDialog progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn_login = (Button) findViewById(R.id.btn_login);
        link_signup = (TextView) findViewById(R.id.link_signup);
        input_email = (EditText) findViewById(R.id.email);
        input_password = (EditText) findViewById(R.id.password);

        btn_login.setOnClickListener(this);
        link_signup.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                goLogin();
                break;
            case R.id.link_signup:
                startActivity(new Intent(this, SignupActivity.class));
                break;
        }
    }

    private void goLogin() {
        String URL = "http://santrikoding.com/apisapulidi/api/login/";
        final String username, password;
        username = input_email.getText().toString();
        password = input_password.getText().toString();
        StringRequest request = new StringRequest(1, URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        goToHome();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("username", username);
                params.put("password", password);
                return params;
            }
        };
        BaseApp.getsInstance().getRequestQueue().add(request);
    }

    private void goToHome() {
        progress = ProgressDialog.show(this, "", "Login...");

        new Thread() {
            public void run() {
                try {
                    sleep(30000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
        finish();
        startActivity(new Intent(getApplicationContext(), HomeActivity.class));
    }
}