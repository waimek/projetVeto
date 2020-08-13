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
import com.example.projetveto.bo.Veto;
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

        //Test insertion en base
        Stetho.initializeWithDefaults(this);
        //Espece
        Espece espece = new Espece( "Chien");
        Espece chatespece = new Espece("Chat");

        EspeceViewModel vue = ViewModelProviders.of(this).get(EspeceViewModel.class);
        ProprietaireViewModel vuue = ViewModelProviders.of(this).get(ProprietaireViewModel.class);
        vue.insert(espece);
        vue.insert(chatespece);
        Veto veto = new Veto("jean", "jacquie","ofkjfer","lkdfvf","45666","edouard.peyrot@orange.fr","mdp","066666666","id",7f,17f);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
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
