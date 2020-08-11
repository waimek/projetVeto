package com.example.projetveto.dal;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.projetveto.bo.Consultation;

import java.util.List;

@Dao
public interface ConsultationDAO {
    @Insert
    void insert(Consultation item);

    @Insert
    void insert(Consultation...items);

    @Query("SELECT * FROM Consultation")
    LiveData<List<Consultation>> get();

    @Query("SELECT * FROM Consultation WHERE id = :id")
    List<Consultation> get(int id);

    @Update
    void update(Consultation consultation);

    @Delete
    void delete(Consultation consultation);

    @Query("Delete FROM Consultation")
    void delete();
}
