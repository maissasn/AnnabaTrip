package com.example.firebasauthapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

public class ShoppingActivity extends AppCompatActivity {

    private Button backButton;
    private ShoppingAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        backButton = findViewById(R.id.backButton);
        SearchView searchView = findViewById(R.id.searchView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<ShoppingPlace> shoppingList = new ArrayList<>();
        shoppingList.add(new ShoppingPlace("Viva Mall", "", "https://maps.google.com/?q=vivamallannaba", R.drawable.vivamall));
        shoppingList.add(new ShoppingPlace("Djawaher Mall", "", "https://maps.google.com/?q=djawahermallannaba", R.drawable.djawaher));
        adapter = new ShoppingAdapter(this, shoppingList);
        recyclerView.setAdapter(adapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                adapter.filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.filter(newText);
                return false;
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}


