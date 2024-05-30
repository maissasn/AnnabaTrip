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

public class PlageActivity extends AppCompatActivity {

    private Button backButton;
    private PlageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plage);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        backButton = findViewById(R.id.backButton);
        SearchView searchView = findViewById(R.id.searchView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Plage> plageList = new ArrayList<>();
        plageList.add(new Plage("Plage Djenan Elbay", "", "https://maps.google.com/?q=Djenanelbay", R.drawable.elbay));
        plageList.add(new Plage("Plage Ain achir", "", "https://maps.google.com/?q=Aïn+Achir", R.drawable.ainachir));
        plageList.add(new Plage("Plage Chtaibi", "", "https://maps.google.com/?q=Chtaibi", R.drawable.chtaibi));
        plageList.add(new Plage("Plage Belvoudar", "", "https://maps.google.com/?q=boulveder", R.drawable.boulvedar));
        plageList.add(new Plage("Plage Elouh ", "", "https://maps.google.com/?q=plagelouh", R.drawable.louh));

        adapter = new PlageAdapter(this, plageList);
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
