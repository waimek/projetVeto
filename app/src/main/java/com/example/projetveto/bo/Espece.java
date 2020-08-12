package com.example.projetveto.bo;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Espece {
    @PrimaryKey(autoGenerate = true)
    private int idEspece;
    private String nomEspece;

    public Espece(int idEspece, String nomEspece) {
        this.idEspece = idEspece;
        this.nomEspece = nomEspece;
    }

    public int getIdEspece() {
        return idEspece;
    }

    public void setIdEspece(int idEspece) {
        this.idEspece = idEspece;
    }

    public String getNomEspece() {
        return nomEspece;
    }

    public void setNomEspece(String nomEspece) {
        this.nomEspece = nomEspece;
    }

    @Override
    public String toString() {
        return "Espece{" +
                "idEspece=" + idEspece +
                ", nomEspece='" + nomEspece + '\'' +
                '}';
    }
}
