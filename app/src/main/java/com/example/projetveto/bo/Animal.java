package com.example.projetveto.bo;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.util.Date;
import java.util.List;

@Entity(foreignKeys = @ForeignKey(entity = RaceEspece.class,
        parentColumns = "idEspeceRace",
        childColumns = "raceEspece",
        onDelete = ForeignKey.CASCADE))
public class Animal {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String nom;
    private Date dateNaissance;
    private String IdentifiantInternational;
    private RaceEspece raceEspece;

    public Animal(int id, String nom, Date dateNaissance, String identifiantInternational, RaceEspece raceEspece) {
        this.id = id;
        this.nom = nom;
        this.dateNaissance = dateNaissance;
        IdentifiantInternational = identifiantInternational;
        this.raceEspece = raceEspece;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getIdentifiantInternational() {
        return IdentifiantInternational;
    }

    public void setIdentifiantInternational(String identifiantInternational) {
        IdentifiantInternational = identifiantInternational;
    }

    public RaceEspece getRaceEspece() {
        return raceEspece;
    }

    public void setRaceEspece(RaceEspece raceEspece) {
        this.raceEspece = raceEspece;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", dateNaissance=" + dateNaissance +
                ", IdentifiantInternational='" + IdentifiantInternational + '\'' +
                ", raceEspece=" + raceEspece +
                '}';
    }
}
