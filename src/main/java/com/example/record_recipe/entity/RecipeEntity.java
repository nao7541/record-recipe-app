package com.example.record_recipe.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "recipe")
public class RecipeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "main_ingredient")
    private String mainIngredient;

    @Column(name = "other_ingredients")
    private String[] otherIngredients;

    @Column(name = "url")
    private String url;
}
