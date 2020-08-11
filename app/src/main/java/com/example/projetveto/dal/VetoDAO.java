package com.example.projetveto.dal;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.projetveto.bo.User;
import com.example.projetveto.bo.Veto;

import java.util.List;

@Dao
public interface VetoDAO {
    @Insert
    void insert(Veto item);

    @Insert
    void insert(Veto...items);

    @Query("SELECT * FROM Veto")
    LiveData<List<Veto>> get();

    @Query("SELECT * FROM Veto WHERE id = :id")
    List<Veto> get(int id);

    @Update
    void update(Veto veto);

    @Delete
    void delete(Veto veto);

    @Query("Delete FROM Veto")
    void delete();
}
