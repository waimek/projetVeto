package com.example.projetveto.repository;

import androidx.lifecycle.LiveData;

import com.example.projetveto.bo.Consultation;

import java.util.List;

public interface ConsultationRepository {
    void insert(Consultation article);

    LiveData<List<Consultation>> get();

    Consultation get(int id);

    LiveData<List<Consultation>> getRdvPasse(int id);

    LiveData<List<Consultation>> getRdvAVenir(int id);

    void update(Consultation consultation);

    void delete(Consultation consultation);

    void delete();
}
