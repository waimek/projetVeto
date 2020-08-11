package com.example.projetveto.bo;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.sql.Timestamp;
import java.util.Date;

@Entity(foreignKeys = @ForeignKey(entity = Veto.class,
        parentColumns = "id",
        childColumns = "idVeto",
        onDelete = ForeignKey.CASCADE))
public class Consultation {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private Date dateHeure;
    private String remarques;
    private boolean passe;
    private Long dureeRdv;
    private int idVeto;

    public Consultation(int id, Date dateHeure, String remarques, boolean passe, Long dureeRdv, int idVeto) {
        this.id = id;
        this.dateHeure = dateHeure;
        this.remarques = remarques;
        this.passe = passe;
        this.dureeRdv = dureeRdv;
        this.idVeto = idVeto;
    }

    public int getIdVeto() {
        return idVeto;
    }

    public void setIdVeto(int idVeto) {
        this.idVeto = idVeto;
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

    public Long getDureeRdv() {
        return dureeRdv;
    }

    public void setDureeRdv(Long dureeRdv) {
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
