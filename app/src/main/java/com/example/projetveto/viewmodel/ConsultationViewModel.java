package com.example.projetveto.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.projetveto.bo.Animal;
import com.example.projetveto.bo.Consultation;
import com.example.projetveto.repository.AnimalBDDRepo;
import com.example.projetveto.repository.AnimalRepository;
import com.example.projetveto.repository.ConsultationBDDRepo;
import com.example.projetveto.repository.ConsultationRepository;

import java.util.List;

public class ConsultationViewModel extends AndroidViewModel {
    ConsultationRepository repository;

    private LiveData<List<Consultation>> observer = null;
    public ConsultationViewModel(@NonNull Application application) {
        super(application);
        repository = new ConsultationBDDRepo(application);
        observer = repository.get();
    }
    public LiveData<List<Consultation>> get() {
        return observer;
    }

    public void insert(Consultation consultation) {
        repository.insert(consultation);
    }

    public void update(Consultation consultation) {

        /**
         * La ligne qui suit sert de passe-plat
         */
        repository.update(consultation);
    }

    public void delete(Consultation consultation) {

        /**
         * La ligne qui suit sert de passe-plat
         */
        repository.delete(consultation);
    }

    void delete() {

    }
}
