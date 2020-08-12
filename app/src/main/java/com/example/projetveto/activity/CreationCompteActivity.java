package com.example.projetveto.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;

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
        final ProprietaireViewModel pvm = ViewModelProviders.of((FragmentActivity) context).get(ProprietaireViewModel.class);
        EditText email = findViewById(R.id.et_email);
        EditText mdp = findViewById(R.id.et_password);
        EditText confirmation = findViewById(R.id.et_confirmation_password);

        if(mdp.getText() == confirmation.getText()){
            pvm.insert(new Proprietaire("","","","","",email.getText().toString(), mdp.getText().toString()));
            Intent intent = new Intent(this, ConnexionActivity.class);
            startActivity(intent);
        }
    }
}
