package com.dami.tacoapp.mapper;

import com.dami.tacoapp.model.dto.IngredientDto;
import lombok.experimental.UtilityClass;

import java.util.Optional;

@UtilityClass
public class IngredientMapper {
    public IngredientDto map(com.dami.tacoapp.model.Ingredient ingredient) {
        return Optional.ofNullable(ingredient)
                .map(i -> new IngredientDto(i.getName(), i.getType().toString()))
                .orElse(null);
    }
}
