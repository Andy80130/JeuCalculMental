package com.example.groupe_1_2025;

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
    private TextView textViewQuestion;
    private TextView textViewReponse;
    private TextView textViewResultat;
    private int nombre1;
    private int nombre2;
    private TypeOperation operation;
    private int bonneReponse;
    private StringBuilder reponseUtilisateur = new StringBuilder();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculmental);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        bouton0=findViewById(R.id.button_0);
        bouton1 = findViewById(R.id.button_1);
        bouton2 = findViewById(R.id.button_2);
        bouton3= findViewById(R.id.button_3);
        bouton4= findViewById(R.id.button_4);
        bouton5 = findViewById(R.id.button_5);
        bouton6= findViewById(R.id.button_6);
        bouton7 = findViewById(R.id.button_7);
        bouton8 = findViewById(R.id.button_8);
        bouton9=findViewById(R.id.button_9);
        button_valider=findViewById(R.id.bouton_valider);
        button_effacer=findViewById(R.id.bouton_effacer);
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
            textViewResultat.setText("✅ Bonne réponse !");
        } else {
            textViewResultat.setText("❌ Mauvaise Réponse. La bonne réponse était " + bonneReponse);
        }

        // Générer une nouvelle question après 2 secondes
        new Handler().postDelayed(this::genererNouvelleQuestion, 2000);
    }

    private void genererNouvelleQuestion() {
        Random random = new Random();
        TypeOperation[] operations = TypeOperation.values();
        operation = operations[random.nextInt(operations.length)];

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
                nombre2 = random.nextInt(9) + 1; // évite la division par 0
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
