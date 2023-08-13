package com.example.FlavourDash;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class AboutActivity extends AppCompatActivity {
    private ImageView backBtn;
    private TextView desc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about );
        backBtn = findViewById(R.id.backBtn);
        desc = findViewById(R.id.app_description);
        setDescription();
        setVariable();
    }
    private void setVariable() {
        backBtn.setOnClickListener(v -> finish());
    }
    private void setDescription(){
        desc.setText("FlavourDash is a cutting-edge food ordering app that brings a world of flavors to your fingertips. With a vast selection of local restaurants and a user-friendly interface, we aim to revolutionize the way you explore and experience food.\n\nDiscover Culinary Delights:\n- Explore a diverse range of cuisines and flavors, from traditional dishes to trendy culinary creations.\n- Get access to a curated list of local restaurants known for their quality and delectable offerings.\n\nEasy Ordering Process:\n- Browse menus, check out special offers, and customize your orders to suit your taste.\n- Enjoy hassle-free payments and convenient delivery or pickup options.\n\nPersonalized Recommendations:\n- Benefit from our advanced recommendation engine that suggests dishes based on your preferences and order history.\n- Discover new restaurants and dishes that match your unique culinary interests.\n\nExceptional Customer Support:\n- Our dedicated support team is available round the clock to assist you with any queries or concerns.\n- We strive to provide exceptional customer service to ensure your satisfaction.\nJoin FlavourDash today and embark on a culinary adventure like no other!");
    }
}