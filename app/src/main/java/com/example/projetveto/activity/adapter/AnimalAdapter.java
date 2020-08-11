package com.example.projetveto.activity.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.projetveto.R;
import com.example.projetveto.bo.Animal;

import java.util.List;

public class AnimalAdapter extends ArrayAdapter<Animal> {

    public AnimalAdapter(@androidx.annotation.NonNull Context context, int resource, @androidx.annotation.NonNull List<Animal> objects) {
        super(context, resource, objects);
    }

    @androidx.annotation.NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //On décompresse le fichier style_ligne_utilisateur.xml
        LayoutInflater li = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View nouvelleLigne = li.inflate(R.layout.activity_infos_animaux_list,parent,false);

        //On met les données dans la ligne

        TextView textViewNom = nouvelleLigne.findViewById(R.id.activity_infos_animaux_nom);
        textViewNom.setText(getItem(position).getNom());

        TextView textViewNaissance = nouvelleLigne.findViewById(R.id.activity_infos_animaux_dateNaissance);
        textViewNaissance.setText(String.valueOf(getItem(position).getDateNaissance()));

        TextView textViewEspece = nouvelleLigne.findViewById(R.id.activity_infos_animaux_espece);
        textViewEspece.setText(String.valueOf(getItem(position).getRaceEspece().getIdEspece()));

        TextView textViewRace = nouvelleLigne.findViewById(R.id.activity_infos_animaux_race);
        textViewRace.setText(String.valueOf(getItem(position).getRaceEspece().getIdRace()));

        TextView textViewPuce = nouvelleLigne.findViewById(R.id.activity_infos_animaux_puce);
        textViewPuce.setText(String.valueOf(getItem(position).isPuce()));

        TextView textViewSterilise = nouvelleLigne.findViewById(R.id.activity_infos_animaux_sterilise);
        textViewSterilise.setText(String.valueOf(getItem(position).isSterilise()));

        //On retourne la ligne
        return nouvelleLigne;
    }
}
