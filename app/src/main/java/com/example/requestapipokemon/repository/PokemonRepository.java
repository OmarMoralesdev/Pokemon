package com.example.requestapipokemon.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.requestapipokemon.api.RetrofitClient;
import com.example.requestapipokemon.api.apiPokemon;
import com.example.requestapipokemon.models.Pokemon;
import com.example.requestapipokemon.response.Estructura;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PokemonRepository {
    private apiPokemon apiService;

    public PokemonRepository() {
        apiService = RetrofitClient.getInstance().getApi();
    }

    public LiveData<List<Pokemon>> getPokemonList() {
        MutableLiveData<List<Pokemon>> data = new MutableLiveData<>();
        apiService.getPokemon().enqueue(new Callback<Estructura>() {
            @Override
            public void onResponse(Call<Estructura> call, Response<Estructura> response) {
                if (response.isSuccessful() && response.body() != null) {
                    data.setValue(response.body().getResults());
                }
            }

            @Override
            public void onFailure(Call<Estructura> call, Throwable t) {
                data.setValue(null);
            }
        });
        return data;
    }
}