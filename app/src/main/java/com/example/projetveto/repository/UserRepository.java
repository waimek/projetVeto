package com.example.projetveto.repository;

import androidx.lifecycle.LiveData;

import com.example.projetveto.bo.User;
import com.example.projetveto.bo.Veto;

import java.util.List;

public interface UserRepository {
    void insert(User article);

    LiveData<List<User>> get();

    User get(int id);

    void update(User user);

    void delete(User user);

    void delete();
}
