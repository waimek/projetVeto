package com.example.projetveto.bo;

import androidx.room.Entity;

@Entity
public class Veto extends User {

    private String idVeto;
    private Float heureDebutTravail;
    private Float heureFinTravail;


    public Veto(String nom, String prenom, String adresse, String ville, String codePostal, String email, String mdp, String tel, String idVeto, Float heureDebutTravail, Float heureFinTravail) {
        super(nom, prenom, adresse, ville, codePostal, email, mdp, tel);
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

    public Float getHeureDebutTravail() {
        return heureDebutTravail;
    }

    public void setHeureDebutTravail(Float heureDebutTravail) {
        this.heureDebutTravail = heureDebutTravail;
    }

    public Float getHeureFinTravail() {
        return heureFinTravail;
    }

    public void setHeureFinTravail(Float heureFinTravail) {
        this.heureFinTravail = heureFinTravail;
    }

    @Override
    public String toString() {
        return super.toString()+"Veto{" +
                "idVeto='" + idVeto + '\'' +
                ", heureDebutTravail=" + heureDebutTravail +
                ", heureFinTravail=" + heureFinTravail +
                '}';
    }
}
