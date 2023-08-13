package com.example.FlavourDash;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class IntroActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnLogin, btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        btnLogin = (Button) findViewById(R.id.button);
        btnLogin.setOnClickListener(this);
        btnRegister = (Button) findViewById(R.id.button2);
        btnRegister.setOnClickListener(this);
    }

    public void onClick(View v) {
        if(v.equals(btnLogin)){
            Intent it = new Intent(this, LoginActivity.class);
            startActivity(it);
        }
        if(v.equals(btnRegister)){
            Intent it = new Intent(this, SignupActivity.class);
            startActivity(it);
        }

    }
}