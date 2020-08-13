package com.example.projetveto.activity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.projetveto.R;
import com.example.projetveto.bo.Animal;

import java.util.List;

public class AnimalAdapter extends ArrayAdapter<Animal> {
    IOnItemClickListener listener;
    public AnimalAdapter(@androidx.annotation.NonNull Context context, int resource, @androidx.annotation.NonNull List<Animal> objects) {
        super(context, resource, objects);
    }

    public void setListener(IOnItemClickListener listener) {
        this.listener = listener;
    }

    @androidx.annotation.NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //On décompresse le fichier style_ligne_utilisateur.xml
        LayoutInflater li = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View nouvelleLigne = li.inflate(R.layout.activity_infos_animaux_list,parent,false);
        final Animal animal = getItem(position);
        //On met les données dans la ligne

        TextView textViewNom = nouvelleLigne.findViewById(R.id.activity_infos_animaux_nom);
        textViewNom.setText(animal.getNom());

        TextView textViewNaissance = nouvelleLigne.findViewById(R.id.activity_infos_animaux_dateNaissance);
        textViewNaissance.setText(String.valueOf(animal.getDateNaissance()));

        TextView textViewEspece = nouvelleLigne.findViewById(R.id.activity_infos_animaux_espece);
        textViewEspece.setText(String.valueOf(animal.getIdEspece()));


        TextView textViewPuce = nouvelleLigne.findViewById(R.id.activity_infos_animaux_puce);
        textViewPuce.setText(String.valueOf(animal.isPuce()));

        TextView textViewSterilise = nouvelleLigne.findViewById(R.id.activity_infos_animaux_sterilise);
        textViewSterilise.setText(String.valueOf(animal.isSterilise()));

        Button buttonEdit = nouvelleLigne.findViewById(R.id.btn_edit);
        buttonEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onEditClick(animal);
            }
        });
        Button buttonDelete = nouvelleLigne.findViewById(R.id.btn_delete);
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onDeleteClick(animal);
            }
        });


        //On retourne la ligne
        return nouvelleLigne;
    }

    public interface IOnItemClickListener{
        void onEditClick(Animal animal);
        void onDeleteClick(Animal animal);
    }
}
