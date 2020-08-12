package com.example.projetveto.dal;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.projetveto.bo.Animal;
import com.example.projetveto.bo.Consultation;
import com.example.projetveto.bo.Espece;
import com.example.projetveto.bo.Proprietaire;
import com.example.projetveto.bo.User;
import com.example.projetveto.bo.Veto;

@Database(entities = {Animal.class, Consultation.class, Espece.class, Proprietaire.class, User.class, Veto.class}, version = 1)
@TypeConverters({Converters.class})
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase INSTANCE;

//    public abstract ArticleDAO getArticleDAO();
    public abstract AnimalDAO getAnimalDAO();
    public abstract ConsultationDAO getConsultationDAO();
    public abstract EspeceDAO getEspeceDAO();
    public abstract ProprietaireDAO getProprietaireDAO();
    public abstract UserDAO getUserDAO();
    public abstract VetoDAO getVetoDAO();
    public static AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context, AppDatabase.class, "appdb.db").build();
        }
        return INSTANCE;
    }
}
