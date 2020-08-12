package com.example.projetveto.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProviders;

import com.example.projetveto.R;
import com.example.projetveto.bo.Espece;
import com.example.projetveto.viewmodel.EspeceViewModel;
import com.example.projetveto.viewmodel.ProprietaireViewModel;
import com.facebook.stetho.Stetho;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Find the toolbar view inside the activity layout
        Toolbar toolbar = findViewById(R.id.toolbar);
        // Sets the Toolbar to act as the ActionBar for this Activity window.
        // Make sure the toolbar exists in the activity and is not null
        setSupportActionBar(toolbar);
//        getSupportActionBar().setTitle("Test");

        //Test insertion en base
        Stetho.initializeWithDefaults(this);
        //Espece
        Espece espece = new Espece( "Chien");
        Espece chatespece = new Espece("Chat");

//        Log.i("LucilleH", "InsertAnimal: " + animal);
//        AnimalViewModel vue = ViewModelProviders.of(this).get(AnimalViewModel.class);
        EspeceViewModel vue = ViewModelProviders.of(this).get(EspeceViewModel.class);
        ProprietaireViewModel vuue = ViewModelProviders.of(this).get(ProprietaireViewModel.class);
//        Log.i("LucilleH", "InsertAnimal: " + vue);
        vue.insert(espece);
        vue.insert(chatespece);
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

    public void onClickCreationCompte(View view){
        Intent intent = new Intent(this, CreationCompteActivity.class);
        startActivity(intent);

    }
    public void onClickConnexion(View view){
        Intent intent = new Intent(this, ConnexionActivity.class);
        startActivity(intent);
    }


}
