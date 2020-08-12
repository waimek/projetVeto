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
import com.example.projetveto.viewmodel.AnimalViewModel;

import java.util.List;

public class InfosAnimauxActivity extends AppCompatActivity {

    /*
     * On fait de la variable un attribut de class
     */
    ListView maListe = null;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("Lucille", "InfosAnimauxActivity: ");
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.activity_infos_animaux);
        final AnimalViewModel view = ViewModelProviders.of((FragmentActivity) context).get(AnimalViewModel.class);
        Log.i("Lucille", "InfosAnimauxActivity: " + view.toString());
        maListe = findViewById(R.id.list_view);
        LiveData<List<Animal>> observer = view.get();

        observer.observe((LifecycleOwner) this, new Observer<List<Animal>>() {
            @Override
            public void onChanged(List<Animal> animaux) {
                AnimalAdapter adapter = new AnimalAdapter(InfosAnimauxActivity.this, R.layout.activity_infos_animaux_list, animaux);
                maListe.setAdapter(adapter);
            }
        });

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Modifier vos informations");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void onClickEditAnimal(View view) {
        Log.i("Lulu", "onClickEditAnimal: ");
//        maListe.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
//                Log.i("TAGlulu", "onItemClick: " + maListe.toString());
//                Animal animal = (Animal) maListe.getAdapter().getItem(position);
//                Intent intent = new Intent(context, EditAnimalActivity.class);
//                intent.putExtra("animalEdit", animal);
//                startActivity(intent);
//            }
//        });
        Intent intent = new Intent(this, EditAnimalActivity.class);
        startActivity(intent);
    }

    public void onClickDeleteAnimal(View view) {
    }
}
