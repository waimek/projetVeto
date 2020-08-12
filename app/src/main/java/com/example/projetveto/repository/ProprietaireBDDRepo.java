package com.example.projetveto.repository;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.projetveto.bo.Proprietaire;
import com.example.projetveto.dal.AppDatabase;
import com.example.projetveto.dal.ProprietaireDAO;

import java.util.List;

public class ProprietaireBDDRepo implements ProprietaireRepository {
    private ProprietaireDAO proprietaireDAO;
    List<Proprietaire> results = null;

    public ProprietaireBDDRepo(Context context) {
        AppDatabase MyDatabase = AppDatabase.getInstance(context);
        proprietaireDAO = MyDatabase.getProprietaireDAO();
    }
    @Override
    public void insert(Proprietaire item) {
        new AsyncTask<Proprietaire, Void, Void>() {
            @Override
            protected Void doInBackground(Proprietaire... proprietaires) {
                proprietaireDAO.insert(proprietaires[0]);
                return null;
            }
        }.execute(item);
    }


    @Override
    public LiveData<List<Proprietaire>> get() {
        return proprietaireDAO.get();
    }

    @Override
    public LiveData<Proprietaire> get(int id) {
        return proprietaireDAO.get(id);
    }

    @Override
    public LiveData<Proprietaire> authentification(String email, String mdp) {
        return proprietaireDAO.authentification(email, mdp);
    }

    @Override
    public void update(Proprietaire proprietaire) {
        new AsyncTask<Proprietaire, Void, Void>() {
            @Override
            protected Void doInBackground(Proprietaire... proprietaires) {
                proprietaireDAO.update(proprietaires[0]);
                return null;
            }
        }.execute(proprietaire);
    }

    @Override
    public void delete(Proprietaire proprietaire) {
        new AsyncTask<Proprietaire, Void, Void>() {
            @Override
            protected Void doInBackground(Proprietaire... proprietaires) {
                proprietaireDAO.delete(proprietaires[0]);
                return null;
            }
        }.execute(proprietaire);
    }

    @Override
    public void delete() {
        new AsyncTask<Void, Void, Void>() {

            @Override
            protected Void doInBackground(Void... voids) {
                proprietaireDAO.delete();
                return null;
            }
        }.execute();
    }
}
