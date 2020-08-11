package com.example.projetveto.bo;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.util.Date;

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
    private boolean puce;
    private boolean sterilise;

    public Animal(int id, String nom, Date dateNaissance, String identifiantInternational, RaceEspece raceEspece, boolean puce, boolean sterilise) {
        this.id = id;
        this.nom = nom;
        this.dateNaissance = dateNaissance;
        IdentifiantInternational = identifiantInternational;
        this.raceEspece = raceEspece;
        this.puce = puce;
        this.sterilise = sterilise;
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

    public boolean isPuce() {
        return puce;
    }

    public void setPuce(boolean puce) {
        this.puce = puce;
    }

    public boolean isSterilise() {
        return sterilise;
    }

    public void setSterilise(boolean sterilise) {
        this.sterilise = sterilise;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", dateNaissance=" + dateNaissance +
                ", IdentifiantInternational='" + IdentifiantInternational + '\'' +
                ", raceEspece=" + raceEspece +
                ", puce=" + puce +
                ", sterilise=" + sterilise +
                '}';
    }
}
