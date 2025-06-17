package com.example.groupe_1_2025;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

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
    private TextView textViewReponse;
    private Integer premierElement=0;
    private Integer deuxiemeElement=0;
    private Button button_valider;
    private Button button_effacer;
    private TypeOperation typeOperation;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculatrice);
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
        button_valider.setOnClickListener(v -> validerReponse(textViewReponse));
        button_effacer.setOnClickListener(v -> effacerChiffre(textViewReponse));
    }

    private void ajouterChiffre(Integer chiffre){
        if(typeOperation==null){
            premierElement= premierElement*10+chiffre;
        }else{
            deuxiemeElement = deuxiemeElement*10+chiffre;
        }
        textViewReponse.setText(textViewReponse.getText()+chiffre.toString());
    }
    private void effacerChiffre(TextView textViewReponse){
        if(textViewReponse.getText()!=null){

        }
        textViewReponse.setText(textViewReponse.getText());
    }
    private void validerReponse(TextView textViewReponse){
        if(textViewReponse.getText()!=null){

        }
        textViewReponse.setText(textViewReponse.getText());
    }
}
