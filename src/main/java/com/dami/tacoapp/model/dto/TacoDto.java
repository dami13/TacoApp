package com.dami.tacoapp.model.dto;

import java.util.List;

public record TacoDto(String name, List<String> ingredientsCodes) {}
