package com.example.groupe_1_2025;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class EnterNameActivity extends AppCompatActivity {

    private EditText editTextPseudo;
    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_name);

        editTextPseudo = findViewById(R.id.editTextPseudo);
        score = getIntent().getIntExtra("score", 0);
    }

    public void onValiderPseudo(View view) {
        String pseudo = editTextPseudo.getText().toString();

        if (!pseudo.isEmpty()) {
            Intent intent = new Intent(EnterNameActivity.this, TableauDesScoresActivity.class);
            intent.putExtra("pseudo", pseudo);
            intent.putExtra("score", score);
            startActivity(intent);
        } else {
            editTextPseudo.setError("Veuillez entrer un pseudo");
        }
    }
}
