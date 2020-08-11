package com.example.projetveto.repository;

import androidx.lifecycle.LiveData;

import com.example.projetveto.bo.Espece;

import java.util.List;

public interface EspeceRepository {
    void insert(Espece article);

    LiveData<List<Espece>> get();

    Espece get(int id);

    void update(Espece espece);

    void delete(Espece espece);

    void delete();
}
