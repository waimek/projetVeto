package com.example.projetveto.activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;

import com.example.projetveto.R;
import com.example.projetveto.bo.Proprietaire;
import com.example.projetveto.bo.User;
import com.example.projetveto.viewmodel.ProprietaireViewModel;

public class EditInfosProprietaireActivity extends AppCompatActivity {

    User userConnecte = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_infos_proprietaire);
        // Find the toolbar view inside the activity layout
        Toolbar toolbar = findViewById(R.id.toolbar);
        userConnecte = (User) getIntent().getExtras().get("userConnecte");
        // Sets the Toolbar to act as the ActionBar for this Activity window.
        // Make sure the toolbar exists in the activity and is not null
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Modifier vos informations");

        EditText etNom= findViewById(R.id.et_nom);
        EditText etPrenom= findViewById(R.id.et_prenom);
        EditText etRue= findViewById(R.id.et_rue);
        EditText etCp= findViewById(R.id.et_cp);
        EditText etVille= findViewById(R.id.et_ville);
        EditText etTel= findViewById(R.id.et_tel);

        etNom.setText(userConnecte.getNom());
        etPrenom.setText(userConnecte.getPrenom());
        etVille.setText(userConnecte.getVille());
        etTel.setText(userConnecte.getTel());
        etCp.setText(userConnecte.getCodePostal());
        etRue.setText(userConnecte.getAdresse());

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
        EditText etNom= findViewById(R.id.et_nom);
        EditText etPrenom= findViewById(R.id.et_prenom);
        EditText etRue= findViewById(R.id.et_rue);
        EditText etCp= findViewById(R.id.et_cp);
        EditText etVille= findViewById(R.id.et_ville);
        EditText etTel= findViewById(R.id.et_tel);

        userConnecte.setAdresse(etRue.getText().toString());
        userConnecte.setNom(etNom.getText().toString());
        userConnecte.setVille(etVille.getText().toString());
        userConnecte.setPrenom(etPrenom.getText().toString());
        userConnecte.setTel(etTel.getText().toString());
        userConnecte.setCodePostal(etCp.getText().toString());

        ProprietaireViewModel pvm = new ViewModelProvider(this).get(ProprietaireViewModel.class);
        pvm.update(new Proprietaire(userConnecte.getNom(),userConnecte.getPrenom(),userConnecte.getAdresse(),userConnecte.getVille(),userConnecte.getCodePostal(),userConnecte.getEmail(),userConnecte.getMdp(),userConnecte.getTel()));
        finish();
    }
}
