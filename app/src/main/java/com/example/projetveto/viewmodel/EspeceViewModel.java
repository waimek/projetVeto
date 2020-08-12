package com.example.projetveto.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.projetveto.bo.Consultation;
import com.example.projetveto.bo.Espece;
import com.example.projetveto.repository.ConsultationBDDRepo;
import com.example.projetveto.repository.ConsultationRepository;
import com.example.projetveto.repository.EspeceBDDRepo;
import com.example.projetveto.repository.EspeceRepository;

import java.util.List;

public class EspeceViewModel extends AndroidViewModel {
    EspeceRepository repository;

    private LiveData<List<Espece>> observer = null;
    public EspeceViewModel(@NonNull Application application) {
        super(application);
        repository = new EspeceBDDRepo(application);
        observer = repository.get();
    }
    public LiveData<List<Espece>> get() {
        return observer;
    }

    public void insert(Espece espece) {
        repository.insert(espece);
    }

    public void update(Espece espece) {

        /**
         * La ligne qui suit sert de passe-plat
         */
        repository.update(espece);
    }

    public void delete(Espece espece) {

        /**
         * La ligne qui suit sert de passe-plat
         */
        repository.delete(espece);
    }

    void delete() {

    }
}
