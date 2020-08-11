package com.example.projetveto.repository;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.projetveto.bo.Animal;
import com.example.projetveto.bo.User;
import com.example.projetveto.dal.AnimalDAO;
import com.example.projetveto.dal.AppDatabase;
import com.example.projetveto.dal.UserDAO;

import java.util.List;

public class UserBDDRepo implements UserRepository {
    private UserDAO userDAO;
    List<User> results = null;

    public UserBDDRepo(Context context) {
        AppDatabase MyDatabase = AppDatabase.getInstance(context);
        userDAO = MyDatabase.getUserDAO();
    }
    @Override
    public void insert(User item) {
        new AsyncTask<User, Void, Void>() {
            @Override
            protected Void doInBackground(User... users) {
                userDAO.insert(users[0]);
                return null;
            }
        }.execute(item);
    }


    @Override
    public LiveData<List<User>> get() {
        return userDAO.get();
    }

    @Override
    public User get(int id) {
        return null;
    }


    @Override
    public void update(User user) {
        new AsyncTask<User, Void, Void>() {
            @Override
            protected Void doInBackground(User... users) {
                userDAO.update(users[0]);
                return null;
            }
        }.execute(user);
    }

    @Override
    public void delete(User user) {
        new AsyncTask<User, Void, Void>() {
            @Override
            protected Void doInBackground(User... users) {
                userDAO.delete(users[0]);
                return null;
            }
        }.execute(user);
    }

    @Override
    public void delete() {
        new AsyncTask<Void, Void, Void>() {

            @Override
            protected Void doInBackground(Void... voids) {
                userDAO.delete();
                return null;
            }
        }.execute();
    }
}
