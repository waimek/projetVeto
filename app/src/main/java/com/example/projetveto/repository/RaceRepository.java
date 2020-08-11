package com.example.projetveto.repository;

import androidx.lifecycle.LiveData;

import com.example.projetveto.bo.Race;

import java.util.List;

public interface RaceRepository {
    void insert(Race article);

    LiveData<List<Race>> get();

    Race get(int id);

    void update(Race race);

    void delete(Race race);

    void delete();
}
