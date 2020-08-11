package com.example.projetveto.bo;

import androidx.room.Entity;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

@Entity
public class Consultation {
    private int id;
    private Date dateHeure;
    private String remarques;
    private boolean passe;
    private Timestamp dureeRdv;

    public Consultation(int id, Date dateHeure, String remarques, boolean passe, Timestamp dureeRdv) {
        this.id = id;
        this.dateHeure = dateHeure;
        this.remarques = remarques;
        this.passe = passe;
        this.dureeRdv = dureeRdv;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateHeure() {
        return dateHeure;
    }

    public void setDateHeure(Date dateHeure) {
        this.dateHeure = dateHeure;
    }

    public String getRemarques() {
        return remarques;
    }

    public void setRemarques(String remarques) {
        this.remarques = remarques;
    }

    public boolean isPasse() {
        return passe;
    }

    public void setPasse(boolean passe) {
        this.passe = passe;
    }

    public Timestamp getDureeRdv() {
        return dureeRdv;
    }

    public void setDureeRdv(Timestamp dureeRdv) {
        this.dureeRdv = dureeRdv;
    }

    @Override
    public String toString() {
        return "Consultation{" +
                "id=" + id +
                ", dateHeure=" + dateHeure +
                ", remarques='" + remarques + '\'' +
                ", passe=" + passe +
                ", dureeRdv=" + dureeRdv +
                '}';
    }
}
