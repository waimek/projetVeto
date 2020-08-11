package com.example.projetveto.bo;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.sql.Time;

@Entity(foreignKeys = @ForeignKey(entity = Consultation.class,
        parentColumns = "id",
        childColumns = "idConsultation",
        onDelete = ForeignKey.CASCADE))
public class Veto extends User {
    @PrimaryKey(autoGenerate = true)
    private String idVeto;
    private Time heureDebutTravail;
    private Time heureFinTravail;
    private Consultation idConsultation;

    public Veto(int id, String nom, String prenom, String adresse, String ville, String codePostal, String email, String id1, Time heureDebutTravail, Time heureFinTravail, Consultation idConsultation) {
        super(id, nom, prenom, adresse, ville, codePostal, email);
        this.idConsultation = idConsultation;
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

    public Consultation getIdConsultation() {
        return idConsultation;
    }

    public void setIdConsultation(Consultation idConsultation) {
        this.idConsultation = idConsultation;
    }

    @Override
    public String toString() {
        return "Veto{" +
                "idVeto='" + idVeto + '\'' +
                ", heureDebutTravail=" + heureDebutTravail +
                ", heureFinTravail=" + heureFinTravail +
                ", idConsultation=" + idConsultation +
                '}';
    }
}
