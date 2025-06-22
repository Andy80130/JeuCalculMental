package com.example.groupe_1_2025;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.Random;
import android.os.Handler;
import android.widget.Toast;

public class CalculMentalActivity extends AppCompatActivity {
    private Button bouton0;
    private Button bouton1;
    private Button bouton2;
    private Button bouton3;
    private Button bouton4;
    private Button bouton5;
    private Button bouton6;
    private Button bouton7;
    private Button bouton8;
    private Button bouton9;
    private Button button_valider;
    private Button button_effacer;
    private TextView textViewVie;
    private TextView textViewScore;
    private TextView textViewQuestion;
    private TextView textViewReponse;
    private TextView textViewResultat;
    private int nombre1;
    private int nombre2;
    private TypeOperation operation;
    private int bonneReponse;
    private StringBuilder reponseUtilisateur = new StringBuilder();
    private int vies = 5;
    private int score = 0;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculmental);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        bouton0 = findViewById(R.id.button_0);
        bouton1 = findViewById(R.id.button_1);
        bouton2 = findViewById(R.id.button_2);
        bouton3 = findViewById(R.id.button_3);
        bouton4 = findViewById(R.id.button_4);
        bouton5 = findViewById(R.id.button_5);
        bouton6 = findViewById(R.id.button_6);
        bouton7 = findViewById(R.id.button_7);
        bouton8 = findViewById(R.id.button_8);
        bouton9= findViewById(R.id.button_9);
        button_valider = findViewById(R.id.bouton_valider);
        button_effacer = findViewById(R.id.bouton_effacer);
        textViewVie = findViewById(R.id.textView_vie);
        textViewScore = findViewById(R.id.textView_score);
        textViewQuestion = findViewById(R.id.textView_question);
        textViewResultat = findViewById(R.id.textView_resultat);
        textViewReponse = findViewById(R.id.textView_reponse);
        bouton0.setOnClickListener(v-> ajouterChiffre(0));
        bouton1.setOnClickListener(v-> ajouterChiffre(1));
        bouton2.setOnClickListener(v-> ajouterChiffre(2));
        bouton3.setOnClickListener(v-> ajouterChiffre(3));
        bouton4.setOnClickListener(v-> ajouterChiffre(4));
        bouton5.setOnClickListener(v-> ajouterChiffre(5));
        bouton6.setOnClickListener(v-> ajouterChiffre(6));
        bouton7.setOnClickListener(v-> ajouterChiffre(7));
        bouton8.setOnClickListener(v-> ajouterChiffre(8));
        bouton9.setOnClickListener(v-> ajouterChiffre(9));
        button_valider.setOnClickListener(v-> validerReponse(textViewReponse));
        button_effacer.setOnClickListener(v-> effacerChiffre(textViewReponse));
        genererNouvelleQuestion();
    }

    private void ajouterChiffre(Integer chiffre) {
        reponseUtilisateur.append(chiffre);
        textViewReponse.setText(reponseUtilisateur.toString());
    }

    private void effacerChiffre(TextView textViewReponse) {
        if (reponseUtilisateur.length() > 0) {
            reponseUtilisateur.deleteCharAt(reponseUtilisateur.length() - 1);
            textViewReponse.setText(reponseUtilisateur.toString());
        }
    }

    private void validerReponse(TextView textViewReponse) {
        if (reponseUtilisateur.length() == 0) {
            textViewResultat.setText("Veuillez entrer une réponse.");
            return;
        }

        int reponse = Integer.parseInt(reponseUtilisateur.toString());
        if (reponse == bonneReponse) {
            disableButtons();
            textViewResultat.setText("✅ Bonne réponse !");
            score += 100;
            textViewScore.setText("Score : " + score);
        } else {
            vies--;
            if (vies > 0) {
                disableButtons();
                textViewResultat.setText("❌ Mauvaise réponse. La bonne réponse était " + bonneReponse);
            } else {
                disableButtons();
                textViewResultat.setText("❌ Vous avez perdu ! La bonne réponse était " + bonneReponse);

                new Handler().postDelayed(this::enterName, 2000);
                return;
            }
        }

        textViewVie.setText("Lives : " + vies);

        if (vies > 0) {
            new Handler().postDelayed(this::genererNouvelleQuestion, 2000);
        }
    }

    private void enterName() {
        Intent intent = new Intent(CalculMentalActivity.this, EnterNameActivity.class);
        startActivityForResult(intent, 1);
    }

    private void disableButtons() {
        bouton0.setEnabled(false);
        bouton1.setEnabled(false);
        bouton2.setEnabled(false);
        bouton3.setEnabled(false);
        bouton4.setEnabled(false);
        bouton5.setEnabled(false);
        bouton6.setEnabled(false);
        bouton7.setEnabled(false);
        bouton8.setEnabled(false);
        bouton9.setEnabled(false);
        button_valider.setEnabled(false);
        button_effacer.setEnabled(false);
    }

    private void enableButtons() {
        bouton0.setEnabled(true);
        bouton1.setEnabled(true);
        bouton2.setEnabled(true);
        bouton3.setEnabled(true);
        bouton4.setEnabled(true);
        bouton5.setEnabled(true);
        bouton6.setEnabled(true);
        bouton7.setEnabled(true);
        bouton8.setEnabled(true);
        bouton9.setEnabled(true);
        button_valider.setEnabled(true);
        button_effacer.setEnabled(true);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK) {
            String pseudo = data.getStringExtra("pseudo");

            Toast.makeText(this, "Pseudo enregistré : " + pseudo, Toast.LENGTH_SHORT).show();

            // Tu peux sauvegarder le pseudo dans une base de données, ou simplement afficher un message
        }
    }

    private void genererNouvelleQuestion() {
        Random random = new Random();
        TypeOperation[] operations = TypeOperation.values();
        operation = operations[random.nextInt(operations.length)];
        enableButtons();

        switch (operation) {
            case ADD:
                nombre1 = random.nextInt(50) + 1;
                nombre2 = random.nextInt(50) + 1;
                bonneReponse = nombre1 + nombre2;
                break;

            case SUBSTRACT:
                // Pour éviter les résultats négatifs, on s'assure que nombre1 >= nombre2
                nombre1 = random.nextInt(100) + 1;
                nombre2 = random.nextInt(nombre1 + 1);  // borné à nombre1 inclus
                bonneReponse = nombre1 - nombre2;
                break;

            case MULTIPLY:
                nombre1 = random.nextInt(10) + 1;
                nombre2 = random.nextInt(10) + 1;
                bonneReponse = nombre1 * nombre2;
                break;

            case DIVIDE:
                // Pour une division entière, on construit un bon résultat puis on calcule l'opération inverse
                nombre2 = random.nextInt(9) + 2; // évite la division par 0
                bonneReponse = random.nextInt(10); // résultat souhaité
                nombre1 = nombre2 * bonneReponse;
                break;
        }

        textViewQuestion.setText(nombre1 + " " + operation.getSymbole() + " " + nombre2 + " = ?");
        textViewReponse.setText("");
        textViewResultat.setText("");
        reponseUtilisateur.setLength(0);
    }
}
