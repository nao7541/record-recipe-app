package com.example.record_recipe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.record_recipe.entity.RecipeEntity;

public interface RecipeRepository extends JpaRepository<RecipeEntity, Long> {
    
}
