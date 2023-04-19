package com.dami.tacoapp.repository;

import com.dami.tacoapp.model.Ingredient;
import org.springframework.data.repository.ListCrudRepository;

public interface IngredientRepository extends ListCrudRepository<Ingredient, String> {
}
