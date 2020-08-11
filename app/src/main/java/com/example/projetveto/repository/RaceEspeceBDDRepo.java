package com.example.projetveto.repository;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.projetveto.bo.Animal;
import com.example.projetveto.bo.RaceEspece;
import com.example.projetveto.dal.AnimalDAO;
import com.example.projetveto.dal.AppDatabase;
import com.example.projetveto.dal.RaceEspeceDAO;

import java.util.List;

public class RaceEspeceBDDRepo implements RaceEspeceRepository {
    private RaceEspeceDAO raceEspeceDAO;
    List<RaceEspece> results = null;

    public RaceEspeceBDDRepo(Context context) {
        AppDatabase MyDatabase = AppDatabase.getInstance(context);
        raceEspeceDAO = MyDatabase.getRaceEspeceDAO();
    }
    @Override
    public void insert(RaceEspece item) {
        new AsyncTask<RaceEspece, Void, Void>() {
            @Override
            protected Void doInBackground(RaceEspece... raceEspeces) {
                raceEspeceDAO.insert(raceEspeces[0]);
                return null;
            }
        }.execute(item);
    }


    @Override
    public LiveData<List<RaceEspece>> get() {
        return raceEspeceDAO.get();
    }

    @Override
    public RaceEspece get(int id) {
        return null;
    }


    @Override
    public void update(RaceEspece raceEspece) {
        new AsyncTask<RaceEspece, Void, Void>() {
            @Override
            protected Void doInBackground(RaceEspece... raceEspeces) {
                raceEspeceDAO.update(raceEspeces[0]);
                return null;
            }
        }.execute(raceEspece);
    }

    @Override
    public void delete(RaceEspece raceEspece) {
        new AsyncTask<RaceEspece, Void, Void>() {
            @Override
            protected Void doInBackground(RaceEspece... raceEspeces) {
                raceEspeceDAO.delete(raceEspeces[0]);
                return null;
            }
        }.execute(raceEspece);
    }

    @Override
    public void delete() {
        new AsyncTask<Void, Void, Void>() {

            @Override
            protected Void doInBackground(Void... voids) {
                raceEspeceDAO.delete();
                return null;
            }
        }.execute();
    }
}
