package com.example.FlavourDash.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.FlavourDash.AboutActivity;
import com.example.FlavourDash.Adapter.FoodListAdapter;
import com.example.FlavourDash.Domain.FoodDomain;
import com.example.FlavourDash.R;
import com.example.FlavourDash.SupportActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{
    private RecyclerView.Adapter adapterFoodList;
    private RecyclerView recyclerViewFood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecyclerview();
        bottomNavigation();
    }

    private void bottomNavigation() {
        LinearLayout homeBtn=findViewById(R.id.homeBtn);
        LinearLayout cartBtn=findViewById(R.id.cartBtn);
        LinearLayout supportBtn=findViewById(R.id.supportBtn);
        LinearLayout aboutBtn=findViewById(R.id.aboutBtn);


        homeBtn.setOnClickListener(v -> startActivity(new Intent(MainActivity.this,MainActivity.class)));

        cartBtn.setOnClickListener(v -> startActivity(new Intent(MainActivity.this,CartActivity.class)));

        supportBtn.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, SupportActivity.class)));

        aboutBtn.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, AboutActivity.class)));

    }

    private void initRecyclerview() {
        ArrayList<FoodDomain> items=new ArrayList<>();
        items.add(new FoodDomain("Cheese Burger Meal Set","Satisfy your cravings with our juicy Cheese Burger. \n" +
                "Made with 100% Angus beef patty and topped with\n" +
                " melted cheddar cheese, fresh lettuce, tomato, and\n" +
                " our secret sauce, this classic burger will leave you\n" +
                " wanting more. Served with crispy fries and a drink,\n" +
                " it's the perfect meal for any occasion.","fast_1",15,20,120,4));
        items.add(new FoodDomain("Pizza Peperoni","Get a taste of Italy with our delicious Pepperoni Pizza. Made with freshly rolled dough, zesty tomato sauce, mozzarella cheese, and topped with spicy pepperoni slices, this pizza is sure to be a crowd-pleaser. Perfectly baked in a wood-fired oven, it's the perfect choice for a quick lunch or a family dinner."
                ,"fast_2",10,25,200,5));
        items.add(new FoodDomain("Vegetable Pizza","Looking for a healthier option? Try our Vegetable Pizza, made with a variety of fresh veggies such as bell peppers, onions, mushrooms, olives, and tomatoes. Topped with mozzarella cheese and a tangy tomato sauce, this pizza is full of flavor and goodness. Perfect for vegetarians and anyone who wants to add more greens to their diet."
                ,"fast_3",13,30,100,4.5));
        items.add(new FoodDomain("BigMac burger Meal Set","Prepare your taste buds for the ultimate burger experience with the Big Mac. This iconic creation from McDonald's has captured the hearts and palates of millions worldwide. Picture this: two mouthwatering all-beef patties, topped with our secret special sauce, nestled between three fluffy sesame seed buns. It's a flavor explosion that will leave you craving more!"
                ,"fast_4",13,30,100,4.5));

        recyclerViewFood=findViewById(R.id.view1);
        recyclerViewFood.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        adapterFoodList=new FoodListAdapter(items);
        recyclerViewFood.setAdapter(adapterFoodList);
    }

}