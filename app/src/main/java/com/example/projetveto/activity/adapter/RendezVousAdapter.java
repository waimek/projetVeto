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
import com.example.projetveto.bo.Consultation;

import java.util.List;

public class RendezVousAdapter extends ArrayAdapter<Consultation> {


    public RendezVousAdapter(@androidx.annotation.NonNull Context context, int resource, @androidx.annotation.NonNull List<Consultation> objects) {
        super(context, resource, objects);
    }


    @androidx.annotation.NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //On décompresse le fichier style_ligne_utilisateur.xml
        LayoutInflater li = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View nouvelleLigne = li.inflate(R.layout.activity_rendez_vous_list,parent,false);

        //On met les données dans la ligne

        TextView textViewDate = nouvelleLigne.findViewById(R.id.txt_date_heure);
        textViewDate.setText(getItem(position).getDateHeure().toString());


        return nouvelleLigne;
    }
}
