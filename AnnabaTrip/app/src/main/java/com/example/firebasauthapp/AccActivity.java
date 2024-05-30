package com.example.firebasauthapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.firebasauthapp.databinding.ActivityAccBinding;
import com.example.firebasauthapp.databinding.ActivityMainBinding;
import com.google.firebase.auth.FirebaseAuth;

public class AccActivity extends AppCompatActivity {
    private ActivityAccBinding binding;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAccBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mAuth = FirebaseAuth.getInstance();

        binding.move1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AccActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        binding.move2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AccActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
    }
}
