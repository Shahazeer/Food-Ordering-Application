package com.example.FlavourDash;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class SupportActivity extends AppCompatActivity {
    private ImageView backBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support);
        backBtn = findViewById(R.id.backBtn);
        setVariable();
    }
    private void setVariable() {
        backBtn.setOnClickListener(v -> finish());
    }
}