package com.example.projetveto.repository;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.projetveto.bo.Animal;
import com.example.projetveto.bo.Race;
import com.example.projetveto.dal.AnimalDAO;
import com.example.projetveto.dal.AppDatabase;
import com.example.projetveto.dal.RaceDAO;

import java.util.List;

public class RaceBDDRepo implements RaceRepository {
    private RaceDAO raceDAO;
    List<Race> results = null;

    public RaceBDDRepo(Context context) {
        AppDatabase MyDatabase = AppDatabase.getInstance(context);
        raceDAO = MyDatabase.getRaceDAO();
    }
    @Override
    public void insert(Race item) {
        new AsyncTask<Race, Void, Void>() {
            @Override
            protected Void doInBackground(Race... races) {
                raceDAO.insert(races[0]);
                return null;
            }
        }.execute(item);
    }


    @Override
    public LiveData<List<Race>> get() {
        return raceDAO.get();
    }

    @Override
    public Race get(int id) {
        return null;
    }


    @Override
    public void update(Race race) {
        new AsyncTask<Race, Void, Void>() {
            @Override
            protected Void doInBackground(Race... races) {
                raceDAO.update(races[0]);
                return null;
            }
        }.execute(race);
    }

    @Override
    public void delete(Race race) {
        new AsyncTask<Race, Void, Void>() {
            @Override
            protected Void doInBackground(Race... races) {
                raceDAO.delete(races[0]);
                return null;
            }
        }.execute(race);
    }

    @Override
    public void delete() {
        new AsyncTask<Void, Void, Void>() {

            @Override
            protected Void doInBackground(Void... voids) {
                raceDAO.delete();
                return null;
            }
        }.execute();
    }
}
