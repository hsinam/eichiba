package com.eichiba.demo.controllers;

import com.eichiba.demo.dto.RecipeIngredientDTO;
import com.eichiba.demo.entitys.Ingredient;
import com.eichiba.demo.entitys.Reciepe;
import com.eichiba.demo.entitys.RecipeIngredients;
import com.eichiba.demo.service.IngredientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class IngredientsController {

    @Autowired
    private IngredientsService ingredientsService;

    @RequestMapping(path = "/ing/save", method = RequestMethod.PUT, consumes = "application/json")
    public Ingredient saveIngredient(@RequestBody Ingredient ingredient){
        return ingredientsService.save(ingredient);
    }

    @RequestMapping(path = "/ing/add}", method = RequestMethod.PUT, consumes = "application/json")
    public RecipeIngredients addIngredientToRecipe(@RequestBody RecipeIngredientDTO recipeIngredientDTO){
         return ingredientsService.addIngredientToReciepe(recipeIngredientDTO);
    }

    @RequestMapping(path = "ing/{id}", method = RequestMethod.GET, consumes = "application/json")
    public Ingredient getIngredient(@PathVariable(value = "id") String id){
        return ingredientsService.getIngredient(Integer.parseInt(id));
    }

    @RequestMapping(path = "recipe/{reciepeId}/ing/{ingId}", method = RequestMethod.GET, consumes = "application/json")
    public RecipeIngredients getRecipeIngredients(@PathVariable(value = "reciepeId") String recipeId,
                                                  @PathVariable(value = "ingId") String ingredientId){
        return ingredientsService.getRecipeIngredients(Integer.parseInt(recipeId), Integer.parseInt(ingredientId));
    }

}
