package com.example.projetveto.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.projetveto.R;
import com.example.projetveto.activity.adapter.RendezVousAdapter;
import com.example.projetveto.bo.Consultation;
import com.example.projetveto.bo.User;
import com.example.projetveto.viewmodel.ConsultationViewModel;

import java.util.List;


public class RendezVousActivity extends AppCompatActivity {

    User userConnecte =null;
    ListView listeAVenir=null;
    ListView listePasse=null;
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

        ConsultationViewModel view = new ViewModelProvider(this).get(ConsultationViewModel.class);
        listeAVenir = findViewById(R.id.list_view_rdv);
        LiveData<List<Consultation>> observer = view.getObserverGetRdvAVenir(userConnecte.getId());

        observer.observe((LifecycleOwner) this, new Observer<List<Consultation>>() {

            @Override
            public void onChanged(List<Consultation> consultations) {
                RendezVousAdapter adapter = new RendezVousAdapter(RendezVousActivity.this,R.layout.activity_rendez_vous_list,consultations);
                listeAVenir.setAdapter(adapter);
                if(listeAVenir != null){
                    TextView textView = findViewById(R.id.aucun_rdv);
                    try{
                        listeAVenir.getItemAtPosition(0);
                        textView.setText("Voici vos rendez vous à venir :");
                    }catch (Exception e){
                        textView.setText("Vous n\'avez aucun rendez-vous de prévu");
                    }

                }
            }
        });


        listePasse = findViewById(R.id.list_view_rdv_passe);
        LiveData<List<Consultation>> observer2 = view.getObserverGetRdvPasse(userConnecte.getId());

        observer2.observe((LifecycleOwner) this, new Observer<List<Consultation>>() {
            @Override
            public void onChanged(List<Consultation> consultations) {
                RendezVousAdapter adapter = new RendezVousAdapter(RendezVousActivity.this,R.layout.activity_rendez_vous_list,consultations);
                listePasse.setAdapter(adapter);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
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
