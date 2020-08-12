package com.example.projetveto.repository;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.projetveto.bo.Animal;
import com.example.projetveto.dal.AnimalDAO;
import com.example.projetveto.dal.AppDatabase;

import java.util.List;

public class AnimalBDDRepo implements AnimalRepository {
    private AnimalDAO animalDAO;
    List<Animal> results = null;

    public AnimalBDDRepo(Context context) {
        AppDatabase MyDatabase = AppDatabase.getInstance(context);
        animalDAO = MyDatabase.getAnimalDAO();
    }

    @Override
    public void insert(final Animal item) {
        new AsyncTask<Animal, Void, Void>() {
            @Override
            protected Void doInBackground(Animal... animals) {
                animalDAO.insert(animals[0]);
                return null;
            }
        }.execute(item);
    }


    @Override
    public LiveData<List<Animal>> get() {
        return animalDAO.get();
    }

    @Override
    public Animal get(int id) {
        return null;
    }

    @Override
    public void update(Animal animal) {
        new AsyncTask<Animal, Void, Void>() {
            @Override
            protected Void doInBackground(Animal... animals) {
                animalDAO.update(animals[0]);
                return null;
            }
        }.execute(animal);
    }

    @Override
    public void delete(Animal animal) {
        new AsyncTask<Animal, Void, Void>() {
            @Override
            protected Void doInBackground(Animal... animals) {
                animalDAO.delete(animals[0]);
                return null;
            }
        }.execute(animal);
    }

    @Override
    public void delete() {
        new AsyncTask<Void, Void, Void>() {

            @Override
            protected Void doInBackground(Void... voids) {
                animalDAO.delete();
                return null;
            }
        }.execute();
    }
}

