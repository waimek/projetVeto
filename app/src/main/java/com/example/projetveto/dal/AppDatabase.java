package com.example.projetveto.dal;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.projetveto.bo.Animal;
import com.example.projetveto.bo.Consultation;
import com.example.projetveto.bo.Espece;
import com.example.projetveto.bo.Proprietaire;
import com.example.projetveto.bo.Race;
import com.example.projetveto.bo.RaceEspece;
import com.example.projetveto.bo.User;
import com.example.projetveto.bo.Veto;

@Database(entities = {Animal.class, Consultation.class, Espece.class, Proprietaire.class, Race.class, RaceEspece.class, User.class, Veto.class}, exportSchema = false, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase INSTANCE;

//    public abstract ArticleDAO getArticleDAO();
    public abstract AnimalDAO getAnimalDAO();
    public abstract ConsultationDAO getConsultationDAO();
    public abstract EspeceDAO getEspeceDAO();
    public abstract ProprietaireDAO getProprietaireDAO();
    public abstract RaceDAO getRaceDAO();
    public abstract RaceEspeceDAO getRaceEspeceDAO();
    public abstract UserDAO getUserDAO();
    public abstract VetoDAO getVetoDAO();

    public static AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context, AppDatabase.class, "appdb.db").build();
        }
        return INSTANCE;
    }
}
