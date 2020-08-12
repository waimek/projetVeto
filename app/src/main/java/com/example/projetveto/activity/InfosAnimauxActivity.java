package com.example.projetveto.activity;

<<<<<<< HEAD
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.projetveto.R;
=======
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
>>>>>>> 8e8cf90d736742864810d2cb570d2c58ca490e58

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
<<<<<<< HEAD
        // Find the toolbar view inside the activity layout
        Toolbar toolbar = findViewById(R.id.toolbar);
        // Sets the Toolbar to act as the ActionBar for this Activity window.
        // Make sure the toolbar exists in the activity and is not null
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Vos animaux");
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
=======

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
>>>>>>> 8e8cf90d736742864810d2cb570d2c58ca490e58
    }
}
