package com.example.firebasauthapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RestaurantActivity extends AppCompatActivity {

    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        backButton = findViewById(R.id.backButton);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Restaurant> restaurantList = new ArrayList<>();
        // Ajoutez vos restaurants à la liste ici
        restaurantList.add(new Restaurant("Sidi Bou Said", "", "https://maps.google.com/?q=sidibousaidannaba", R.drawable.sidibousaid));
        restaurantList.add(new Restaurant("DONATELLA Annaba", "", "https://maps.google.com/?q=DONATELLAAnnaba", R.drawable.donatella));
        restaurantList.add(new Restaurant("Restaurant tbarka", "", "https://maps.google.com/?q=tbarkaannaba", R.drawable.tbarka));
        restaurantList.add(new Restaurant("Village de neige", "", "https://maps.google.com/?q=villagedeneigeannaba", R.drawable.villedeneige));
        restaurantList.add(new Restaurant("Crepiere", "", "https://maps.google.com/?q=restaurant5", R.drawable.crepiere));

        RestaurantAdapter adapter = new RestaurantAdapter(this, restaurantList);
        recyclerView.setAdapter(adapter);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}
