package com.example.FlavourDash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignupActivity extends AppCompatActivity implements View.OnClickListener {
    EditText email, password;
    Button register;
    DatabaseHelper dbHelper;
    TextView login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        dbHelper = new DatabaseHelper(this);

        email = findViewById(R.id.regemail);
        password = findViewById(R.id.regpass);
        register = findViewById(R.id.button6);
        register.setOnClickListener(this);
        login = findViewById(R.id.textView5);
        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String user = email.getText().toString();
        String pass = password.getText().toString();
        if (view.equals(register)) {
            if (isValidEmail(user) && isValidPassword(pass)) {
                boolean isInserted = dbHelper.insertUser(user, pass);
                if (isInserted) {
                    Toast.makeText(this, "Registration Successful", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(this, LoginActivity.class);
                    intent.putExtra("user", user);
                    intent.putExtra("pass", pass);
                    startActivity(intent);
                }
            }
            else {
                Toast.makeText(this, "Invalid email format or password requirements not met", Toast.LENGTH_LONG).show();
            }
        }
        if(view.equals(login)){
            Intent it = new Intent(this,LoginActivity.class);
            startActivity(it);
        }
    }

    private boolean isValidEmail(String email) {
        // Regular expression for email validation
        String emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    private boolean isValidPassword(String password) {
        // Password requirements: at least one uppercase letter, one lowercase letter, one number, minimum length 6
        String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{6,}$";
        Pattern pattern = Pattern.compile(passwordRegex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}
