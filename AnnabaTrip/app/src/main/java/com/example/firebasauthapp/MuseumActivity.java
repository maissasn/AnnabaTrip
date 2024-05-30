package com.example.firebasauthapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MuseumActivity extends AppCompatActivity {

    private Button backButton;
    private MuseumAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_museum);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        backButton = findViewById(R.id.backButton);
        SearchView searchView = findViewById(R.id.searchView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Museum> museumList = new ArrayList<>();
        museumList.add(new Museum("Museum of Modern Art", "The Museum of Modern Art in Annaba showcases contemporary works by Algerian and international artists.", "https://maps.google.com/?q=museum+of+modern+art+annaba", R.drawable.modernart));
        museumList.add(new Museum("Museum de Ruines ", "The Museum of Ruines in Annaba offers exhibits on the rich historical heritage of the region.", "https://maps.google.com/?q=museum+of+history+annaba", R.drawable.mesum));
        museumList.add(new Museum("Museum of Popular Arts", "The Museum of Popular Arts in Annaba features traditional Algerian crafts and folk art.", "https://maps.google.com/?q=museum+of+popular+arts+annaba", R.drawable.museart));

        adapter = new MuseumAdapter(this, museumList);
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

