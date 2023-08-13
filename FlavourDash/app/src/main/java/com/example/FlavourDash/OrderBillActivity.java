package com.example.FlavourDash;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class OrderBillActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_bill);
        TextView amount = (TextView) findViewById(R.id.amount);
        String amt= getIntent().getStringExtra("amount");
        amount.setText("Total Amount To Be Paid: "+amt);

    }
}