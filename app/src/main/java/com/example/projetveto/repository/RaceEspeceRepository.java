package com.example.projetveto.repository;

import androidx.lifecycle.LiveData;

import com.example.projetveto.bo.RaceEspece;

import java.util.List;

public interface RaceEspeceRepository {
    void insert(RaceEspece article);

    LiveData<List<RaceEspece>> get();

    RaceEspece get(int id);

    void update(RaceEspece raceEspece);

    void delete(RaceEspece raceEspece);

    void delete();
}
