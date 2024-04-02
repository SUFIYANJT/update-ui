package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.card.MaterialCardView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MaterialCardView vehicleCard = findViewById(R.id.vehicleCard);
        MaterialCardView machineCard = findViewById(R.id.machineCard);

        vehicleCard.setOnClickListener(v -> {
            Intent intent = new Intent(this, vechiclesupdate.class);
            intent.putExtra("type", "vehicle");
            startActivity(intent);
        });

        machineCard.setOnClickListener(v -> {
            Intent intent = new Intent(this, mechincesupdate.class);
            intent.putExtra("type", "machine");
            startActivity(intent);
        });
    }
}
