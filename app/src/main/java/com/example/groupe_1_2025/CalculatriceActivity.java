package com.example.groupe_1_2025;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CalculatriceActivity extends AppCompatActivity {

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

    private Button boutonAjouter;
    private Button boutonMultiplier;
    private Button boutonSoustraire;
    private Button boutonDiviser;
    private TextView textViewCalcul;

    private Integer premierElement=0;
    private Integer deuxiemeElement=0;
    private TypeOperation typeOperation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculatrice);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //TODO QUAND J'APPUIE SUR MES BOUTONS ÇA
        // AJOUTE LES CHIFFRES EN QUESTION DANS LA TEXTVIEW

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
        textViewCalcul = findViewById(R.id.textView_reponse);
        boutonAjouter = findViewById(R.id.button_add);
        boutonSoustraire = findViewById(R.id.button_moins);
        boutonMultiplier = findViewById(R.id.button_multiplier);
        boutonDiviser = findViewById(R.id.button_diviser);
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
        //TODO RAJOUTER LA LIGNE DE BOUTON POUR LE TYPE D'OPERATION
        // FAIRE EN SORTE QUE QUAND J'APPUIE DESSUS ÇA AIT LE COMPORTEMENT ATTENDU
        boutonAjouter.setOnClickListener(v -> ajouterTypeOperation(TypeOperation.ADD));
        boutonDiviser.setOnClickListener(v-> ajouterTypeOperation(TypeOperation.DIVIDE));
        boutonMultiplier.setOnClickListener(v -> ajouterTypeOperation(TypeOperation.MULTIPLY));
        boutonSoustraire.setOnClickListener(v -> ajouterTypeOperation(TypeOperation.SUBSTRACT));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.monmenu,menu);
        MenuItem boutonRAZ = menu.findItem(R.id.bouton_raz);
        boutonRAZ.setOnMenuItemClickListener(v -> {
            premierElement =0;
            deuxiemeElement =0;
            typeOperation=null;
            textViewCalcul.setText("");
            return true;
        });
        //TODO AJOUTER UN BOUTON "CALCULER" dans un menu burger
        // AU CLICK SUR LE BOUTON CALCULER JE FAIS UN TOAST AVEC LE RESULTAT DE L'OPERATION
        MenuItem boutonCalculer = menu.findItem(R.id.bouton_calculer);
        boutonCalculer.setOnMenuItemClickListener(v -> faisLeCalcul());
        return super.onCreateOptionsMenu(menu);
    }

    private boolean faisLeCalcul() {
        Integer resultat=0 ;
        if(typeOperation==null){
            Toast.makeText(this,"PAS D'OPERATION",Toast.LENGTH_LONG).show();
        }else{
            switch (typeOperation){
                case ADD:
                    resultat = premierElement+deuxiemeElement;
                    break;
                case SUBSTRACT:
                    resultat = premierElement-deuxiemeElement;
                    break;
                case MULTIPLY:
                    resultat = premierElement*deuxiemeElement;
                    break;
                case DIVIDE:
                    resultat = premierElement/deuxiemeElement;
                    break;
                default:
                    Toast.makeText(this,"PAS D'OPERATION",Toast.LENGTH_LONG).show();
            }
            Toast.makeText(this,resultat.toString(),Toast.LENGTH_LONG).show();
        }

        return true;
    }

    private void ajouterChiffre(Integer chiffre){
        if(typeOperation==null){
            premierElement= premierElement*10+chiffre;
        }else{
            deuxiemeElement = deuxiemeElement*10+chiffre;
        }
        textViewCalcul.setText(textViewCalcul.getText()+chiffre.toString());
    }

    private void ajouterTypeOperation(TypeOperation typeOperation){
        if(this.typeOperation==null){
            this.typeOperation = typeOperation;
            textViewCalcul.setText(textViewCalcul.getText()+ typeOperation.getSymbole());
        }else{
            Toast.makeText(this,"OPERATION DEJA SAISI VEUILLEZ RESET",Toast.LENGTH_LONG).show();
        }
    }
}