package com.example.projetveto.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
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
        // Find the toolbar view inside the activity layout
        Toolbar toolbar = findViewById(R.id.toolbar);
        // Sets the Toolbar to act as the ActionBar for this Activity window.
        // Make sure the toolbar exists in the activity and is not null
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Ajouter un animal");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //if(item.getItemId() == R.id.itemresearc)
        Intent intent =null;
        switch (item.getItemId()) {
            case R.id.miAnimaux:
                intent = new Intent(InsertAnimalActivity.this, InfosAnimauxActivity.class);
                startActivity(intent);
                return true;
            case R.id.miRdv:
                intent = new Intent(InsertAnimalActivity.this, RendezVousActivity.class);
                startActivity(intent);
                return true;
            case R.id.miInfos:
                intent = new Intent(InsertAnimalActivity.this, InfosProprietaireActivity.class);
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
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