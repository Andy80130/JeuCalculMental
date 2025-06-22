package com.example.groupe_1_2025;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class EnterNameActivity extends AppCompatActivity {

    private EditText editTextPseudo;
    private Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_name);

        editTextPseudo = findViewById(R.id.editText_pseudo);
        buttonSubmit = findViewById(R.id.bouton_valider_nom);

        buttonSubmit.setOnClickListener(v -> submitName());
    }

    private void submitName() {
        String pseudo = editTextPseudo.getText().toString().trim();

        if (!pseudo.isEmpty()) {
            // Passer le pseudo à l'activité suivante ou à un autre écran
            Intent resultIntent = new Intent();
            resultIntent.putExtra("pseudo", pseudo);
            setResult(RESULT_OK, resultIntent);
            finish();
        } else {
            editTextPseudo.setError("Veuillez entrer un pseudo");
        }
    }
}
