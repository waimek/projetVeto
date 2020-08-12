package com.example.projetveto.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.projetveto.R;
import com.example.projetveto.bo.Proprietaire;
import com.example.projetveto.viewmodel.ProprietaireViewModel;

public class ConnexionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);
    }

    public void onClickConnexion(View view) {
        ProprietaireViewModel pvm = new ViewModelProvider(this).get(ProprietaireViewModel.class);
        EditText etEmail= findViewById(R.id.et_email);
        EditText etPassword= findViewById(R.id.et_password);
        pvm.getProprietaire(etEmail.getText().toString(), etPassword.getText().toString());
        pvm.getObserverAuth().observe(this, new Observer<Proprietaire>() {
            @Override
            public void onChanged(Proprietaire proprietaire) {
                if(proprietaire!= null){
                Intent intent = new Intent(ConnexionActivity.this, RendezVousActivity.class);
                intent.putExtra("userConnecte", proprietaire);
                startActivity(intent);
                }else{
                Toast.makeText(ConnexionActivity.this,"Erreur d'authentification, réessayez", Toast.LENGTH_LONG).show();
                }
            }
        });



    }
}
