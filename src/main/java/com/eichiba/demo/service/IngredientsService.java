package com.eichiba.demo.service;

import com.eichiba.demo.dto.ReciepesDTO;
import com.eichiba.demo.dto.RecipeIngredientDTO;
import com.eichiba.demo.entitys.Ingredient;
import com.eichiba.demo.entitys.Reciepe;
import com.eichiba.demo.entitys.RecipeIngredients;
import com.eichiba.demo.entitys.compKeys.ReciepeIngredientKey;
import com.eichiba.demo.repository.IngredientsRepository;
import com.eichiba.demo.repository.ReciepeRepository;
import com.eichiba.demo.repository.RecipeIngredientsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class IngredientsService {

    private Logger logger = LoggerFactory.getLogger(IngredientsService.class);

    @Autowired
    private IngredientsRepository ingredientsRepository;

    @Autowired
    private RecipeIngredientsRepository recipeIngredientsRepository;

    @Autowired
    private ReciepeRepository reciepeRepository;

    public Ingredient getIngredient(int ingredientId){
        return ingredientsRepository.getOne(ingredientId);
    }

//    public Reciepe getReciepe(int ingredientId){
//
//        Ingredient ingredient = ingredientsRepository.getOne(ingredientId);
//
//
//    }

//    public List<ReciepesDTO> getRecipeBasedOnIngredient(int ingredientId){
//        return  reciepeRepository.findAllByIngredientIn(ingredientId);
//    }

//    public List<ReciepesDTO> getRecipeBasedOnIngredient1(int ingredientId){
//        return reciepeRepository.findAllByIngredient(ingredientId);
//    }

//    public List<ReciepesDTO> getRecipeBasedOnIngredientListWithIng(){
//
//        List<Integer> ingredientIdList = new ArrayList<>();
//        ingredientIdList.add(24);
//        ingredientIdList.add(25);
//
//        List<ReciepesDTO> reciepesDTOS = reciepeRepository.findAllByIngredientList(ingredientIdList);
//
//
//    }

    public List<ReciepesDTO> getRecipeBasedOnIngredientList(){

        List<Integer> ingredientIdList = new ArrayList<>();
        ingredientIdList.add(24);
        ingredientIdList.add(25);

        return reciepeRepository.findAllByIngredientList(ingredientIdList);
    }

    public RecipeIngredients getRecipeIngredients(int recipeId, int ingId){

        ReciepeIngredientKey reciepeIngredientKey = new ReciepeIngredientKey();
        reciepeIngredientKey.setIngredientId(ingId);
        reciepeIngredientKey.setRecipeId(recipeId);

        return recipeIngredientsRepository.getOne(reciepeIngredientKey);
    }

    public RecipeIngredients addIngredientToReciepe(RecipeIngredientDTO recipeIngredientDTO){

        Ingredient ingredient = ingredientsRepository.getOne(recipeIngredientDTO.getIngredientId());
        Reciepe reciepe = reciepeRepository.getOne(recipeIngredientDTO.getRecipeId());


        if(ingredient == null || reciepe == null){
            logger.error("INGREDIENT OR RECIPE NOT FOUND");
        }else{
            RecipeIngredients recipeIngredients = new RecipeIngredients();

            recipeIngredients.setReciepe(reciepe);
            recipeIngredients.setIngredient(ingredient);
            recipeIngredients.setQuantity(10);  //Default Temp

            return recipeIngredientsRepository.save(recipeIngredients);
        }


        return null;
    }

//    public void addIngredientToReciepe(int reciepeId, Ingredient ingredients){
//
//        Set<Reciepe> set = new HashSet<Reciepe>();
//
//        Reciepe reciepe = new Reciepe();
//        reciepe.setReciepeId(reciepeId);
//
//        set.add(reciepe);
//        ingredients.setReciepeSet(set);
//
//        ingredientsRepository.save(ingredients);
//
//    }

    public Ingredient save(Ingredient ingredient) {
        return ingredientsRepository.save(ingredient);
    }
}
