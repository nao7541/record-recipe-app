package com.example.record_recipe.form;

import com.example.record_recipe.dto.RecipeDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.List;

public record RecipeForm(
    @NotBlank
    @Size(max = 255, message = "255文字以内で入力してください")
    String name,
    @NotBlank
    @Size(max = 255, message = "255文字以内で入力してください")
    String mainIngredient,
    @Size(max = 255, message = "255文字以内で入力してください")
    List<String> otherIngredients,
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
        recipeDTO.setOtherIngredients(
            this.otherIngredients != null
                ? this.otherIngredients.toArray(new String[0])
                : new String[0]
        );
        recipeDTO.setUrl(this.url);

        return recipeDTO;
    }
}
