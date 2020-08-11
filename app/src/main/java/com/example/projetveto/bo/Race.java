package com.example.projetveto.bo;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Race {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String nomRace;

    public Race(int id, String nomRace) {
        this.id = id;
        this.nomRace = nomRace;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomRace() {
        return nomRace;
    }

    public void setNomRace(String nomRace) {
        this.nomRace = nomRace;
    }

    @Override
    public String toString() {
        return "Race{" +
                "id=" + id +
                ", nomRace='" + nomRace + '\'' +
                '}';
    }
}
