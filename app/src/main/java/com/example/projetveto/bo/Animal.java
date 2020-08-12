package com.example.projetveto.bo;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(foreignKeys = @ForeignKey(entity = Espece.class,
        parentColumns = "idEspece",
        childColumns = "idEspece",
        onDelete = ForeignKey.CASCADE))

public class Animal implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String nom;
    private Date dateNaissance;
    private String identifiantInternational;
    private int idEspece;
    private int idProprietaire;
    private boolean puce;
    private boolean sterilise;

    public Animal(int id, String nom, Date dateNaissance, String identifiantInternational, int idEspece, int idProprietaire, boolean puce, boolean sterilise) {
        this.id = id;
        this.nom = nom;
        this.dateNaissance = dateNaissance;
        this.identifiantInternational = identifiantInternational;
        this.idEspece = idEspece;
        this.idProprietaire = idProprietaire;
        this.puce = puce;
        this.sterilise = sterilise;
    }

    protected Animal(Parcel in) {
        id = in.readInt();
        nom = in.readString();
        identifiantInternational = in.readString();
        idEspece = in.readInt();
        idProprietaire = in.readInt();
        puce = in.readByte() != 0;
        sterilise = in.readByte() != 0;
    }

    public Animal(String nom, Date naissance, int idEspece, int idProprietaire, boolean puce, boolean sterilise) {
        this.nom = nom;
        this.dateNaissance = naissance;
        this.idEspece = idEspece;
        this.idProprietaire = idProprietaire;
        this.puce = puce;
        this.sterilise = sterilise;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(nom);
        dest.writeString(identifiantInternational);
        dest.writeInt(idEspece);
        dest.writeInt(idProprietaire);
        dest.writeByte((byte) (puce ? 1 : 0));
        dest.writeByte((byte) (sterilise ? 1 : 0));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Animal> CREATOR = new Creator<Animal>() {
        @Override
        public Animal createFromParcel(Parcel in) {
            return new Animal(in);
        }

        @Override
        public Animal[] newArray(int size) {
            return new Animal[size];
        }
    };

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
        return identifiantInternational;
    }

    public void setIdentifiantInternational(String identifiantInternational) {
        this.identifiantInternational = identifiantInternational;
    }

    public int getIdEspece() {
        return idEspece;
    }

    public void setIdEspece(int idEspece) {
        this.idEspece = idEspece;
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

    public void setSterilise(boolean sterilise) {
        this.sterilise = sterilise;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", dateNaissance=" + dateNaissance +
                ", identifiantInternational='" + identifiantInternational + '\'' +
                ", idEspece=" + idEspece +
                ", idProprietaire=" + idProprietaire +
                ", puce=" + puce +
                ", sterilise=" + sterilise +
                '}';
    }
}
