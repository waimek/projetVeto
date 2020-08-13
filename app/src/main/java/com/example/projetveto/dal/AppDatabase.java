package com.example.projetveto.dal;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.projetveto.bo.Animal;
import com.example.projetveto.bo.Consultation;
import com.example.projetveto.bo.Espece;
import com.example.projetveto.bo.Proprietaire;
import com.example.projetveto.bo.User;
import com.example.projetveto.bo.Veto;

import java.util.Date;

@Database(entities = {Animal.class, Consultation.class, Espece.class, Proprietaire.class, User.class, Veto.class}, version = 1)
@TypeConverters({Converters.class})
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase INSTANCE;

    public abstract AnimalDAO getAnimalDAO();
    public abstract ConsultationDAO getConsultationDAO();
    public abstract EspeceDAO getEspeceDAO();
    public abstract ProprietaireDAO getProprietaireDAO();
    public abstract UserDAO getUserDAO();
    public abstract VetoDAO getVetoDAO();
    public static AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context, AppDatabase.class, "appdb.db").addCallback(roomCallBack).build();

        }
        return INSTANCE;
    }


    /**
     * Permet de remplir la base de données au moment de sa création.
     */
    private static Callback roomCallBack = new Callback()
    {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateBddAsync().execute(INSTANCE);
        }
    };

    /**
     * Contient le code qui insert dans la base de données de manière asynchrone.
     */
    private static class PopulateBddAsync extends AsyncTask<AppDatabase, Void, Void>
    {
        @Override
        protected Void doInBackground(AppDatabase... voids)
        {
            ProprietaireDAO dao2 = voids[0].getProprietaireDAO();
            dao2.insert(new Proprietaire("abc","abc","abc","abc","abc","abc","abc","abc"));
            VetoDAO dao = voids[0].getVetoDAO();
            dao.insert(new Veto("Allo","Kilo","Sandy","Allo","Allo","Allo","Allo","Allo","Allo",3f,5f));
            dao.insert(new Veto("Allo","Fonfec","Sophie","Allo","Allo","Allo","Allo","Allo","Allo",3f,5f));
            dao.insert(new Veto("Allo","Ception","Alex","Allo","Allo","Allo","Allo","Allo","Allo",3f,5f));
            dao.insert(new Veto("Allo","Descrepes","Yvan","Allo","Allo","Allo","Allo","Allo","Allo",3f,5f));
            dao.insert(new Veto("Allo","Terieur","Alex","Allo","Allo","Allo","Allo","Allo","Allo",3f,5f));

            ConsultationDAO dao1 = voids[0].getConsultationDAO();
            dao1.insert(new Consultation(new Date(),"Terieur",false, 1505121l,1,1));
            dao1.insert(new Consultation(new Date(),"Cosson",false, 1505121l,1,1));
            dao1.insert(new Consultation(new Date(),"Ly",false, 1505121l,1,1));
            dao1.insert(new Consultation(new Date(),"Tean",false, 1505121l,1,1));
            return null;
        }
    }
}
