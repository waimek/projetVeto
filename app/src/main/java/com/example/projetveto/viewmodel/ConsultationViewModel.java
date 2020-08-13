package com.example.projetveto.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.projetveto.bo.Consultation;
import com.example.projetveto.repository.ConsultationBDDRepo;
import com.example.projetveto.repository.ConsultationRepository;

import java.util.List;

public class ConsultationViewModel extends AndroidViewModel {
    ConsultationRepository repository;

    private LiveData<List<Consultation>> observer = null;
    public LiveData<List<Consultation>> observerGetRdvPasse = null;
    public LiveData<List<Consultation>> observerGetRdvAVenir = null;

    public ConsultationViewModel(@NonNull Application application) {
        super(application);
        repository = new ConsultationBDDRepo(application);
        observer = repository.get();
    }
    public LiveData<List<Consultation>> get() {
        return observer;
    }

    public LiveData<List<Consultation>> getObserverGetRdvPasse(int id){
        return getRdvPasse(id);
    }
    public LiveData<List<Consultation>> getObserverGetRdvAVenir(int id){
        return getRdvAVenir(id);
    }
    public LiveData<List<Consultation>>  getRdvPasse(int id){
        observerGetRdvPasse = repository.getRdvPasse(id);
        return observerGetRdvPasse;
    }
    public LiveData<List<Consultation>> getRdvAVenir(int id){
        observerGetRdvAVenir = repository.getRdvAVenir(id);
        return observerGetRdvAVenir;
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
