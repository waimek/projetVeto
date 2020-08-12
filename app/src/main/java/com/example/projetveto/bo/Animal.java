package com.example.projetveto.bo;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(foreignKeys = {@ForeignKey(entity = RaceEspece.class,
        parentColumns = "idEspeceRace",
        childColumns = "idRaceEspece",
        onDelete = ForeignKey.CASCADE),
        @ForeignKey(entity = Proprietaire.class,
        parentColumns = "id",
        childColumns = "idProprietaire",
        onDelete = ForeignKey.CASCADE)})

public class Animal {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String nom;
    private Date dateNaissance;
<<<<<<< HEAD
    private String identifiantInternational;
    private int idRaceEspece;
    private int idProprietaire;
    private boolean puce;
    private boolean sterilise;

    public Animal(int id, String nom, Date dateNaissance, String identifiantInternational, int idRaceEspece, int idProprietaire, boolean puce, boolean sterilise) {
        this.id = id;
        this.nom = nom;
        this.dateNaissance = dateNaissance;
        this.identifiantInternational = identifiantInternational;
        this.idRaceEspece = idRaceEspece;
        this.idProprietaire = idProprietaire;
=======
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
>>>>>>> 8e8cf90d736742864810d2cb570d2c58ca490e58
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
        return this.identifiantInternational;
    }

    public void setIdentifiantInternational(String identifiantInternational) {
        this.identifiantInternational = identifiantInternational;
    }

    public int getIdRaceEspece() {
        return idRaceEspece;
    }

    public void setIdRaceEspece(int idRaceEspece) {
        this.idRaceEspece = idRaceEspece;
    }

    public int getIdProprietaire() {
        return idProprietaire;
    }

    public void setIdProprietaire(int idProprietaire) {
        this.idProprietaire = idProprietaire;
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

<<<<<<< HEAD
    public void setSterilise(boolean sterilise) {
        this.sterilise = sterilise;
=======
    public void setRaceEspece(RaceEspece raceEspece) {

        this.raceEspece = raceEspece;
>>>>>>> 8e8cf90d736742864810d2cb570d2c58ca490e58
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
<<<<<<< HEAD
                ", identifiantInternational='" + identifiantInternational + '\'' +
                ", idRaceEspece=" + idRaceEspece +
                ", idProprietaire=" + idProprietaire +
=======
                ", IdentifiantInternational='" + IdentifiantInternational + '\'' +
                ", raceEspece=" + raceEspece +
>>>>>>> 8e8cf90d736742864810d2cb570d2c58ca490e58
                ", puce=" + puce +
                ", sterilise=" + sterilise +
                '}';
    }
}
