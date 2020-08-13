package com.example.projetveto.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.projetveto.R;
import com.example.projetveto.activity.adapter.AnimalAdapter;
import com.example.projetveto.bo.Animal;
import com.example.projetveto.bo.User;
import com.example.projetveto.viewmodel.AnimalViewModel;
import com.facebook.stetho.Stetho;

import java.util.List;

public class InfosAnimauxActivity extends AppCompatActivity {

    /*
     * On fait de la variable un attribut de class
     */
    public Intent intent = null;
    ListView maListe = null;
    Context context;
    User userConnecte = null;
    AnimalAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Stetho.initializeWithDefaults(this);
//        userConnecte= (User) getIntent().getExtras().get("userConnecte");


        intent = new Intent(this, InfosAnimauxActivity.class);
        Log.i("Lucille", "InfosAnimauxActivity: ");
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.activity_infos_animaux);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Modifier vos informations");

        final AnimalViewModel view = ViewModelProviders.of((FragmentActivity) context).get(AnimalViewModel.class);
        Log.i("Lucille", "InfosAnimauxActivity: " + view.toString());
        maListe = findViewById(R.id.list_view);
        LiveData<List<Animal>> observer = view.get();

        observer.observe((LifecycleOwner) this, new Observer<List<Animal>>() {
            @Override
            public void onChanged(List<Animal> animaux) {
                adapter = new AnimalAdapter(InfosAnimauxActivity.this, R.layout.activity_infos_animaux_list, animaux);
                maListe.setAdapter(adapter);
                adapter.setListener(new AnimalAdapter.IOnItemClickListener() {
                    @Override
                    public void onEditClick(Animal animal) {
                        Log.i("TAGlulu", "onItemClick: " + maListe.toString());
                        Intent intent = new Intent(context, EditAnimalActivity.class);
                        intent.putExtra("animalEdit", animal);
                        startActivity(intent);
                    }

                    @Override
                    public void onDeleteClick(Animal animal) {
                        AnimalViewModel vue = ViewModelProviders.of((FragmentActivity) context).get(AnimalViewModel.class);
                        vue.delete(animal);
                        vue.update(animal);
                        startActivity(intent);
                    }
                });
            }
        });


//        maListe.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
//                Log.i("TAGlulu", "onItemClick: " + maListe.toString());
//                //if(view.getId() == R.id.btn_edit)
//                Animal animal = (Animal) maListe.getAdapter().getItem(position);
//                Intent intent = new Intent(context, EditAnimalActivity.class);
//                intent.putExtra("animalEdit", animal);
//                startActivity(intent);
//            }
//        });


    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        Intent intent =null;
//        switch (item.getItemId()) {
//            case R.id.miAnimaux:
//                return true;
//            case R.id.miRdv:
//                intent = new Intent(InfosAnimauxActivity.this, RendezVousActivity.class);
//                intent.putExtra("userConnecte",userConnecte);
//                startActivity(intent);
//                return true;
//            case R.id.miInfos:
//                intent = new Intent(InfosAnimauxActivity.this, InfosProprietaireActivity.class);
//                intent.putExtra("userConnecte",userConnecte);
//                startActivity(intent);
//                return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void onClickAddAnimal(View view) {
        Intent intent = new Intent(this, InsertAnimalActivity.class);
        startActivity(intent);
    }
}
