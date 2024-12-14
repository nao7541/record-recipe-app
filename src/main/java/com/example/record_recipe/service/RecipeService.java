package com.example.record_recipe.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

import com.example.record_recipe.repository.RecipeRepository;
import com.example.record_recipe.util.NotFoundException;
import com.example.record_recipe.entity.RecipeEntity;
import com.example.record_recipe.dto.RecipeDTO;

@Service
@Transactional
public class RecipeService {

    @Autowired
    private RecipeRepository repository;

    // DBからレシピ一覧を取得するメソッド
    public List<RecipeDTO> findAll() {
        return repository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // DBからレシピを取得するメソッド
    public RecipeDTO findById(Long id) {
        RecipeEntity entity = repository.findById(id).orElseThrow(NotFoundException::new);
        return convertToDTO(entity);
    }

    // レシピを登録するメソッド
    public void register(RecipeDTO recipe) {
        RecipeEntity entity = convertToEntity(recipe);
        repository.save(entity);
    }

    // エンティティをDTOに変換するメソッド
    private RecipeDTO convertToDTO(RecipeEntity entity) {
        RecipeDTO dto = new RecipeDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setMainIngredient(entity.getMainIngredient());
        dto.setOtherIngredients(entity.getOtherIngredients());
        dto.setUrl(entity.getUrl());
        return dto;
    }

    // DTOをエンティティに変換するメソッド
    private RecipeEntity convertToEntity(RecipeDTO dto) {
        RecipeEntity entity = new RecipeEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setMainIngredient(dto.getMainIngredient());
        entity.setOtherIngredients(dto.getOtherIngredients());
        entity.setUrl(dto.getUrl());
        return entity;
    }
}
