package com.example.record_recipe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.record_recipe.service.RecipeService;

import com.example.record_recipe.form.RecipeForm;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

import com.example.record_recipe.dto.RecipeDTO;

@Controller
@RequestMapping("/recipe")
public class RecipeController {

    @Autowired
    private RecipeService service;

    @GetMapping("/list")
    public String recipeList(Model model) {

        List<RecipeDTO> recipeList = service.findAll();
        model.addAttribute("recipeList", recipeList);

        return "recipes/list";
    }

    @GetMapping("{id}")
    public String showRecipeDetail(@PathVariable Long id, Model model) {
        RecipeDTO recipe = service.findById(id);
        model.addAttribute("recipe", recipe);
        return "recipes/detail";
    }

    @GetMapping("/registerForm")
    public String showRecipeRegisterForm(@ModelAttribute RecipeForm form){
        return "recipes/registerForm";
    }

    @PostMapping
    public String registerRecipe(@Validated RecipeForm form, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return showRecipeRegisterForm(form);
        }
        service.register(form.toDTO());
        return "redirect:/recipe/list";
    }
}
