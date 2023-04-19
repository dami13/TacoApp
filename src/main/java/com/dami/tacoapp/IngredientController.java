package com.dami.tacoapp;

import com.dami.tacoapp.model.dto.IngredientDto;
import com.dami.tacoapp.service.IngredientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController()
@RequestMapping("/ingredients")
public class IngredientController {
    private final IngredientService ingredientService;

    @GetMapping
    public List<IngredientDto> getIngredients() {
        return ingredientService.getAllIngredients();
    }
}
