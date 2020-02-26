package com.eichiba.demo.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Data
@Component
public class RecipeIngredientDTO implements Serializable {

    private int recipeId;

    private int ingredientId;
}
