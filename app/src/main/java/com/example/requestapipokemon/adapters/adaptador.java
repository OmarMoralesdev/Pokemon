package com.example.requestapipokemon.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.requestapipokemon.Habilidades;
import com.example.requestapipokemon.R;
import com.example.requestapipokemon.models.Pokemon;
import com.example.requestapipokemon.models.habilidad;
import com.squareup.picasso.Picasso;

import java.util.List;

public class adaptador extends RecyclerView.Adapter<adaptador.ViewHolder> {

    List<Pokemon> pokemons;
    public adaptador(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtNombre, txtUrl;
        ImageView imgPokemon;
        Pokemon pokemon;
        public ViewHolder(android.view.View itemView) {
            super(itemView);
            txtNombre = itemView.findViewById(R.id.txtNombre);
            imgPokemon = itemView.findViewById(R.id.imgFoto);

            txtNombre.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), Habilidades.class);
                    intent.putExtra("pokemon", pokemon);
                    v.getContext().startActivity(intent);
                }
            });
        }

            public void setData(Pokemon pokemon) {
               this.pokemon = pokemon;
                txtNombre.setText(pokemon.getName());
                Picasso.get().load(pokemon.getId()).into(imgPokemon);

            }
    }

    @Override
    public adaptador.ViewHolder onCreateViewHolder(android.view.ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.recycleview, parent, false);
        return new adaptador.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(adaptador.ViewHolder holder, int position) {
        Pokemon pokemon = pokemons.get(position);
        holder.setData(pokemon);

    }

    @Override
    public int getItemCount() {
        return pokemons.size();
    }
}
