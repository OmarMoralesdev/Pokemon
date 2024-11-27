package com.example.requestapipokemon.response;

import com.example.requestapipokemon.models.habilidad;
import java.util.List;

public class habilidadReponse2 {
    private List<habilidad> effect_entries;

    public List<habilidad> getEffectEntries() {
        return effect_entries;
    }

    public void setEffectEntries(List<habilidad> effect_entries) {
        this.effect_entries = effect_entries;
    }
}
