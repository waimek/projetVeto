package com.example.projetveto.repository;

import androidx.lifecycle.LiveData;

import com.example.projetveto.bo.Animal;

import java.util.List;

public interface AnimalRepository {
    void insert(Animal article);

    LiveData<List<Animal>> get();

    LiveData<List<Animal>> get(int idProprietaire);

    void update(Animal animal);

    void delete(Animal animal);

    void delete();
}
