package com.example.projetveto.bo;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.util.List;

@Entity(foreignKeys = {@ForeignKey(entity = Race.class,
        parentColumns = "id",
        childColumns = "idRace",
        onDelete = ForeignKey.CASCADE), @ForeignKey(entity = Espece.class, parentColumns = "id", childColumns = "idEspece", onDelete = ForeignKey.CASCADE)})
public class RaceEspece {
    @PrimaryKey(autoGenerate = true)
    private int idEspeceRace;
    private int idRace;
    private int idEspece;

    public RaceEspece(int idEspeceRace, int idRace, int idEspece) {
        this.idEspeceRace = idEspeceRace;
        this.idRace = idRace;
        this.idEspece = idEspece;
    }

    public int getIdEspeceRace() {
        return idEspeceRace;
    }

    public void setIdEspeceRace(int idEspeceRace) {
        this.idEspeceRace = idEspeceRace;
    }

    public int getIdRace() {
        return idRace;
    }

    public void setIdRace(int idRace) {
        this.idRace = idRace;
    }

    public int getIdEspece() {
        return idEspece;
    }

    public void setIdEspece(int idEspece) {
        this.idEspece = idEspece;
    }

    @Override
    public String toString() {
        return "RaceEspece{" +
                "idEspeceRace=" + idEspeceRace +
                ", idRace=" + idRace +
                ", idEspece=" + idEspece +
                '}';
    }
}
