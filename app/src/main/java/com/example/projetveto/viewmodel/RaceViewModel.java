package com.example.projetveto.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.projetveto.bo.Animal;
import com.example.projetveto.bo.Race;
import com.example.projetveto.repository.AnimalBDDRepo;
import com.example.projetveto.repository.AnimalRepository;
import com.example.projetveto.repository.RaceBDDRepo;
import com.example.projetveto.repository.RaceRepository;

import java.util.List;

public class RaceViewModel extends AndroidViewModel {
    RaceRepository repository;

    private LiveData<List<Race>> observer = null;
    public RaceViewModel(@NonNull Application application) {
        super(application);
        repository = new RaceBDDRepo(application);
        observer = repository.get();
    }
    public LiveData<List<Race>> get() {
        return observer;
    }

    public void insert(Race race) {
        repository.insert(race);
    }

    public void update(Race race) {

        /**
         * La ligne qui suit sert de passe-plat
         */
        repository.update(race);
    }

    public void delete(Race race) {

        /**
         * La ligne qui suit sert de passe-plat
         */
        repository.delete(race);
    }

    void delete() {

    }
}
