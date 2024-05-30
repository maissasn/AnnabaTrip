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

public class HotelActivity extends AppCompatActivity {

    private Button backButton;
    private HotelAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        backButton = findViewById(R.id.backButton);
        SearchView searchView = findViewById(R.id.searchView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Hotel> hotelList = new ArrayList<>();
        hotelList.add(new Hotel("Hotel Sheraton", "Le Sheraton Annaba Hotel est un hôtel de luxe situé à Annaba, en Algérie. Il propose des chambres élégantes, des restaurants raffinés, une piscine extérieure, un centre de fitness, et des espaces de réunion. Idéal pour les séjours d'affaires et de loisirs, il est bien situé près des attractions principales de la ville.", "https://maps.google.com/?q=sheratonhotel", R.drawable.sheraton));
        hotelList.add(new Hotel("Hotel Sabri", "L'Hôtel Sabri à Annaba, en Algérie, offre des chambres modernes avec vue sur la mer, un restaurant, une piscine extérieure et des salles de conférence. Idéal pour les touristes et les voyageurs d'affaires, il est proche des principales attractions de la ville.", "https://maps.google.com/?q=sabrihotelAnnaba", R.drawable.sabrihotel));
        hotelList.add(new Hotel("Hotel Seybouse", "Situé au cœur d'Annaba, l'Hôtel Seybouse offre des chambres confortables avec vue sur la mer et la ville. Idéal pour les séjours d'affaires et de loisirs.", "https://maps.google.com/?q=seybousehotelAnnaba", R.drawable.seybouse));
        hotelList.add(new Hotel("Hotel Royal", "L'Hôtel Royal, niché en plein centre-ville, propose des hébergements luxueux et un service de qualité. Parfait pour les voyageurs cherchant le confort et l'élégance.", "https://maps.google.com/?q=royalelisahotelannaba", R.drawable.royal));
        hotelList.add(new Hotel("Hotel Zlmountazah", "Perché sur les hauteurs d'Annaba, l'Hôtel El Mountazah offre une vue panoramique sur la mer Méditerranée. Un choix parfait pour une escapade relaxante.", "https://maps.google.com/?q=hotelelmountazahannaba", R.drawable.elmountazah));

        adapter = new HotelAdapter(this, hotelList);
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
