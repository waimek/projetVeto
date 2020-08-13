package com.example.projetveto.activity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.projetveto.R;
import com.example.projetveto.bo.Veto;

import java.util.List;

public class VetoAdapter extends ArrayAdapter<Veto> {

    public VetoAdapter(@androidx.annotation.NonNull Context context, int resource, @androidx.annotation.NonNull List<Veto> objects) {
        super(context, resource, objects);
    }

    @androidx.annotation.NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //On décompresse le fichier style_ligne_utilisateur.xml
        LayoutInflater li = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View nouvelleLigne = li.inflate(R.layout.activity_choix_veto_list,parent,false);

        //On met les données dans la ligne

        TextView textViewNom = nouvelleLigne.findViewById(R.id.txt_nom);
        textViewNom.setText(getItem(position).getNom());

        TextView textViewPrenom = nouvelleLigne.findViewById(R.id.txt_prenom);
        textViewPrenom.setText(String.valueOf(getItem(position).getPrenom()));

        TextView textViewTel = nouvelleLigne.findViewById(R.id.txt_tel);
        textViewTel.setText(String.valueOf(getItem(position).getId()));

        TextView textViewHeureDeb = nouvelleLigne.findViewById(R.id.txt_heureDeb);
        textViewHeureDeb.setText(String.valueOf(getItem(position).getHeureDebutTravail()));

        TextView textViewHeureFin = nouvelleLigne.findViewById(R.id.txt_heureFin);
        textViewHeureFin.setText(String.valueOf(getItem(position).getHeureFinTravail()));

        TextView textViewAdresse = nouvelleLigne.findViewById(R.id.txt_adresse);
        textViewAdresse.setText(String.valueOf(getItem(position).getAdresse()));

        TextView textViewVille = nouvelleLigne.findViewById(R.id.txt_ville);
        textViewVille.setText(String.valueOf(getItem(position).getVille()));
        //On retourne la ligne
        return nouvelleLigne;
    }
}
