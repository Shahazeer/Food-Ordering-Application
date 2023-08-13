package com.example.FlavourDash.Activity;

 import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

 import android.content.Intent;
 import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
 import android.widget.LinearLayout;
 import android.widget.ScrollView;
import android.widget.TextView;

 import com.example.FlavourDash.AboutActivity;
 import com.example.FlavourDash.Adapter.CartListAdapter;
import com.example.FlavourDash.Helper.ChangeNumberItemsListener;
import com.example.FlavourDash.Helper.ManagmentCart;
 import com.example.FlavourDash.LoginActivity;
 import com.example.FlavourDash.OrderBillActivity;
 import com.example.FlavourDash.R;
 import com.example.FlavourDash.SupportActivity;

public class CartActivity extends AppCompatActivity implements View.OnClickListener{
    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerViewList;
    private ManagmentCart managmentCart;
    private TextView totalFeeTxt, taxTxt, deliveryTxt, totalTxt, emptyTxt;
    private double tax;
    private ScrollView scrollView;
    private ImageView backBtn;
    Button orderNow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        orderNow = (Button)findViewById(R.id.button) ;
        orderNow.setOnClickListener(this);
        managmentCart = new ManagmentCart(this);

        initView();
        initList();
        calculateCart();
        setVariable();

    }
    @Override
    public void onClick(View view) {
        String amt = totalTxt.getText().toString();
        if(view.equals(orderNow)){
            Intent intent = new Intent(this, OrderBillActivity.class);
            intent.putExtra("amount", amt);
            startActivity(intent);
        }
    }
    private void setVariable() {
        backBtn.setOnClickListener(v -> finish());
    }

    private void initList() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerViewList.setLayoutManager(linearLayoutManager);
        adapter = new CartListAdapter(managmentCart.getListCart(), this, new ChangeNumberItemsListener() {
            @Override
            public void changed() {
                calculateCart();
            }
        });

        recyclerViewList.setAdapter(adapter);

        if(managmentCart.getListCart().isEmpty()){
            emptyTxt.setVisibility(View.VISIBLE);
            scrollView.setVisibility(View.GONE);
        }else{
            emptyTxt.setVisibility(View.GONE);
            scrollView.setVisibility(View.VISIBLE);
        }
    }

    private void calculateCart() {
        double percentTax = 0.02;  //you can change this item for tax price
        double delivery = 10;
        tax = Math.round((managmentCart.getTotalFee() * percentTax * 100.0)) / 100.0;

        double total = Math.round((managmentCart.getTotalFee() + tax + delivery) * 100.0) / 100;
        double itemTotal = Math.round(managmentCart.getTotalFee() * 100.0) / 100.0;

        totalFeeTxt.setText("₹" + itemTotal);
        taxTxt.setText("₹" + tax);
        deliveryTxt.setText("₹" + delivery);
        totalTxt.setText("₹" + total);
    }

    private void initView() {
        totalFeeTxt = findViewById(R.id.totalFeeTxt);
        taxTxt = findViewById(R.id.taxTxt);
        deliveryTxt = findViewById(R.id.deliveryTxt);
        totalTxt = findViewById(R.id.totalTxt);
        recyclerViewList = findViewById(R.id.view3);
        scrollView = findViewById(R.id.scrollView);
        backBtn = findViewById(R.id.backBtn);
        emptyTxt = findViewById(R.id.emptyTxt);
    }
}