package com.example.record_recipe.dto;

import lombok.Data;

@Data
public class RecipeDTO {
    private Long id;
    private String name;
    private String mainIngredient;
    private String[] otherIngredients;
    private String url;
}
