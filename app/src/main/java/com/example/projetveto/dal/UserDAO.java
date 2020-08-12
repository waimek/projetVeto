package com.example.projetveto.dal;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.projetveto.bo.User;

import java.util.List;

@Dao
public interface UserDAO {
    @Insert
    void insert(User item);

    @Insert
    void insert(User...items);

    @Query("SELECT * FROM User")
    LiveData<List<User>> get();

    @Query("SELECT * FROM User WHERE id = :id")
    List<User> get(int id);

    @Update
    void update(User user);

    @Delete
    void delete(User user);

    @Query("Delete FROM User")
    void delete();
}
