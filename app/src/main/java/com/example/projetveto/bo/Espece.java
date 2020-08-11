package com.example.projetveto.bo;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Espece {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String nomEspece;

    public Espece(int id, String nomEspece) {
        this.id = id;
        this.nomEspece = nomEspece;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
                "id=" + id +
                ", nomEspece='" + nomEspece + '\'' +
                '}';
    }
}
