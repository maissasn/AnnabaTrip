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

public class lieuActivity extends AppCompatActivity {

    private Button backButton;
    private LieuAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lieu);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        backButton = findViewById(R.id.backButton);
        SearchView searchView = findViewById(R.id.searchView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Lieu> lieuList = new ArrayList<>();
        lieuList.add(new Lieu("Basilique Saint Augustin", "", "https://maps.google.com/?q=basilique+saint+augustin+annaba", R.drawable.saintagustin));
        lieuList.add(new Lieu("Cour de Révolution ", "", "https://maps.google.com/?q=courderévolutionannaba", R.drawable.courrev));
        lieuList.add(new Lieu("Farouk land", "", "https://maps.google.com/?q=farouklanannaba", R.drawable.faroukland));
        lieuList.add(new Lieu("Parc de ain achir", " ", "https://maps.google.com/?q=ainachirannaba", R.drawable.jardinainachir));
        lieuList.add(new Lieu("Seraidi", "", "https://maps.google.com/?q=seraidiannaba", R.drawable.seraid));
        lieuList.add(new Lieu(" Fnar Annaba", "", "https://maps.google.com/?q=fnarannaba", R.drawable.fnar));
        adapter = new LieuAdapter(this, lieuList);
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
