package com.example.projetveto.bo;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.Entity;

@Entity
public class Proprietaire extends User implements Parcelable {


    public Proprietaire(String nom, String prenom, String adresse, String ville, String codePostal, String email, String mdp, String tel) {
        super(nom, prenom, adresse, ville, codePostal, email, mdp, tel);
    }


    public Proprietaire(Parcel in) {
        super(in);
    }

    @Override
    public String toString() {
        return super.toString()+"Proprietaire{" +
                '}';
    }


}
