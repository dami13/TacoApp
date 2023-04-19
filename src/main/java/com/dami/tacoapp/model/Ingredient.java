package com.dami.tacoapp.model;

import com.dami.tacoapp.model.dto.IngredientDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class Ingredient {
    @Id
    @GeneratedValue
    private String id;
    @NotBlank(message = "Ingredient name is required")
    private String name;
    @NotNull(message = "Ingredient type is required")
    private Type type;

    public enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }

    public Ingredient from(IngredientDto dto) {
        this.name = dto.name();
        this.type = Type.valueOf(dto.typeCode());
        return this;
    }
}
