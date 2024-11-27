package com.example.requestapipokemon.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.requestapipokemon.Habilidades;
import com.example.requestapipokemon.R;
import com.example.requestapipokemon.models.Pokemon;
import com.example.requestapipokemon.models.habilidad;

import java.util.List;

public class adaptadorHablilidades extends RecyclerView.Adapter<adaptadorHablilidades.ViewHolder> {

    List<habilidad> habilidades;

    public adaptadorHablilidades(List<habilidad> habilidades) {
        this.habilidades = habilidades;
    }

    @Override
    public adaptadorHablilidades.ViewHolder onCreateViewHolder(android.view.ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.hablidadesry, parent, false);

        return new adaptadorHablilidades.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(adaptadorHablilidades.ViewHolder holder, int position) {
        habilidad habilidad = habilidades.get(position);
        holder.setData(habilidad);
    }

    @Override
    public int getItemCount() {
        return habilidades.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView  habilidad;
        Pokemon pokemon;
        habilidad habilidades;
        public ViewHolder(android.view.View itemView) {
            super(itemView);
            habilidad = itemView.findViewById(R.id.abilityDescription);


        }

        public void setData(habilidad habilidades) {
            this.habilidades = habilidades;
            habilidad.setText(habilidades.getEffect());

        }
    }


}
