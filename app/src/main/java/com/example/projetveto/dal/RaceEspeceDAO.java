package com.example.projetveto.dal;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.projetveto.bo.RaceEspece;
import com.example.projetveto.bo.Veto;

import java.util.List;

@Dao
public interface RaceEspeceDAO {
    @Insert
    void insert(RaceEspece item);

    @Insert
    void insert(RaceEspece...items);

    @Query("SELECT * FROM RaceEspece")
    LiveData<List<RaceEspece>> get();

    @Query("SELECT * FROM RaceEspece WHERE idEspeceRace = :idEspeceRace")
    List<RaceEspece> get(int idEspeceRace);

    @Update
    void update(RaceEspece raceEspece);

    @Delete
    void delete(RaceEspece raceEspece);

    @Query("Delete FROM RaceEspece")
    void delete();
}
