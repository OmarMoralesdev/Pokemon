package com.example.requestapipokemon.response;

import java.util.List;

public class habilidadReponse {
    private List<habilidadReponse2> effect_changes;

    public List<habilidadReponse2> getEffectEntries() {
        return effect_changes;
    }

    public void setEffectEntries(List<habilidadReponse2> effect_entries) {
        this.effect_changes = effect_entries;
    }
}
