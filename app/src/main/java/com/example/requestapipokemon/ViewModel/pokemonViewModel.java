package com.example.requestapipokemon.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.requestapipokemon.models.Pokemon;
import com.example.requestapipokemon.repository.PokemonRepository;

import java.util.List;

public class pokemonViewModel extends ViewModel {

    private PokemonRepository repository;
    private LiveData<List<Pokemon>> pokemonList;

    public pokemonViewModel() {
        repository = new PokemonRepository();
        pokemonList = repository.getPokemonList();
    }

    public LiveData<List<Pokemon>> getPokemonList() {
        return pokemonList;
    }
}