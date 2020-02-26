package com.eichiba.demo.controllers;

import com.eichiba.demo.dto.ReciepesDTO;
import com.eichiba.demo.entitys.Reciepe;
import com.eichiba.demo.service.IngredientsService;
import com.eichiba.demo.service.ReciepeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReciepeController {

    @Autowired
    private ReciepeService reciepeService;

    @Autowired
    private IngredientsService ingredientsService;

    @RequestMapping(path = "/reciepe/save", method = RequestMethod.PUT, consumes = "application/json")
    public Reciepe putReciepe(@RequestBody Reciepe reciepe){
        return reciepeService.saveReciepe(reciepe);
    }

    @RequestMapping(path = "/reciepe/{id}", method = RequestMethod.GET, consumes = "application/json")
    public Reciepe getReciepeDetails(@PathVariable(value = "id") String id){
        return reciepeService.getReciepe(id);
    }

//    @RequestMapping(path = "/get/ing/{id}",method = RequestMethod.GET)
//    public List<ReciepesDTO> getRecipesBasedOnIngredients(@PathVariable(value = "id") String id){
//        return ingredientsService.getRecipeBasedOnIngredient1(Integer.parseInt(id));
//    }

    @RequestMapping(path = "/get/ing/{id}",method = RequestMethod.GET)
    public List<ReciepesDTO> getRecipesBasedOnIngredientsList(@PathVariable(value = "id") String id){
        return ingredientsService.getRecipeBasedOnIngredientList();
    }

    @RequestMapping(path = "/getRecipeList",method = RequestMethod.GET)
    public List<ReciepesDTO> getRecipesBasedOnIngredientsListWithIng(){
        return ingredientsService.getRecipeBasedOnIngredientListWithIng();
    }


}
