package com.example.projetveto.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.projetveto.R;
import com.example.projetveto.bo.User;


public class RendezVousActivity extends AppCompatActivity {

    User userConnecte =null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rendez_vous);
        // Find the toolbar view inside the activity layout
        Toolbar toolbar = findViewById(R.id.toolbar);
        // Sets the Toolbar to act as the ActionBar for this Activity window.
        // Make sure the toolbar exists in the activity and is not null
        userConnecte= (User) getIntent().getExtras().get("userConnecte");
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Mes rendez-vous");
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
                intent = new Intent(RendezVousActivity.this, InfosAnimauxActivity.class);
                intent.putExtra("userConnecte",userConnecte);
                startActivity(intent);
                return true;
            case R.id.miRdv:
                return true;
            case R.id.miInfos:
                intent = new Intent(RendezVousActivity.this, InfosProprietaireActivity.class);
                intent.putExtra("userConnecte",userConnecte);
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onClickPrendreRDV(View view) {
        Intent intent = new Intent(this, ChoixVetoActivity.class);
        intent.putExtra("userConnecte",userConnecte);
        startActivity(intent);
    }
}
