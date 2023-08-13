package com.example.FlavourDash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity implements View.OnClickListener {
    EditText email, password;
    Button register;
    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        dbHelper = new DatabaseHelper(this);

        email = findViewById(R.id.regemail);
        password = findViewById(R.id.regpass);
        register = findViewById(R.id.button6);
        register.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String user = email.getText().toString();
        String pass = password.getText().toString();
        if (view.equals(register)) {
            boolean isInserted = dbHelper.insertUser(user, pass);
            if (isInserted) {
                Toast.makeText(this, "Registration Successful", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(this, LoginActivity.class);
                intent.putExtra("user", user);
                intent.putExtra("pass", pass);
                startActivity(intent);
            }
        }
    }
}
