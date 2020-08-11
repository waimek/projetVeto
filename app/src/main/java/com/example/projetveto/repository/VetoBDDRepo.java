package com.example.projetveto.repository;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.projetveto.bo.Animal;
import com.example.projetveto.bo.Veto;
import com.example.projetveto.dal.AnimalDAO;
import com.example.projetveto.dal.AppDatabase;
import com.example.projetveto.dal.VetoDAO;

import java.util.List;

public class VetoBDDRepo implements VetoRepository {
    private VetoDAO vetoDAO;
    List<Veto> results = null;

    public VetoBDDRepo(Context context) {
        AppDatabase MyDatabase = AppDatabase.getInstance(context);
        vetoDAO = MyDatabase.getVetoDAO();
    }
    @Override
    public void insert(Veto item) {
        new AsyncTask<Veto, Void, Void>() {
            @Override
            protected Void doInBackground(Veto... vetos) {
                vetoDAO.insert(vetos[0]);
                return null;
            }
        }.execute(item);
    }


    @Override
    public LiveData<List<Veto>> get() {
        return vetoDAO.get();
    }

    @Override
    public Veto get(int id) {
        return null;
    }


    @Override
    public void update(Veto veto) {
        new AsyncTask<Veto, Void, Void>() {
            @Override
            protected Void doInBackground(Veto... vetos) {
                vetoDAO.update(vetos[0]);
                return null;
            }
        }.execute(veto);
    }

    @Override
    public void delete(Veto veto) {
        new AsyncTask<Veto, Void, Void>() {
            @Override
            protected Void doInBackground(Veto... vetos) {
                vetoDAO.delete(vetos[0]);
                return null;
            }
        }.execute(veto);
    }

    @Override
    public void delete() {
        new AsyncTask<Void, Void, Void>() {

            @Override
            protected Void doInBackground(Void... voids) {
                vetoDAO.delete();
                return null;
            }
        }.execute();
    }
}
