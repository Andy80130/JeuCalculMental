package com.example.groupe_1_2025;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class TableauDesScoresActivity extends AppCompatActivity {

    private final List<String> listeScores = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tableau_des_scores);

        ListView listView = findViewById(R.id.listViewScores);

        String pseudo = getIntent().getStringExtra("pseudo");
        int score = getIntent().getIntExtra("score", 0);

        String ligneScore = pseudo + " : " + score + " points";
        listeScores.add(ligneScore);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listeScores);
        listView.setAdapter(adapter);
    }
}
