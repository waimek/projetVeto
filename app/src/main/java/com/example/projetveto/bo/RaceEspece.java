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
    protected List<Race> idRace;
    private List<Espece> idEspece;

    public RaceEspece(int idEspeceRace, List<Race> idRace, List<Espece> idEspece) {
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

    public List<Race> getIdRace() {
        return idRace;
    }

    public void setIdRace(List<Race> idRace) {
        this.idRace = idRace;
    }

    public List<Espece> getIdEspece() {
        return idEspece;
    }

    public void setIdEspece(List<Espece> idEspece) {
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
