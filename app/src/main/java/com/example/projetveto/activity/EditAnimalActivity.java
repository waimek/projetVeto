package com.example.projetveto.activity;

import android.content.Intent;
import android.os.Bundle;
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
import com.example.projetveto.bo.User;
import com.example.projetveto.viewmodel.AnimalViewModel;
import com.facebook.stetho.Stetho;

import java.sql.Date;

public class EditAnimalActivity extends AppCompatActivity {

    AnimalViewModel view = null;
    User userConnecte = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Stetho.initializeWithDefaults(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_animal);
//        userConnecte= (User) getIntent().getExtras().get("userConnecte");
        // Find the toolbar view inside the activity layout
        Toolbar toolbar = findViewById(R.id.toolbar);

        // Sets the Toolbar to act as the ActionBar for this Activity window.
        // Make sure the toolbar exists in the activity and is not null
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Editer un animal");


        //Test Edit l'Activity
        view = ViewModelProviders.of(this).get(AnimalViewModel.class);
//        final LiveData<List<Article>> observer = view.get();

        Animal animal = (Animal) getIntent().getExtras().get("animalEdit");

        EditText nomAnimalEdit = findViewById(R.id.et_nom);
        nomAnimalEdit.setText(animal.getNom());

        EditText dateAnimalEdit = findViewById(R.id.et_date_naissance);
        dateAnimalEdit.setText(String.valueOf(animal.getDateNaissance()));

        EditText especeAnimalEdit = findViewById(R.id.textViewEspece);
        especeAnimalEdit.setText(String.valueOf(animal.getIdEspece()));

        CheckBox editPuce = findViewById(R.id.chk_puce);
        editPuce.setText(String.valueOf(animal.isPuce()));


        CheckBox editSterilise = findViewById(R.id.chk_sterilise);
        editSterilise.setText(String.valueOf(animal.isSterilise()));

        EditText editNumeroIdentification = findViewById(R.id.et_numero_identification);
        editNumeroIdentification.setText(String.valueOf(animal.getIdentifiantInternational()));

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

        return super.onOptionsItemSelected(item);
    }

    public void onClickEdit(View view) {

//        final LiveData<List<Article>> observer = view.get();

        Animal animal = (Animal) getIntent().getExtras().get("animalEdit");

        EditText nomAnimalEdit = findViewById(R.id.et_nom);
        String nomEdit = nomAnimalEdit.getText().toString();
        animal.setNom(nomEdit);

        EditText dateAnimalEdit = findViewById(R.id.et_date_naissance);
        Date dateEdit = Date.valueOf(dateAnimalEdit.getText().toString());
        animal.setDateNaissance(dateEdit);

        EditText especeAnimalEdit = findViewById(R.id.textViewEspece);
        int editEspece = Integer.parseInt(especeAnimalEdit.getText().toString());
        animal.setIdEspece(editEspece);

        CheckBox editAnimalPuce = findViewById(R.id.chk_puce);
        boolean editPuce = Boolean.parseBoolean(editAnimalPuce.getText().toString());
        animal.setPuce(editPuce);


        CheckBox editAnimalSterilise = findViewById(R.id.chk_sterilise);
        boolean editSterilise = Boolean.parseBoolean(editAnimalSterilise.getText().toString());
        animal.setSterilise(editSterilise);

        EditText editNumeroIdentification = findViewById(R.id.et_numero_identification);
        String editNum = editNumeroIdentification.getText().toString();
        animal.setIdentifiantInternational(editNum);


        AnimalViewModel vue = ViewModelProviders.of(this).get(AnimalViewModel.class);
        vue.update(animal);
        Intent intent = new Intent(this, InfosAnimauxActivity.class);
        startActivity(intent);
    }

    public void onClickComeBack(View view) {
        Intent intent = new Intent(this, InfosAnimauxActivity.class);
        startActivity(intent);
    }
}
