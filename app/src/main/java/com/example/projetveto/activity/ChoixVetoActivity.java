package com.example.projetveto.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.projetveto.R;
import com.example.projetveto.activity.adapter.VetoAdapter;
import com.example.projetveto.bo.User;
import com.example.projetveto.bo.Veto;
import com.example.projetveto.viewmodel.VetoViewModel;

import java.util.List;

public class ChoixVetoActivity extends AppCompatActivity {

    ListView maListe = null;
    User userConnecte =null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix_veto);
        userConnecte = (User) getIntent().getExtras().get("userConnecte");
        maListe = findViewById(R.id.list_view_veto);
        VetoViewModel view = new ViewModelProvider(this).get(VetoViewModel.class);
        LiveData<List<Veto>> observer = view.get();

        observer.observe((LifecycleOwner) this, new Observer<List<Veto>>() {
            @Override
            public void onChanged(List<Veto> vetos) {
                VetoAdapter adapter = new VetoAdapter(ChoixVetoActivity.this,R.layout.activity_choix_veto_list,vetos);
                maListe.setAdapter(adapter);
            }
        });

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Choisir un vétérinaire");
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
                intent = new Intent(ChoixVetoActivity.this, InfosAnimauxActivity.class);
                intent.putExtra("userConnecte",userConnecte);
                startActivity(intent);
                return true;
            case R.id.miRdv:
                intent = new Intent(ChoixVetoActivity.this, RendezVousActivity.class);
                intent.putExtra("userConnecte",userConnecte);
                startActivity(intent);
                return true;
            case R.id.miInfos:
                intent = new Intent(ChoixVetoActivity.this, InfosProprietaireActivity.class);
                intent.putExtra("userConnecte",userConnecte);
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}