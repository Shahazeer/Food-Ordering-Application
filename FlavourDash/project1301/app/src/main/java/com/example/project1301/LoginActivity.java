package com.example.FlavourDash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.FlavourDash.Activity.MainActivity;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    Button login;
    EditText email, password;
    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        dbHelper = new DatabaseHelper(this);

        email = findViewById(R.id.email);
        password = findViewById(R.id.editTextTextPassword);
        login = findViewById(R.id.button3);
        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String username1 = email.getText().toString();
        String password1 = password.getText().toString();
        if (v.equals(login)) {
            String storedPassword = dbHelper.getUserPassword(username1);
            if (storedPassword != null && storedPassword.equals(password1)) {
                Toast.makeText(this, "Login Successful", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(this, "Invalid username or password", Toast.LENGTH_LONG).show();
            }
        }
    }
}
