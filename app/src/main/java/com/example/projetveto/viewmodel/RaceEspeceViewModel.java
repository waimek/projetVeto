package com.example.projetveto.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.projetveto.bo.Animal;
import com.example.projetveto.bo.RaceEspece;
import com.example.projetveto.repository.AnimalBDDRepo;
import com.example.projetveto.repository.AnimalRepository;
import com.example.projetveto.repository.RaceEspeceBDDRepo;
import com.example.projetveto.repository.RaceEspeceRepository;
import com.example.projetveto.repository.RaceRepository;

import java.util.List;

public class RaceEspeceViewModel extends AndroidViewModel {
    RaceEspeceRepository repository;

    private LiveData<List<RaceEspece>> observer = null;
    public RaceEspeceViewModel(@NonNull Application application) {
        super(application);
        repository = new RaceEspeceBDDRepo(application);
        observer = repository.get();
    }
    public LiveData<List<RaceEspece>> get() {
        return observer;
    }

    public void insert(RaceEspece raceEspece) {
        repository.insert(raceEspece);
    }

    public void update(RaceEspece raceEspece) {

        /**
         * La ligne qui suit sert de passe-plat
         */
        repository.update(raceEspece);
    }

    public void delete(RaceEspece raceEspece) {

        /**
         * La ligne qui suit sert de passe-plat
         */
        repository.delete(raceEspece);
    }

    void delete() {

    }
}
