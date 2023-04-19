package com.dami.tacoapp.mapper;

import com.dami.tacoapp.model.Ingredient;
import com.dami.tacoapp.model.Taco;
import com.dami.tacoapp.model.dto.TacoDto;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@UtilityClass
public class TacoMapper {
    public TacoDto map(Taco taco) {
        return Optional.ofNullable(taco)
                .map(t -> new TacoDto(t.getName(), getIngredientsCodes(t)))
                .orElse(null);
    }

    private static List<String> getIngredientsCodes(Taco taco) {
        return Optional.of(taco)
                .map(Taco::getIngredients)
                .map(i -> i.stream().map(TacoMapper::getIngredientCode).collect(Collectors.toList()))
                .orElse(List.of());
    }

    private static String getIngredientCode(Ingredient ingredient) {
        return Optional.of(ingredient)
                .map(Ingredient::getId)// TODO add ingredient code
                .orElse(null);
    }
}
