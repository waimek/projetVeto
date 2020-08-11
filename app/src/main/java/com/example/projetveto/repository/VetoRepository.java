package com.example.projetveto.repository;

import androidx.lifecycle.LiveData;

import com.example.projetveto.bo.Veto;

import java.util.List;

public interface VetoRepository {
    void insert(Veto article);

    LiveData<List<Veto>> get();

    Veto get(int id);

    void update(Veto veto);

    void delete(Veto veto);

    void delete();
}
