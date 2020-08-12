package com.example.projetveto.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;

import com.example.projetveto.R;
import com.example.projetveto.viewmodel.ProprietaireViewModel;

public class ConnexionActivity extends AppCompatActivity {

    Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);
    }

    public void onClickConnexion(View view) {
        final ProprietaireViewModel pvm = ViewModelProviders.of((FragmentActivity) context).get(ProprietaireViewModel.class);

        Intent intent = new Intent(this, RendezVousActivity.class);
        startActivity(intent);
    }
}
