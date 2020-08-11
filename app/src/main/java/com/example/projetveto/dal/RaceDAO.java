package com.example.projetveto.dal;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.projetveto.bo.Proprietaire;
import com.example.projetveto.bo.Race;

import java.util.List;

@Dao
public interface RaceDAO {
    @Insert
    void insert(Race item);

    @Insert
    void insert(Race...items);

    @Query("SELECT * FROM Race")
    LiveData<List<Race>> get();

    @Query("SELECT * FROM Race WHERE id = :id")
    List<Race> get(int id);

    @Update
    void update(Race race);

    @Delete
    void delete(Race race);

    @Query("Delete FROM Proprietaire")
    void delete();
}
