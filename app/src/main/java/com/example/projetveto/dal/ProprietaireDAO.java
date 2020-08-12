package com.example.projetveto.dal;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.projetveto.bo.Proprietaire;

import java.util.List;

@Dao
public interface ProprietaireDAO {
    @Insert
    void insert(Proprietaire item);

    @Insert
    void insert(Proprietaire...items);

    @Query("SELECT * FROM Proprietaire")
    LiveData<List<Proprietaire>> get();

    @Query("SELECT * FROM Proprietaire WHERE id = :id")
    LiveData<Proprietaire> get(int id);

    @Query("SELECT * FROM Proprietaire WHERE email = :email and mdp= :mdp")
    LiveData<Proprietaire> authentification(String email, String mdp);

    @Update
    void update(Proprietaire proprietaire);

    @Delete
    void delete(Proprietaire proprietaire);

    @Query("Delete FROM Proprietaire")
    void delete();
}
