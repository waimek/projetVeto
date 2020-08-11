package com.example.projetveto.bo;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.util.List;
@Entity(foreignKeys = @ForeignKey(entity = Animal.class,
        parentColumns = "id",
        childColumns = "animals",
        onDelete = ForeignKey.CASCADE))
public class Proprietaire extends User {
    @PrimaryKey(autoGenerate = true)
    private String idProprietaire;
    private List<Animal> animals;

    public Proprietaire(int id, String nom, String prenom, String adresse, String ville, String codePostal, String email, String idProprietaire, List<Animal> animals) {
        super(id, nom, prenom, adresse, ville, codePostal, email);
        this.idProprietaire = idProprietaire;
        this.animals = animals;
    }

    public String getIdProprietaire() {
        return idProprietaire;
    }

    public void setIdProprietaire(String idProprietaire) {
        this.idProprietaire = idProprietaire;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    @Override
    public String toString() {
        return "Proprietaire{" +
                "idProprietaire='" + idProprietaire + '\'' +
                ", animals=" + animals +
                '}';
    }
}
