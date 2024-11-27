package com.example.requestapipokemon.api;

import com.example.requestapipokemon.models.Pokemon;
import com.example.requestapipokemon.response.Estructura;
import com.example.requestapipokemon.response.habilidadReponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.Path;

public interface apiPokemon {
    @GET("pokemon?limit=10&offset=0")
    Call<Estructura> getPokemon();

    @GET("ability/{id}")
    Call<habilidadReponse> getAbilityById(@Path("id") Integer id);
}
