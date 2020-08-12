package com.example.projetveto.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.projetveto.bo.Animal;
import com.example.projetveto.bo.Veto;
import com.example.projetveto.repository.AnimalBDDRepo;
import com.example.projetveto.repository.AnimalRepository;
import com.example.projetveto.repository.VetoBDDRepo;
import com.example.projetveto.repository.VetoRepository;

import java.util.List;

public class VetoViewModel extends AndroidViewModel {
    VetoRepository repository;

    private LiveData<List<Veto>> observer = null;
    public VetoViewModel(@NonNull Application application) {
        super(application);
        repository = new VetoBDDRepo(application);
        observer = repository.get();
    }
    public LiveData<List<Veto>> get() {
        return observer;
    }

    public void insert(Veto veto) {
        repository.insert(veto);
    }

    public void update(Veto veto) {

        /**
         * La ligne qui suit sert de passe-plat
         */
        repository.update(veto);
    }

    public void delete(Veto veto) {

        /**
         * La ligne qui suit sert de passe-plat
         */
        repository.delete(veto);
    }

    void delete() {

    }
}
