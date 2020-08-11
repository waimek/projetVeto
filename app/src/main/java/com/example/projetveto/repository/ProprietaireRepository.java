package com.example.projetveto.repository;

import androidx.lifecycle.LiveData;

import com.example.projetveto.bo.Proprietaire;

import java.util.List;

public interface ProprietaireRepository {
    void insert(Proprietaire article);

    LiveData<List<Proprietaire>> get();

    Proprietaire get(int id);

    void update(Proprietaire proprietaire);

    void delete(Proprietaire proprietaire);

    void delete();
}
