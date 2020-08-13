package com.example.projetveto.dal;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.projetveto.bo.Animal;

import java.util.List;

@Dao
public interface AnimalDAO {
    @Insert
    void insert(Animal item);

    @Insert
    void insert(Animal...items);

    @Query("SELECT * FROM Animal WHERE idProprietaire = :idProprietaire")
    List<Animal> get(int idProprietaire);

    @Query("SELECT * FROM Animal")
    LiveData<List<Animal>> get();
//
//    @Query("SELECT * FROM Animal WHERE id = :id")
//    List<Animal> get(int id);

    @Update
    void update(Animal animal);

    @Delete
    void delete(Animal animal);

    @Query("Delete FROM Animal")
    void delete();
}
