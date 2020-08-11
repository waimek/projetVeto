package com.example.projetveto.repository;

import androidx.lifecycle.LiveData;

import com.example.projetveto.bo.Animal;

import java.util.List;

public interface AnimalRepository {
    void insert(Animal article);

    LiveData<List<Animal>> get();

    Animal get(int id);

    void update(Animal animal);

    void delete(Animal animal);

    void delete();
}
