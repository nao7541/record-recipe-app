package com.example.record_recipe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.record_recipe.entity.RecipeEntity;

public interface RecipeRepository extends JpaRepository<RecipeEntity, Long> {
    
    @Query("SELECT r FROM RecipeEntity r WHERE r.name like :name")
    List<RecipeEntity> findByName(@Param("name") String name);
}
