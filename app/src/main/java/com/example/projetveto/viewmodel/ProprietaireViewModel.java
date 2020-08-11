package com.example.projetveto.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.projetveto.bo.Animal;
import com.example.projetveto.bo.Proprietaire;
import com.example.projetveto.repository.AnimalBDDRepo;
import com.example.projetveto.repository.AnimalRepository;
import com.example.projetveto.repository.ProprietaireBDDRepo;
import com.example.projetveto.repository.ProprietaireRepository;

import java.util.List;

public class ProprietaireViewModel extends AndroidViewModel {
    ProprietaireRepository repository;

    private LiveData<List<Proprietaire>> observer = null;
    public ProprietaireViewModel(@NonNull Application application) {
        super(application);
        repository = new ProprietaireBDDRepo(application);
        observer = repository.get();
    }
    public LiveData<List<Proprietaire>> get() {
        return observer;
    }

    public void insert(Proprietaire proprietaire) {
        repository.insert(proprietaire);
    }

    public void update(Proprietaire proprietaire) {

        /**
         * La ligne qui suit sert de passe-plat
         */
        repository.update(proprietaire);
    }

    public void delete(Proprietaire proprietaire) {

        /**
         * La ligne qui suit sert de passe-plat
         */
        repository.delete(proprietaire);
    }

    void delete() {

    }
}
