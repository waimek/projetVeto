package com.example.projetveto.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.projetveto.bo.Proprietaire;
import com.example.projetveto.repository.ProprietaireBDDRepo;
import com.example.projetveto.repository.ProprietaireRepository;

import java.util.List;

public class ProprietaireViewModel extends AndroidViewModel {
    ProprietaireRepository repository;

    private LiveData<List<Proprietaire>> observer = null;
    public LiveData<Proprietaire> observerGetByIdProprietaire = null;
    public LiveData<Proprietaire> observerAuth =null;
    public ProprietaireViewModel(@NonNull Application application) {
        super(application);
        repository = new ProprietaireBDDRepo(application);
        observer = repository.get();

    }
    public LiveData<List<Proprietaire>> get() {
        return observer;
    }

    public LiveData<Proprietaire> getObserverGetByIdProprietaire(){
        return observerGetByIdProprietaire;
    }
    public LiveData<Proprietaire> getObserverAuth(){
        return observerAuth;
    }
    public void getProprietaire(int id){

        observerGetByIdProprietaire = repository.get(id);
    }
    public void getProprietaire(String email, String mdp){
        observerAuth = repository.authentification(email, mdp);
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
