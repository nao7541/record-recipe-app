package com.example.record_recipe.form;

import com.example.record_recipe.dto.RecipeDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RecipeForm(
    @NotBlank
    @Size(max = 255, message = "255文字以内で入力してください")
    String name,
    @NotBlank
    @Size(max = 255, message = "255文字以内で入力してください")
    String mainIngredient,
    @Size(max = 255, message = "255文字以内で入力してください")
    String[] otherIngredients,
    @NotBlank
    @Size(max = 255, message = "255文字以内で入力してください")
    String url
) {
    // DTOクラスに変換
    public RecipeDTO toDTO() {
        // 明示的なコンストラクタを定義していないため、引数を入れられないので空で作成する
        RecipeDTO recipeDTO = new RecipeDTO();

        recipeDTO.setId(null);
        recipeDTO.setName(this.name);
        recipeDTO.setMainIngredient(this.mainIngredient);
        recipeDTO.setOtherIngredients(this.otherIngredients);
        recipeDTO.setUrl(this.url);

        return recipeDTO;
    }
}
