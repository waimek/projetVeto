package com.example.projetveto.bo;

import java.sql.Time;

public class Veto extends User{
    private String idVeto;
    private Time heureDebutTravail;
    private Time heureFinTravail;

    public Veto(int id, String nom, String prenom, String adresse, String ville, String codePostal, String email, String id1, Time heureDebutTravail, Time heureFinTravail) {
        super(id, nom, prenom, adresse, ville, codePostal, email);
        this.idVeto = idVeto;
        this.heureDebutTravail = heureDebutTravail;
        this.heureFinTravail = heureFinTravail;
    }

    public String getIdVeto() {
        return idVeto;
    }

    public void setIdVeto(String idVeto) {
        this.idVeto = idVeto;
    }

    public Time getHeureDebutTravail() {
        return heureDebutTravail;
    }

    public void setHeureDebutTravail(Time heureDebutTravail) {
        this.heureDebutTravail = heureDebutTravail;
    }

    public Time getHeureFinTravail() {
        return heureFinTravail;
    }

    public void setHeureFinTravail(Time heureFinTravail) {
        this.heureFinTravail = heureFinTravail;
    }

    @Override
    public String toString() {
        return "Veto{" +
                "idVeto='" + idVeto + '\'' +
                ", heureDebutTravail=" + heureDebutTravail +
                ", heureFinTravail=" + heureFinTravail +
                '}';
    }
}
