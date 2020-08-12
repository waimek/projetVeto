package com.example.projetveto.bo;

import androidx.room.Entity;
import androidx.room.Ignore;

@Entity
public class Proprietaire extends User {


    @Ignore
    public Proprietaire(int id, String nom, String prenom, String adresse, String ville, String codePostal, String email, String mdp) {
        super(id, nom, prenom, adresse, ville, codePostal, email, mdp);
    }

    public Proprietaire(int id, String nom, String prenom, String adresse, String ville, String codePostal, String email) {
        super(id, nom, prenom, adresse, ville, codePostal, email);
    }

    @Ignore
    public Proprietaire(String nom, String prenom, String adresse, String ville, String codePostal, String email, String mdp) {
        super(nom, prenom, adresse, ville, codePostal, email, mdp);
    }

    @Override
    public String toString() {
        return super.toString()+"Proprietaire{" +
                '}';
    }
}
