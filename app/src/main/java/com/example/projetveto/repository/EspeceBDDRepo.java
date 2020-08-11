package com.example.projetveto.repository;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.projetveto.bo.Animal;
import com.example.projetveto.bo.Espece;
import com.example.projetveto.dal.AnimalDAO;
import com.example.projetveto.dal.AppDatabase;
import com.example.projetveto.dal.EspeceDAO;

import java.util.List;

public class EspeceBDDRepo implements EspeceRepository {
    private EspeceDAO especeDAO;
    List<Espece> results = null;

    public EspeceBDDRepo(Context context) {
        AppDatabase MyDatabase = AppDatabase.getInstance(context);
        especeDAO = MyDatabase.getEspeceDAO();
    }
    @Override
    public void insert(Espece item) {
        new AsyncTask<Espece, Void, Void>() {
            @Override
            protected Void doInBackground(Espece... especes) {
                especeDAO.insert(especes[0]);
                return null;
            }
        }.execute(item);
    }


    @Override
    public LiveData<List<Espece>> get() {
        return especeDAO.get();
    }

    @Override
    public Espece get(int id) {
        return null;
    }


    @Override
    public void update(Espece espece) {
        new AsyncTask<Espece, Void, Void>() {
            @Override
            protected Void doInBackground(Espece... especes) {
                especeDAO.update(especes[0]);
                return null;
            }
        }.execute(espece);
    }

    @Override
    public void delete(Espece espece) {
        new AsyncTask<Espece, Void, Void>() {
            @Override
            protected Void doInBackground(Espece... especes) {
                especeDAO.delete(especes[0]);
                return null;
            }
        }.execute(espece);
    }

    @Override
    public void delete() {
        new AsyncTask<Void, Void, Void>() {

            @Override
            protected Void doInBackground(Void... voids) {
                especeDAO.delete();
                return null;
            }
        }.execute();
    }
}
