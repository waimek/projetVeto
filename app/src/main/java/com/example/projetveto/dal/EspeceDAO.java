package com.example.projetveto.dal;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.projetveto.bo.Espece;

import java.util.List;

@Dao
public interface EspeceDAO {
    @Insert
    void insert(Espece item);

    @Insert
    void insert(Espece...items);

    @Query("SELECT * FROM Espece")
    LiveData<List<Espece>> get();

    @Query("SELECT * FROM Espece WHERE idEspece = :id")
    List<Espece> get(int id);

    @Update
    void update(Espece espece);

    @Delete
    void delete(Espece espece);

    @Query("Delete FROM Espece")
    void delete();
}
