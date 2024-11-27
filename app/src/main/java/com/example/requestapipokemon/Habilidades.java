package com.example.requestapipokemon;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.requestapipokemon.adapters.adaptadorHablilidades;
import com.example.requestapipokemon.api.RetrofitClient;
import com.example.requestapipokemon.api.apiPokemon;
import com.example.requestapipokemon.models.Pokemon;
import com.example.requestapipokemon.models.habilidad;
import com.example.requestapipokemon.response.habilidadReponse;
import com.example.requestapipokemon.response.habilidadReponse2;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Habilidades extends AppCompatActivity {

    private RecyclerView recyclerViewHabilidades;
    private adaptadorHablilidades adapter;
    private List<habilidad> habilidadesList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_habilidades);

        recyclerViewHabilidades = findViewById(R.id.recyclerViewHabilidades);
        recyclerViewHabilidades.setLayoutManager(new LinearLayoutManager(this));
        adapter = new adaptadorHablilidades(habilidadesList);
        recyclerViewHabilidades.setAdapter(adapter);

        Pokemon pokemon = (Pokemon) getIntent().getSerializableExtra("pokemon");

        if (pokemon != null) {
            Integer id = pokemon.getId2();
            TextView txtHabilidades = findViewById(R.id.textView);

            apiPokemon apiService = RetrofitClient.getInstance().getApi();
            Call<habilidadReponse> call = apiService.getAbilityById(id);

            call.enqueue(new Callback<habilidadReponse>() {
                @Override
                public void onResponse(Call<habilidadReponse> call, Response<habilidadReponse> response) {
                    if (response.isSuccessful() && response.body() != null) {
                        List<habilidadReponse2> effectEntries = response.body().getEffectEntries();
                        habilidadesList.clear();

                        for (habilidadReponse2 entry : effectEntries) {
                            habilidadesList.addAll(entry.getEffectEntries());
                        }

                        adapter.notifyDataSetChanged();
                    } else {
                        txtHabilidades.setText("Error al obtener habilidades");
                    }
                }

                @Override
                public void onFailure(Call<habilidadReponse> call, Throwable t) {
                    txtHabilidades.setText("Error en la llamada: " + t.getMessage());
                    Log.e("Habilidades", "Error en la llamada a la API", t);
                }
            });
        } else {
            Log.e("Habilidades", "Objeto Pokémon no recibido");
        }
    }
}