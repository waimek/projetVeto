package com.example.projetveto.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.projetveto.R;
import com.example.projetveto.bo.User;

public class InfosProprietaireActivity extends AppCompatActivity {

    User userConnecte = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infos_proprietaire);
        // Find the toolbar view inside the activity layout
        Toolbar toolbar = findViewById(R.id.toolbar);
        userConnecte = (User) getIntent().getExtras().get("userConnecte");
        // Sets the Toolbar to act as the ActionBar for this Activity window.
        // Make sure the toolbar exists in the activity and is not null
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Modifier vos informations");

        if(userConnecte.getNom()!="" || userConnecte.getPrenom()!=""){
            TextView txtNomPrenom = findViewById(R.id.txt_nom_prenom_genre);
            txtNomPrenom.setText(userConnecte.getNom() +" "+ userConnecte.getPrenom());
        }
        if(userConnecte.getAdresse()!=""){
            TextView txtRue = findViewById(R.id.txt_rue);
            txtRue.setText(userConnecte.getAdresse());
        }
        if(userConnecte.getCodePostal()!="" && userConnecte.getVille()!=""){
            TextView txtCpVille = findViewById(R.id.txt_cp_ville);
            txtCpVille.setText(userConnecte.getCodePostal()+" "+userConnecte.getVille());
        }
        if(userConnecte.getTel()!=""){
            TextView txtTel = findViewById(R.id.txt_tel);
            txtTel.setText(userConnecte.getTel());
        }
        TextView txtEmail = findViewById(R.id.txt_email);
        txtEmail.setText(userConnecte.getEmail());
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
                intent = new Intent(InfosProprietaireActivity.this, InfosAnimauxActivity.class);
                intent.putExtra("userConnecte",userConnecte);
                startActivity(intent);
                return true;
            case R.id.miRdv:
                intent = new Intent(InfosProprietaireActivity.this, RendezVousActivity.class);
                intent.putExtra("userConnecte",userConnecte);
                startActivity(intent);
                return true;
            case R.id.miInfos:

                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onClickEdit(View view) {
        Intent intent = new Intent(this, EditInfosProprietaireActivity.class);
        intent.putExtra("userConnecte",userConnecte);
        startActivity(intent);

    }
}
