package com.example.projetveto.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;

import com.example.projetveto.R;
import com.example.projetveto.activity.adapter.AnimalAdapter;
import com.example.projetveto.bo.Animal;
import com.example.projetveto.viewmodel.AnimalViewModel;

import java.util.List;

public class InfosAnimauxActivity extends AppCompatActivity {
    /**
     * On fait de la variable un attribut de class
     */
    ListView maListe = null;
    Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infos_animaux);

        AnimalViewModel view = new ViewModelProvider((ViewModelStoreOwner) this).get(AnimalViewModel.class);

        maListe = findViewById(R.id.list_view);
        LiveData<List<Animal>> observer = view.get();

        observer.observe((LifecycleOwner) this, new Observer<List<Animal>>() {
            @Override
            public void onChanged(List<Animal> animaux) {
                AnimalAdapter adapter = new AnimalAdapter(InfosAnimauxActivity.this,R.layout.activity_infos_animaux_list,animaux);
                maListe.setAdapter(adapter);
            }
        });
    }
}
