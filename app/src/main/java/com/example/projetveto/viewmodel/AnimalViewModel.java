package com.example.projetveto.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.projetveto.bo.Animal;
import com.example.projetveto.repository.AnimalBDDRepo;
import com.example.projetveto.repository.AnimalRepository;

import java.util.List;

public class AnimalViewModel extends AndroidViewModel {
    AnimalRepository repository;

    private LiveData<List<Animal>> observer = null;
    public AnimalViewModel(@NonNull Application application) {
        super(application);
        repository = new AnimalBDDRepo(application);
        observer = repository.get();
    }
    public LiveData<List<Animal>> get() {
        return observer;
    }

    public void insert(Animal animal) {
        repository.insert(animal);
    }

    public void update(Animal animal) {

        /**
         * La ligne qui suit sert de passe-plat
         */
        repository.update(animal);
    }

    public void delete(Animal animal) {

        /**
         * La ligne qui suit sert de passe-plat
         */
        repository.delete(animal);
    }

    void delete() {

    }
}
