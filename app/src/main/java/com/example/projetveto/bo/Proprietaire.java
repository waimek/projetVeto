package com.example.projetveto.bo;

import androidx.room.Entity;

@Entity
public class Proprietaire extends User {


    public Proprietaire(int id, String nom, String prenom, String adresse, String ville, String codePostal, String email) {
        super(id, nom, prenom, adresse, ville, codePostal, email);

    }


    @Override
    public String toString() {
        return super.toString()+"Proprietaire{" +
                '}';
    }
}
