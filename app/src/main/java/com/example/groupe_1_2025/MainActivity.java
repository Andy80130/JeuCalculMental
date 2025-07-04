package com.example.groupe_1_2025;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Button boutonCalculatrice;
    private Button boutonCalculMental;
    private Button boutonAPropos;
    private Button boutonTableauDesScores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        boutonCalculatrice = findViewById(R.id.bouton_calculatrice);
        boutonCalculatrice.setOnClickListener(view -> {
            Intent intent = new Intent(this, CalculatriceActivity.class);
            startActivity(intent);
        });

        boutonCalculMental = findViewById(R.id.bouton_calculMental);
        boutonCalculMental.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, CalculMentalActivity.class);
            startActivity(intent);
        });

        boutonAPropos = findViewById(R.id.bouton_a_propos);
        boutonAPropos.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, AProposActivity.class);
            startActivity(intent);
        });

        boutonTableauDesScores = findViewById(R.id.bouton_tableauDesScores);
        boutonTableauDesScores.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, TableauDesScoresActivity.class);
            startActivity(intent);
        });
    }
}