package com.example.projetveto.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.example.projetveto.R;
import com.example.projetveto.bo.Animal;
import com.example.projetveto.viewmodel.AnimalViewModel;
import com.facebook.stetho.Stetho;

import java.util.Date;

public class InsertAnimalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_animal);
    }

    public void onClickSave(View view) {
        Stetho.initializeWithDefaults(this);

        /**
         * Insertion d'un nom
         */
        EditText insertNom = findViewById(R.id.animal_nom_insert);
        String nom = insertNom.getText().toString();

        /**
         * Insertion d'une date de naissance
         */
        EditText insertNaissance = findViewById(R.id.animal_naissance_insert);
        Date naissance = new Date(insertNaissance.getText().toString());


        /**
         * Insertion d'un espece
         */
        EditText insertEspece = findViewById(R.id.animal_Raceespece_insert);
        int espece = Integer.parseInt(insertEspece.getText().toString());

        /**
         * Insertion d'un proprio
         */
        EditText insertProprio = findViewById(R.id.animal_propriotaire_insert);
        int proprio = Integer.parseInt(insertProprio.getText().toString());

        /**
         * Insertion d'un puce ou pas ?
         */
        boolean puce = false;
            CheckBox insertPuce = findViewById(R.id.animal_puce_insert);
            if (insertPuce.isChecked()) {
                puce = true;
            }

        /**
         * Insertion d'un sterilise ou pas ?
         */
        boolean sterilise = false;
        CheckBox insertSteril = findViewById(R.id.animal_sterilise_insert);
        if (insertSteril.isChecked()) {
            sterilise = true;
        }
//        Toast.makeText(this, "Le produit a bien été ajouté " + titre + " , " + price + " , " + description + " , " + grade +  " , " + bought + " . ", Toast.LENGTH_LONG).show();
        Animal animal = new Animal(nom, naissance, espece, proprio, puce, sterilise);
        Log.i("LucilleH", "InsertAnimal: " + animal);
        AnimalViewModel vue = ViewModelProviders.of(this).get(AnimalViewModel.class);
        Log.i("LucilleH", "InsertAnimal: " + vue);
        vue.insert(animal);
    }
}