package com.dami.tacoapp.service;

import com.dami.tacoapp.mapper.IngredientMapper;
import com.dami.tacoapp.model.Ingredient;
import com.dami.tacoapp.model.dto.IngredientDto;
import com.dami.tacoapp.repository.IngredientRepository;
import jakarta.validation.constraints.NotNull;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class IngredientService {
    private final IngredientRepository ingredientRepository;
    public List<IngredientDto> getAllIngredients() {
        return ingredientRepository.findAll().stream()
                .map(IngredientMapper::map)
                .collect(Collectors.toList());
    }
    public void addIngredient(@NotNull @NonNull IngredientDto ingredientDto) {
        ingredientRepository.save(new Ingredient().from(ingredientDto));
    }

    public void removeIngredient(@NotNull @NonNull String ingredientId) {
        ingredientRepository.deleteById(ingredientId);
    }
}
