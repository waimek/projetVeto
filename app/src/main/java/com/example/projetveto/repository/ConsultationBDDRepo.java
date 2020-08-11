package com.example.projetveto.repository;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.projetveto.bo.Animal;
import com.example.projetveto.bo.Consultation;
import com.example.projetveto.dal.AnimalDAO;
import com.example.projetveto.dal.AppDatabase;
import com.example.projetveto.dal.ConsultationDAO;

import java.util.List;

public class ConsultationBDDRepo implements ConsultationRepository {
    private ConsultationDAO consultationDAO;
    List<Consultation> results = null;

    public ConsultationBDDRepo(Context context) {
        AppDatabase MyDatabase = AppDatabase.getInstance(context);
        consultationDAO = MyDatabase.getConsultationDAO();
    }
    @Override
    public void insert(Consultation item) {
        new AsyncTask<Consultation, Void, Void>() {
            @Override
            protected Void doInBackground(Consultation... consultations) {
                consultationDAO.insert(consultations[0]);
                return null;
            }
        }.execute(item);
    }


    @Override
    public LiveData<List<Consultation>> get() {
        return consultationDAO.get();
    }

    @Override
    public Consultation get(int id) {
        return null;
    }


    @Override
    public void update(Consultation consultation) {
        new AsyncTask<Consultation, Void, Void>() {
            @Override
            protected Void doInBackground(Consultation... consultations) {
                consultationDAO.update(consultations[0]);
                return null;
            }
        }.execute(consultation);
    }

    @Override
    public void delete(Consultation consultation) {
        new AsyncTask<Consultation, Void, Void>() {
            @Override
            protected Void doInBackground(Consultation... consultations) {
                consultationDAO.delete(consultations[0]);
                return null;
            }
        }.execute(consultation);
    }

    @Override
    public void delete() {
        new AsyncTask<Void, Void, Void>() {

            @Override
            protected Void doInBackground(Void... voids) {
                consultationDAO.delete();
                return null;
            }
        }.execute();
    }
}
