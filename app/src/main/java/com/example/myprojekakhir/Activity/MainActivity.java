package com.example.myprojekakhir.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.myprojekakhir.Adapter.CategoryAdapter;
import com.example.myprojekakhir.Adapter.PopularAdapter;
import com.example.myprojekakhir.Domain.CategoryDomain;
import com.example.myprojekakhir.Domain.FoodDomain;
import com.example.myprojekakhir.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter, adapter2;
    private RecyclerView recyclerViewCategoryList,  recyclerViewPopularList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewCategory();
        recyclerViewPopular();
        bottomNavigation();
    }

    private void bottomNavigation() {
        FloatingActionButton floatingActionButton = findViewById(R.id.card_btn);
        LinearLayout homeBtn = findViewById(R.id.homeBtn);
        LinearLayout promoBtn = findViewById(R.id.promoBtn);
        LinearLayout riwayatBtn = findViewById(R.id.riwayatBtn);
        LinearLayout favoritBtn = findViewById(R.id.favoritBtn);


        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CartActivity.class));
            }
        });

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MainActivity.class));
            }
        });

        promoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PromoActivity.class));
            }
        });

        riwayatBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RiwayatActivity.class));
            }
        });

        favoritBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, FavoriteActivity.class));
            }
        });
    }

    private void recyclerViewPopular() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewPopularList = findViewById(R.id.recyclerView2);
        recyclerViewPopularList.setLayoutManager(linearLayoutManager);

        ArrayList<FoodDomain> foodlist = new ArrayList<>();
        foodlist.add(new FoodDomain("Pepperoni pizza", "pizza1", "slices pepperoni ,mozzarella cheese, fresh oregano,  ground black pepper, pizza sauce", 60000));
        foodlist.add(new FoodDomain("Vegetable pizza", "pizza2", " olive oil, Vegetable oil, pitted Kalamata, cherry tomatoes, fresh oregano, basil", 50000));;
        foodlist.add(new FoodDomain("Original pizza", "pizza_original", "corn, tomato, sauce, onion, mushroom, sausage", 40000));;
        foodlist.add(new FoodDomain("Chicken Rice", "nasi_ayam", "crispy chicken, rice, iced tea", 32000));
        foodlist.add(new FoodDomain("Curry Chicken", "ayam_gulai", "crispy chicken, rice, coca cola, curry sauce", 38000));
        foodlist.add(new FoodDomain("Mozzarella Hotdog", "hotdog_mozarela", "mozzarella cheese, tomato sauce, mayonnaise", 15000));
        foodlist.add(new FoodDomain("Potato Hotdog", "hotdog_kentang", "cheese, tomato sauce, sausage, potatoes", 15000));
        foodlist.add(new FoodDomain("Regular Burger Pack", "regular_burger_pack", "tomat, keju, kentang, daging slice, saos, milo", 42000));
        foodlist.add(new FoodDomain("Beef Burger Pack", "beef_burger_pack", "tomato, cheese, potato, meat slice, sauce, salad, sesame, coca-cola", 62000));
        foodlist.add(new FoodDomain("Cheese Burger", "burger", "beef, Gouda Cheese, Special sauce, Lettuce, tomato ", 35000));
        foodlist.add(new FoodDomain("Tiramisu Donuts", "tiramisu_donuts", "tiramisu, peanuts, milk ", 19500));
        foodlist.add(new FoodDomain("Potato Donuts", "potato_donuts", "potato, milk, sugar", 15000));
        foodlist.add(new FoodDomain("New Donuts", "new_donuts", "milk, sesame, sauce, mayonnaise, meat", 25000));
        foodlist.add(new FoodDomain("Chocolate", "chocolate", "chocolate, milk, sugar, oreo ", 18000));
        foodlist.add(new FoodDomain("Fanta Orange", "fanta_orange", "ice, orange, milk ", 12000));
        foodlist.add(new FoodDomain("Fanta Straubery", "fanta_straubery", "ice, straubery, milk  ", 12000));
        foodlist.add(new FoodDomain("Ice Coffee", "coffee", "coffee, milk, sugar ", 17000));

        adapter2 = new PopularAdapter(foodlist);
        recyclerViewPopularList.setAdapter(adapter2);
    }

    private void recyclerViewCategory() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewCategoryList = findViewById(R.id.recyclerView);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryDomain> categoryList = new ArrayList<>();
        categoryList.add(new CategoryDomain("Pizza", "cat_1"));
        categoryList.add(new CategoryDomain("Burger", "cat_2"));
        categoryList.add(new CategoryDomain("Hotdog", "cat_3"));
        categoryList.add(new CategoryDomain("Drink", "cat_4"));
        categoryList.add(new CategoryDomain("Dount", "cat_5"));

        adapter = new CategoryAdapter(categoryList);
        recyclerViewCategoryList.setAdapter(adapter);

    }
}