package com.example.projetveto.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.projetveto.R;
import com.example.projetveto.bo.Proprietaire;
import com.example.projetveto.viewmodel.ProprietaireViewModel;

public class CreationCompteActivity extends AppCompatActivity {

    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creation_compte);
    }

    public void onClickCreationCompte(View view) {
        ProprietaireViewModel pvm = new ViewModelProvider(this).get(ProprietaireViewModel.class);
        EditText email = findViewById(R.id.et_email);
        EditText mdp = findViewById(R.id.et_password);
        EditText confirmation = findViewById(R.id.et_confirmation_password);

        if(mdp.getText().toString().equals(confirmation.getText().toString())){
            pvm.insert(new Proprietaire("","","","","",email.getText().toString(), mdp.getText().toString(),""));
            Intent intent = new Intent(this, ConnexionActivity.class);
            startActivity(intent);
        }else{
            Toast.makeText(this,"Les mots de passe doivent être les mêmes", Toast.LENGTH_LONG).show();
        }
    }
}
