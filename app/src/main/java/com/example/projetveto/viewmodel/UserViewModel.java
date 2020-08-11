package com.example.projetveto.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.projetveto.bo.Animal;
import com.example.projetveto.bo.User;
import com.example.projetveto.repository.AnimalBDDRepo;
import com.example.projetveto.repository.AnimalRepository;
import com.example.projetveto.repository.UserBDDRepo;
import com.example.projetveto.repository.UserRepository;

import java.util.List;

public class UserViewModel extends AndroidViewModel {
    UserRepository repository;

    private LiveData<List<User>> observer = null;
    public UserViewModel(@NonNull Application application) {
        super(application);
        repository = new UserBDDRepo(application);
        observer = repository.get();
    }
    public LiveData<List<User>> get() {
        return observer;
    }

    public void insert(User user) {
        repository.insert(user);
    }

    public void update(User user) {

        /**
         * La ligne qui suit sert de passe-plat
         */
        repository.update(user);
    }

    public void delete(User user) {

        /**
         * La ligne qui suit sert de passe-plat
         */
        repository.delete(user);
    }

    void delete() {

    }
}
